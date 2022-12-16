package u4pp;

public class Fighter extends Combatant{
    int level = 1;
    int experience = 0;
    int focusStacks = 0;
    boolean blocking = false;

    /**
     * Constructor that sets the default level to 1, with 0 experience, 0 focus stacks, and not blocking.
	 */
    public Fighter(String name, int maxHealth, int attack){
        super(name, maxHealth, attack);
    }

    /**
     * Getters
     * Constructor that gets the experience of the character.
     * @return the experience.
	 */
    public int getEXP(){
        return experience;
    }

    /**
     * Getters
     * Constructor that gets the focus stacks of the character.
     * @return the focus stacks.
	 */
    public int getFocusStacks(){
        return focusStacks;
    }

    /**
     * Getters
     * Constructor that gets the level of the character.
     * @return the level.
	 */
    public int getLevel(){
        return level;
    }

    /**
     * Getters
     * Constructor that determines the blocking of the character.
     * @return the blocking.
	 */
    public boolean getIsBlocking(){
        return blocking;
    }

    /**
     * Constructor that calls takeDamage on the target with damage based on the Fighter's attack multiplied by 2 per stack of focus.
	 */
    public void attack(Combatant target){
        target.takeDamage(attack * 2 * focusStacks);
    }

    /**
     * Constructor that halves the damage (rounded down) taken the next time takeDamage is called on the Fighter.
	 */
    public void block(){
        blocking = true;
    }

    /**
     * Constructor that increases future damage, by gaining 1 stack of focus.
	 */
    public void focus(){
        focusStacks++;
    }

    /**
     * Constructor where the Fighter has EXP greater than or equal to their level, 
     * they should spend EXP equal to their level and gain 1 level. Doing so will increase their max health by 5, 
     * increase their attack by 1, and heal them to full health. This method should be able to handle gaining so much 
     * EXP that the character levels multiple times in a row.
	 */
    public void gainEXP(int exp){
        experience += exp;
        while(experience >= level){
            experience -= level;
            level++;
        }
    }
    
    /**
     * Constructor that loses health based on the damage taken. 
     * Loses half as much (rounded down) health if the Fighter is blocking.
	 */
    public void takeDamage(int damage){
        if(blocking == true){
            damage /= 2;
        }
        health -= damage;
        block();
    }

    /**
     * Constructor.
     * @return the stats of the character.
	 */
    public String toString(){
        return "Name: " + name + " Health: " + health + " MaxHealth: " + maxHealth + "Attack Power: " + attack + "Level: " + level + "Experience: " + experience + "Focus Stacks: " + focusStacks + "Blocking: " + blocking;
    }
}
