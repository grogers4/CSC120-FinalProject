//import java.util.List;
import java.util.Scanner;
//import java.lang.reflect.Array; // Import Array class

public class GameLoop {


    static Ghost player = new Ghost();

    
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        LargeItems possessed_item = null;

        int turns = 0;

        Character houseKeeper = new Character();

        Boolean almostSoupTime = false;

        //creating rooms
        Room entryway = new Room("entryway");
        Room diningRoom = new Room("diningroom");
        Room livingRoom = new Room("livingroom");
        Room upstairs = new Room("upstairs");
        Room kitchen = new Room("kitchen");
        Room bedroom = new Room("bedroom");
        Room basement = new Room("basement");
        Room chute = new Room("chute");
        //creating room info and descriptions
        entryway.addNeighbor(diningRoom);
        entryway.addNeighbor(livingRoom);
        entryway.addNeighbor(upstairs);
        bedroom.addNeighbor(livingRoom);
        diningRoom.addNeighbor(entryway);
        livingRoom.addNeighbor(bedroom);
        livingRoom.addNeighbor(entryway);
        upstairs.addNeighbor(entryway);
        basement.addNeighbor(kitchen);
        chute.addNeighbor(upstairs);
        chute.addNeighbor(kitchen);
        kitchen.addNeighbor(chute);
        kitchen.addNeighbor(basement);
        entryway.addDescription("You are in the entryway to what seems to be a fancy old house. The ceiling is high and the room is lit by a large chandelier. There is a large staircase leading upstairs in the middle of the room, and what apears to be a dining room to the left. A large doorway opens to a living room on the right. There is a metal plaque on the wall by the door, and a stack of mail on the floor by the door.");
        diningRoom.addDescription("You are in the dining room. A long wooden table lined with empty chairs occupies most of the room, but there is not much else. There is a small door, likely leading to the kitchen, but it is locked.");
        livingRoom.addDescription("You are in the living room. The furniture looks more formal than inviting, but there is a cat sleeping in a chair next to a ball of yarn. The far wall in lined with shelves of books, and a grand piano sits in the corner. There is a door leading to a bedroom.");
        upstairs.addDescription("You are upstairs. The long hallway is lined with doors, but they are all locked. There is a laundry chute at one end of the hall.");
        kitchen.addDescription("You are in the kitchen. There is a mix of modern and antique appliances, including an old wood stove. It looks like this room has not been used in a long time; everything is put away in cupboards, except for a bag of beans and some cans on the counter.");
        bedroom.addDescription("You are in a bedroom. This room seems very different than the other rooms in the house, the only one that appears to be in current use. There is a bed and desk and personal belongings strewn across the room. There is a small box of papers on the desk. The housekeeper is asleep in bed.");
        basement.addDescription("You are in the basement. The room is small and dark, and there is not much to see in the first place. The only light coming in is from up a small staircase, which leads to the kitchen.");
        chute.addDescription("You are in the basement. The room is small and dark, and there is not much to see in the first place. The only light coming in is from up a small staircase, which leads to the kitchen.");

        //creating items
        Item mail = new Item("mail", "A stack of several peices of mail. Some seem to be official notices, but one appears to be a personal correspondence, but the back of the envelope is facing down so you cannot see who it's addressed to.", entryway);
        Item plaque = new Item("plaque", "The plaque reads: This historic house, built in 1864, has been restored to it's origional state. The building is maintained year-round by a live in housekeeper and open to the public for six month of the year. Thank you for visiting.", entryway);
        Item cat = new Item("cat", "The cat is fast asleep", livingRoom);
        Item box = new Item("box", "You can see a few photos, one of a family standing outside a house, but the rest are not visible. the photo looks too old and the housekeeper too young for this to be a picture of him. The rest of the papers seem to be letters. The one on top is folded, the part you can read says: ...to hear your condition is worsening. You mentioned missing your mother's cooking- I believe I have a recipe for her soup somewhere. I am away now but I will send you the recipe as soon as I return. I always believed a good bowl of soup can heal the body and soul. I am visiting ...", bedroom);
        SmallItems yarn = new SmallItems("yarn", "A ball of gray yarn", livingRoom);
        SmallItems beans = new SmallItems("beans", "Just some beans.", kitchen);
        SmallItems cans = new SmallItems ("cans", "Two cans of vegetable broth", kitchen);
        LargeItems piano = new LargeItems("piano", "A fancy grand piano", livingRoom, "The piano plays an eerie out of sync tune.");
        LargeItems woodStove = new LargeItems("woodstove", "An old wood stove. It looks like it might still work, but it definitely hasn't been used in a long time.", kitchen, "The stove makes a loud clattering sound.");


        // "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        //get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse;

        // opening information
        System.out.println("You have died. When a person's life ends without satisfying their last wish, their soul becomes trapped between the physical world and the afterlife as a ghost. As one of these unlucky souls, it is your imperitive to complete your unfinished business and rest in peace. Unfortunately, you are unable to remember any of the details of your life or death. Ghosts are physically bound to the location they died, and unfortunately, you cannot remember any details from your own life. You must use your surroundings to discover and realize your unfinished business, but be careful not to waste time; souls that remain between the physical world and the afterlife too long start to fade, and eventually become unable to do anything at all, forever tortured by a desire they do not know and cannot fulfill. Good luck.");
        player.location = livingRoom; //have to set this to be able to use enter function to start game
        player.enter(entryway);
        
        //playing loop
        do {
            System.out.println("");
            userResponse = userInput.nextLine().toLowerCase();
            String [] userWords = userResponse.split(" ");
            if (userWords[0].equals("shrink")) {
                player.shrink();
                turns ++;
            } else if (userWords[0].equals("grow")) {
                player.grow();
                turns ++;
            } else if (userWords[0].equals("rest")) {
                player.rest();
                turns ++;
            } else if (userWords[0].equals("possess")) {   
                possessed_item = player.possess(userWords[1]);
                if (possessed_item == null) {
                } else {
                    if (possessed_item.equals(woodStove)) {
                        houseKeeper.openKitchen(kitchen, diningRoom);
                        if (houseKeeper.hasRecipe) {
                            almostSoupTime = true;
                        }
                    }
                    if (possessed_item.equals(piano)) {
                        if (SmallItems.isDropped(yarn)) {
                            houseKeeper.getRecipe();
                        } else {
                            houseKeeper.checkPiano();
                        }
                    }
                }
                turns ++;
            } else if (userWords[0].equals("undo")) {
                if (player.isPossessing) {
                    LargeItems.unpossess(possessed_item);
                    player.undo();
                    if (almostSoupTime) {
                        houseKeeper.makingSoup = true;
                    }
                } else {
                    System.out.println("You can only undo if you are possessing something");
                }
                turns ++;
            } else if (userWords[0].equals("grab")) {
                String grabbingItem = "";
                int array_length = userWords.length;
                int p;
                for (p = 1; p < array_length; p ++) {
                    grabbingItem = grabbingItem + userWords[p];
                    if (p < (array_length-1)) {
                        grabbingItem = grabbingItem + " ";
                    }
                }
                player.grab(grabbingItem);
                turns ++;
            } else if (userWords[0].equals("drop")) {
                Boolean dropped = player.drop(userWords[1]);
                if (dropped) {
                    if (userWords[1].equals("yarn")) {
                        System.out.println("The cat is woken by the ball of yarn dropping. She chses the ball as it rolls toward the entryway. As she's swatting at the yarn, she becomes more interested in the mail on the floor. She tears up the personal envelope, revealing the paper that was inside. After this she gets bored and returns to her previous spot.");
                        Item paper = new Item("paper", "The peice of paper has a recipe for hearty winter soup.", entryway);
                    }
                }
                turns ++;
            } else if (userWords[0].equals("examine")) {
                player.examine(userWords[1]);
                turns ++;
            } else if (userWords[0].equals("enter")){
                if (userWords.length > 2) {
                    System.out.println("please type the room you'd like to enter as one word");
                } else {
                    if (userWords[1].equals("chute")) {
                        if (player.getSize() > 1) {
                            System.out.println("You are too big to go down the chute now");
                        } else {
                            player.enter(Room.getRoom(userWords[1]));
                        }
                    } else {
                        player.enter(Room.getRoom(userWords[1]));
                    }
                }
                turns ++;
            } else if (userWords[0].equals("help")) {
                System.out.println("If you are having trouble figuring out what to do, here is a list of commands available to you: \nexamine ___ \ndrop ___ \npossess ___\ngrab ___ \nenter ___ \nshrink\nrest\ngrow\nundo\nNot all commands will work on all objects. If you use a command on a room or item that is multiple words, you must type it as one word with no space.");
            } else {
                System.out.println("I don't understand. Try to rephrase your command or try something else");
                turns ++;
            }
            
            //check to see if the game should end
            if (turns > 100) {
                stillPlaying = false;
                System.out.println("Your effort to fulfill your unfinished business has taken too long. You can no longer exert any control over your actions. You will wander this house as a ghost, lost and confused, forever.");
            }
            if (houseKeeper.makingSoup) {
                stillPlaying = false;
                System.out.println("The housekeeper returns to the kitchen, holding the recipe from the letter and a bag of groceries. He gets out a a large pot and other kitchen supplies and begins to cook. As the soup he's making comes together, the kitchen is filled with a wonderful aroma that makes you feel calm and happy. You begin to remember parts of your life, including your time as the housekeeper here, the illness that took your life, and how all you wanted in your last days was to experience your mother's soup one more time. Your soul passes to the afterlife in peace.");
            }
        }
        while (stillPlaying);

        // close
        userInput.close();

    }

}
