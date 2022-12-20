package u4pp;
import java.util.Scanner;

public class InputHelper {
    Scanner input;

    /**
	 * Constructs a scanner that is used to read the input.
	 * @param scanner the scanner.
	 */
    public InputHelper(Scanner scanner){
        input = scanner;
    }

    /**
	 * Checks if player answers prompt with y, Y, n, or N.
	 * @param prompt the message given to player.
     * @return true if input starts with y, Y, n, or N.
	 */
    public boolean getYesNoInput(String prompt){
        System.out.println(prompt);
        String userInput = (input.next().substring(0, 1)).toLowerCase();
        
        while(!(userInput.equals("y")) && !(userInput.equals("n"))) {
            System.out.println("Input is invalid.");
            System.out.println(prompt);
            userInput = (input.next().substring(0, 1)).toLowerCase();
        }
        if(userInput.equals("y")){
            return true;
        }
        return false;
    }
    
    /**
	 * Checks if player answers prompt with proper integer.
	 * @param prompt the message given to player.
     * @param min the minimum value of the integer.
     * @param max the maximum value of the integer.
     * @return userInput if input is larger than or equal to min & less than or equal to max.
	 */
    public int getIntegerInput(String prompt, int min, int max){
        int num = 0;

        boolean inputError = false;
        while (!inputError) {
            try {
                System.out.println(prompt);
                String userInput = input.nextLine();
                num = Integer.parseInt(userInput);
                
                while(num < min || num > max){
                    System.out.println("Input is invalid.");
                    System.out.println(prompt);
                    userInput = input.nextLine();
                    num = Integer.parseInt(userInput);
                }
                inputError = true;
            }catch (NumberFormatException e) {
                System.out.println("Input is invalid.");
            }
        }

        return num;
    }
}
