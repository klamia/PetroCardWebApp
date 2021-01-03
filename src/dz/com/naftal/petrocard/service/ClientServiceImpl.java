package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IClientDAO;
import dz.com.naftal.petrocard.model.Client;

@Service("iClientService")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired 
	private IClientDAO iClientDAO;
	
	
	

	public IClientDAO getiClientDAO() {
		return iClientDAO;
	}

	public void setiClientDAO(IClientDAO iClientDAO) {
		this.iClientDAO = iClientDAO;
	}

	@Override
	public void createClient(Client client) {
		
		iClientDAO.createClient(client);
	}

	@Override
	public Client getClientByName(String raisonsocial) {
		
		return iClientDAO.getClientByName(raisonsocial);
	}

	@Override
	public List<Client> getAllclient() {
		
		return iClientDAO.getAllclient()  ;
	}

	@Override
	public Client  updateClient(Client client) {
		
		return iClientDAO.updateClient(client);
	}

	@Override
	public Client findBayId(Integer clientId) {
		
		return iClientDAO.findBayId(clientId);
	}

}
