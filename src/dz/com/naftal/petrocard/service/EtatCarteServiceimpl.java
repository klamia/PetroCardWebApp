package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IEtatCarteDAO;
import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.EtatCarte;
@Transactional
@Service("iEtatCarteService")
public class EtatCarteServiceimpl implements IEtatCarteService {

	@Autowired
	private IEtatCarteDAO iEtatCarteDAO;
	
	

	public IEtatCarteDAO getiEtatCarteDAO() {
		return iEtatCarteDAO;
	}

	public void setiEtatCarteDAO(IEtatCarteDAO iEtatCarteDAO) {
		this.iEtatCarteDAO = iEtatCarteDAO;
	}

	@Override
	public void createEtatCarte(EtatCarte etatcarte) {
		iEtatCarteDAO.createEtatCarte(etatcarte);
		
	}

	@Override
	public EtatCarte getEtatCartebyTypeEtat(String typeEtat) {
		return iEtatCarteDAO.getEtatCartebyTypeEtat(typeEtat);
	}

	@Override
	public List<EtatCarte> getAllEtatCarte() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getAllEtatCarte();
	}

	@Override
	public void updateEtatCarte(EtatCarte etatcarte) {
		iEtatCarteDAO.updateEtatCarte(etatcarte);
		
	}

	@Override
	public List<EtatCarte> getCartesActivees() {
		// TODO Auto-generated method stub
		return  iEtatCarteDAO.getCartesActivees();
	}

	@Override
	public List<EtatCarte> getCartesNonExpirees() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesNonExpirees();
	}

	@Override
	public List<EtatCarte> getCartesBloques() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesBloques();
	}

	@Override
	public List<EtatCarte> getCartesRemplace() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesRemplace();
	}

	@Override
	public List<EtatCarte> getCartesConfectionne() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesConfectionne();
	}

	@Override
	public List<EtatCarte> getCartesActiveesPrepaid() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesActiveesPrepaid();
	}

	@Override
	public Carte getCartebyId(Integer carteid) {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartebyId(carteid);
	}

	@Override
	public List<EtatCarte> getCartesExpirees() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesExpirees();
	}

	@Override
	public List<EtatCarte> getCartesABloques() {
		// TODO Auto-generated method stub
		return iEtatCarteDAO.getCartesABloques();
	}

}
