package notebook.service.product_category.Impl;

import notebook.entity.ProductCategory;
import notebook.repository.ProductCategoryRepository;
import notebook.service.common.BeanProvider;
import notebook.service.product_category.ProductCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
  @Override
  public long saveProductCategory(ProductCategory productCategory) {
    ProductCategoryRepository productCategoryRepository = BeanProvider.getBean(ProductCategoryRepository.class);

    ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);

    return savedProductCategory.getCategoryId();
  }
}
