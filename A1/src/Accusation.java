public class Accusation {
    public RoomType accusedRoom;
    public WeaponType accusedWeapon;
    public CharacterType accusedCharacter;


    /* Constructor for Accusation object */
    public Accusation(RoomType accusedRoom, WeaponType accusedWeapon, CharacterType accusedCharacter){
        this.accusedRoom = accusedRoom;
        this.accusedWeapon = accusedWeapon;
        this.accusedCharacter = accusedCharacter;
    }


public boolean checkAccusation(Player player){
        for(int i = 0; i < 6; i++){

            //this is temporary
            System.out.println();
            player.setIsStillPlaying(false);
            System.out.println("Player " + player.getName() + " is out!");
            return false;

        }


        return false;
}


    public String toString() {
        return null;
    }
}
