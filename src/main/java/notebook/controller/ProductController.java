package notebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public long createPatient(@RequestBody Product product) {
		return productService.save(product);
	}

}
