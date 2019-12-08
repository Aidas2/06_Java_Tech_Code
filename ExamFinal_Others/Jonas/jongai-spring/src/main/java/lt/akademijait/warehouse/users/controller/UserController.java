package lt.akademijait.warehouse.users.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.warehouse.security.security.CurrentUser;
import lt.akademijait.warehouse.security.security.UserPrincipal;
import lt.akademijait.warehouse.users.service.UserService;

@RestController
@Api(value = "user")
@RequestMapping(value = "api/users")
public class UserController {

	private final UserService userService;;

	// konstruktorius
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/me", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserGetCommand getCurrentUserUsername(@CurrentUser UserPrincipal userPrincipal) {
        UserGetCommand userGetCommand = new UserGetCommand();
        BeanUtils.copyProperties(userPrincipal, userGetCommand);
        return userGetCommand;
    }
	
	// New user creation
	//Nenaudojamas
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new user", notes = "Creates new user with provided data")
	public void createCountry(
			@ApiParam(value = "User data", required = true) @Valid @RequestBody final CreateUserCommand cuc) {

		userService.createUser(cuc.getName(), cuc.getUsername(), cuc.getEmail(), cuc.getPassword(), cuc.getRole());
	}

	

}
