package cow.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to provide the data to the API
 * Note: this code pretty closely follows the Spring tutorial
 * found here: https://spring.io/guides/tutorials/rest/
 */
@RestController
public class ItemController {

	// TODO: make this a database/utility class
	private ItemRepository itemMap ;


	public ItemController(ItemRepository items) {
		this.itemMap = items;
	}

	// gets all items from list
	@GetMapping("/items")
	protected List<Item> getAll() {
		return new ArrayList<Item>(itemMap.findAll() );
	}

	// gets one
	@GetMapping("/items/{id}")
	protected Item getOne(@PathVariable Long id) throws AttributeNotFoundException {
		return itemMap.findById(id).orElseThrow(() -> new AttributeNotFoundException("ID : " + id));
	}

	// instructions say 'set the list of items' so I'm gonna delete the
	// current list and replace it. I guess use put instead if you want
	// to add to the item list?
	@PostMapping("/items")
	protected List<Item> replaceAllItems(@RequestBody List<Item> newItems) {
		itemMap.deleteAllInBatch();
		return itemMap.saveAll(newItems);
	}

	// updates existing item if it finds one, otherwise adds it
	@PutMapping("/items/{id}")
	protected Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
		Optional<Item> existing = itemMap.findById(id);
		if(existing.isPresent()){
			existing.get().setName(newItem.getName());
			return itemMap.save(existing.get());
		} else {
			return itemMap.save(newItem);
		}
	}

	// saves all (TODO: look up how saveAll works if IDs match existing)
	@PutMapping("/items")
	protected List<Item> addItems(@RequestBody List<Item> newItems) {
		return itemMap.saveAll(newItems);
	}

	// deletes single item
	@DeleteMapping("/items/{id}")
	protected void deleteItem(@PathVariable Long id) {
		itemMap.deleteById(id);
	}

	// clears list
	@DeleteMapping("/items/")
	protected void deleteAllItems() {
		itemMap.deleteAllInBatch();
	}

}
