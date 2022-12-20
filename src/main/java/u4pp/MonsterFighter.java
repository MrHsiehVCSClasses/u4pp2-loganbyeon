package u4pp;

import java.util.Scanner;


public class MonsterFighter {
    Fighter fighter;
    Monster mon;
    RandomMonster randMon;
    DefenseMonster defMon;
    int totalMonsters;
    boolean[] totalDead;
    
    /**
     * Constructor that will allow monsters to fight.
     */
    public MonsterFighter(){
        totalMonsters = 3;
        totalDead = new boolean[totalMonsters];
        mon = new Monster("Norm", 100, 10, 50);
        randMon = new RandomMonster("Randy", 200, 20, 100);
        defMon = new DefenseMonster("Def", 250, 15, 150, 20);
    }

    public void fighter_turn(Fighter f, Monster m, int move) {
        if (move == 1) { // Attack
            // Monster Status
            int damage = f.getAttackPower() * (int) Math.pow(2, f.getFocusStacks());
            int mHealth = m.getHealth() - damage;
            System.out.print(m.getName() + " took " + damage + " damage. -> ");
            if (mHealth < 0) {
                mHealth = 0;
            }
            System.out.println(m.getName() + " HP: " + mHealth + " \\ " + m.getMaxHealth());
            // Fighter attacks
            f.attack(m);
        }else if (move == 2) { // Focus
            f.focus();
            System.out.println("Fighter " + f.getName() + " grew " + f.getFocusStacks() + " fold!");
        }else { // Block
            f.block();
            System.out.println("Fighter " + f.getName() + " is blocking.");
        }
    }

    public void monster_slain(Fighter f, Monster m) {
        System.out.println("-----------------------------------------------");
        System.out.println(m.getName() + " was slain!");
        System.out.println("You gained " + m.getExpGiven() + " experience!");
        System.out.println("-----------------------------------------------");
        System.out.println("Fighter " + f.getName() + "'s Stats:");
        System.out.println(
            "Level: " + f.getLevel() + 
            "\nExperience: " + f.getEXP() +
            "\nAttack: " + f.getAttackPower() +
            "\nMax Health: " + f.getMaxHealth() +
            "\nHealth: " + f.getHealth()
        );
        System.out.println("-----------------------------------------------");
    }

    public boolean level_cleared(InputHelper in, Fighter f, Monster m) {
        System.out.println("-----------------------------------------------");
        System.out.println(m);

        while(m.canFight() == true) {
            System.out.println("-----------------------------------------------");
            String options = "Select a move: Attack (1), Focus (2), Block (3)";
            int move = in.getIntegerInput(options, 1, 3);
            System.out.println("-----------------------------------------------");
            
            // Fighter's turn
            fighter_turn(f, m, move);
    
            // Monster's turn
            if (m.canFight() == false) { // Monster Dies
                break;
            }else {
                int prevHealth = f.getHealth();
                m.takeTurn(f);

                if (prevHealth == f.getHealth()) {
                    System.out.println(m.getName() + "'s attack missed!");
                }else {
                    System.out.println(m.getName() + " attacks!");
                    // Fighter Status
                    if (f.getHealth() < 0) {
                        f.setHealth(0);
                    }
                    System.out.println("Fighter " + f.getName() + " took " + m.getAttackPower() + " damage. -> " + 
                        " HP: " + f.getHealth() + " \\ " + f.getMaxHealth()
                    );
                }
            }
    
            // Fighter Dies
            if (f.canFight() == false) {
                System.out.println("-----------------------------------------------");
                System.out.println("YOU DIED");
                System.out.println("-----------------------------------------------");
                return false;            
            }
        }
        f.gainEXP(m.getExpGiven());
        monster_slain(f, m);
        return true;
    }

    public boolean playAgain(InputHelper in) {
        if (in.getYesNoInput("Play Again? Y/N") == false) {
            return false;
        }
        return true;
    }

    /**
     * Constructor that will allow User Experience.
     * Play the RPG!
	 */
    public void play(Scanner scanner){
        System.out.println("----Monster Fighter----");
        InputHelper input = new InputHelper(scanner);

        // Create Fighter
        System.out.print("Fighter's name: ");
        String name = scanner.nextLine();
        fighter = new Fighter(name, 100, 10);

        while(true){
            // Fight: Monster
            if (level_cleared(input, fighter, mon) == false) {
                if (playAgain(input) == true) {
                    // Reset stats
                    fighter = new Fighter(fighter.getName(), 100, 10);
                    mon = new Monster(mon.getName(), 100, 10, 50);
                    continue;
                }
                break;
            }
            System.out.println("Here comes a new challenger!");

            // Fight: Random Monster
            if (level_cleared(input, fighter, randMon) == false) {
                if (playAgain(input) == true) {
                    // Reset stats
                    fighter = new Fighter(fighter.getName(), 100, 10);
                    mon = new Monster(mon.getName(), 100, 10, 50);
                    randMon = new RandomMonster(randMon.getName(), 200, 20, 100);
                    continue;
                }
                break;
            }
            System.out.println("Here comes a new challenger!");

            // Fight: Defense Monster
            if (level_cleared(input, fighter, defMon) == false) {
                if (playAgain(input) == true) {
                    // Reset stats
                    fighter = new Fighter(fighter.getName(), 100, 10);
                    mon = new Monster(mon.getName(), 100, 10, 50);
                    randMon = new RandomMonster(randMon.getName(), 200, 20, 100);
                    defMon = new DefenseMonster(defMon.getName(), 250, 15, 150, 20);
                    continue;
                }
                break;
            }
            System.out.println(fighter.getName() + " slayed! (YOU WIN!)");
            if (playAgain(input) == true) {
                fighter = new Fighter(fighter.getName(), 100, 10);
                mon = new Monster(mon.getName(), 100, 10, 50);
                randMon = new RandomMonster(randMon.getName(), 200, 20, 100);
                defMon = new DefenseMonster(defMon.getName(), 250, 15, 150, 20);
                continue;
            }
            break;
        }
    }
}
