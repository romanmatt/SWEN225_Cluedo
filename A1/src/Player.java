import java.util.ArrayList;

public class Player {

	
	
	private CharacterType playersCharacter;
    private RoomType room;
    private boolean isStillPlaying;
    private ArrayList <Card> hand = new ArrayList<>();
    private Cell cell;
    String notes = ""; //Any extra notes for the player

  
    
    /* Constructor for the Player object */
    public Player(CharacterType character){
        this.playersCharacter = character;
        isStillPlaying = true;
    }

    /* Helper methods */

    public void addToHand(Card c) {
    	hand.add(c);
    }	
	
    public int getX() {
  		return cell.getX();
  	}

  	public int getY() {
  		return cell.getY();
  	}

  	public Cell getCell() {
  		return cell;
  	}

  	public RoomType getRoom() {
  		return room;
  	}

    public CharacterType getName(){
        return this.playersCharacter;
    }
    
    public ArrayList<Card> getHand() {
    	return hand;
    }

     public String toString() {
    	if (playersCharacter == CharacterType.COLONELMUSTARD) {
    		return "Colonel Mustard";
    	}
    	if (playersCharacter == CharacterType.MISSSCARLET) {
    		return "Miss Scarlet";
    	}
    	if (playersCharacter == CharacterType.MRSWHITE) {
    		return "Mrs White";
    	}
    	if (playersCharacter == CharacterType.MRGREEN) {
    		return "Mr Green";
    	}
    	if (playersCharacter == CharacterType.MRSPEACOCK) {
    		return "Mrs Peacock";
    	}
    	if (playersCharacter == CharacterType.PROFESSORPLUM) {
    		return "Professor Plum";
    	}
    	return "[Player name not found]";
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
