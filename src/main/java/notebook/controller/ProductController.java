package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
import notebook.controller.wrappers.ProductUserIdWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import notebook.entity.Product;
import notebook.service.product.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ApplicationContext context;

	@Autowired
	public ProductController(ApplicationContext context) {
		this.context = context;
	}

	@GetMapping("/get")
	public List<Product> getAllProducts() {
		return context
      .getBean(ProductService.class)
      .findAll();
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		ProductService productService = context.getBean(ProductService.class);

		return productService.saveProduct(product);
	}

	@PostMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return context
      .getBean(ProductService.class)
      .saveProduct(product);
	}
	
	@PostMapping("/delete")
	public long updatePatient(@RequestBody DeleteByIdRequestWrapper requestWrapper) {
		return context
      .getBean(ProductService.class)
      .deleteProduct(requestWrapper.getId());
	}

	public List<Product> getPruductByUser(@RequestBody ProductUserIdWrapper productUserIdWrapper ) {
	  return context
      .getBean(ProductService.class)
      .getProductsByUser(productUserIdWrapper.getUserId());
  }
}
