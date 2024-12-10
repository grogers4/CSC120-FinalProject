import java.util.List;
import java.util.Scanner;

public class GameLoop {

    static Ghost player = new Ghost();
    String [] keyWords = {"grab", "drop", "examine", "possess", "shrink", "grow", "rest", "undo"};
    
    public static void main(String[] args) {

        // "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        //get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        //String userResponse = "";
        String userResponse;

        // opening information
        System.out.println("You have died. When a person's life ends without satisfying their last wish, their soul becomes trapped between the physical world and the afterlife as a ghost. As one of these unlucky souls, it is your imperitive to complete your unfinished business and rest in peace. Unfortunately, you are unable to remember any of the details of your life or death. Ghosts are physically bound to the location they died, and unfortunately, you cannot remember any details from your own life. You must use your surroundings to discover and realize your unfinished business, but be careful not to waste time; souls that remain between the physical world and the afterlife too long start to fade, and eventually become unable to do anything at all, forever tortured by a desire they do not know and cannot fulfill. Good luck.");

        
        do {
            System.out.println("");
            userResponse = userInput.nextLine().toLowerCase();
            String [] userWords = userResponse.split(" ");
            if (userWords[0].equals("shrink")) {
                player.shrink();
            } else if (userWords[0].equals("grow")) {
                player.grow();
            } else if (userWords[0].equals("rest")) {
                player.rest();
            } else if (userWords[0].equals("undo")) {
                player.undo();
            } else if (userWords[0].equals("grab")) {
                //player.grab(userWords[1]);
            } else if (userWords[0].equals("drop")) {
                player.drop(userWords[1]);
            } else if (userWords[0].equals("examine")) {
                player.examine(userWords[1]);
            } else if (userWords[0].equals("possess")) {
                //player.possess(userWords[1]);
            } else {
                System.out.println("I don't understand. Try to rephrase your command or try something else");
            }
            
                //check to see if the game should end
                if (Character.makingSoup) {
                stillPlaying = false;
                }
        }
        while (stillPlaying);

        // close
        userInput.close();

        
    }

}
