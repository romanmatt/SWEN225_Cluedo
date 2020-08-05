class WeaponCard implements Card {
    WeaponType weapon;

    public WeaponCard(WeaponType weapon){
        this.weapon = weapon;
    }



    public void setWeapon(WeaponType weapon){
        this.weapon = weapon;

    }

    public WeaponType getWeapon(){
        return this.weapon;
    }

    /* Deletes selected weapon */
    public void delete(){

    }




}
