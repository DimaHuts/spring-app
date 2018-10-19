package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
import notebook.service.common.BeanProvider;
import notebook.service.common.CurrentUserFetcher;
import org.springframework.web.bind.annotation.*;

import notebook.entity.Product;
import notebook.service.product.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@GetMapping("/get")
	public List<Product> getAllProducts() {
		var productService = BeanProvider.getBean(ProductService.class);

		return productService.findAll();
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		var productService = BeanProvider.getBean(ProductService.class);

		return productService.saveProduct(product);
	}

	@PostMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
    var productService = BeanProvider.getBean(ProductService.class);

		return productService.saveProduct(product);
	}
	
	@PostMapping("/delete")
	public long updatePatient(@RequestBody DeleteByIdRequestWrapper requestWrapper) {
    var productService = BeanProvider.getBean(ProductService.class);

		return productService.deleteProduct(requestWrapper.getId());
	}

	@GetMapping("/get/byUser/{userId}")
	public List<Product> getProductsByUser(@PathVariable("userId") long userId) {
    var authenticatedUser = CurrentUserFetcher.getCurrentUser();
    var resultUserId = authenticatedUser.getId();

    if (userId != 0) {
      resultUserId = userId;
    }

    var productService = BeanProvider.getBean(ProductService.class);

	  return productService.getProductsByUser(resultUserId);
  }
}
