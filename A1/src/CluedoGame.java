import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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

        while(true){
            String input = userInput();
            if(isInputValid(input)){
                break;
            }
        }

    }

    /**
     * userInput() takes care of the user's text input
     * on what player they wish to play
     * @param input
     * */
    public static String userInput() {
        String input = new String();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println(
                    "CLUEDO: TEXT-BASED TUI DESKTOP VERSION.\n" +
                    "PLAYERS:\n"+
                    "S - MISS SCARLETT \n"+
                    "M - COLONEL MUSTARD\n"+
                    "W - MRS. WHITE\n"+
                    "G - MR. GREEN\n"+
                    "E - MRS. PEACOCK\n"+
                    "P - PROFESSOR PLUM\n"+
                    "PLEASE ENTER CHARACTERS THAT YOU WOULD LIKE TO PLAY IN THE GAME BETWEEN 3-6.\n" +
                    "INPUT EXAMPLE: \"G-P-M\" "
            );
            input = sc.nextLine();
        }
        catch(Error e) {
            System.out.println("ERROR:NOT A VALID INPUT! PLEASE ENTER CHARACTERS BETWEEN 3-6 PLAYERS " + e);
        }
        return input;
    }

    /**
     * Helper Method for userInput()
     * called isInputValid() which goes through
     * the string input
     * @return false
     * */
    private boolean isInputValid(String str){
        String [] token = str.split("-");
        for(int i =0; i<token.length; i++){
            if(token[i+1].equals(" ")|| i== (token.length-1)){

                Player player;

                //Check to see what token is in input
                //Scarlett
                if(token[i].equals("S")){
                    player = new Player(CharacterType.MissScarlett);
                }
                //Mustard
                else if(token[i].equals("M")){
                    player = new Player(CharacterType.ColonelMustard);
                }
                //White
                else if(token[i].equals("W")){
                    player = new Player(CharacterType.MrsWhite);
                }
                //Green
                else if(token[i].equals("G")){
                    player = new Player(CharacterType.MrGreen);
                }
                //Peacock
                else if(token[i].equals("E")){
                    player = new Player(CharacterType.MrsPeacock);
                }
                //Plum
                else if(token[i].equals("P")){
                    player = new Player(CharacterType.ProfessorPlum);
                }
                else{
                    System.out.print("ERROR: INVALID INPUT.");
                        return false;
                }

                activePlayers.add(player);

                for(Player p: activePlayers){
                    if(p.equals(player)){
                        System.out.print("ERROR: CANNOT DUPLICATE SAME PLAYERS");
                        return false;
                    }
                }
            }
            else{
                System.out.print("ERROR: MUST BE SEPARATED BY '-' ");
                return false;
            }
        }
        return true;
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
