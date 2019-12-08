
package it.akademija.cart;

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
import it.akademija.products.CreateProductCommand;
import it.akademija.products.Product;
import it.akademija.products.ProductService;

@RestController
@Api(value = "cart")
@RequestMapping(value = "/api/users/{user}/cart-products")
public class CartController {

	private final CartService cartService; // pridedame DAO

	// konstruktorius
	@Autowired
		public CartController(CartService cartService) {
			this.cartService = cartService;
		}

	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(path = "/api/users/{user}/cart-products", method = RequestMethod.GET)
	@ApiOperation(value = "Get cart of user", notes = "Returns user's cart")
	public List<Cart> getCart(@ApiParam(value = "User", required = true) @Valid @PathVariable final String user) {
		return cartService.getCart();// skaitome per DAO
	}

	@RequestMapping(path = "/api/users/{user}/cart-products", method = RequestMethod.POST)
	@ApiOperation(value = "Add product to user's cart", notes = "Adds product to user's cart")
	@ResponseStatus(HttpStatus.CREATED)
	public void addProductToCart(@ApiParam(value = "User", required = true) @Valid @PathVariable final String user,
			@ApiParam(value = "Product", required = true) @Valid @RequestBody final CreateCartCommand cmd) {
		cartService.addProductToCart(new Cart(cmd.getId(), cmd.getTitle(), cmd.getImage()));
		System.out.println(cmd);
	}

	@RequestMapping(path = "/api/users/{user}/cart-products/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductFromCart(@ApiParam(value = "User", required = true) @Valid @PathVariable final String user,
									@ApiParam(value = "Product id", required = true) @Valid @PathVariable final long id) {
		cartService.deleteProductFromCart(id);
		System.out.println("Deleting product: " + id);
	}
}