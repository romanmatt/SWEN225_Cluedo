import java.util.*;

public class Suggestion {
    
    //Temporary 
    
//    public RoomType suggestedRoom;
//    public WeaponType suggestedWeapon;
//    public CharacterType suggestedCharacter;
//    public String toString() {
//        return null;
//    }

    private Card[] suggestion;
    private Player currentPlayer;
    private ArrayList<Player> listOfPlayers;
    private Scanner scanner;

    /* Constructor for Suggestion object */
    public Suggestion(Card[] guesses, Player player, ArrayList<Player> listOfPlayers){
        this.suggestion = guesses;
        this.currentPlayer = player;
        this.listOfPlayers = listOfPlayers;
        scanner = new Scanner(System.in);


    }

}
