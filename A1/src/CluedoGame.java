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

    RoomType solutionRoom;
    WeaponType solutionWeapon;
    CharacterType solutionCharacter;

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
     *
     * */
    public static String userInput() {
        String input = new String();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println(
                    "CLUEDO: TEXT-BASED TUI DESKTOP VERSION.\n" +
                            "PLAYERS:\n"+
                            "R - MISS SCARLETT \n"+
                            "M - COLONEL MUSTARD\n"+
                            "W - MRS. WHITE\n"+
                            "G - MR. GREEN\n"+
                            "E - MRS. PEACOCK\n"+
                            "P - PROFESSOR PLUM\n"+
                            "PLEASE ENTER CHARACTERS THAT YOU WOULD LIKE TO PLAY IN THE GAME BETWEEN 3-6.\n" +
                            "INPUT EXAMPLE: \"G P M\" , \"W R M P\""
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
        char token[] = str.toUpperCase().toCharArray();
        for(int i =0; i<token.length; i++){
            if(i==token.length-1 || token[i+1]==' '){

                Player player;

                //Check to see what token is in input
                //Scarlett
                if(token[i]=='R'){
                    player = new Player(CharacterType.MissScarlett);
                }
                //Mustard
                else if(token[i]=='M'){
                    player = new Player(CharacterType.ColonelMustard);
                }
                //White
                else if(token[i]=='W'){
                    player = new Player(CharacterType.MrsWhite);
                }
                //Green
                else if(token[i]=='G'){
                    player = new Player(CharacterType.MrGreen);
                }
                //Peacock
                else if(token[i]=='E'){
                    player = new Player(CharacterType.MrsPeacock);
                }
                //Plum
                else if(token[i]=='P'){
                    player = new Player(CharacterType.ProfessorPlum);
                }
                else{
                    System.out.print("ERROR: INVALID INPUT./n");
                    return false;
                }

                for(Player p: activePlayers){
                    if(p.equals(player)){
                        System.out.print("ERROR: CANNOT DUPLICATE SAME PLAYERS");
                        return false;
                        }
                }
                activePlayers.add(player);
                takeTurn(player);
                i++;
                }
                else{
                    System.out.print("ERROR: MUST BE SEPARATED BY ' '.");
                    return false;
                }
            }
        return true;
    }

    public boolean accuse(Accusation accusation) {
        if (accusation.accusedRoom == solutionRoom && accusation.accusedWeapon == solutionWeapon && accusation.accusedCharacter == solutionCharacter) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints instructions and accepts input for player turn
     * Calls appropriate action based on input
     * Move action calculates if move is possible
     * Accuse and suggest methods called
     */
    public void takeTurn(Player player) {
        System.out.println(player.toString() + "'s turn.");
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.println(player.toString() + " would you like to move? (Y/N)");
            Scanner s = new Scanner(System.in);
            input = s.next();
            if (input.equals("Y") || input.equals("N")) {
                validInput = true;
            } else {
                System.out.println("Please enter Y or N.");
            }
            s.close();
        }
        //----------------------------------------------
        if (input.equals("Y")) {
            // Move the player
            int steps = rollDiceGenerator();
            System.out.println(player.toString() + " has rolled a " + steps);
            String input = "";
            boolean validInput = false;
            int xCor;
            int yCor;
            
            while (!validInput) {
                System.out.println(player.toString() + " enter a coordinate seperated by a space eg:5 3");
                Scanner s = new Scanner(System.in);
                xCor = null;
                yCor = null;
                
                if (s.hasNextInt() && s.hasNextInt()) {
                    xCor = s.next();
                    yCor = s.next();
                    
                    if(xCor<26 && yCor<25){
                        validInput = true;
                    }
                    else{
                        System.out.println("Please enter a valid coordinate.");
                    }
                    
                } else {
                    System.out.println("Please enter a valid coordinate.");
                }
                s.close();
            }
            
           
        }
        //----------------------------------------------
        if (player.getRoom() != null) {
            // Make a suggestion or accusation
            validInput = false;
            while (!validInput) {
                System.out.println(player.toString() + " would you like to make a suggestion (S) or accusation (A)?");
                Scanner s = new Scanner(System.in);
                input = s.next();
                if (input.equals("S") || input.equals("A")) {
                    validInput = true;
                } else {
                    System.out.println("Please enter S or A.");
                }
                s.close();
            }
            //----------------------------------------------
            if (input.equals("S")) {
                // Make a suggestion
            }
            //----------------------------------------------
            if (input.equals("A")) {
                // Make an accusation
            }
        }
        System.out.println("End of " + player.toString() + "'s turn.");
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

    /**
     * toString() method from the board class
     * draws the board into console
     * */

    private void setupCards() {
    	ArrayList<Card> remainingDeck = new ArrayList<Card>();
    	ArrayList<RoomCard> roomDeck = new ArrayList<RoomCard>();
    	roomDeck.add(new RoomCard(RoomType.BALLROOM));
    	roomDeck.add(new RoomCard(RoomType.CONSERVATORY));
    	roomDeck.add(new RoomCard(RoomType.BILLIARD));
    	roomDeck.add(new RoomCard(RoomType.LIBRARY));
    	roomDeck.add(new RoomCard(RoomType.STUDY));
    	roomDeck.add(new RoomCard(RoomType.HALL));
    	roomDeck.add(new RoomCard(RoomType.LOUNGE));
    	roomDeck.add(new RoomCard(RoomType.DINING));
    	roomDeck.add(new RoomCard(RoomType.KITCHEN));
    	RoomCard murderRoom = roomDeck.get(new Random().nextInt(roomDeck.size()));
    	roomDeck.remove(murderRoom);
    	solutionRoom = murderRoom.getRoom();
    	remainingDeck.addAll(roomDeck);
    	ArrayList<WeaponCard> weaponDeck = new ArrayList<WeaponCard>();
    	weaponDeck.add(new WeaponCard(WeaponType.CANDLESTICK));
    	weaponDeck.add(new WeaponCard(WeaponType.DAGGER));
    	weaponDeck.add(new WeaponCard(WeaponType.LEADPIPE));
    	weaponDeck.add(new WeaponCard(WeaponType.REVOLVER));
    	weaponDeck.add(new WeaponCard(WeaponType.ROPE));
    	weaponDeck.add(new WeaponCard(WeaponType.SPANNER));
    	WeaponCard murderWeapon = weaponDeck.get(new Random().nextInt(weaponDeck.size()));
    	weaponDeck.remove(murderWeapon);
    	solutionWeapon = murderWeapon.getWeapon();
    	remainingDeck.addAll(weaponDeck);
    	ArrayList<CharacterCard> characterDeck = new ArrayList<CharacterCard>();
    	characterDeck.add(new CharacterCard(CharacterType.MISSSCARLET));
    	characterDeck.add(new CharacterCard(CharacterType.COLONELMUSTARD));
    	characterDeck.add(new CharacterCard(CharacterType.MRSWHITE));
    	characterDeck.add(new CharacterCard(CharacterType.MRGREEN));
    	characterDeck.add(new CharacterCard(CharacterType.MRSPEACOCK));
    	characterDeck.add(new CharacterCard(CharacterType.PROFESSORPLUM));
    	CharacterCard murderer = characterDeck.get(new Random().nextInt(characterDeck.size()));
    	characterDeck.remove(murderer);
    	solutionCharacter = murderer.getCharacter();
    	remainingDeck.addAll(characterDeck);
    	while (!remainingDeck.isEmpty()) {
    		for (Player p : activePlayers) {
    			if (!remainingDeck.isEmpty()) {
    				p.addToHand(remainingDeck.get(new Random().nextInt(remainingDeck.size())));
    			}
    		}
    	}
    }
    
    public void setupPlayers() {
    	for (Player p : activePlayers) {
    		if (p.getName() == CharacterType.MISSSCARLET) {
    			((HallwayCell) board.board[7][23]).placePlayer(p);
    		}
    		if (p.getName() == CharacterType.COLONELMUSTARD) {
    			((HallwayCell) board.board[0][17]).placePlayer(p);
    		}
    		if (p.getName() == CharacterType.MRSWHITE) {
    			((HallwayCell) board.board[9][0]).placePlayer(p);
    		}
    		if (p.getName() == CharacterType.MRGREEN) {
    			((HallwayCell) board.board[14][0]).placePlayer(p);
    		}
    		if (p.getName() == CharacterType.MRSPEACOCK) {
    			((HallwayCell) board.board[24][7]).placePlayer(p);
    		}
    		if (p.getName() == CharacterType.PROFESSORPLUM) {
    			((HallwayCell) board.board[24][19]).placePlayer(p);
    		}
    	}
    }
    
    public static void main(String[] args){
        CluedoGame cluedoGame = new CluedoGame();
        cluedoGame.run();
    }
}
