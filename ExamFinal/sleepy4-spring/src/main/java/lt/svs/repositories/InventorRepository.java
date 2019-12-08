package lt.svs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.svs.entities.Inventor;

public interface InventorRepository extends JpaRepository <Inventor, Long> {
	Inventor findInventorByTitle(String title);
	void deleteInventorByTitle(String title);

}
