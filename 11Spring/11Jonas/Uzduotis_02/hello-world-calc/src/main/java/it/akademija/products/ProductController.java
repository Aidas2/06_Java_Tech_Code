package it.akademija.products;

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
		
		return productService.getProducts();// skaitome per DAO
	}
	//---------------------------------------------------------------------------------
	//Čia yra prekių kategorijos "Clothes" POSTAS
	@RequestMapping(path = "/clothes", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new product. Category Clothes", notes = "Creates new product with provided data")
	public void createProduct(
			@ApiParam(value = "Product data", required = true) @Valid @RequestBody final CreateProductCommand cmd) {
		//nenaudojama
		/*long id = 0;
		if (productService.getProducts().size() == 0) {
			id = 1;
		} else {
			id = productService.getProducts().get(productService.getProducts().size() - 1).getId() + 1;
		}*/

		productService.createProduct(new Clothes(cmd.getTitle(), new ProductDetails(cmd.getImage(), cmd.getDescription()),
				cmd.getPrice(), cmd.getQuantity()));
		System.out.println(cmd);
	}
	
	//---------------------------------------------------------------------------------
		//Čia yra prekių kategorijos "Toys" POSTAS
		@RequestMapping(path = "/toys", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED)
		@ApiOperation(value = "Create new product. Category Toys", notes = "Creates new product with provided data")
		public void createToy(
				@ApiParam(value = "Product data", required = true) @Valid @RequestBody final CreateProductCommand cmd) {
			//nenaudojama
			/*long id = 0;
			if (productService.getProducts().size() == 0) {
				id = 1;
			} else {
				id = productService.getProducts().get(productService.getProducts().size() - 1).getId() + 1;
			}*/

			productService.createProduct(new Toys(cmd.getTitle(), new ProductDetails(cmd.getImage(), cmd.getDescription()),
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



		productService.updateProduct(new Clothes(id, cmd.getTitle(), new ProductDetails(cmd.getImage(), cmd.getDescription()),
				cmd.getPrice(), cmd.getQuantity()));

		// productDao.updateProduct(productToUpdate);

	}

}