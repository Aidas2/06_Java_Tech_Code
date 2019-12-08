package it.akademija.springapp.repository;

import it.akademija.springapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByFirstNameAndLastNameAndDob(String firstName, String lastName, LocalDate dob);

}
