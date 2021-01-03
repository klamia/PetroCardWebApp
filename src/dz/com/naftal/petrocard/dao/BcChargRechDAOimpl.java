package dz.com.naftal.petrocard.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.BcChargRech;


@Repository("iBcChargRechDAO")
@Transactional
public class BcChargRechDAOimpl implements IBcChargRechDAO {

	
	/**
	 * EntityManager injected by Spring for persistence unit org_SmaPuSQL_Driver
	 * 
	 */
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	
	@Override
	public  void createBC(BcChargRech bcchargrech) {
		 em.persist(bcchargrech); 

		    
		  }
	

	@Override
	@Transactional(readOnly = true)
	public BcChargRech getBcById(Integer bcchargrechid) {
		
		return em.find(BcChargRech.class, bcchargrechid); 
	}

	@Override
	public List<BcChargRech> getAllBc() {
		return em.createNamedQuery("BcChargRech.findAll").getResultList();
	}

	@Override
	public  BcChargRech updateBc(BcChargRech bcchargrech) {
		
		return em.merge(bcchargrech);

	}

	
	@Override
	 public BcChargRech removeBc(BcChargRech bcchargrech) {
		
       em.remove(em.merge(bcchargrech));
       return bcchargrech;

	}

}
