
public class Town  implements Comparable<Town>{
	
	private String name;
	private int weight;
	private Town pred;
	
	
	
	public Town(String name ) {
		this.name = name;
		this.weight = 0;
		this.pred = null;
	}
	
	
	public Town (Town templateTown) {
		this.name = templateTown.name;
	}

	
	
	@Override
	public int compareTo(Town o) {
		int compareValue;
		if (this.hashCode() == o.hashCode()) {
			compareValue = 0;
		}
		else {
			return this.name.compareTo(o.name);
		}
		
		return compareValue;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return name;
	}
	
	
	public int hashCode() {
		return name.hashCode();	
	}
	
	public Town getPred() {
		return pred;
	}
	
	public void setPred(Town pred) {
		this.pred = pred;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean equals;
		if (this.hashCode() == o.hashCode()) {
			equals = true;
		}
		else {
			equals = false;
		}
		return equals;
	}
}
