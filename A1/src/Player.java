import java.util.ArrayList;

public class Player {
    private CharacterType playersCharacter;
    private RoomCell playersRoom;
    private boolean isStillPlaying;
    private ArrayList <Card> playersHand = new ArrayList<>();
    String notes = ""; //Any extra notes for the player

    /* Constructor for the Player object */
    public Player(CharacterType character){
        this.playersCharacter = character;
        isStillPlaying = true;
    }
    /* Helper methods */

    public ArrayList<Card> getHand(){
        return this.playersHand;
    }


    public CharacterType getName(){
        return this.playersCharacter;
    }


    //Not needed but will remain just in case

    /**
     * Used for removing a player from the game loop when an accusation is incorrect
     * @param isStillPlaying
     */
    public void isStillPlaying(boolean isStillPlaying){
        this.isStillPlaying = isStillPlaying;
    }

    public boolean getIsStillPlaying(){
        return this.isStillPlaying;
    }









}



