package gamedev.entity.tower;

import gamedev.entity.Tower;
import gamedev.td.GDSprite;

public class ArrowTower extends Tower{
	
	private int maxLevel = 5;

	//modify(2017.02.23 18:45 By JangMinWoo)
	//modify quality of ArrowTower
	private static int damageLevels[] = {10,12,14,16,18};
	private static int rangeLevels[] = {100,105,110,115,120};
	private static float attackRateLevels[] = {1.5f,1.7f,1.9f,2.1f,2.3f};

	public ArrowTower(GDSprite sprite, int level, int cost) {
		super(sprite, damageLevels[level], rangeLevels[level], attackRateLevels[level], cost, level, "Arrow Tower");
	}

	
	//modify(2017.02.23 18:45 By JangMinWoo)
	//Print upgrade statue
	public void upgrade() {
		if(level+1 < maxLevel){
			
			level++;
			System.out.println("ArrowTower is upgraded to LEVEL "+ (level+1));
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
