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
//import it.akademija.dao.PagingData; //nebenaudojam (10-os pamokos 03 uzduotyje)
import it.akademija.dao.UserDao;
import it.akademija.dao.UserService;

//pagal 51 skaidre: 
@RestController(value="restController")
@Api(value = "user") //pagal 71 skaidre
@RequestMapping(value = "/api/users")
public class UserController {

	//private final UserDao userDao; // pridedame DAO
	//private User user;
	private final UserService userService;

	//10 pamoka 02 užduotis (03 uzduotyje nebenaudojam)
	//@Autowired
    	//private PagingData pagingData;

	//konstruktorius (60 skaidre)
	@Autowired
	/*public UserController(UserDao userDao) {
	this.userDao = userDao;
	}*/	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/* Apdoros užklausas: GET /api/users (pagal 51 skaidre --> 60 skaidre) */ 
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get users",notes="Returns registered users") //pagal 71 skaidre
	public List<User> getUsers() {
		//pagingData.setLimit(5); //2 užduočiai reikalinga eilutė
		//return userService.getUsers();// skaitome per DAO, veliau per userService
		return userService.getSpringUsers(); //dar veliau - per Spring
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
		
		//senas metodas
		//userService.createUser(new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()));
		//naujas metodas
		userService.createSpringUser(new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()));				
		//userDao.createUser();
	System.out.println(cmd);
	}
	
	/* Apdoros uzklausas: DELETE /api/users/<vartotojas>  (pagal 55 skaidre) */
	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete user",notes="Deletes selected user")
	public void deleteUser( @PathVariable final String username ) {
		//userService.deleteUser(username); //senas metodas
		userService.deleteSpringUser(username); //naujas metodas

		System.out.println("Deleting user: " + username);
	}
	
//--------------------Cia turi ieskoti zmoniu pagal varda ir pavarde
	@RequestMapping(path = "/{firstName}+{lastName}", method = RequestMethod.GET)
	@ApiOperation(value="Search users by first and last name",notes="Returns matched users")
	public List<User> searchUsers(
			@ApiParam(value="User first name",required=false)
			@Valid
			@PathVariable final String firstName,
			@ApiParam(value="User last name",required=false)
			@Valid
			@PathVariable final String lastName) {
		return userService.findUsersByFirstNameAndLastName(firstName, lastName);
	}
	
//--------------------Cia turi ieskoti zmoniu pagal vardo ir pavardes fragmenta
		@RequestMapping(path = "/{partOfFirstName}+{partOfLastName}", method = RequestMethod.GET)
		@ApiOperation(value="Search users by first and last name part",notes="Returns matched users")
		public List<User> searchUsersByPartName(
				@ApiParam(value="User first name",required=false)
				@Valid
				@PathVariable final String partOfFirstName,
				@ApiParam(value="User last name",required=false)
				@Valid
				@PathVariable final String partOfLastName) {
			return userService.findUsersByFirstNameContainingAndLastNameContaining(partOfFirstName, partOfLastName);
		}

}
