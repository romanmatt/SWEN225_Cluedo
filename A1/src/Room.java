class Room {
  private ArrayList<Cell> cells; // The cells of the board that make up this room
  private ArrayList<Cell> doors; // The door cells this room uses for movement calculations 
  private ArrayList<Player> players; // The players currently in this room 
  private ArrayList<Weapon> weapons; // The weapon piece currently in this room
  
  public ArrayList<Cell> getCells() {
    return cells;
  }
  
  public ArrayList<Cell> getDoors() {
    return doors;
  }
  
  public ArrayList<Player> getPlayers() {
    return players;
  }
  
  public ArrayList<Weapon> getWeapons() {
    return weapons;
  }
  
  public Boolean containsWeapon(Weapon weapon) {
    if (weapons.contains(weapon)) {
      return true;
    } else {
      return false;
    }
  }
  
  public Boolean containsPlayer(Player player) {
    if (players.contains(player)) {
      return true;
    } else {
      return false;
    }
  }
  
  public void placePlayer(Player player) {
    players.add(player);
  }
  
  public void placeWeapon(Weapon weapon) {
    weapons.add(weapon);
  }
  
  public void removePlayer(Player player) {
    if (players.contains(player)) {
      players.remove(player);
    }
  }
  
  public void removeWeapon(Weapon weapon) {
    if (weapons.contains(weapon)) {
      weapons.remove(weapon);
    }
  }
}
