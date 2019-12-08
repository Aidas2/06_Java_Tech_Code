package lt.akademijait.warehouse.customer.service;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.akademijait.warehouse.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByCustomerCode(String customerCode);
	void deleteByCustomerCode(String customerCode);
	boolean existsByFirstNameAndLastNameAndBirthday(String firstName, String lastName, LocalDate birthday);

	// Savo querių kūrimas
	// @Query("select h from holiday h where h.code = ?1")
	// Holiday findByCode(String code);

	// Anotacija @Modifying reikalinga, jeigu su queriu atlieku duomenų keitimo ar
	// trynimo operaciją
	// @Modifying
	// @Query("update holiday h set h.description = ?1 where h.code = ?2")
	// void setFixedDescriptionFor(String decription, String code);

}
