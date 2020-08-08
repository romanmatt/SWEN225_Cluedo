class RoomCard implements Card {
    RoomType room = null;
    
    public RoomCard (RoomType room){
        this.room = room;   
    }
    
    public RoomType getRoom() {
        return this.room;
    }
    
    
}
