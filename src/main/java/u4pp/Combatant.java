package u4pp;

public class Combatant {
    String name; 
    int health;
    int attack;
    int maxHealth;
    
    /**
	 * Constructor that has health equal to its max health.
	 */
    public Combatant(String name, int maxHealth, int attack){
        this.name = name;
        health = maxHealth;
        this.attack = attack;
        this.maxHealth = maxHealth;
    }

    /**
	 * Getters & Setters
     * Constructor that gets the name.
	 * @return the name.
	 */
    public String getName(){
        return name;
    }

    /**
	 * Getters & Setters
     * Constructor that gets the health.
	 * @return the health.
	 */
    public int getHealth(){
        return health;
    }

    /**
	 * Getters & Setters
     * Constructor that gets the maximum health.
	 * @return the maximum health.
	 */
    public int getMaxHealth(){
        return maxHealth;
    }

    /**
	 * Getters & Setters
     * Constructor that gets the attack.
	 * @return the attack.
	 */
    public int getAttackPower(){
        return attack;
    }

    /**
	 * Getters & Setters
     * Constructor that sets the health.
	 */
    public void setHealth(int health){
        if(health >= 0 && health < maxHealth){
            this.health = health;
        }else if (health < 0) {
            this.health = 0;
        }else {
            this.health = maxHealth;
        }
    }

    /**
	 * Getters & Setters
     * Constructor that sets the maximum health.
	 */
    public void setMaxHealth(int health){
        if(health > 0){
            this.maxHealth = health;
            if (this.health > maxHealth) {
                this.health = maxHealth;
            }
        }else if (health <= 0) {
            this.maxHealth = 1;
        }
    }

    /**
	 * Getters & Setters
     * Constructor that sets the attack.
	 */
    public void setAttackPower(int attackPower){
        if(attackPower >= 0){
            attack = attackPower;
        }else {
            attack = 0;
        }
    }

    /**
     * Constructor that takes the damage.
	 */
    public void takeDamage(int damage){
        if(damage >= 0){
            setHealth(health - damage);
        }
    }

    /**
     * Constructor that determines whether the monster can fight based on health.
	 * @return true if monster can fight.
	 */
    public boolean canFight(){
        if(health > 0){
            return true;
        }
        return false;
    }

    /**
     * Constructor that returns the stats of the character.
	 * @return the stats of the character.
	 */
    public String toString(){
        return "Name: " + name + 
            "\nHealth: " + health + " \\ " + maxHealth + " (Max Health)" +
            "\nAttack Power: " + attack;
    }
}
