package notebook.service.productcategory.crud;

import notebook.entity.ProductCategory;
import notebook.repository.productcategory.ProductCategoryRepository;
import notebook.service.common.BeanProvider;
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
