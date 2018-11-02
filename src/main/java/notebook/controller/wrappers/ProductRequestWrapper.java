package notebook.controller.wrappers;

import notebook.entity.Product;

import java.util.List;

public class ProductRequestWrapper {
  private Product product;

  private List<Long> categoryIds;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public List<Long> getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(List<Long> categoryIds) {
    this.categoryIds = categoryIds;
  }
}
