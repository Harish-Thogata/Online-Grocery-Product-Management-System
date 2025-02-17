package in.harish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PRODUCT_DETAILS")
@Data
public class Product {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="PRODUCT_ID")
	 private Integer id;

	 @Column(name="PRODUCT_NAME")
	 private String name;
	 
	 @Column(name="PRODUCT_CATEGORY")
	 private String category;
	 
	 @Column(name="PRODUCT_PRICE")
	 private Integer price;
	 
	 @Column(name="PRODUCT_QUANTITY")
	 private Integer quantity;
}
