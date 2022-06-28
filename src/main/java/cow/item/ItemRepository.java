package cow.item;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring documentation says I need this class but nothing else so I guess I trust it
 */
interface ItemRepository extends JpaRepository<Item, Long> {

}
