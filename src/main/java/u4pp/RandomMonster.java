package u4pp;

import java.util.Random;

public class RandomMonster extends Monster{
    int exp;

    /**
     * Constructor where the random monster's exp parameter represents the experience.
	 */
    public RandomMonster(String name, int health, int attack, int exp){
        super(name, health, attack, exp);
        this.exp = exp;
    }

    /**
     * Constructor that only has a 50% chance of taking a normal Monster turn. 
     * Half the time, does nothing.
	 */
    public void takeTurn(Combatant target){
        Random rand = new Random();
        int num = rand.nextInt(2);
        if(num == 0){
            target.takeDamage(attack);
        }
    }
}
