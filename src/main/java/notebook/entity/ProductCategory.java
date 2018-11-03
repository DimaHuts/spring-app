package notebook.entity;

import javax.persistence.*;

@Entity
public class ProductCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long categoryId;

  private String categoryName;

  public ProductCategory() {}

  public ProductCategory(long categoryId) {
    this.categoryId = categoryId;
  }

  public ProductCategory(String categoryName) {
    this.categoryName = categoryName;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
