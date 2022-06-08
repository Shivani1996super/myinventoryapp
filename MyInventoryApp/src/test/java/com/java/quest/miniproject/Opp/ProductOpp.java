package com.java.quest.miniproject.Opp;

import java.util.List;

import com.java.quest.miniproject.entity.Product;

public interface ProductOpp {
	public List<Product> findAll();
	public Product findById(int theId);
	public void save(Product product);
	public void deleteById(int theId);


	}


