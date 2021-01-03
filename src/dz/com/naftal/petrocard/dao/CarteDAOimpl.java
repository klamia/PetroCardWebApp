package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.model.Carte;




@Repository("iCarteDAO")
@Transactional
public class CarteDAOimpl implements ICarteDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	
	@Override
	public void createCarte(Carte carte) {
		em.persist(carte); 

	    
	}

	@Override
	public Carte getCartebyId(Integer carteid) {
		return em.find(Carte.class, carteid);
	}

	@Override
	public List<Carte> getAllCarte() {
		return em.createNamedQuery("Carte.findAll").getResultList();
	}

	@Override
	public Carte updateCarte(Carte carte) {
		  return em.merge(carte);
	}

	@Override
	public List<Carte> getCartePrepaid() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Carte.findCartePrepaid").getResultList();
	}

	@Override
	public List<Carte> getCarteExpire() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Carte.findExpiryCarte").getResultList();  
	}


	/*
	@Override
	 public void removeBc(Carte carte) {
		
      em.remove(em.merge(carte));
    

	}
*/
	
	
	
}
