# libGDX_TD
Java Game Development Group Project using [libGDX] - Tower Defense in Desktop


[libGDX]: https://libgdx.badlogicgames.com/

## Collaborated with
 MinSeok Koo([kei98301]), Minwoo Jang([jmw1038]), Youngin Cho([ChoYoungIn]), Seungwook Choi([seungwookchoi]), 
 Yeseul Cho([yscho1219]).

[kei98301]: https://github.com/kei98301
[jmw1038]: https://github.com/jmw1038
[ChoYoungIn]: https://github.com/ChoYoungIn
[seungwookchoi]: https://github.com/seungwookchoi
[yscho1219]: https://github.com/yscho1219
## Commit Note
17.02.02:[Minseok Koo] Tower overlap problem solving. 

	(gamedev-td-core/src/gamedev/input/GameInputProcessor.java)

17.02.02:[Youngin Cho] Add Right-click deselect function. 

	(gamedev-td-core/src/gamedev/input/GameInputProcessor.java)

17.02.07:[Minwoo Jang] Add skip function. 

	(gamedev-td-core/src/gamedev/input/GameInputProcessor.java)
	(gamedev-td-core/src/gamedev/entity/GameState.java)
	(gamedev-td-core/src/gamedev/entity/TextureFactory.java)
	(gamedev-td-core/src/gamedev/screen/GameUserInterface.java)

17.02.08:[Minwoo Jang] Fixed a problem where the mouse was focused but the tower was selected. 

	(gamedev-td-core/src/gamedev/input/GameInputProcessor.java)

17.02.09:[Minwoo Jang] Fixed a problem where Steve and DartDirt installed the tower. 

	(gamedev-td-core/src/gamedev/entity/GameState.java)

17.02.09:[Minwoo Jang] When Restart and Quit button is pressed, reset.

	(gamedev-td-core/src/gamedev/input/PauseInputProcessor.java)
	
17.02.16:[Minseok Koo] Remove unnecessary towers.

	(gamedev-td-core/src/gamedev/input/screen/GameUserInterface.java)
	
17.02.16:[Seungwook Choi] As the level goes up, the monsters increase the health. //Not commit yet.

	(gamedev-td-core/src/gamedev/entity/Enemy.java)
	(gamedev-td-core/src/gamedev/entity/GameState.java)

17.02.23:[Minseok Koo] UI of Map, Main menu, Pause screen, Lvl select screen, gameover screen (images, font)

	(gamedev-td-core/src/gamedev/level/Map.java)
	(gamedev-td-core/src/gamedev/screen/MainMenuScreen.java)
	(gamedev-td-core/src/gamedev/screen/PauseScreen.java)
	(gamedev-td-core/src/gamedev/screen/LvlSelectScreen.java)
	(gamedev-td-core/src/gamedev/screen/GameOverScreen.java)
	(gamedev-td-core/src/gamedev/screen/GameUserInterface.java)
	(gamedev-td-core/src/gamedev/td/helper/FontHelper.java)

	(gamedev-td-desktop/assets/img/button_basic.png)
	(gamedev-td-desktop/assets/img/play_button.png)
	(gamedev-td-desktop/assets/img/settings_button.png)
	(gamedev-td-desktop/assets/img/about_button.png)
	(gamedev-td-desktop/assets/img/exit_button.png)
	(gamedev-td-desktop/assets/img/back_to_menu_button.png)
	(gamedev-td-desktop/assets/img/restart_button.png)
	(gamedev-td-desktop/assets/img/resume_button.png)
	(gamedev-td-desktop/assets/img/quit2menu_button.png)
	(gamedev-td-desktop/assets/img/dirt_dark.png)
	(gamedev-td-desktop/assets/img/dirt_light.png)
	(gamedev-td-desktop/assets/img/grass.png)
	(gamedev-td-desktop/assets/img/lvlSelectBG.png)
	(gamedev-td-desktop/assets/img/main_background.png)
	(gamedev-td-desktop/assets/img/map1.png)
	(gamedev-td-desktop/assets/img/map2.png)
	(gamedev-td-desktop/assets/img/steve.png)
	(gamedev-td-desktop/assets/img/title.png)
	(gamedev-td-desktop/assets/img/wave.png)

	(gamedev-td-desktop/font/License.txt  (modified))
	(gamedev-td-desktop/font/prstartk.tff (added))
	(gamedev-td-desktop/font/prstart.tff (added))
	(gamedev-td-desktop/font/Sample.png (deleted))
	(gamedev-td-desktop/font/sample (2).png (deleted))
	

