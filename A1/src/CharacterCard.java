/**
 * Character cards
 * Contains character card methods
 */
class CharacterCard implements Card {
    CharacterType character = null;
    
    /** Constructor */
    public CharacterCard (CharacterType character){
        this.character = character;   
    }
    
    /** Setter */
    public void setCharacter (CharacterType character){
        this.character = character;   
    }
    
    /** Getter */
    public CharacterType getCharacter() {
        return this.character;
    }

    /** Remove */
    public void removeCharacter() {
        this.character = null;
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

        CharacterCard other = (CharacterCard) o;
        return this.character == other.character;
    }
    
    /** To String */
    public String toString(){
        if(getCharacter().equals(CharacterType.MISSSCARLETT)){
            return "Miss Scarlett";
        }
        if(getCharacter().equals(CharacterType.COLONELMUSTARD)){
            return "Colonel Mustard";
        }
        if(getCharacter().equals(CharacterType.MRSWHITE)){
            return "Mrs. White";
        }
        if(getCharacter().equals(CharacterType.MRGREEN)){
            return "Mr. Green";
        }
        if(getCharacter().equals(CharacterType.MRSPEACOCK)){
            return "Mrs. Peacock";
        }
        if(getCharacter().equals(CharacterType.PROFESSORPLUM)){
            return "Professor Plum";
        }
        return "";
    }
}
