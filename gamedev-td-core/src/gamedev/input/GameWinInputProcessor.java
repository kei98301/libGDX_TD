package gamedev.input;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;

import gamedev.entity.GameState;
import gamedev.screen.GameWinScreen;
import gamedev.td.GDSprite;
import gamedev.td.TowerDefense;

public class GameWinInputProcessor extends GDInputProcessor{

	List<GDSprite> buttons;
	private GameWinScreen gameWinScreen;

	public GameWinInputProcessor(TowerDefense towerDefense, GameWinScreen screen){
		super(towerDefense);
		this.gameWinScreen = screen;
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
		
		buttons = gameWinScreen.getButtons();
		for (int i = 0; i < buttons.size(); i++) {
			GDSprite sprite = buttons.get(i);
			
			if(Gdx.input.isButtonPressed(Buttons.LEFT))
				if(sprite.contains(screenX, screenY)) {
					switch(i) {
					case GameWinScreen.RESTART:
						GameState.getInstance().initialize();
						towerDefense.switchScreen(towerDefense.getGameScreen());
						break;
					case GameWinScreen.MAIN_MENU:
						towerDefense.switchScreen(towerDefense.getMainMenuScreen());
						break;
					case GameWinScreen.EXIT:
						System.exit(1);
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
		buttons = gameWinScreen.getButtons();
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
