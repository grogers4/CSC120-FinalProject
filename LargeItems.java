import java.util.Hashtable;

//large items that can be possessed
public class LargeItems extends Item{
    
    private static Hashtable<String, String> itemDescriptions = new Hashtable<String, String>();
    private static Hashtable<String, Room> itemLocations = new Hashtable<String, Room>();
    /**Hashtable for storing String names of items corresponding to LargeItems */
    public static Hashtable<String, LargeItems> itemNames = new Hashtable<String, LargeItems>();
    /**Hashtable for storing whether item is being possessed */
    public static Hashtable<LargeItems, Boolean> itemPossessing = new Hashtable<LargeItems, Boolean>();
    /**Hashtable for storing description for items when they become possessed */
    public static Hashtable<LargeItems, String> itemPossessedDescription = new Hashtable<LargeItems, String>();
    /** Room location of LargeItems */
    public Room location;
            
    /**
     * constructor for LargeItems
     * adds values to relevant hashtables and sets location
     * @param String name of item
     * @param String description of item
     * @param Room location of item
     * @param String description of possessed item
     */
    public LargeItems(String name, String description, Room location, String possessDescrip) {
        super(name, description, location);
        itemDescriptions.put(name, description);
        this.location = location;
        itemLocations.put(name, location);
        itemNames.put(name, this);
        Boolean possessed = false;
        itemPossessing.put(this, possessed);
        itemPossessedDescription.put(this, possessDescrip);
    }
    
    /**
     * getter for item location
     * checks is name correlates with an Item
     * @param String name of large item
     * @return Room or null if item doesn't exist
     */
    public static Room getLocation(String name) {
        if (itemLocations.containsKey(name)) {
            return itemLocations.get(name);
        } else {
            return null;
        }
    }
        
    /**
    * getter for item description
     * @param String name of item
     * @return String description if LargeItems exists
     */
    public static String getDescription(String name) {
        if (itemDescriptions.containsKey(name)) {
        return itemDescriptions.get(name);
        } else {
            System.out.println("I don't know what " + name + " is.");
            return null;
        }
    }
    
    /**
     * getter for LargeItems from name
     * @param String name of item
     * @return LargeItems or null if the item doesn't exist
     */
    public static LargeItems getItem(String name) {
        if (itemNames.containsKey(name)) {
        return itemNames.get(name);
        } else {
            System.out.println("I don't know this item");
            return null;
        }
    }

    /**
     * method for possessing
     * sets possessing to be true in itemPossessing hashtable
     * @param LargeItems item
     */
    public static void possess(LargeItems item) {
        if (itemPossessing.containsKey(item)) {
            Boolean possessing = true;
            itemPossessing.replace(item, possessing);
        } else {
            System.out.println("I don't know this item.");
        }
    }

    /**
     * method for unpossessing
     * sets Boolean in itemPossessing hashtable to false
     * @param LargeItems item
     */
    public static void unpossess(LargeItems item) {
        if (itemPossessing.containsKey(item)) {
            Boolean possessing = false;
            itemPossessing.replace(item, possessing);
        } else {
            System.out.println("I don't know this item.");
        }
    }

    /**
     * getter for description of possessed item
     * returns description for item when it is possessed or null if the item doesn't exist
     * @param String name of LargeItems
     * @return String description of possessed item
     */
    public static String getPossessedDescription(String name) {
        if (itemNames.containsKey(name)) {
        return itemPossessedDescription.get(itemNames.get(name));
        } else {
            System.out.println("I don't know this item");
            return null;
        }
    }

}
