package gamedev.td.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class BGMHelper {
	Music music;
    
	public BGMHelper(){
	
		music = Gdx.audio.newMusic(Gdx.files.internal("assets/sound/BGM.mp3"));	
	}
    
    public void play(){
		music.play(); 	
		music.setLooping(true);
    }
    
    public void stop(){
    	music.stop();
    }
}