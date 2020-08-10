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
        if(getRoom().equals(RoomType.BALLROOM)){
            return "Ballroom";
        }
        if(getRoom().equals(RoomType.CONSERVATORY)){
            return "Conservatory";
        }
        if(getRoom().equals(RoomType.BILLIARDROOM)){
            return "Billiard Room";
        }
        if(getRoom().equals(RoomType.LIBRARY)){
            return "Library";
        }
        if(getRoom().equals(RoomType.STUDY)){
            return "Study";
        }
        if(getRoom().equals(RoomType.HALL)){
            return "Hall";
        }
        if(getRoom().equals(RoomType.LOUNGE)){
            return "Lounge";
        }
        if(getRoom().equals(RoomType.DININGROOM)){
            return "Dining Room";
        }
        if(getRoom().equals(RoomType.KITCHEN)){
            return "Kitchen";
        }
        return "";
    }
}
