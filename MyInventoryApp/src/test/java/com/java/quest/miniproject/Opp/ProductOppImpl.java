package com.java.quest.miniproject.Opp;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.quest.miniproject.Opp.ProductOpp;
import com.java.quest.miniproject.entity.Product;

@Repository
public class ProductOppImpl implements ProductOpp {
	private EntityManager entityManager;

	@Autowired
	public ProductOppImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override 
	@Transactional
	public List<Product> findAll() {
		// create hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		List<Product> product = theQuery.getResultList();
		return product;
	}

	@Override
	@Transactional
	public Product findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Product thepro = currentSession.get(Product.class, theId);
		return thepro;
	}
//	create
	@Override
	@Transactional
	public void save(Product product)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
		
	}
//	delete
	@Override
	@Transactional
	public void deleteById(int theId)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId",theId);
		theQuery.executeUpdate();
	}

}
