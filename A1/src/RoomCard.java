/**
 * Room cards
 * Contains room card methods
 */
class RoomCard implements Card {
    RoomType room = null;
    
    /** Constructor */
    public RoomCard (RoomType room){
        this.room = room;   
    }
    
    /** Setter */
    public RoomType setRoom (RoomType room){
        this.room = room;   
    }
    
    /** Getter */
    public RoomType getRoom() {
        return this.room;
    }

    /** Remove */
    public RoomType removeRoom() {
        this.room = null;
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
}
