package notebook.controller;

import java.util.List;

import notebook.controller.wrappers.DeleteByIdRequestWrapper;
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
	public Product createPatient(@RequestBody Product product) {
		return context
      .getBean(ProductService.class)
      .saveProduct(product);
	}

	@PostMapping("/update")
	public Product updatePatient(@RequestBody Product product) {
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
}
