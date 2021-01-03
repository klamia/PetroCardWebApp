package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.model.Client;





@Repository("iClientDAO")
@Transactional
public class ClientDAOimpl implements IClientDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;

	@Override
	public void createClient(Client client) {
		em.persist(client); 

	    
	}

	@Override
	public  Client getClientByName(String raisonsocial) {
		return em.find(Client.class, raisonsocial);
	}

	@Override
	public List<Client> getAllclient() {
		return  em.createNamedQuery("Client.findAll").getResultList();
	}

	@Override
	public Client updateClient(Client client) {
		return em.merge(client);
	}

	@Override
	public Client findBayId(Integer clientId) {
		
		return em.find(Client.class, clientId);
	}
	
	
	

}
