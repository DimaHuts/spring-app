package notebook.service.product.findproductsbuser;

import notebook.entity.Product;

import java.util.List;

public interface FindProductsByUserService {
  List<Product> getProductsByUser(long userId);
}
