package in.harish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.harish.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findByName(String name);
	
	public List<Product> findByCategory(String category);

}
