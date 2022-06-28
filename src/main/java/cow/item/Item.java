package cow.item;


/**
 * Simple class for storing item class - probably to be expanded with functionality
 * @author terrasaur
 *
 */
public class Item {

	public Item (Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private final int id;
	private String name;
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns a JSON string of the object Item
	 * @return formatted JSON string
	 */
	@Override
	public String toString() {
	    return "Item{id=" + this.id + ", name=\"" + this.name + "\"}";
	}
}
