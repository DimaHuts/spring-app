package notebook.controller;

import notebook.entity.ProductCategory;
import notebook.service.common.BeanProvider;
import notebook.service.product_category.ProductCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-category")
public class ProductCategoryController {

  @PostMapping("/create")
  public long saveProductCategory(@RequestBody ProductCategory productCategory){
    ProductCategoryService productCategoryService = BeanProvider.getBean(ProductCategoryService.class);

    return productCategoryService.saveProductCategory(productCategory);
  }
}
