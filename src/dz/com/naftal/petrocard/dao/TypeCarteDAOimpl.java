package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.model.TypeCarte;

@Repository("iTypeCarteDAO")
@Transactional

public class TypeCarteDAOimpl implements ITypeCarteDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createTypeCarte(TypeCarte typecarte) {
		em.persist(typecarte); 

	     
	}

	@Override
	public TypeCarte gettypecartebytype(String intitule) {
		return em.find(TypeCarte.class, intitule);
	}

	@Override
	public List<TypeCarte> getAllTypeCarte() {
		return em.createNamedQuery("TypeCarte.findAll").getResultList();
	}

	@Override
	public void updateTypeCarte(TypeCarte typecarte) {
		em.merge(typecarte);
	}

	@Override
	public TypeCarte findById(Integer typecarteid) {
		// TODO Auto-generated method stub
		return em.find(TypeCarte.class, typecarteid);
	}

}
