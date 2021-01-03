package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.ITypeEtatDAO;
import dz.com.naftal.petrocard.model.TypeEtat;
@Transactional
@Service("iTypeEtatService")
public class TypeEtatServiceimpl implements ITypeEtatService {

	@Autowired
	private ITypeEtatDAO iTypeEtatDAO;
	
	public ITypeEtatDAO getiTypeEtatDAO() {
		return iTypeEtatDAO;
	}

	public void setiTypeEtatDAO(ITypeEtatDAO iTypeEtatDAO) {
		this.iTypeEtatDAO = iTypeEtatDAO;
	}

	@Override
	public void createTypeEtat(TypeEtat typeetat) {
		iTypeEtatDAO.createTypeEtat(typeetat);

	}

	@Override
	public TypeEtat getTypeEtatbyType(String intitule) {
		// TODO Auto-generated method stub
		return iTypeEtatDAO.getTypeEtatbyType(intitule);
	}

	@Override
	public List<TypeEtat> getAllTypeEtat() {
		// TODO Auto-generated method stub
		return iTypeEtatDAO.getAllTypeEtat();
	}

	@Override
	public void updateTypeEtat(TypeEtat typeetat) {
		iTypeEtatDAO.updateTypeEtat(typeetat);

	}

	@Override
	public TypeEtat getTypeEtatbyId(Integer typeetatid) {
		// TODO Auto-generated method stub
		return iTypeEtatDAO.getTypeEtatbyId(typeetatid);
	}

}
