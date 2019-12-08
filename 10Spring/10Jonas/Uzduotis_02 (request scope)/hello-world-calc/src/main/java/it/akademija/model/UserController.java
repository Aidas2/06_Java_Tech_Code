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
import it.akademija.dao.PagingData;
import it.akademija.dao.UserDao;
import it.akademija.dao.UserService;

@RestController(value="restController")
@Api(value = "user")
@RequestMapping(value = "/api/users")
public class UserController {

	//private final UserDao userDao; // pridedame DAO
	//private User user;
	private final UserService userService;
	
	//2 užduotis
	@Autowired
    private PagingData pagingData;
	
	//konstruktorius
	@Autowired
	/*senas
	public UserController(UserDao userDao) {
	this.userDao = userDao;
	}*/
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get users",notes="Returns registered users")
	public List<User> getUsers() {
		pagingData.setLimit(5); //2 užduočiai reikalinga eilutė
		return userService.getUsers();// skaitome per DAO
	}
			
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
		
		userService.createUser(new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()));
		
		
		//userDao.createUser();	
	System.out.println(cmd);
	}
	
	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete user",notes="Deletes selected user")
	public void deleteUser( @PathVariable final String username ) {
		userService.deleteUser(username);
		System.out.println("Deleting user: " + username);
	}
	
	
	
	
	
	
}