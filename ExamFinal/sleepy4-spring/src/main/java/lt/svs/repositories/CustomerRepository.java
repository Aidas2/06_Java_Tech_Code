package lt.svs.repositories;

import lt.svs.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
	Customer findCustomerByName(String name);
	void deleteCustomerByName(String name);
}
