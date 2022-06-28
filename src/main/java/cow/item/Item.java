package cow.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Simple class for storing item class - probably to be expanded with functionality
 *
 */
@Entity
public class Item {
	public Item() {
		this.name = null;
	}

	public Item (String name) {
		this.name = name;
	}
	
	private @Id @GeneratedValue Long id;
	private String name;
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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

