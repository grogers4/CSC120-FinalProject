
public class Ghost {

    private int ghostPowers;
    /** Boolean for whether ghost is possessing something */
    public Boolean isPossessing;
    private int size;
    /** Room of current location */
    public Room location;


    /**
     * constructor for a ghost
     * sets size, ghost powers, and isPossessing
     */
    public Ghost() {
        ghostPowers = 5;
        isPossessing = false;
        size = 2;
    }

    /**
     * getter for location
     * @return Room location of ghost
     */
    public Room getLocation() {
        return this.location;
    }

    /**
     * getter for size
     * @return int size of ghost
     */
    public int getSize() {
        return this.size;
    }

    /**
     * method to attempt to grab item
     * prints statement that the item can't be grabbed cause you're a ghost
     * @param String word that player wants to grab
     */
    public void grab(String word) {
        System.out.println("Your ghost hand passes through the " + word + ". Ghosts cannot grab things.");
    }

    /**
     * drops the object to the floor if it has not already been dropped and if there is enough ghost power
     * @param String name of item 
     * @returns Boolean based on whether an item was dropped
     * checks if name of item is viable for dropping, if the item is in the same room as player, and if the item has already been dropped
     */
    public Boolean drop(String name) {
        SmallItems item = SmallItems.getItem(name);
        if (item == null) {
            System.out.println("You cannot drop this item");
            return false;
        } else {
            if (SmallItems.itemNames.containsKey(name)) {
                if (item.location.equals(this.location)) {
                    if (ghostPowers > 0) {
                        if (SmallItems.itemDropped.get(item)) {
                            System.out.println("You've already knocked this item to the floor");
                            return false;
                        } else {
                            System.out.println(name + " falls to the floor. Spooky.");
                            ghostPowers --;
                            SmallItems.drop(item);
                            return true;
                        }
                    } else {
                        System.out.println("You do not have the power to drop this item");
                        return false;
                    }
                } else {
                    System.out.println("You must be in the same room to drop an item");
                    return false;
                }
            } else {
                System.out.println("I don't know this object");
                return false;
            }
        }
    }

    /**
     * method for examining item
     * checks if name entered is a small item, large item, or item in the same location as the player
     * prints description of the item from the hashtable, or that the item cannot be found
     * @param string name of item
     */
    public void examine(String item) {
        if (this.location.equals(Item.getLocation(item))) {
            System.out.println(Item.getDescription(item));
        } else if (this.location.equals(SmallItems.getLocation(item))) {
            System.out.println(SmallItems.getDescription(item));
        } else if (this.location.equals(LargeItems.getLocation(item))) {
            System.out.println(LargeItems.getDescription(item));
        } else {
            System.out.println("This item cannot be found in this room.");
        }
        
    }

    /**
     * makes ghost possess the item if they have enough ghost power
     * sets isPossessing boolean to true
     * @param String item name
     * @return LargeItems item being possessed, or null if action is unsuccessful
     */
    public LargeItems possess(String name) {
        LargeItems item = LargeItems.getItem(name);
        if (item == null) {
            System.out.println("You cannot possess that");
            return null;
        } else {
            if (ghostPowers>0) {
                if (this.location == LargeItems.getLocation(name)) {
                    System.out.println("You are now possessing the " + name + ".");
                    isPossessing = true;
                    ghostPowers = 0;
                    System.out.println(LargeItems.getPossessedDescription(name));
                    return LargeItems.getItem(name);
                } else {
                    System.out.println("You are not in the same room as this object.");
                    return null;
                }  
            } else { 
                System.out.println("You do not currently have the power to possess this item.");
                return null;
            }
        } 
    }


    /**
     * method to enter room
     * checks if name entered is an accurate room name and if player is currently possessing something
     * calls Room.enter(player) and enters if value returned is true
     * @param Room name of room
     */
    public void enter(Room name) {
        if (name == null) {
            System.out.println("This is not the name of a room you can enter");
        } else {
            if (isPossessing == false) {
                if (name.enter(this)) {
                    location = name;
                } 
            } else { 
                    System.out.println("You cannot move while possessing something.");
            }
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
            System.out.println("You do not have enough power to shrink");
        }
        return size;
    }

    /**
     * method to increase size by one if it is not already enlarged
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
            System.out.println("You do not have enough power to grow");
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
            System.out.println("You cannot rest while possessing an item.");
        }
        
    }

    /**
     * method to undo possession
     * checks if player is possessing anything, prints statements based on that
     */
    public void undo() {
        if (isPossessing) {
            isPossessing = false;
            System.out.println("You are no longer possessing anything");
        } else {
            System.out.println("You can only undo if you are possessing something");
        }
        
    }

    public static void main(String[] args) {
    }

}