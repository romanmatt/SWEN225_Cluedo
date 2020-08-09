
public class Fringe implements Comparable {
	Fringe prev;
	int steps;
	Cell cell;
	
	public Fringe(Cell cell) {
		this.prev = null;
		this.steps = 0;
		this.cell = cell;
	}
	
	public Fringe(Fringe prev, Cell cell) {
		this.prev = prev;
		this.steps = prev.steps + 1;
		this.cell = cell;
	}

	public int compareTo(Object o) {
		if (o.getClass() != Fringe.class) {
			return 0;
		} else {
			if (((Fringe) o).steps > steps) {
				return -1;
			} else if (((Fringe) o).steps < steps) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
