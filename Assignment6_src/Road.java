/**
 * @author Omar Abarca
 */
public class Road implements Comparable<Road>{
	
	private Town source;
	private Town destination;
	private String name;
	private int weight;
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		this.weight = degrees;
	}
	
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		weight = 1;
	}
	
	public boolean contains(Town town) {
		if (getSource().getName().equals(town.getName())|| getDestination().getName().equals(town.getName()))
			return true;
		return false;
	}

	public Town getSource() {
		return source;
	}

	public Town getDestination() {
		return destination;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Road [source=" + source + ", destination=" + destination + ", name=" + name + ", weight=" + weight
				+ "]";
	}

	@Override
	public boolean equals(Object r) {
		Road road = (Road) r;
        return (road.destination.equals(this.destination) 
                && road.source.equals(this.source)) || 
                (road.destination.equals(this.source) 
                && road.source.equals(this.destination));
	}

	@Override
	public int compareTo(Road o) {
		if(getName().equals(o.getName()))
			return 0;
		return 1;
	}

}
