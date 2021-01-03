package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.ICarteDAO;
import dz.com.naftal.petrocard.model.Carte;
@Transactional
@Service("iCarteService")
public class CarteServiceImpl implements ICarteService {

	@Autowired
	private ICarteDAO iCarteDAO;
	
	
	public ICarteDAO getiCarteDAO() {
		return iCarteDAO;
	}

	public void setiCarteDAO(ICarteDAO iCarteDAO) {
		this.iCarteDAO = iCarteDAO;
	}

	@Override
	public void createCarte(Carte carte) {
		// TODO Auto-generated method stub
		iCarteDAO.createCarte(carte);
	}

	@Override
	public Carte getCartebyId(Integer carteid) {
		// TODO Auto-generated method stub
		return iCarteDAO.getCartebyId(carteid);
	}

	@Override
	public List<Carte> getAllCarte() {
		// TODO Auto-generated method stub
		return iCarteDAO.getAllCarte();
	}

	@Override
	public Carte updateCarte(Carte carte) {
		return iCarteDAO.updateCarte(carte);
	}

	@Override
	public List<Carte> getCartePrepaid() {
		// TODO Auto-generated method stub
		return iCarteDAO.getCartePrepaid();
	}

	@Override
	public List<Carte> getCarteExpire() {
		// TODO Auto-generated method stub
		return iCarteDAO.getCarteExpire();
	}

}
