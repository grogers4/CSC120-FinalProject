import java.util.List;

public class Room {

    public String name;
    public String description;
    public boolean ghost;
    public List<Room> neighboring;


    /* Full constructor */
    public Room(String name) {
        this.name = name;
        ghost = false;
    }

    public void addNeighbor(Room room) {
        neighboring.add(room);
    }

    public void addDescription(String description) {
        this.description = (description);
    }

    /* Accessors */
    public String getName() {
        return this.name;
    }

    /* Navigation methods */
    public Boolean enter(Ghost name) {
        if (ghost = true) {
            throw new RuntimeException("You are already in this room.");
        } 
        if (neighboring.contains(name.getLocation())) { //check if you're in a neighboring room)
            ghost = true;
            System.out.println(description); 
            return true;
        } else {
            throw new RuntimeException("You cannot currently enter this room");
        }
    }
        
    

    public void exit() {
        throw new RuntimeException("Where would you like to go?");
    }


    public static void main(String[] args) {
        Room entryway = new Room("entryway");
        Room diningRoom = new Room("dining room");
        Room livingRoom = new Room("living room");
        Room upstairs = new Room("upstairs");
        Room kitchen = new Room("kitchen");
        Room bedroom = new Room("bedroom");
        Room basement = new Room("basement");
        entryway.addNeighbor(diningRoom);
        entryway.addNeighbor(livingRoom);
        entryway.addNeighbor(upstairs);
        diningRoom.addNeighbor(entryway);
        livingRoom.addNeighbor(bedroom);
        livingRoom.addNeighbor(entryway);
        upstairs.addNeighbor(entryway);
        upstairs.addNeighbor(basement);
        basement.addNeighbor(upstairs);
        basement.addNeighbor(kitchen);

        entryway.addDescription("You are in the entryway to what seems to be a fancy old house. The ceiling is high and the room is lit by a large chandelier. There is a large staircase leading upstairs in the middle of the room, and what apears to be a dining room to the left. A large doorway opens to a living room on the right. There is a metal plaque on the wall by the door, and a stack of mail on the floor by the door.");
        diningRoom.addDescription("You are in the dining room. A long wooden table lined with empty chairs occupies most of the room, but there is not much else. There is a small door, likely leading to the kitchen, but it is locked.");
        livingRoom.addDescription("You are in the living room. The furniture looks more formal than inviting, but there is a cat sleeping in a chair next to a ball of yarn. The far wall in lined with shelves of books, and a grand piano sits in the corner. There is a door leading to a bedroom.");
        upstairs.addDescription("You are upstairs. The long hallway is lined with doors, but they are all locked. There is a laundry shoot at one end of the hall.");
        kitchen.addDescription("You are in the kitchen. It looks like it has not been used in a long time; everything is put away in cupboards, except for a bag of beans and some cans on the counter.");
        bedroom.addDescription("You are in a bedroom. This room seems very different than the other rooms in the house, the only one that appears to be in current use. There is a bed and desk and personal belongings strewn across the room. There is a small box of papers on the desk.");
        basement.addDescription("You are in the basement. The room is small and dark, and there is not much to see in the first place. The only light coming in is from up a small staircase, which leads to the kitchen.");

    } 

}


