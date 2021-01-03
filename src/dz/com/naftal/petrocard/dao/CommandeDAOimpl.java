package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.Commande;

@Repository("iCommandeDAO")
@Transactional
public class CommandeDAOimpl implements ICommandeDAO {
	
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	@Override
	public void createCommande(Commande commande) {
		em.persist(commande); 

	   
	}

	@Override
	public Commande getCommandeById(Integer commandeid) {
		return em.find(Commande.class, commandeid);
	}
	
	public  Commande getCommandeByEtat(String etat){
		return em.find(Commande.class, etat);
	}

	@Override
	public List<Commande> getAllCommande() {
		return em.createNamedQuery("Commande.findAll").getResultList();
	}

	@Override
	public Commande updateCommande(Commande commande) {
		 return em.merge(commande);
	}

	@Override
	public List<Commande> getCommandevalidees() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Commande.findCommandeValidees").getResultList();
	}

	@Override
	public List<Commande> getCommanderejetees() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Commande.findCommandeRejetees").getResultList();
	}

	@Override
	public List<Commande> getCommandeByClient() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Commande.findCommandeByClient").getResultList();
	}

	@Override
	public List<Commande> getCommandeEncours() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Commande.findCommandeEncours").getResultList();
	}

	@Override
	public List<Commande> getCommandeNonEnvoyees() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Commande.findCommandeNonEnvoyees").getResultList();
	}

	@Override
	public List<Commande> getCommandeEnvoyees() {
			return em.createNamedQuery("Commande.findCommandeEnvoyees").getResultList();

	}

}
