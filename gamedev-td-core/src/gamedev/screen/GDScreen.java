package gamedev.screen;

import com.badlogic.gdx.Screen;

import gamedev.input.GDInputProcessor;

public abstract class GDScreen implements Screen{
	protected GDInputProcessor inputProcessor;

	public GDInputProcessor getInputProcessor() {
		return inputProcessor;
	}
	

}
