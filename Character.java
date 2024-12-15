public class Character {
    /** Boolean for closing game loop */
    public Boolean makingSoup;
    /**Boolean that allows makingSoup to be true if necessary actions are done with it true */
    public Boolean hasRecipe;

    /**sets values to false */
    public Character() {
        makingSoup = false;
        hasRecipe = false;
    }

    /** method for opening door between dining room and kitchen
     * @param Room kitchen
     * @param Room dining room
     * calls addNeighbor method to make these rooms accessible between each other
    */
    public void openKitchen(Room kitchen, Room diningRoom) {
        System.out.println("The housekeeper comes into the kitchen and looks around for the source of the racket. He turns a knob of the wood stove, stopping the sound, and returns to his bedroom, leaving the door to the kitchen ajar.");
        kitchen.addNeighbor(diningRoom);
        diningRoom.addNeighbor(kitchen);
    }

    /** method for if piano is possessed
     * prints statement
     */
    public void checkPiano() {
        System.out.println("The housekeeper comes into the living room, confused about the sound coming from the piano. He sees there is no one else in the house, and returns to his room.");
    }

    /** method for if piano is possessed once the recipe has been constructed
     * prints statement
     * sets hasRecipe to true
     */
    public void getRecipe() {
        System.out.println("The housekeeper comes into the living room, confused about the sound coming from the piano. He notices the torn up mail and goes into the entryway to get a closer look. He looks at the peice of paper from the letter and takes it back to his room.");
        hasRecipe = true;
    }

}
