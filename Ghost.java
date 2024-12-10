import java.util.Hashtable;

public class Ghost {

    private int ghostPowers;
    private Boolean isPossessing;
    private int size;
    public Room location;


    /**
     * constructor for a ghost
     */
    public Ghost() {
        ghostPowers = 5;
        isPossessing = false;
        size = 2;
    }

    public Room getLocation() {
        return this.location;
    }

    /**
     * method to attempt to grab item
     * prints statement that the item can't be grabbed cause you're a ghost
     * @param Items 
     */
    public void grab(Item word) {
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
        if (this.location == Item.getLocation(item)) {
            System.out.println(Item.getDescription(item));
        } else {
            throw new RuntimeException("This item cannot be found in this room.");
        }
        
    }

    /**
     * makes ghost possess the item if they have enough ghost power
     * sets isPossessing boolean to true
     * @param string item
     */
    public void possess(Item name) {
        if (ghostPowers>0) {
            System.out.println("You are now possessing the " + name + ". Scary. Everyone who interacts with this item will be very very scared.");
            isPossessing = true;
            ghostPowers = 0;
        } else { 
            System.out.println("You do not currently have the power to possess this item.");
        }
    }


    /**
     * method to 
     * @param 
     */
    public void enter(Room name) {
        if (isPossessing == false) {
            if (name.enter(this)) {
                location = name;
            }
        } else { 
            System.out.println("You cannot move while possessing something.");
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
                System.out.println("You have shrunk");
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
                System.out.println("You have grown");
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
        isPossessing = false;
    }

    public static void main(String[] args) {
    }

}