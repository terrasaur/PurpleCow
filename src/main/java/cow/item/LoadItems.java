package cow.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadItems {
	private static final Logger log = LoggerFactory.getLogger(LoadItems.class);
	
	@Bean
	public CommandLineRunner initItems(ItemRepository items) {
		// TODO actually read this from memory or something
		// load some starter data
		return args -> {
			log.info("Loading: " + items.save(new Item("pencils")));
			log.info("Loading: " + items.save(new Item("pens")));
			log.info("Loading: " + items.save(new Item("notebook")));
			log.info("Loading: " + items.save(new Item("paper")));
		};
	}

}
