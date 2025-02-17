package in.harish.service;

import java.util.List;
import java.util.Optional;

import in.harish.entity.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Optional<Product> getProductsById(Integer id);
	
	public List<Product> searchByName(String name);
	
	public List<Product> searchByCategory(String category);
	
	public Product saveProduct(Product product);
	
	public Product updateProduct(Integer id, Product productDetails);
	
	public String deleteProduct(Integer id);
}
