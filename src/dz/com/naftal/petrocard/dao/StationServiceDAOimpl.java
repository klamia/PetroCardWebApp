package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.StationService;

@Repository("iStationServiceDAO")
@Transactional

public class StationServiceDAOimpl implements IStationServiceDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;

	
	@Override
	public void createStationService(StationService stationservice) {
		em.persist(stationservice); 

	    
	}

	@Override
	public StationService getStationServicebyId(String stationserviceid) {
		return em.find(StationService.class, stationserviceid);
	}

	@Override
	public List<StationService> getAllStationService() {
		return em.createNamedQuery("StationService.findAll").getResultList();
	}

	@Override
	public void updateStationService(StationService stationservice) {
		 em.merge(stationservice);
	}

	

}
