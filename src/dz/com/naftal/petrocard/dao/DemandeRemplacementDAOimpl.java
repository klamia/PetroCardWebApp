package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.DemandeRemplacement;
@Repository("iDemandeRemplacementDAO")
@Transactional
public class DemandeRemplacementDAOimpl implements IDemandeRemplacementDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createDemandeRemplacement(DemandeRemplacement demanderemplacement) {
		em.persist(demanderemplacement); 



	}

	@Override
	public DemandeRemplacement getDemandeRemplacementbyId(
			Integer demanderemplacementid) {
		return em.find(DemandeRemplacement.class, demanderemplacementid);
	}

	@Override
	public List<DemandeRemplacement> getAllDemandeRemplacement() {
		return em.createNamedQuery("DemandeRemplacement.findAll").getResultList();
	}

	@Override
	public DemandeRemplacement updateDemandeRemplacement(
			DemandeRemplacement demanderemplacement) {
		return em.merge(demanderemplacement);
	}

	@Override
	public DemandeRemplacement removeDemandeRemplacement(
			DemandeRemplacement demanderemplacement) {
		 em.remove(em.merge(demanderemplacement));
		 return demanderemplacement;
	}

	@Override
	public List<DemandeRemplacement> getDemandeRemplacementNonTraite() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("DemandeRemplacement.findDemandeRemplacementNonTraite").getResultList();
	}

}
