package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.EtatCarte;
@Repository("iEtatCarteDAO")
@Transactional
public class EtatCarteDAOimpl implements IEtatCarteDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createEtatCarte(EtatCarte etatcarte) {
		em.persist(etatcarte); 

	    
	}

	@Override
	public EtatCarte getEtatCartebyTypeEtat(String typeEtat) {
		return em.find(EtatCarte.class, typeEtat);
	}

	@Override
	public List<EtatCarte> getAllEtatCarte() {
		return em.createNamedQuery("EtatCarte.findAll").getResultList();
	}

	@Override
	public void updateEtatCarte(EtatCarte etatcarte) {
		 em.merge(etatcarte);
	}
	

	@Override
	public List<EtatCarte> getCartesActivees() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesActivees").getResultList();
	}

	@Override
	public List<EtatCarte> getCartesNonExpirees() {
		// TODO Auto-generated method stub
		 return em.createNamedQuery("EtatCarte.findCartesNonExpirees").getResultList();
	}

	@Override
	public List<EtatCarte> getCartesBloques() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesBloques").getResultList();
	}

	@Override
	public List<EtatCarte> getCartesRemplace() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesRemplace").getResultList();
	}

	@Override
	public List<EtatCarte> getCartesConfectionne() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesConfectionne").getResultList();
	}

	@Override
	public List<EtatCarte> getCartesActiveesPrepaid() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesPrepaidActives").getResultList();
	}

	@Override
	public Carte getCartebyId(Integer carteid) {
		// TODO Auto-generated method stub
		
			return em.find(Carte.class, carteid);
		}

	@Override
	public List<EtatCarte> getCartesExpirees() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesExpirees").getResultList();
	}

	@Override
	public List<EtatCarte> getCartesABloques() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EtatCarte.findCartesABloques").getResultList();
	}
	

}
