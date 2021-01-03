package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.model.Employedemandeur;

@Repository("iEmployedemandeurDAO")
@Transactional
public class EmployedemandeurDAOimpl implements IEmployedemandeurDAO {

	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;
	
	@Override
	public void createEmploye(Employedemandeur employe) {
		// TODO Auto-generated method stub
               em.persist(employe);
	}

	@Override
	public Employedemandeur getEmployebyId(Integer employeid) {
		// TODO Auto-generated method stub
		return em.find(Employedemandeur.class, employeid );
	}

	@Override
	public List<Employedemandeur> getAllEmploye() {
		// TODO Auto-generated method stub
		return em.createQuery("Employedemandeur.findall").getResultList();
		 
	}

	@Override
	public Employedemandeur updateEmploye(Employedemandeur employe) {
		// TODO Auto-generated method stub
		return em.merge(employe);
	}

}
