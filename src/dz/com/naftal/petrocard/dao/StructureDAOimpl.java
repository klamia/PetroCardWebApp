package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.Structure;

@Repository("iStructureDAO")
@Transactional

public class StructureDAOimpl implements IStructureDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createStructure(Structure structure) {
		em.persist(structure); 

	    
	}

	@Override
	public Structure getStructurebyname(String nomstruct) {
		return em.find(Structure.class, nomstruct);
	}

	@Override
	public List<Structure> getAllStructure() {
		return em.createNamedQuery("Structure.findAll").getResultList();
	}

	@Override
	public void updateStructure(Structure structure) {
		 em.merge(structure);
	}

}
