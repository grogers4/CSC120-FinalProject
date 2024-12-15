import java.util.Hashtable;

public class SmallItems extends Item{
    
    private static Hashtable<String, String> smallItemDescriptions = new Hashtable<String, String>();
    private static Hashtable<String, Room> smallItemLocations = new Hashtable<String, Room>();
    /**Hashtable for storing String name corresponding with SmallItems */
    public static Hashtable<String, SmallItems> smallItemNames = new Hashtable<String, SmallItems>();
    /**Hashtable for storing SmallItems with boolean for whether it has been dropped */
    public static Hashtable<SmallItems, Boolean> itemDropped = new Hashtable<SmallItems, Boolean>();
    /**Room location of item */
    public Room location;
        
    /**
     * constructor for SmallItems
     * stes values and adds to relevant hashtables
     * @param String name of item
     * @param String description of item
     * @param Room location 
     */
    public SmallItems(String name, String description, Room location) {
        super(name, description, location);
        smallItemDescriptions.put(name, description);
        this.location = location;
        smallItemLocations.put(name, location);
        smallItemNames.put(name, this);
        itemDropped.put(this, false);
    }
        
    /**
     * getter for item location
     * returns location of item of null if it doesn't exist
     * @param String name of item
     * @return Room location
     */
    public static Room getLocation(String name) {
        if (smallItemLocations.containsKey(name)) {
            return smallItemLocations.get(name);
        } else {
            return null;
        }
    }
        
    /**
     * getter for item description
     * @param String name of SmallItems
     * @return name if object exists
     */
    public static String getDescription(String name) {
        if (smallItemDescriptions.containsKey(name)) {
        return smallItemDescriptions.get(name);
        } else {
            System.out.println("I don't know what " + name + " is.");
            return null;
        }
    }
        
    /**
     * getter for SmallItems from name
     * @param String name of item
     * @return SmallItems or null if the item doesn't exist
     */
    public static SmallItems getItem(String name) {
        if (itemNames.containsKey(name)) {
        return smallItemNames.get(name);
        } else {
            System.out.println("I don't know this item");
            return null;
        }
    }
    
    /**
     * method for dropping item
     * sets boolean in itemDropped hashtable to true if action successful
     * @param SmallItems item to be dropped
     */
    public static void drop(SmallItems item) {
        if (itemDropped.containsKey(item)) {
            Boolean dropped = true;
            itemDropped.replace(item, dropped);
        } else {
            System.out.println("I don't know this item.");
        }
    }

    /**
     * getter for boolean of whether item has been dropped
     * @param SmallItems
     * @return Boolean whether item has been dropped
     */
    public static Boolean isDropped(SmallItems item) {
        return itemDropped.get(item);
    }
    
}
