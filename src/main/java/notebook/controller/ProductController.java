package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
import notebook.service.common.BeanProvider;
import notebook.service.product.findallproducts.FindAllProductsService;
import notebook.service.product.findproductsbuser.FindProductsByUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import notebook.entity.Product;
import notebook.service.product.crud.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@PreAuthorize("hasAuthority('VIEW_ALL_PRODUCTS')")
	@GetMapping("/get")
	public List<Product> getAllProducts() {
		FindAllProductsService findAllProductsService = BeanProvider.getBean(FindAllProductsService.class);

		return findAllProductsService.findAll();
	}

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.saveProduct(product);
	}

	@PostMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.saveProduct(product);
	}

	@PostMapping("/delete")
	public long deleteProduct(@RequestBody DeleteByIdRequestWrapper requestWrapper) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.deleteProduct(requestWrapper.getId());
	}

	@GetMapping("/get/byUser/{userId}")
	public List<Product> getProductsByUser(@PathVariable("userId") long userId) {
		FindProductsByUserService findProductsByUserService = BeanProvider.getBean(FindProductsByUserService.class);

	  return findProductsByUserService.getProductsByUser(userId);
  }
}
