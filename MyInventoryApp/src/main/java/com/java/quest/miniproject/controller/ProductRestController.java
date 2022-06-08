package com.java.quest.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.quest.miniproject.Opp.ProductOpp;
import com.java.quest.miniproject.entity.Product;

@RestController
@RequestMapping("/proapp")
public class ProductRestController {
	private ProductOpp productOpp;

	@Autowired
	public ProductRestController(ProductOpp productOpp) {
		this.productOpp = productOpp;
	}
	@GetMapping("/pro")
	public List<Product> findAll() {
		return productOpp.findAll();
	}
	@GetMapping("/products/{productId}")
	public Product getEmployeeDetail(@PathVariable int productId) {
		Product thepro = productOpp.findById(productId);
		return thepro;
}
	// create
		@PostMapping("/products")
		public Product addProduct(@RequestBody Product thepro) {
			thepro.setId(0);
			productOpp.save(thepro);
			return thepro;
		}
		// update
		@PutMapping("/products")
		public Product updateProduct(@RequestBody Product thepro) {
			productOpp.save(thepro);
			return thepro;
		}
		//delete
		@DeleteMapping("/products/{productId}")
		public String deleteProduct(@PathVariable int productId) {
			Product thepro = productOpp.findById(productId);
		if(thepro==null)
		{
			throw new RuntimeException("product id not found"+productId);
		}
		productOpp.deleteById(productId);
			return "product id deleted";
		}
}
