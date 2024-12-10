import java.util.Hashtable;

public class Item {

    private String name;
    private String description;
    private static Hashtable<String, String> itemDescriptions;
    private static Hashtable<String, Room> itemLocations;
    public Room location;
        
            /*constructor for items */
        public Item(String name, String description, Room location) {
            this.name = name;
            this.description = description;
            itemDescriptions.put(name, description);
            this.location = location;
        }
        
        public static Room getLocation(String name) {
            if (itemLocations.contains(name)) {
                return itemLocations.get(name);
            } else {
                throw new RuntimeException("I don't know what " + name + " is.");
            }
        }
    
        /**
         * getter for item description
         * @param name
         * @return name if object exists
         */
        public static String getDescription(String name) {
            if (itemDescriptions.containsKey(name)) {
            System.out.println(itemDescriptions.get(name));
            return name;
          } else {
            throw new RuntimeException("I don't know what " + name + " is.");
          }
    }

}


