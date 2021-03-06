package gamedev.screen;

import gamedev.entity.GameState;
import gamedev.entity.Tower;
import gamedev.entity.TowerFactory.TowerType;
import gamedev.entity.tower.ArrowTower;
import gamedev.entity.tower.DirtTower;
import gamedev.entity.tower.EggTower;
import gamedev.screen.render.TowerRangeRenderer;
import gamedev.td.Config;
import gamedev.td.GDSprite;
import gamedev.td.SpriteManager;
import gamedev.td.helper.FontHelper;
import gamedev.td.helper.TimeHelper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameUserInterface {
	BitmapFont towerInfoFont, costFont;
	GDSprite uiBackground, infoBackground, towerToPutSprite, upgradeBtn, sellBtn,
			upgradeToCorruptedEgg, upgradeToSlime, upgradeToWood,
			upgradeToSand, upgradeToFireArrow, upgradeToIceArrow,
				tileHighlight, towerBtnHighlight, ghostTower, 
				waveLabel, towerLabel, moneyLabel;
	//modify(2017.02.05 01:46 By JangMinWoo)
	//add SkipButton  at userInterface
	GDSprite skipBtn;
	
	//add(2017.02.14 13:16 By ChoYoungIn)
	//add levelLabel at userInterface
	GDSprite levelLabel;
	
	//add(2017.02.16 19:07 By ChoYoungIn)
	//add red_highlight at userInterface
	//GDSprite redHighlight;
	
	Tower selectedDeployedTower;

	TowerRangeRenderer towerRangeRenderer;
	
	private int userInterfaceY = 480;

	private ArrayList<GDSprite> btnsBuildTower;
	
	// Tower information when building
	String towerName;
	private int damage;
	private int cost;
	private float range;
	private float attackRate;
	
	private Tower towerToBuild, towerToUpgrade;
	private GDSprite[] heartSprite;

	
	public GameUserInterface() {
		setTowerInfo(null);
		towerToPutSprite = null;
		ghostTower = null;
		FontHelper.initialize();
		towerInfoFont = FontHelper.minecraftia14px;
		costFont = FontHelper.minecraftia8px;
		
		SpriteManager spriteManager = SpriteManager.getInstance();
		
		towerLabel = spriteManager.getSprite("tower_label");
		towerLabel.setPosition(0, 13 * Config.tileSize);
		
		moneyLabel = spriteManager.getSprite("emerald");
		moneyLabel.setPosition(0, 14 * Config.tileSize);
		
		waveLabel = spriteManager.getSprite("wave");
		waveLabel.setPosition(5, 15 * Config.tileSize);

		uiBackground = spriteManager.getSprite("ui");
		uiBackground.setPosition(0, userInterfaceY);
		
		infoBackground = spriteManager.getSprite("info_bg");
		infoBackground.setPosition(300, userInterfaceY + 10);

		
		//modify(2017.02.06 02:59 By JangMinWoo)
		//edit (Y)position of upgradeBtn,selBtn (120->110), upgradeToWood,Sand,......(120->130)
		upgradeBtn = spriteManager.getSprite("upgrade_button");
		upgradeBtn.setPosition(300, userInterfaceY + 110);
		sellBtn = spriteManager.getSprite("sell_button");
		sellBtn.setPosition(425, userInterfaceY + 110);

		tileHighlight = spriteManager.getSprite("highlight");
		towerBtnHighlight = spriteManager.getSprite("tower_highlight");
		
		//add(2017.02.16 19:07 By ChoYoungIn)
		//add redHighlight
		//redHighlight = spriteManager.getSprite("red_highlight");
		
		//modify(2017.02.06 02:59 By JangMinWoo)
		//add skip button
		skipBtn = spriteManager.getSprite("skip_button");	
		skipBtn.setPosition(565,userInterfaceY+50);
		
		//add(2017.02.14 13:16 By ChoYoungIn)
		//add levelLabel
		levelLabel = spriteManager.getSprite("level");
		levelLabel.setPosition(565, userInterfaceY+10);
		
		towerRangeRenderer = new TowerRangeRenderer();
		
		initializeHeartSprites();
		initializeUpgradeButtons();
		initializeBuildTowerButtons();
	}

	private void initializeHeartSprites() {
		SpriteManager spriteManager = SpriteManager.getInstance();
		heartSprite = new GDSprite[10];
		
		for (int i = 0; i < 10; i ++){
			heartSprite[i] = spriteManager.getSprite("heart");
			heartSprite[i].setPosition(i * 20 + i * 2 + 10, 12 * Config.tileSize + 10);
		}
	}

	
	private void initializeUpgradeButtons() {
		SpriteManager spriteManager = SpriteManager.getInstance();
		
		//modify(2017.02.24 02:36 By JangMinWoo)
		//edit Y Position of TowerToUpgrade
		upgradeToWood = spriteManager.getSprite("upgrade_to_wood");
		upgradeToWood.setPosition(300, userInterfaceY + 130);

		upgradeToSand = spriteManager.getSprite("upgrade_to_sand");
		upgradeToSand.setPosition(425, userInterfaceY + 130);

		upgradeToFireArrow = spriteManager.getSprite("upgrade_to_fireArrow");
		upgradeToFireArrow.setPosition(300, userInterfaceY + 130);

		upgradeToIceArrow = spriteManager.getSprite("upgrade_to_iceArrow");
		upgradeToIceArrow.setPosition(425, userInterfaceY + 130);

		upgradeToSlime = spriteManager.getSprite("upgrade_to_slime");
		upgradeToSlime.setPosition(300, userInterfaceY + 130);

		upgradeToCorruptedEgg = spriteManager.getSprite("upgrade_to_cegg");
		upgradeToCorruptedEgg.setPosition(425, userInterfaceY + 130);
	}
	
	private void initializeBuildTowerButtons() {
		btnsBuildTower = new ArrayList<GDSprite>();
		SpriteManager spriteManager = SpriteManager.getInstance();

		GDSprite dirtTower = spriteManager.getTower(TowerType.Dirt_Tower);
		GDSprite arrowTower = spriteManager.getTower(TowerType.Arrow_Tower);
		GDSprite eggTower = spriteManager.getTower(TowerType.Egg_Tower);
		//GDSprite potionTower = spriteManager.getTower(TowerType.Potion_Tower);
		//GDSprite currencyTower = spriteManager.getTower(TowerType.Currency_Tower);

		int offset = 3, y = 13;
		dirtTower.setPosition(Config.tileSize, y * Config.tileSize);
		arrowTower.setPosition(Config.tileSize * 2 + offset, y * Config.tileSize);
		eggTower.setPosition(Config.tileSize * 3 + offset * 2, y * Config.tileSize);
		//potionTower.setPosition(Config.tileSize * 4 + offset * 3, y * Config.tileSize);
		//currencyTower.setPosition(Config.tileSize * 5 + offset * 4, y * Config.tileSize);

		btnsBuildTower.add(dirtTower);
		btnsBuildTower.add(arrowTower);
		btnsBuildTower.add(eggTower);
		//btnsBuildTower.add(potionTower);
		//btnsBuildTower.add(currencyTower);
	}

	public void render(SpriteBatch spriteBatch) {

	}

	public void update(float delta) {

	}

	public void draw(SpriteBatch spriteBatch) {
		towerRangeRenderer.render(); // put towerRangeRenderer outside spriteBatch begin and end (issue in drawing)
		spriteBatch.begin();
		
		tileHighlight.draw(spriteBatch);
		
		//add(2017.02.16 19:07 By ChoYoungIn)
		//set visible redHighlight
		//redHighlight.draw(spriteBatch);
		
		uiBackground.draw(spriteBatch);
		infoBackground.draw(spriteBatch);
		
		towerLabel.draw(spriteBatch);
		moneyLabel.draw(spriteBatch);
		waveLabel.draw(spriteBatch);
		
		//add(2017.02.04.18:37 By Jang Minwoo)
		//set visible skipButton
		skipBtn.draw(spriteBatch);
		
		//add(2017.02.14 13:16 By ChoYoungIn)
		//set visible levelLabel
		levelLabel.draw(spriteBatch);
		
		// Draw 'build tower' buttons
		for (GDSprite tower : btnsBuildTower)
			tower.draw(spriteBatch);

		if (towerToBuild != null){
			// Draw tower descriptions
			drawTowerInfo(spriteBatch);
			
			
		//modify(2017.02.10 22:24 By JangMinWoo)
		//set visible upgrade,sellBtn and upgradedTowerBtn
		//}else if (towerToUpgrade != null){
		}if	 (towerToUpgrade != null){	
			upgradeBtn.draw(spriteBatch);
			costFont.draw(spriteBatch, selectedDeployedTower.getUpgradeCost() + "", upgradeBtn.getX() + 85, upgradeBtn.getY() + 6);
			sellBtn.draw(spriteBatch);
			costFont.draw(spriteBatch, selectedDeployedTower.getSellCost() + "", sellBtn.getX() + 75, sellBtn.getY() + 6);

			if (selectedDeployedTower instanceof ArrowTower) {
				upgradeToFireArrow.draw(spriteBatch);
				upgradeToIceArrow.draw(spriteBatch);
			} else if (selectedDeployedTower instanceof DirtTower) {
				upgradeToWood.draw(spriteBatch);
				upgradeToSand.draw(spriteBatch);
			} else if (selectedDeployedTower instanceof EggTower) {
				upgradeToSlime.draw(spriteBatch);
				upgradeToCorruptedEgg.draw(spriteBatch);
			}
		}
		
		towerBtnHighlight.draw(spriteBatch);
		if(ghostTower != null) {
			ghostTower.draw(spriteBatch);
		}
		
		drawHealthBars(spriteBatch);
		towerInfoFont.draw(spriteBatch, GameState.getInstance().getMoney()+"", Config.tileSize + 5, 14 * Config.tileSize + 14);
		towerInfoFont.draw(spriteBatch, TimeHelper.formatSeconds(GameState.getInstance().getRoundTime()), Config.tileSize + 5, 15 * Config.tileSize + 12);
		
		//add(2017.02.15 09:52 By ChoYoungIn)
		//draw level at (650, userInterfaceY+20) (level-1 for PRE_ROUND_WAIT time)
		towerInfoFont.setColor(Color.BLACK);
		towerInfoFont.draw(spriteBatch, GameState.getInstance().getLevel()-1+"", 605, userInterfaceY+20);
		
		spriteBatch.end();
	}

	private void drawTowerInfo(SpriteBatch spriteBatch) {
		towerInfoFont.setColor(Color.WHITE);

		// Descriptions
		int x = 310;
		if (towerToBuild != null) {
			towerInfoFont.draw(spriteBatch, towerName, x, userInterfaceY + 15);
			towerInfoFont.draw(spriteBatch, "Cost: " + cost, x, userInterfaceY + 32);
			towerInfoFont.draw(spriteBatch, "Damage: " + damage, x, userInterfaceY + 49);
			towerInfoFont.draw(spriteBatch, "Range: " + range, x, userInterfaceY + 66);
			towerInfoFont.draw(spriteBatch, "Speed: " + attackRate, x, userInterfaceY + 83);
		}
		
		// Image icon
//		if (towerSprite != null) {
//			towerSprite.setPosition(x + 150, userInterfaceY + 25);
//			towerSprite.draw(spriteBatch);
//		} 
		if (towerToPutSprite != null) {
			//Modified (2017.02.22 15:25 By Minseok Koo)
			//Modified User Interface(tower icon position)
			towerToPutSprite.setPosition(x + 180, userInterfaceY + 25);
			towerToPutSprite.draw(spriteBatch);
		}

	}

	private void drawHealthBars(SpriteBatch spriteBatch) {
		GameState gameState = GameState.getInstance();
		for (int i = 0; i < gameState.getPlayerLife(); i++) {
			heartSprite[i].draw(spriteBatch);
		}
	}
	
	public void setTowerInfo(Tower towerToBuild) {
		this.towerToBuild = towerToBuild;
		
		if (towerToBuild != null) {
			damage = towerToBuild.getDamage();
			cost = towerToBuild.getCost();
			range = towerToBuild.getAttackRange();
			attackRate = towerToBuild.getAttackRate();
			towerName = towerToBuild.getTowerName();
		} else {
			damage = 0;
			cost = 0;
			range = 0;
			attackRate = 0;
			towerName = "";
		}
	}
	
	public List<GDSprite> getBuildTowerButtons() {
		return btnsBuildTower;
	}

	public GDSprite getTileHighlight() {
		return tileHighlight;
	}

	public GDSprite getTowerBtnHighlight() {
		return towerBtnHighlight;
	}
	
	//modify(2017.02.05 01:46 By JangMinWoo)
	//add 'get SkipButton method'  at userInterface
	public GDSprite getSkipButton(){
		return skipBtn;
	}

	public void setTowerToBuild(Tower towerToBuild, TowerType towerType) {
		setTowerInfo(towerToBuild);
		
		SpriteManager spriteManager = SpriteManager.getInstance();
		towerToPutSprite = spriteManager.getTower(towerType);
		
		GameState state = GameState.getInstance();
		
		if (state.canBuyTower(towerToBuild)) {
			towerRangeRenderer.setTowerToBuild(towerToBuild);
		} else {
			towerToPutSprite = null;
			towerToBuild = null;
		}
	}

	public void setTowerToUpgrade(Tower tower) {
		//modify(2017.02.10 22:25 By JangMinWoo)
		//set clicked tower as TowerToUpgrade 		
		towerToUpgrade = tower;
		selectedDeployedTower = tower;
	}

	/**
	 * Reset; Deselect all towers to be built or upgraded.
	 */
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Change color of the highlighted cell
	 * @param point
	 */
	public void setHighlightedCell(Point point) {
		tileHighlight.setPosition(point.x, point.y);
	}
	
	//add(2017.02.16 19:12 By ChoYoungIn)
	//add setHighlightColor method at userInterface
	public void setRedHighlight() {
		towerRangeRenderer.setRedColor();
	}
	public void setWhiteHighlight(){
		towerRangeRenderer.setWhiteColor();
	}
	//public void setRedHighlightedCell(Point point) {
		//redHighlight.setPosition(point.x, point.y);
	//}
	
	/**
	 * Place a ghost tower on the highlighted cell
	 * Note that the attack range should be drawn as well
	 * @param point
	 */
	public void setGhostTowerLocation(Point point) {
		if(ghostTower != null) {
			ghostTower.setPosition(point.x, point.y);
		}
	}
	
	public void setGhostTower(TowerType towerType) {
		if(towerType != null)
			ghostTower = SpriteManager.getInstance().getTower(towerType);
		else ghostTower.setColor(Config.clearer);
	}
	
	public void setTowerRange(Tower towerToBuild) {
		if(towerToBuild != null)
			towerRangeRenderer.setAttackRange(towerToBuild.getAttackRange());
		else towerRangeRenderer.setAttackRange(0);
	}
	
	//modify(2017.02.24 01:46 By JangMinWoo)
	//add method	
	public Tower getSelectedDeployedTower(){
		return this.selectedDeployedTower;
	}
	public GDSprite getUpgradeBtn(){
		return this.upgradeBtn;
	}

	//modify(2017.02.05 01:46 By JangMinWoo)
	//define UpgradeTower Method
	public void UpgradeTower(){
		GameState instance = GameState.getInstance();
		instance.getDeployedTowers().remove(selectedDeployedTower);
		this.selectedDeployedTower.upgrade();
		instance.getDeployedTowers().add(selectedDeployedTower);
	}
}

	
	
