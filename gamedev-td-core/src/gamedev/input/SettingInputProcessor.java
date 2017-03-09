package gamedev.input;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;

import gamedev.entity.GameState;
import gamedev.screen.SettingScreen;
import gamedev.td.GDSprite;
import gamedev.td.TowerDefense;

public class SettingInputProcessor extends GDInputProcessor{

	List<GDSprite> buttons;
	private SettingScreen settingScreen;

	Color red = new Color(1,0,0,.5f);
	Color white = new Color(1,1,1,.5f);

//	BGMHelper bgm;
	
	public SettingInputProcessor(TowerDefense towerDefense, SettingScreen settingScreen){
		super(towerDefense);
		this.settingScreen = settingScreen;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		//modify(2017.02.09 19:51 By JangMinWoo)
		//reset Stage when clicked QuitToMenu,RESTART
		GameState instance = GameState.getInstance();
	
		buttons = settingScreen.getButtons();
		for (int i = 0; i < buttons.size(); i++) {
			GDSprite sprite = buttons.get(i);
			
			if(Gdx.input.isButtonPressed(Buttons.LEFT))
				if(sprite.contains(screenX, screenY)) {
					switch(i) {
					case SettingScreen.SOUND_ON:
					//	bgm.play();
						break;
						
					case SettingScreen.SOUND_OFF:
					//	bgm.stop();
						break;
				
					case SettingScreen.MAIN_MENU:
						towerDefense.switchScreen(towerDefense.getMainMenuScreen());
						
						instance.initialize();
						
						break;
					}
				}
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		buttons = settingScreen.getButtons();
		for (int i = 0; i < buttons.size(); i++) {
			GDSprite sprite = buttons.get(i);
				if(screenX >= sprite.getX() && screenX < sprite.getX() + sprite.getWidth()
						&& screenY >= sprite.getY() && screenY < sprite.getY() + sprite.getHeight()) {
						
					buttons.get(i).setAlpha(0.8f);
				}
				else buttons.get(i).setAlpha(1);
		}
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}

	