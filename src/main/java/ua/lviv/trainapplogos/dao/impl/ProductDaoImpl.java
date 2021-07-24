package ua.lviv.trainapplogos.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ua.lviv.trainapplogos.dao.ProductDao;
import ua.lviv.trainapplogos.domain.Product;
import ua.lviv.trainapplogos.shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {
	private EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
	
	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			product = em.find(Product.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product update(Product product) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Product e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Product>) query.getResultList();
	}
	 
	 
}
