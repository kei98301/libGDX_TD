package gamedev.entity.tower;

import gamedev.entity.Tower;
import gamedev.td.GDSprite;

public class EggTower extends Tower {

	private int maxLevel = 5;
	//modify(2017.02.23 18:45 By JangMinWoo)
	//modify quality of EggTower
	private static int damageLevels[] = {7,9,11,13,15};
	private static int rangeLevels[] = {100,105,110,115,120};
	private static float attackRateLevels[] = {1.3f,1.7f,1.9f,2.1f,2.3f};
	
	public EggTower(GDSprite sprite, int level, int cost) {
		super(sprite, damageLevels[level], rangeLevels[level], attackRateLevels[level], cost, level, "Egg Tower");
	}

	//modify(2017.02.23 18:45 By JangMinWoo)
	//Print upgrade statue
	public void upgrade() {
		if(level+1 < maxLevel){
			
			level++;
			System.out.println("EggTower is upgraded to LEVEL "+ (level+1));
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
