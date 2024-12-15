import java.util.Hashtable;

public class Item {

    private static Hashtable<String, String> itemDescriptions = new Hashtable<String, String>();
    private static Hashtable<String, Room> itemLocations = new Hashtable<String, Room>();
    /** Hashtable for storing a String for the name of the Item it describes */
    public static Hashtable<String, Item> itemNames = new Hashtable<String, Item>();
    /** Room location of item */
    public Room location;
            
    /**
     * constructor for items
     * @param String name of item
     * @param String description of item
     * @param Room location of item
     * sets location and adds information to appropriate hashtables
     */
    public Item(String name, String description, Room location) {
        this.location = location;
        itemNames.put(name, this);
        itemDescriptions.put(name, description);
        itemLocations.put(name, location);
    }
            
    /**
     * getter for item location
     * checks is name correlates with an Item
     * @param String name of item
     * @return Room or null if item doesn't exist
     */
    public static Room getLocation(String name) {
        if (itemLocations.containsKey(name)) {
            return itemLocations.get(name);
        } else {
            System.out.println("I don't know what " + name + " is.");
            return null;
        }
    }
        
    /**
     * getter for item description
     * checks if name corresponds to an Item
     * @param String name of item
     * @return String description of item if object exists
     */
    public static String getDescription(String name) {
        if (itemDescriptions.containsKey(name)) {
        return itemDescriptions.get(name);
        } else {
            return null;
        }
    }
    
    /**
     * getter for Item from name
     * @param String name of item
     * @return Item or null if the Item doesn't exist
     */
    public static Item getItem(String name) {
        if (itemNames.containsKey(name)) {
        return itemNames.get(name);
        } else {
            System.out.println("I don't know this item");
            return null;
        }
    }

}


