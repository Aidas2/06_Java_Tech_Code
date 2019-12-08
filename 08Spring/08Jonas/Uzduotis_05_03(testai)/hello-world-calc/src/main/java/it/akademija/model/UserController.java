package it.akademija.model;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.dao.UserDao;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	private final UserDao userDao; // pridedame DAO
	//private User user;
	
	//konstruktorius
	@Autowired
	public UserController(UserDao userDao) {
	this.userDao = userDao;
	}
	
	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		//return Collections.emptyList(); -> pirma versija
		return userDao.getUsers();// skaitome per DAO
	}
		
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody final CreateUserCommand cmd) {
		//user.setUsername(cmd.getUsername());
		//user.setFirstName(cmd.getFirstName());
		//user.setLastName(cmd.getLastName());
		//user.setEmail(cmd.getEmail());
		//userDao.createUser(user);
		
		userDao.createUser(new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()));
		
		
		//userDao.createUser();	
	System.out.println(cmd);
	}
	
	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser( @PathVariable final String username ) {
		userDao.deleteUser(username);
		System.out.println("Deleting user: " + username);
	}
	
}