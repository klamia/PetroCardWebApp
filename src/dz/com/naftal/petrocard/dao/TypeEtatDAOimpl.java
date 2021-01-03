package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.TypeEtat;
@Repository("iTypeEtatDAO")
@Transactional
public class TypeEtatDAOimpl implements ITypeEtatDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public  void  createTypeEtat(TypeEtat typeetat) {
		em.persist(typeetat); 

	    
	}

	@Override
	public TypeEtat getTypeEtatbyType(String intitule) {
		return em.find(TypeEtat.class, intitule);
	}

	@Override
	public List<TypeEtat> getAllTypeEtat() {
		return em.createNamedQuery("TypeEtat.findAll").getResultList();
	}

	@Override
	public  void  updateTypeEtat(TypeEtat typeetat) {
		 em.merge(typeetat);
	}

	@Override
	public TypeEtat getTypeEtatbyId(Integer typeetatid) {
		// TODO Auto-generated method stub
		return em.find(TypeEtat.class, typeetatid);
	}

}
