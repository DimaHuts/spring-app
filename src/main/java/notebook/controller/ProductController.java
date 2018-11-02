package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
import notebook.controller.wrappers.ProductRequestWrapper;
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
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.findAll();
	}

	@PostMapping("/create")
	public Product createProduct(@RequestBody ProductRequestWrapper productRequestWrapper) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.saveProduct(productRequestWrapper.getProduct(), productRequestWrapper.getCategoryIds());
	}

	@PostMapping("/update")
	public Product updateProduct(@RequestBody ProductRequestWrapper productRequestWrapper) {
		ProductService productService = BeanProvider.getBean(ProductService.class);

		return productService.saveProduct(productRequestWrapper.getProduct(), productRequestWrapper.getCategoryIds());
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
