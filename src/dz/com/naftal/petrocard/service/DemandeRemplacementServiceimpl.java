package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IDemandeRemplacementDAO;
import dz.com.naftal.petrocard.model.DemandeRemplacement;
@Transactional
@Service("iDemandeRemplacementService")
public class DemandeRemplacementServiceimpl implements
		IDemandeRemplacementService {
    
	@Autowired
	private IDemandeRemplacementDAO iDemandeRemplacementDAO;
	
	
	public IDemandeRemplacementDAO getiDemandeRemplacementDAO() {
		return iDemandeRemplacementDAO;
	}

	public void setiDemandeRemplacementDAO(
			IDemandeRemplacementDAO iDemandeRemplacementDAO) {
		this.iDemandeRemplacementDAO = iDemandeRemplacementDAO;
	}

	@Override
	public void createDemandeRemplacement(
			DemandeRemplacement demanderemplacement) {
		iDemandeRemplacementDAO.createDemandeRemplacement(demanderemplacement);

	}

	@Override
	public DemandeRemplacement getDemandeRemplacementbyId(
			Integer demanderemplacementid) {
		// TODO Auto-generated method stub
		return iDemandeRemplacementDAO.getDemandeRemplacementbyId(demanderemplacementid);
	}

	@Override
	public List<DemandeRemplacement> getAllDemandeRemplacement() {
		// TODO Auto-generated method stub
		return iDemandeRemplacementDAO.getAllDemandeRemplacement();
	}

	@Override
	public DemandeRemplacement updateDemandeRemplacement(
			DemandeRemplacement demanderemplacement) {
		return iDemandeRemplacementDAO.updateDemandeRemplacement(demanderemplacement);

	}

	@Override
	public DemandeRemplacement removeDemandeRemplacement(
			DemandeRemplacement demanderemplacement) {
		return iDemandeRemplacementDAO.removeDemandeRemplacement(demanderemplacement);

	}

	@Override
	public List<DemandeRemplacement> getDemandeRemplacementNonTraite() {
		// TODO Auto-generated method stub
		return iDemandeRemplacementDAO.getDemandeRemplacementNonTraite();
	}

}
