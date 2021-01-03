package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.Contrat;


@Repository("iContratDAO")
@Transactional
public class ContratDAOimpl implements IContratDAO {

	
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createContrat(Contrat contrat) {
		em.persist(contrat); 

	    
	}

	@Override
	public Contrat getContratbyId(String contratid) {
		return em.find(Contrat.class, contratid);
	}

	@Override
	public List<Contrat> getAllContrat() {
		
			return em.createNamedQuery("Contrat.findAll").getResultList();
	}

	@Override
	public void updateContrat(Contrat contrat) {
		  em.merge(contrat);
	}

}
