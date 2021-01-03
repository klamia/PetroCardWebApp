package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.Client;
import dz.com.naftal.petrocard.model.Ident;


@Repository("identDAO")
@Transactional
public class IdentDAOimpl implements IdentDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createIdent(Ident porteur) {
		em.persist(porteur); 

	    
	}

	@Override
	public Ident getIdentbyClient(Client client) {
		return em.find(Ident.class, client);
	}

	@Override
	public List<Ident> getAllIdent() {
		return em.createNamedQuery("Ident.findAll").getResultList();
	}

	@Override
	public Ident updateIdent(Ident porteur) {
		 return em.merge(porteur);
	}

	@Override
	public Ident removeIdent(Ident porteur) {
		 em.remove(em.merge(porteur));
		return porteur;
		 

	}

	@Override
	public Ident getIdentbyID(Integer porteurid) {
		// TODO Auto-generated method stub
		return em.find(Ident.class, porteurid);
	}

	@Override
	public List<Ident> findbycdevalidees() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Ident.findbycdevalidees").getResultList(); 
	}

	@Override
	public List<Ident> findbyCdeID() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Ident.findIdentByCdeID").getResultList();
	}

}
