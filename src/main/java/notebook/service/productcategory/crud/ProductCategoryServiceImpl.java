package notebook.service.productcategory.crud;

import notebook.entity.ProductCategory;
import notebook.repository.productcategory.CrudProductCategoryRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
  @Override
  public long saveProductCategory(ProductCategory productCategory) {
    CrudProductCategoryRepository productCategoryRepository = BeanProvider.getBean(CrudProductCategoryRepository.class);

    ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);

    return savedProductCategory.getCategoryId();
  }
}
