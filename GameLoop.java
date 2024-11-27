import java.util.Scanner;

public class GameLoop {

    public static void main(String[] args) {

        // "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        //get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // opening information
        System.out.println("");

        
        do {
            System.out.println("");
            userResponse = userInput.nextLine().toUpperCase();

            //check to see if the game should end
            if () {
                stillPlaying = false;
            }
        } while (stillPlaying);

        // close
        userInput.close();

        
    }

}