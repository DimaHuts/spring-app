package notebook.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String description;

	private double price;

	private String[] images;

	@ManyToOne(
		fetch = FetchType.LAZY,
		optional = false
	)
	@JoinColumn(
		name = "userId",
		nullable = false
	)
	private User user;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {
		CascadeType.REFRESH,
	})
	@JoinTable(name = "product_categories",
		joinColumns = { @JoinColumn(name = "productId") },
		inverseJoinColumns = { @JoinColumn(name = "categoryId") })
	private Set<ProductCategory> categories;

	public Product() {}

	public Product(String name, String description, double price, Set<ProductCategory> categories, String[] images) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.images = images;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<ProductCategory> categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}
}
