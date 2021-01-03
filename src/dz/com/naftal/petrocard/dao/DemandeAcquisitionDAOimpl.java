package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.DemandeAcquisition;
@Repository("iDemandeAcquisitionDAO")
@Transactional
public class DemandeAcquisitionDAOimpl implements IDemandeAcquisitionDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createDemandeAcquisition(DemandeAcquisition demandeAcquisition){
		try {
			em.persist(demandeAcquisition); 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DemandeAcquisition getDemandeAcquisitionbyId(Integer demandeacquisitionid){
			return em.find(DemandeAcquisition.class, demandeacquisitionid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeAcquisition> getAllDemandeAcquisition() {
		return (List<DemandeAcquisition>) em.createNamedQuery("DemandeAcquisition.findAll").getResultList();
	}

	@Override
	public DemandeAcquisition updateDemandeAcquisition(DemandeAcquisition demandeAcquisition){
		return em.merge(demandeAcquisition);
	}

	@Override
	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcqusition) {
		em.remove(em.merge(demandeAcqusition));
            return demandeAcqusition;
	}

	@Override
	public List<DemandeAcquisition> getDemandeAcquisitionByClient() {
		// TODO Auto-generated method stub
		return (List<DemandeAcquisition>) em.createNamedQuery("DemandeAcquisition.findDemandeByClient").getResultList();
	}

	@Override
	public List<DemandeAcquisition> getDemandeAcquisitionNonTraite() {
		// TODO Auto-generated method stub
		return (List<DemandeAcquisition>) em.createNamedQuery("DemandeAcquisition.findNonTraite").getResultList();
	}

}
