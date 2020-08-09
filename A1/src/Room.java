import java.util.ArrayList;

class Room {
    private ArrayList<Cell> cells = new ArrayList<Cell>(); // The cells of the board that make up this room
    private ArrayList<DoorCell> doors = new ArrayList<DoorCell>(); // The door cells this room uses for movement calculations
    private ArrayList<Character> characters = new ArrayList<Character>(); // The players currently in this room
    private ArrayList<WeaponType> weapons = new ArrayList<WeaponType>(); // The weapon piece currently in this room

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public ArrayList<DoorCell> getDoors() {
        return doors;
    }

    public void addCell(RoomCell cell) {
        cells.add(cell);
    }
    
    public void addDoor(DoorCell door) {
		doors.add(door);
	}

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }

    public Boolean containsWeapon(WeaponType weapon) {
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

    public void placeWeapon(WeaponType weapon) {
        weapons.add(weapon);
    }

    public void removeCharacter(Character character) {
        if (characters.contains(character)) {
            characters.remove(character);
        }
    }

    public void removeWeapon(WeaponType weapon) {
        if (weapons.contains(weapon)) {
            weapons.remove(weapon);
        }
    }
}
