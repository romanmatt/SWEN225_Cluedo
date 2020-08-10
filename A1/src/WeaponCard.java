/**
 * Weapon cards
 * Contains weapon card methods
 */
class WeaponCard implements Card {
    WeaponType weapon = null;
    
    /** Constructor */
    public WeaponCard (WeaponType weapon){
        this.weapon = weapon;   
    }
    
    /** Setter */
    public void setWeapon (WeaponType weapon){
        this.weapon = weapon;   
    }
    
    /** Getter */
    public WeaponType getWeapon() {
        return this.weapon;
    }

    /** Remove */
    public void removeWeapon() {
        this.weapon = null;
    }

    /** Equals */
    public boolean equals(Object o){
        //checking if o is null
        if(o == null){
            return false;
        }

        //checking if o is equal to this class
        if(getClass() != o.getClass()){
            return false;
        }

        WeaponCard other = (WeaponCard) o;
        return this.weapon == other.weapon;
    }
    
    /** To String */
    public String toString(){
        if(getWeapon() instanceof RoomType.BALLROOM){
            return "Ballroom";
        }
        if(getWeapon() instanceof RoomType.CONSERVATORY){
            return "Conservatory";
        }
        if(getWeapon() instanceof RoomType.BILLIARDROOM){
            return "Billiard Room";
        }
        if(getWeapon() instanceof RoomType.LIBRARY){
            return "Library";
        }
        if(getWeapon() instanceof RoomType.STUDY){
            return "Study";
        }
        if(getWeapon() instanceof RoomType.HALL){
            return "Hall";
        }
        if(getWeapon() instanceof RoomType.LOUNGE){
            return "Lounge";
        }
        if(getWeapon() instanceof RoomType.DININGROOM){
            return "Dining Room";
        }
        if(getWeapon() instanceof RoomType.KITCHEN){
            return "Kitchen";
        }     
    }
}
