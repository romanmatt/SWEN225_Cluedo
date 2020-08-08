public class CharacterCard implements Card {
    CharacterType character;

    /* Constructor */
    public CharacterCard(CharacterType character) {
        this.character = character;
    }


    public CharacterType getCharacter() {
        return this.character;
    }



    public boolean equals(Object o){
        //checking if o is null
        if(o == null){
            return false;
        }

        //checking if o is equal to this class
        if(getClass() != o.getClass()){
            return false;
        }
        CharacterCard other = (CharacterCard) o;
        return this.character == other.character;
    }

   public String getCharacterName() {
       return this.character.toString();
   }
   

   public void delete(){

   }


}
