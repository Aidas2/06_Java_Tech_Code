package lt.sventes.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.sventes.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findUsersByFirstNameAndLastName(String firstName, String lastName);
	List<User> findUsersByFirstNameContainingAndLastNameContaining (String partOfFirstName, String partOfLastName);

	//@Query("select u from User u where u.firstname like %?1")
	//@Query("select u from User u where u.max.age")
	//select u from User u where u.firstname like %?1
	
	
	//"SELECT m FROM Magazine m WHERE m.price = (SELECT MAX(x.price) FROM Magazine x WHERE m = x AND x.title = 'JDJ')"
	//@Query("SELECT m FROM User m where m.age = (SELECT MAX(m.age) FROM User)")
	@Query("SELECT m FROM User m where m.age = (SELECT MAX(userMax.age) FROM User userMax)")
	User findOldestUser();
} 
