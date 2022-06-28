package cow.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	// TODO: make this a database/utility class
	private ItemRepository itemMap ;
	
	public ItemController(ItemRepository items) {
		this.itemMap = items;
	}
	
	@GetMapping("/items")
	protected List<Item> getAll() {
		return new ArrayList<Item>(itemMap.findAll() );
	}
	
	@GetMapping("/items/{id}")
	protected Item getOne(@PathVariable Long id) throws AttributeNotFoundException {
		return itemMap.findById(id).orElseThrow(() -> new AttributeNotFoundException("ID : " + id));
	}
	
	@PostMapping("/items")
	protected Item addNewItem(@RequestBody Item newItem) {
		return itemMap.save( newItem);
	}
	
}
