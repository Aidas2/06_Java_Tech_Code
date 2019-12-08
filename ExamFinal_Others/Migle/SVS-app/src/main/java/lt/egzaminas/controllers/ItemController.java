package lt.egzaminas.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.egzaminas.dtos.*;
import lt.egzaminas.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "item")
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Rest controller for loading all items.
     *
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get all items", notes="Returns all items")
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    /**
     * Rest controller for loading item by item identifier.
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiOperation(value = "Get item info", notes="Returns item info")
    public ItemDto getById (
            @ApiParam(value = "item id", required = true)
            @PathVariable String id) {
        return itemService.getById(id);
    }

    /**
     * Rest controller for creating an item.
     *
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new item", notes="Creates new item")
    public void create (
            @ApiParam(value = "Item data", required = true)
            @RequestBody
            final ItemDto item) {
        itemService.create(item);
    }

    /**
     * Rest controller for deleting an item by item identifier.
     *
     * @param
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete item by id")
    public void delete (
            @ApiParam(value="item id", required = true)
            @PathVariable final String id) {
        itemService.delete(id);
    }

    /**
     * Rest controller for updating an item by item identifier.
     *
     * @param
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update item info", notes="Updates the item by id")
    public void update (
            @ApiParam(value = "Item data", required = true)
            @RequestBody
            final ItemDto item,
            @ApiParam(value="Item id", required = true)
            @PathVariable String id) {
        itemService.update(id, item);
    }
}
