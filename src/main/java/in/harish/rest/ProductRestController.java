package in.harish.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.harish.entity.Product;
import in.harish.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		Optional<Product> productsById = productService.getProductsById(id);
		if(productsById.isPresent()) {
			return ResponseEntity.ok(productsById.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/search/name")
	public ResponseEntity<List<Product>> searchByName(@RequestParam String name){
		List<Product> products = productService.searchByName(name);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/search/category")
	public ResponseEntity<List<Product>> searchByCategory(@RequestParam String category){
		List<Product> products = productService.searchByCategory(category);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		if (product.getId() != null && product.getId() == 0) {
	        product.setId(null); // Reset to null for Hibernate to treat it as new
	    }
		
		Product savedProduct = productService.saveProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productDetails){
		Product updatedProduct = productService.updateProduct(id, productDetails);
		if(updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		String deletedProduct = productService.deleteProduct(id);
		return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
	}
}

