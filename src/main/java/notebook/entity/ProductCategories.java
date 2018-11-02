package notebook.entity;

import javax.persistence.*;

@Table(name = "product_categories")
@Entity
public class ProductCategories {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "product_id", nullable = false)
  private long productId;

  @Column(name = "category_id", nullable = false)
  private long categoryId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }
}
