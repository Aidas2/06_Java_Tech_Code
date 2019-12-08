package it.akademija.springapp.repository;

import it.akademija.springapp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    @Query("SELECT concat('Sector- ', i.sector, ' Count - ', count(i.sector)) from Inventory i group by i.sector ")
    List<String> getSectorCount();
}
