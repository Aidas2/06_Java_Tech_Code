package it.akademija.cart;

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
import it.akademija.products.Product;

@RestController
@RequestMapping(value = "/api/users/{user}/cart")
public class CartsController {

	private final CartDao cartDao; // pridedame DAO
	
	
	//konstruktorius
	@Autowired
	public CartsController(CartDao cartDao) {
	this.cartDao = cartDao;
	}
	
	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(method = RequestMethod.GET)
	public List<Cart> getProducts() {
		//return Collections.emptyList(); -> pirma versija
		return cartDao.getCart();// skaitome per DAO
	}
		
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody final CreateCartCommand cmd) {		
		cartDao.createCart(new Cart(cmd.getId(), cmd.getTitle(), cmd.getImage()));
		System.out.println(cmd);
	}
	
	@RequestMapping(path = "/api/users/{user}/cart/{title}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct( @PathVariable final String title ) {
		cartDao.deleteCart(title);
		System.out.println("Deleting product: " + title);
	}
	
}