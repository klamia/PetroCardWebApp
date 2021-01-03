package dz.com.naftal.petrocard.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 */
@Repository("roleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO {

	/**
	 * EntityManager injected by Spring for persistence unit org_SmaPuSQL_Driver
	 * 
	 */
	
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager entityManager;

	@Override
	public void persist(Role roles) {
		try {

			entityManager.persist(roles);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Role merge(Role roles) {
		
			return entityManager.merge(roles);	
	}

	@Override
	public Role findrolesId(Integer roleid) {

		try {
			String queryString = "SELECT r FROM Role r WHERE r.roleid = :roleid";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("roleid", roleid);
			return (Role) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllroles() {
		// TODO Auto-generated method stub
		try {
			
			
			return (List<Role>) entityManager.createNamedQuery("Role.findAll").getResultList();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Role remove(Role roles) {
		 entityManager.remove(entityManager.merge(roles));
		 return roles;
		
	}

}
