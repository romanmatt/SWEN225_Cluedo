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


    public String toString() {
        return null;
    }
}
