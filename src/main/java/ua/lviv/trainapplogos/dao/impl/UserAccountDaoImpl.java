package ua.lviv.trainapplogos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import ua.lviv.trainapplogos.dao.UserAccountDao;
import ua.lviv.trainapplogos.domain.UserAccount;
import ua.lviv.trainapplogos.shared.FactoryManager;

public class UserAccountDaoImpl implements UserAccountDao {
	private EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = Logger.getLogger(UserAccountDaoImpl.class);
	
	@Override
	public UserAccount create(UserAccount user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public UserAccount read(Integer id) {
		UserAccount user = null;
		try {
			user = em.find(UserAccount.class, id);
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public UserAccount update(UserAccount user) {
		try {
		
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
			
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}
	}

	@Override
	public List<UserAccount> readAll() {
		List<UserAccount> listOfUsers = new ArrayList<>();
		try {
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}

		return listOfUsers;
	}
	
	@Override
	public UserAccount getUserByEmail(String email) {
		UserAccount user = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<UserAccount> criteria = builder.createQuery(UserAccount.class);
			
			Root<UserAccount> from = criteria.from(UserAccount.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), email));
			TypedQuery<UserAccount> typed = em.createQuery(criteria);
			user = typed.getSingleResult();
		} catch (Exception e) {
//			LOGGER.error(e);
			e.printStackTrace();
		}
		return user;
	}
}

