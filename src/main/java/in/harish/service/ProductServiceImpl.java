package in.harish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.harish.entity.Product;
import in.harish.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductsById(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> searchByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> searchByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Integer id, Product productDetails) {
		Optional<Product> productOptional = productRepository.findById(id);
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setName(productDetails.getName());
			product.setCategory(productDetails.getCategory());
			product.setPrice(productDetails.getPrice());
			product.setQuantity(productDetails.getQuantity());
			
			return productRepository.save(product);
		}else {
			return null;
		}
	}

	@Override
	public String deleteProduct(Integer id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			productRepository.deleteById(id);
			return "Product With ID " + id + "has been successfully deleted.";
		}
		else {
			return "Product With ID " + id + "not found.";
		}
	}
}
