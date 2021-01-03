package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.model.Vehicule;
@Repository("iVehiculeDAO")
@Transactional

public class VehiculeDAOimpl implements IVehiculeDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createVehicule(Vehicule vehicule) {
		em.persist(vehicule); 

	    
	}

	@Override
	public Vehicule getVehiculebyMatricule(String matricule) {
		return em.find(Vehicule.class, matricule);
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		return em.createNamedQuery("Vehicule.findAll").getResultList();
	}

	@Override
	public void updateVehicule(Vehicule vehicule) {
		 em.merge(vehicule);
	}

	@Override
	public void removeVehicule(Vehicule vehicule) {
		em.remove(em.merge(vehicule));
	}

}
