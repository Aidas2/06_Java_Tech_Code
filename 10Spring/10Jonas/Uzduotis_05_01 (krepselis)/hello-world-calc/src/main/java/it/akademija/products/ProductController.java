package it.akademija.products;

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

@RestController
@Api(value = "product")
@RequestMapping(value = "/products")
public class ProductController {

	private final ProductService productService; // pridedame DAO

	// konstruktorius
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns existing products")
	public List<Product> getProducts() {
		// return Collections.emptyList(); -> pirma versija
		return productService.getProducts();// skaitome per DAO
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new product", notes = "Creates new product with provided data")
	public void createProduct(
			@ApiParam(value = "Product data", required = true) @Valid @RequestBody final CreateProductCommand cmd) {
		// user.setUsername(cmd.getUsername());
		// user.setFirstName(cmd.getFirstName());
		// user.setLastName(cmd.getLastName());
		// user.setEmail(cmd.getEmail());
		// userDao.createUser(user);

		// paimu produktu sarasa, paimu paskutini elementa, paimu jo id ir prie jo
		// pridedu 1
		// Ir tada naujo produkto id bus naujas ir nesikartojantis
		// productDao.getProducts().get(productDao.getProducts().size()-1).getId()+1
		long id = 0;
		if (productService.getProducts().size() == 0) {
			id = 1;
		} else {
			id = productService.getProducts().get(productService.getProducts().size() - 1).getId() + 1;
		}

		productService.createProduct(new Product(id, cmd.getTitle(), cmd.getImage(), cmd.getDescription(),
				cmd.getPrice(), cmd.getQuantity()));
		System.out.println(cmd);
	}

	// ------------------------------------------------------------------------------

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "Deletes selected product")
	public void deleteProduct(@PathVariable final long id) {
		productService.deleteProduct(id);
		System.out.println("Deleting product: " + id);
	}

	// ----------------------------------------------------------------------------------------

	// mano metodas produkto atnaujinimui
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK) 
	@ApiOperation(value = "Edit product", notes = "Change selected product's data")

	public void updateProduct(@ApiParam(value = "Product id", required = true) @Valid @PathVariable final long id,
			@ApiParam(value = "Product data", required = true) @Valid @RequestBody final CreateProductCommand cmd) {



		productService.updateProduct(new Product(id, cmd.getTitle(), cmd.getImage(), cmd.getDescription(),
				cmd.getPrice(), cmd.getQuantity()));

		// productDao.updateProduct(productToUpdate);

	}

}