package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.DemandeBlocage;

@Repository("iDemandeBlocageDAO")
@Transactional
public class DemandeBlocageDAOimpl implements IDemandeBlocageDAO {

	
	
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createDemandeBlocage(DemandeBlocage demandeblocage) {
		em.persist(demandeblocage); 

	    
	}

	@Override
	public DemandeBlocage getDemandeBlocageId(Integer demandeblocageid) {
		return em.find(DemandeBlocage.class, demandeblocageid);
	}

	@Override
	public List<DemandeBlocage> getAllDemandeBlocage() {
		return em.createNamedQuery("DemandeBlocage.findAll").getResultList();
	}

	@Override
	public DemandeBlocage  updateDemandeBlocage(DemandeBlocage demandeblocage) {
		 return em.merge(demandeblocage);
	}

	@Override
	public DemandeBlocage removedemandeblocage(DemandeBlocage demandeblocage) {
		
		 em.remove(em.merge(demandeblocage));
		 return demandeblocage;
	}

	@Override
	public List<DemandeBlocage> getAllDemandeBlocageNonTraite() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("DemandeBlocage.findDemandeBloqueNonTraite").getResultList();
	}

}
