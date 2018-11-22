package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
import notebook.service.common.BeanProvider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import notebook.entity.Product;
import notebook.service.product.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@PreAuthorize("hasAuthority('Permissions.VIEW_ALL_PRODUCTS.getPermission()')")
	@GetMapping("/get")
	public List<Product> getAllProducts() {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.findAll();
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
	public long updatePatient(@RequestBody DeleteByIdRequestWrapper requestWrapper) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.deleteProduct(requestWrapper.getId());
	}

	@GetMapping("/get/byUser/{userId}")
	public List<Product> getProductsByUser(@PathVariable("userId") long userId) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

    long resultUserId = productService.getUserIdForFetchProduct(userId);

	  return productService.getProductsByUser(resultUserId);
  }
}
