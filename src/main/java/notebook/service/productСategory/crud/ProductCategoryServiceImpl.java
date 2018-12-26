package notebook.service.productСategory.crud;

import notebook.entity.ProductCategory;
import notebook.repository.productCategory.ProductCategoryRepository;
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
