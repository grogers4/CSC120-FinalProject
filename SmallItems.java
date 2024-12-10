import java.util.Hashtable;

public class SmallItems extends Item{
    
    private String name;
    private String description;
    private static Hashtable<String, String> itemDescriptions;
    private static Hashtable<String, Room> itemLocations;
    public Room location;
    public Boolean dropped;

    public SmallItems(String name, String description, Room location) {
        super(name, description, location);
        this.dropped = false;
    }


    
}
