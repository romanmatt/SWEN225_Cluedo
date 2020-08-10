import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class CluedoGame {
    private static boolean isGameOver;
    public int numOfSteps;
    private static Board board = new Board();
    private Player player;
    private boolean gameWon = false;

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
            input = "";
            validInput = false;
            int xCor;
            int yCor;
            
            while (!validInput) {
                System.out.println(player.toString() + " enter a coordinate you can reach in " + steps + " steps seperated by a space eg:5 3");
                Scanner s = new Scanner(System.in);
                xCor = -1;
                yCor = -1;
                
                //check coord right format
                if (s.hasNextInt() && s.hasNextInt()) {
                    xCor = s.nextInt();
                    yCor = s.nextInt();
                    
                    //check coord within boundary
                    if(xCor<26 && yCor<25){
                        
                        boolean reachable = false;
                        int pX = player.getY();
                        int pY = player.getX();
                        
                        int xSum;
                        int ySum;
                        
                        if(xCor>pX){
                            xSum = xCor - pX;
                        }
                        else{
                            xSum = pX - xCor;
                        }
                        
                        if(yCor>pY){
                            ySum = yCor - pY;
                        }
                        else{
                            ySum = pY - yCor;
                        }
                        
                        if(xSum+ySum == steps){
                            reachable = true;
                        }
                        
                        //check coord is reachable
                        if(board.canMove(player, board.board[xCor][yCor], steps)){
                            board.movePlayer(player, board.board[xCor][yCor]);
                            
                        } else { System.out.println("You cannot reach that location. Please enter a valid coordinate.");}
                    } else { System.out.println("Please enter a coordinate within the board's boundaries.");}
                } else { System.out.println("Please enter a valid number.");}
                s.close();
            }
            
           
        }
        //----------------------------------------------
        if (player.getRoom() != null) { // Player must be in a room to make a suggestion or accusation
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
                boolean validWeapon = false;
                boolean validChar = false;
                
                //check valid input
                System.out.println(player.toString() + " is making a suggestion.");
                RoomType suggestedRoom = player.getRoom(); // The player always has to suggest the room they're in
                WeaponType suggestedWeapon = null;
                CharacterType suggestedCharacter = null;    
                
                // Chose the weapon
                while (!validWeapon) {
                    System.out.println(player.toString() + ",  suggest a weapon.");
                    System.out.println("1. Candle Stick\n" +
                      					"2. Dagger\n" + 
                       					"3. Lead Pipe\n" +
                       					"4. Revolver\n" +
                       					"5. Rope\n" +
                       					"6. Spanner");
                    Scanner s = new Scanner(System.in);
                    int chosenWeapon = s.nextInt();
                    if (chosenWeapon == 1) {
                    	suggestedWeapon = WeaponType.CANDLESTICK;
                      	validWeapon = true;
                    } else if (chosenWeapon == 2) {
                       	suggestedWeapon = WeaponType.DAGGER;
                      	validWeapon = true;
                    } else if (chosenWeapon == 3) {
                       	suggestedWeapon = WeaponType.LEADPIPE;
                       	validWeapon = true;
                    } else if (chosenWeapon == 4) {
                       	suggestedWeapon = WeaponType.REVOLVER;
                       	validWeapon = true;
                    } else if (chosenWeapon == 5) {
                       	suggestedWeapon = WeaponType.ROPE;
                       	validWeapon = true;
                    } else if (chosenWeapon == 6) {
                       	suggestedWeapon = WeaponType.SPANNER;
                       	validWeapon = true;
                    } else {
                       	System.out.println("Please enter a number between 1 and 6.");
                    }    
                    s.close();
                } 
                // Choose the character
                while (!validChar) {
                    System.out.println(player.toString() + ", suggest a character.");
                    System.out.println("1. Miss Scarlet\n" + 
                     					"2. Colonel Mustard\n" +
                       					"3. Mrs White\n" +
                       					"4. Mr Green\n" +
                       					"5. Mrs Peacock\n" +
                       					"6. Professor Plum");
                    Scanner s = new Scanner(System.in);
                    int chosenCharacter = s.nextInt();
                    if (chosenCharacter == 1) {
                    	suggestedCharacter = CharacterType.MISSSCARLET;
                       	validChar = true;
                    } else if (chosenCharacter == 2) {
                       	suggestedCharacter = CharacterType.COLONELMUSTARD;
                       	validChar = true;
                    } else if (chosenCharacter == 3) {
                       	suggestedCharacter = CharacterType.MRSWHITE;
                       	validChar = true;
                    } else if (chosenCharacter == 4) {
                       	suggestedCharacter = CharacterType.MRGREEN;
                       	validChar = true;
                    } else if (chosenCharacter == 5) {
                       	suggestedCharacter = CharacterType.MRSPEACOCK;
                       	validChar = true;
                    } else if (chosenCharacter == 6) {
                       	suggestedCharacter = CharacterType.PROFESSORPLUM;
                       	validChar = true;
                    } else {
                       	System.out.println("Please enter a number between 1 and 6.");
                    }
                    s.close();
                }
                board.moveCharacter(suggestedCharacter, suggestedRoom);
                Suggestion suggestion = new Suggestion(suggestedRoom, suggestedWeapon, suggestedCharacter, player);
                for (Player p : activePlayers) {
                	if (suggestion.testSuggestion(p)) {
                		break;
                	}
                }
            }
            //----------------------------------------------
            if (input.equals("A")) {
                // Make an accusation
                boolean validWeapon = false;
                boolean validChar   = false;
                
                //check valid input
                System.out.println(player.toString() + " is making an accusation");
                RoomType accusedRoom = player.getRoom(); // Accusations must be made from the accused room.
                WeaponType accusedWeapon = null;
                CharacterType accusedCharacter = null;
                while (!validWeapon) {
                    System.out.println(player.toString() + ", accuse a weapon.");
                    System.out.println("1. Candle Stick\n" +
                    					"2. Dagger\n" +
                    					"3. Lead Pipe\n" +
                    					"4. Revolver\n" +
                    					"5. Rope\n" + 
                    					"6. Spanner");
                    Scanner s = new Scanner(System.in);
                    int chosenWeapon = s.nextInt();
                    if (chosenWeapon == 1) {
                    	accusedWeapon = WeaponType.CANDLESTICK;
                    	validWeapon = true;
                    } else if (chosenWeapon == 2) {
                    	accusedWeapon = WeaponType.DAGGER;
                    	validWeapon = true;
                    } else if (chosenWeapon == 3) {
                    	accusedWeapon = WeaponType.LEADPIPE;
                    	validWeapon = true;
                    } else if (chosenWeapon == 4) {
                    	accusedWeapon = WeaponType.REVOLVER;
                    	validWeapon = true;
                    } else if (chosenWeapon == 5) {
                    	accusedWeapon = WeaponType.ROPE;
                    	validWeapon = true;
                    } else if (chosenWeapon == 6) {
                    	accusedWeapon = WeaponType.SPANNER;
                    	validWeapon = true;
                    } else {
                    	System.out.println("Please enter a number between 1 and 6.");
                    }
                    s.close();
                }                
                while (!validChar) {
                    System.out.println(player.toString() + ", accuse a character.");
                    System.out.println("1. Miss Scarlet\n" + 
                    					"2. Colonel Mustard\n" +
                    					"3. Mrs White\n" +
                    					"4. Mr Green\n" +
                    					"5. Mrs Peacock\n" +
                    					"6. Professor Plum");
                    Scanner s = new Scanner(System.in);
                    int chosenCharacter = s.nextInt();
                    if (chosenCharacter == 1) {
                    	accusedCharacter = CharacterType.MISSSCARLET;
                       	validChar = true;
                    } else if (chosenCharacter == 2) {
                    	accusedCharacter = CharacterType.COLONELMUSTARD;
                       	validChar = true;
                    } else if (chosenCharacter == 3) {
                    	accusedCharacter = CharacterType.MRSWHITE;
                       	validChar = true;
                    } else if (chosenCharacter == 4) {
                    	accusedCharacter = CharacterType.MRGREEN;
                       	validChar = true;
                    } else if (chosenCharacter == 5) {
                    	accusedCharacter = CharacterType.MRSPEACOCK;
                       	validChar = true;
                    } else if (chosenCharacter == 6) {
                    	accusedCharacter = CharacterType.PROFESSORPLUM;
                       	validChar = true;
                    } else {
                       	System.out.println("Please enter a number between 1 and 6.");
                    }
                    s.close();
                }
                board.moveCharacter(accusedCharacter, accusedRoom);
                Accusation accusation = new Accusation(accusedRoom, accusedWeapon, accusedCharacter);
                if (accuse(accusation)) {
                	win(player);
                } else {
                	lose(player);
                }
            }
            System.out.println("End of " + player.toString() + "'s turn.");
        }
    }
        
    /**
     * Win function
     * Ends game and calls win screen
     */
    public void win(Player player){
        System.out.println(player.toString() + " has won!");
        System.out.println(player.toString() + " has correctly accused the perpetrator " + solutionCharacter.toString());
        System.out.println( " who used a " +  solutionWeapon.toString() + " in " +  solutionRoom.toString());
    }
    
    public void lose(Player player) {
    	activePlayers.remove(player);
    	System.out.println(player.toString() + " has made an incorrect accusation, and was murdered.");
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
        cluedoGame.setupCards();
        cluedoGame.setupPlayers();
        cluedoGame.clock();
    }

	private void clock() {
		while (!gameWon) {
			for (Player p : activePlayers) {
				takeTurn(p);
			}
		}
	}
}
