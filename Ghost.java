import java.util.Hashtable;

public class Ghost {

    /**hashtable to store items in the house and their description */
    public Hashtable<String, String> objectDescription;
    /**hashtable to store  */
    public Hashtable<String, Boolean> smallObjects;

    private int ghostPowers;

    private Boolean isPossessing;

    private int size;

    public String coordinates;

    /**
     * constructor for a ghost
     */
    public Ghost() {
        System.out.println("You have died and are now a ghost haunting a small house.");
        ghostPowers = 5;
        isPossessing = false;
        size = 2;
    }

    /**
     * method to attempt to grab item
     * prints statement that the item can't be grabbed cause you're a ghost
     * @param Items 
     */
    public void grab(Items word) {
        System.out.println("Your ghost hand passes through the " + word + ". Ghosts cannot grab things.");
    }

    /**
     * drops the object to the floor if it has not already been dropped and if there is enough ghost power
     * @param string item 
     * @returns string item
     */
    public String drop(String item) {
        if (smallObjects.containsKey(item)) {
            if (smallObjects.get(item)) {
                if (ghostPowers > 0) {
                    System.out.println(item + " clatters to the floor. Spooky.");
                    ghostPowers --;
                    smallObjects.replace(item, false);
                } else { 
                    System.out.println("You do not have enough ghostly power to do this right now.");
                }
            } else { 
                throw new RuntimeException("You've already knocked this item to the floor");
            } 
        } else { 
            throw new RuntimeException("You do not have the power to drop this item");
        }
        return item;
    }

    /**
     * prints description of the item from the hashtable
     * @param string item
     */
    public void examine(String item) {
        System.out.println(objectDescription.get(item));
    }

    /**
     * makes ghost possess the item if they have enough ghost power
     * sets isPossessing boolean to true
     * @param string item
     */
    public void use(String item) {
        if (ghostPowers>0) {
            System.out.println("You are now possessing the " + item + ". Scary. Everyone who interacts with this item will be very very scared.");
            isPossessing = true;
            ghostPowers = 0;
        } else { 
            System.out.println("You do not currently have the power to possess this item.");
        }
    }

    /**
     * method to walk (ghosts cannot walk, so always returns false) 
     * @param string direction
     * @returns boolean false 
     */
    public boolean walk(String direction) {
        System.out.println("Ghosts can't walk. Try flying if you want to move around.");
        return false;
    }

    /**
     * method to fly, sets coordinates if they are within acceptable range
     * @param int x
     * @param int y
     * @return Boolean based on success of flying
     */
    public boolean fly(int x, int y) {
        if (isPossessing == false) {
            if (x < 31) {
                if (y < 31) {
                    String str_x = Integer.toString(x);
                    String str_y = Integer.toString(y);
                    coordinates = "(" + str_x + ", " + str_y + ")";
                    System.out.println("New coordinates: " + coordinates);
                    return true;
                } else {
                    throw new RuntimeException("Your soul is permanently bound to the location you died: a one room house under 1,000 sqaure feet. Please enter coordinate values no greater than 30 when flying.");
                }
            } else { 
                throw new RuntimeException("Your soul is permanently bound to the location you died: a one room house under 1,000 sqaure feet. Please enter coordinate values no greater than 30 when flying.");
            }
        } else { 
            System.out.println("You cannot fly while possessing something.");
            return false;
        }

    }

    /**
     * method to decrease size by 1, unless starting size is already shrunken
     * @returns int current size after shrinking
     */
    public Number shrink() {
        if (ghostPowers > 0) {
            if (size > 1) {
                size --;
                ghostPowers--;
            } else { 
                System.out.println("You are too little to shrink");
            }
        } else { 
            throw new RuntimeException("You do not have enough power to shrink");
        }
        return size;
    }

    /**
     * method to increase starting size by one if it is not already enlarged
     * @returns int current size
     */
    public Number grow() {
        if (ghostPowers > 0) {
            if (size < 3) {
                size ++;
                ghostPowers --;
            } else { 
                System.out.println("You are too big to grow");
            }
        } else { 
            throw new RuntimeException("You do not have enough power to grow");
        }
        return size;
    }
    
    /**
     * method to reset ghostPowers to 5 if the ghost is not currently possessing
     */
    public void rest() {
        if (isPossessing == false) {
            ghostPowers = 5;
            System.out.println("You are well rested and your ghost powers are replenished.");
        } else { 
            throw new RuntimeException("You cannot rest while possessing an item.");
        }
        
    }

    /**
     * method to undo possession
     */
    public void undo() {
    }

    public static void main(String[] args) {
    }

}