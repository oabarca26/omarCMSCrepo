/**
 * @author Omar Abarca
 */
public class Town implements Comparable<Town>{

	private String name;
	
	public Town(String name) {
		this.name = name;
	}
	
	public Town(Town templateTown) {
		name = templateTown.getName();
	}

	@Override
	public int compareTo(Town o) {
		if(getName().equals(o.getName()))
			return 0;
		return 1;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Town [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
