package dz.com.naftal.petrocard.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 */
@Repository("usersDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	/**
	 * EntityManager injected by Spring for persistence unit org_SmaPuSQL_Driver
	 * 
	 */
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager entityManager;

	@Override
	public User merge(User users) {
		try {

			return entityManager.merge(users);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void persist(User users) {
		try {

			entityManager.persist(users);

		} catch (Exception e) {

		}

	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByMail(String username) {

		try {
			String queryString = "SELECT u FROM User u WHERE u.username =:username";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("username", username);
			User us = (User) query.getSingleResult();
			System.err.println("****" + us.getUserid());
			return us;
			// return (Users) query.getSingleResult();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public User findUsersByName(String username) {

		try {
			Query query = entityManager.createNamedQuery("User.findByName");
			query.setParameter("username", username);
			return (User) query.getSingleResult();
		} catch (NoResultException e) {
			e.getStackTrace();
			return null;
		}

	}
	
    @SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("User.findAll").getResultList();
	}

}
