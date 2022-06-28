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
		return args -> {
			log.info("Loading: " + items.save(new Item((long)1, "apples")));
			log.info("Loading: " + items.save(new Item((long)2, "bananas")));
			log.info("Loading: " + items.save(new Item((long)3, "cauliflower")));
			log.info("Loading: " + items.save(new Item((long)4, "honey")));
		};
	}

}
