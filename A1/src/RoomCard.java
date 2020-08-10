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
    
    /** To String */
    public String toString(){
        if(getRoom() instanceof RoomType.BALLROOM){
            return "Ballroom";
        }
        if(getRoom() instanceof RoomType.CONSERVATORY){
            return "Conservatory";
        }
        if(getRoom() instanceof RoomType.BILLIARDROOM){
            return "Billiard Room";
        }
        if(getRoom() instanceof RoomType.LIBRARY){
            return "Library";
        }
        if(getRoom() instanceof RoomType.STUDY){
            return "Study";
        }
        if(getRoom() instanceof RoomType.HALL){
            return "Hall";
        }
        if(getRoom() instanceof RoomType.LOUNGE){
            return "Lounge";
        }
        if(getRoom() instanceof RoomType.DININGROOM){
            return "Dining Room";
        }
        if(getRoom() instanceof RoomType.KITCHEN){
            return "Kitchen";
        }     
    }
    
}
