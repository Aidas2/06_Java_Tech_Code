package lt.egzaminas.repositories;

import lt.egzaminas.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item, String> {
}
