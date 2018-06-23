package notebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import notebook.entity.Product;
import notebook.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/api/products/get")
	public List<Product> getAllProducts() {
		return productService.findAll();
	}

	@PostMapping(value = "/api/product/create")
	public Product createPatient(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

  @PostMapping(value = "/api/product/update")
  public Product updatePatient(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

}
