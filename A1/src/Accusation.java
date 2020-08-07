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
            System.out.println(); //temporary

            //if the accused weapon, character and room matches the murderer's
            //game stops
            //player can no longer play
        }


        return false;
}


    public String toString() {
        return null;
    }
}
