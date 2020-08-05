class Room {
  private ArrayList<Cell> cells; // The cells of the board that make up this room
  private ArrayList<Cell> doors; // The door cells this room uses for movement calculations 
  private ArrayList<Character> characters; // The players currently in this room 
  private ArrayList<Weapon> weapons; // The weapon piece currently in this room
  
  public ArrayList<Cell> getCells() {
    return cells;
  }
  
  public ArrayList<Cell> getDoors() {
    return doors;
  }
  
  public ArrayList<Character> getCharacters() {
    return characters;
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
  
  public Boolean containsCharacter(Character character) {
    if (characters.contains(character)) {
      return true;
    } else {
      return false;
    }
  }
  
  public void placeCharacter(Character character) {
    characters.add(character);
  }
  
  public void placeWeapon(Weapon weapon) {
    weapons.add(weapon);
  }
  
  public void removeCHaracter(Character character) {
    if (characters.contains(charatcer)) {
      characters.remove(character);
    }
  }
  
  public void removeWeapon(Weapon weapon) {
    if (weapons.contains(weapon)) {
      weapons.remove(weapon);
    }
  }
}
