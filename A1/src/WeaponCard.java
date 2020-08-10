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
        if(getWeapon() instanceof WeaponType.CANDLESTICK){
            return "Candlestick";
        }
        if(getWeapon() instanceof WeaponType.DAGGER){
            return "Dagger";
        }
        if(getWeapon() instanceof WeaponType.LEADPIPE){
            return "Lead Pipe";
        }
        if(getWeapon() instanceof WeaponType.REVOLVER){
            return "Revolver";
        }
        if(getWeapon() instanceof WeaponType.ROPE){
            return "Rope";
        }
        if(getWeapon() instanceof WeaponType.SPANNER){
            return "Spanner";
        }
    }

}
