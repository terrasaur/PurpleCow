package cow;

import org.json.JSONObject;

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
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns a JSON string of the object Item
	 * @return formatted JSON string
	 */
	public String getJson() {		
		return "{\n\"id\": " + id + "\n, \"name\": " + JSONObject.quote(name) + "\n}";
	}
}
