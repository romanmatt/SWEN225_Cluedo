import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CluedoGame {
    private static boolean isGameOver;
    public int numOfSteps;
    private static Board board = new Board();
    private Player player;

    private static String [] characterList = {"W: Mrs. White",
            "S: Miss Scarlett", "M: Colonel Mustard",
            "P: Professor Plum", "C: Mrs. Peacock",
            "G: Mr. Green"};
    private static String [] weaponList = {""};
    private static String [] roomList = {""};

    ArrayList<Card> allDeckCards = new ArrayList<Card>();
    ArrayList<Player> activePlayers = new ArrayList<Player>();
    ArrayList<Card> playerDeck = new ArrayList<Card>();
    ArrayList<Card> solutionDeck = new ArrayList<Card>();


    /**
     * run() is a collective of methods
     * responsible for the text GUI of the game
     * */
    public void run(){
        userInput();
    }

    /**
     * userInput() takes care of the user's text input
     * on choice of number of players, what player they wish to play
     * */
    private int userInput() {
        Scanner sc = new Scanner(System.in);
        int num;
        try{
            System.out.println("CLUEDO: TEXT-BASED GUI DESKTOP VERSION.\n" +
                    "PLEASE ENTER NUMBER OF PLAYERS BETWEEN [3-6] FOR THE GAME: \n" +
                    "INPUT EXAMPLE: 4 "
            );
            num = sc.nextInt();
            if(num<3 || num>6 ){
                throw new IllegalArgumentException("NOT A VALID NUMBER! PLEASE ENTER NUMBER FROM 3-6.");
            }
        }
        catch(Error e) {
            System.out.println("ERROR: " + e);
        }


        }







    /**
     * Make two die variable that randomly generates
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

    public static void main(String[] args){
        CluedoGame cluedoGame = new CluedoGame();
        cluedoGame.run();
    }



}
