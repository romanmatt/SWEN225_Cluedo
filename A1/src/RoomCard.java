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
    public void setRoom (RoomType room){
        this.room = room;   
    }
    
    /** Getter */
    public RoomType getRoom() {
        return this.room;
    }

    /** Remove */
    public void removeRoom() {
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

        RoomCard other = (RoomCard) o;
        return this.room == other.room;
    }
}
