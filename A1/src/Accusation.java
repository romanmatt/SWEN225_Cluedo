public class Accusation {
    public RoomType accusedRoom;
    public WeaponType accusedWeapon;
    public CharacterType accusedCharacter;
    private Player player;


    /* Constructor for Accusation object */
    public Accusation(RoomType accusedRoom, WeaponType accusedWeapon, CharacterType accusedCharacter, Player player){
        this.accusedRoom = accusedRoom;
        this.accusedWeapon = accusedWeapon;
        this.accusedCharacter = accusedCharacter;
        this.player = player;
    }

// Moved this method to CluedoGame to have access to the solution
//public boolean checkAccusation(){
//        for(int i = 0; i < 6; i++){
//
//            //this is temporary
//            System.out.println();
//            player.setIsStillPlaying(false);
//            System.out.println("Player " + player.getName() + " is out!");
//            return false;
//
//        }
//
//
//        return false;
//}


    public String toString() {
        return null;
    }
}
