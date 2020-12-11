
public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	Road(Town source, Town destination, int i, String roadName){
		this.source = source;
		this.destination = destination;
		this.weight = i; 
		this.name = roadName;
	}
	
	Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		this.weight = 1; 
	}

	public boolean contains(Town town) {
		boolean contains;
		
		if(town.equals(this.source) || town.equals(this.destination)) {
			contains = true;
		}
		else {
			contains = false;
		} 
		
		return contains;
	}
	
	//incomplete
	@Override
	public String toString() {
		return "";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Town getDestination() {
		return this.destination;
	}
	
	public void setDestination(Town o) {
		this.destination = o;
	}
	
	public Town getSource() {
		return this.source;
	}
	
	public void setSource(Town o) {
		this.source = o;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object a) {
		boolean equals;
		
		if(((Road) a).contains(this.source) && ((Road) a).contains(this.destination)) {
			equals = true;
		}
		else {
			equals = false;
		}
		
		return equals;
		
	}

	@Override
	public int compareTo(Road o) {
		if(this.equals(o)) {
			return 0;
		}
		else {
			return this.source.compareTo(o.source);
		}
	}

}
