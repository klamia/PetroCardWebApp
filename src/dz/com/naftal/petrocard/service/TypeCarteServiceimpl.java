package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.ITypeCarteDAO;
import dz.com.naftal.petrocard.model.TypeCarte;
@Transactional
@Service("iTypeCarteService")
public class TypeCarteServiceimpl implements ITypeCarteService {

	@Autowired
	private ITypeCarteDAO typecartedao;
	
	public ITypeCarteDAO getTypecartedao() {
		return typecartedao;
	}

	public void setTypecartedao(ITypeCarteDAO typecartedao) {
		this.typecartedao = typecartedao;
	}

	@Override
	public void createTypeCarte(TypeCarte typecarte) {
		typecartedao.createTypeCarte(typecarte);

	}

	@Override
	public TypeCarte gettypecartebytype(String intitule) {
		// TODO Auto-generated method stub
		return typecartedao.gettypecartebytype(intitule);
	}

	@Override
	public List<TypeCarte> getAllTypeCarte() {
		// TODO Auto-generated method stub
		return typecartedao.getAllTypeCarte();
	}

	@Override
	public void updateTypeCarte(TypeCarte typecarte) {
		typecartedao.updateTypeCarte(typecarte);

	}

	@Override
	public TypeCarte findById(Integer typecarteid) {
		// TODO Auto-generated method stub
		return typecartedao.findById(typecarteid);
	}

}
