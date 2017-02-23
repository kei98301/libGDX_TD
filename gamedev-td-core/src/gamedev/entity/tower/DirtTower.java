package gamedev.entity.tower;

import gamedev.entity.Tower;
import gamedev.td.GDSprite;

public class DirtTower extends Tower {
	
	private int maxLevel = 5;
	//modify(2017.02.23 18:45 By JangMinWoo)
	//modify quality of DirtTower
	private static int damageLevels[] = {1,3,5,7,9};
	private static int rangeLevels[] = {80,82,84,86,88,90};
	private static float attackRateLevels[] = {20f,22f,24f,26f,28f};
		
	public DirtTower(GDSprite sprite, int level, int cost) {
		super(sprite, damageLevels[level], rangeLevels[level], attackRateLevels[level], cost, level, "Dirt Tower");
		
	}

	//modify(2017.02.23 18:45 By JangMinWoo)
	//Print upgrade statue
	public void upgrade() {
		if(level+1 < maxLevel){
			
			level++;
			System.out.println("DirtTower is upgraded to LEVEL "+ (level+1));
			this.upgradeCost+=10;
		}
		else{
			
			System.out.println("Cannot Upgrade anymore");
		}
		damage = damageLevels[level];
		attackRange = rangeLevels[level];
		attackRate = attackRateLevels[level];
		setAttackCooldown(attackRate);		
	}

}
