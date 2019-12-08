package it.akademija.model;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.dao.UserDao;

//pagal 51 skaidre: 
@RestController
@Api(value = "user") //pagal 71 skaidre
@RequestMapping(value = "/api/users")
public class UserController {

	private final UserDao userDao; // pridedame DAO
	//private User user;
	
	//konstruktorius (60 skaidre)
	@Autowired
	public UserController(UserDao userDao) {
	this.userDao = userDao;
	}
	
	/* Apdoros užklausas: GET /api/users (pagal 51 skaidre --> 60 skaidre) */ 
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get users",notes="Returns registered users") //pagal 71 skaidre
	public List<User> getUsers() {
		//return Collections.emptyList(); -> pirma versija
		return userDao.getUsers();// skaitome per DAO
	}
	
	/* Sukurs vartotoja ir grazins atsakyma su HTTP statusu 201 (pagal 53 skaidre) */	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create user",notes="Creates user with data")
	//sena eilute
	//public void createUser(@RequestBody final CreateUserCommand cmd) {
	public void createUser(@ApiParam(value="User Data",required=true)
		@Valid
		@RequestBody final CreateUserCommand cmd) {
		//user.setUsername(cmd.getUsername());
		//user.setFirstName(cmd.getFirstName());
		//user.setLastName(cmd.getLastName());
		//user.setEmail(cmd.getEmail());
		//userDao.createUser(user);
		
		userDao.createUser(new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()));
				
		//userDao.createUser();
	System.out.println(cmd);
	}
	
	/* Apdoros uzklausas: DELETE /api/users/<vartotojas>  (pagal 55 skaidre) */
	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete user",notes="Deletes selected user")
	public void deleteUser( @PathVariable final String username ) {
		userDao.deleteUser(username);
		System.out.println("Deleting user: " + username);
	}
	
}
