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
    public WeaponType setWeapon (WeaponType weapon){
        this.weapon = weapon;   
    }
    
    /** Getter */
    public WeaponType getWeapon() {
        return this.weapon;
    }

    /** Remove */
    public WeaponType removeWeapon() {
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
}
