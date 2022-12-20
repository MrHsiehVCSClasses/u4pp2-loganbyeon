package u4pp;

public class Monster extends Combatant{
    int exp;

    /**
     * Constructor where the exp parameter represents how much experience the monster gives when it is defeated.
	 */
    public Monster(String name, int health, int attack, int exp){
        super(name, health, attack);
        if (exp < 0) {
            this.exp = 0;
        }else {
            this.exp = exp;
        }
    }

    /**
     * Constructor where the exp parameter represents how much experience the monster gives when it is defeated.
     * @return the experience.
	 */
    public int getExpGiven(){
        return exp;
    }

    /**
     * Constructor that represents what the monster does on its turn. 
     * The basic Monster should simply attack whatever its target is (usually, the player).
	 */
    public void takeTurn(Combatant target){
        target.takeDamage(attack);
    } 
    
    /**
     * Constructor.
     * @return the stats of the character.
	 */
    public String toString(){
        return "Monster: " + name + 
            "\nHealth: " + health + " \\ " + maxHealth + " (Max Health)" +
            "\nAttack Power: " + attack + 
            "\nExperience: " + exp;
    }
}
