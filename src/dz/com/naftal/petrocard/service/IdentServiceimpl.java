package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IdentDAO;
import dz.com.naftal.petrocard.model.Client;
import dz.com.naftal.petrocard.model.Ident;

@Transactional 
@Service("identService")
public class IdentServiceimpl implements IdentService {

	@Autowired
	private IdentDAO identDAO;
	
	
	@Override
	public void createIdent(Ident porteur) {
		identDAO.createIdent(porteur);

	}

	@Override
	public Ident getIdentbyClient(Client client) {
		// TODO Auto-generated method stub
		return identDAO.getIdentbyClient(client);
	}

	@Override
	public Ident updateIdent(Ident porteur) {
		return identDAO.updateIdent(porteur);

	}

	@Override
	public Ident removeIdent(Ident porteur) {
		return identDAO.removeIdent(porteur);

	}

	

	public IdentDAO getIdentDAO() {
		return identDAO;
	}

	public void setIdentDAO(IdentDAO identDAO) {
		this.identDAO = identDAO;
	}

	@Override
	public Ident getIdentbyID(Integer porteurid) {
		// TODO Auto-generated method stub
		return identDAO.getIdentbyID(porteurid);
	}

	@Override
	public List<Ident> getAllIdent() {
		// TODO Auto-generated method stub
		return identDAO.getAllIdent();
	}

	@Override
	public List<Ident> findbycdevalidees() {
		// TODO Auto-generated method stub
		return identDAO.findbycdevalidees();
	}

	@Override
	public List<Ident> findbyCdeID() {
		// TODO Auto-generated method stub
		return identDAO.findbyCdeID();
	}

}
