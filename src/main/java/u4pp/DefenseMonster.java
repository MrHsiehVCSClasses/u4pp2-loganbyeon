package u4pp;

public class DefenseMonster extends Monster{
    int defense;

    /**
     * Constructor where the defense monster's defense parameter represents the defense.
	 */
    public DefenseMonster(String name, int health, int attack, int exp, int defense){
        super(name, health, attack, exp);
        this.defense = defense;
    }

    /**
     * Constructor that gets the defense.
     * @return the defense.
	 */
    public int getDefense(){
        return defense;
    }

    /**
     * Constructor where a DefenseMonster negates a certain amount of damage each turn, based on its defense stat. 
     * If the damage dealt is less than or equal to its defense, the monster will take no damage. 
     * If the damage is greater than the monsters defense, the monster loses health equal to the damage minus its defense.
	 */
    public void takeDamage(int damage){
        if(damage > defense){
            health -= damage - defense;
        }
    }

    /**
     * Constructor.
     * @return the stats of the character.
	 */
    public String toString(){
        return "Name: " + name + 
            "\nHealth: " + health + " \\ " + maxHealth + " (Max Health)" +
            "\nAttack Power: " + attack + 
            "\nExperience: " + exp + 
            "\nDefense: " + defense;
    }
}
