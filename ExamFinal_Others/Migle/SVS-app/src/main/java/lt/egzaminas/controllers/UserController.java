package lt.egzaminas.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.egzaminas.dtos.ItemDto;
import lt.egzaminas.dtos.UserDto;
import lt.egzaminas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "user")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Rest controller for loading all users.
     *
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get all users", notes="Returns all users")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    /**
     * Rest controller for loading user by user identifier.
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiOperation(value = "Get item info", notes="Returns item info")
    public UserDto getById (
            @ApiParam(value = "item id", required = true)
            @PathVariable String id) {
        return userService.getById(id);
    }

    /**
     * Rest controller for loading all users items.
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}/items", method = RequestMethod.GET)
    @ApiOperation(value="Get all user's items", notes="Returns all items in user's storage")
    public List<ItemDto> getAllItems(
            @ApiParam(value = "id", required = true)
            @PathVariable String id) {
        return userService.getAllItems(id);
    }


    /**
     * Rest controller for creating a user.
     *
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new user", notes="Creates new user")
    public void create (
            @ApiParam(value = "User data", required = true)
            @RequestBody
            final UserDto userDto) {
        userService.create(userDto);
    }

    /**
     * Rest controller for deleting a user by user identifier.
     *
     * @param
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete user by id")
    public void delete (
            @ApiParam(value="User id", required = true)
            @PathVariable final String id) {
        userService.delete(id);
    }

    /**
     * Rest controller for updating a user by user identifier.
     *
     * @param
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update user info", notes="Updates the user by id")
    public void update (
            @ApiParam(value = "Item data", required = true)
            @RequestBody
            final UserDto userDto,
            @ApiParam(value="Item id", required = true)
            @PathVariable String id) {
        userService.update(id, userDto);
    }

}
