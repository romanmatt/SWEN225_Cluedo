import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CluedoGame {
    private static boolean isGameOver;
    private static Board board = new Board();
    private Player player;
    public int numOfSteps;


    ArrayList<Card> allDeckCards = new ArrayList<Card>();
    ArrayList<Player> activePlayers = new ArrayList<Player>();
    
    /**
     * Make two variable that randomly generates
     * numbers between 1-6 and add them together to get
     * sum total
     * @ return dieSum
     * */
    public int rollDiceGenerator() {
        int die1 = (int) (Math.random()*6) +1;
        int die2 = (int) (Math.random()*6) +1;
        int dieSum = die1 + die2;
        return dieSum;
    }

    /**
     * introGame() is a method that asks users how many players are
     * playing.
     * */
    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        try{
            System.out.println("CLUEDO: TEXT-BASED GUI DESKTOP VERSION.\n" +
                    "PLEASE ENTER INITIALS OF PLAYERS BETWEEN [3-6] FOR THE GAME: \n" +
                    "INPUT EXAMPLE: \"M W G P\""
            );
            input = sc.nextLine();
        }
        catch(Error e){
            System.out.println("ERROR: " + e);
        }
        return input;
    }





}
