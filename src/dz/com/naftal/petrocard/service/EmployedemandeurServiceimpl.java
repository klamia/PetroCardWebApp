package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IEmployedemandeurDAO;
import dz.com.naftal.petrocard.model.Employedemandeur;
@Transactional
@Service("iEmployedemandeurService")
public class EmployedemandeurServiceimpl implements IEmployedemandeurService {

	@Autowired
	private IEmployedemandeurDAO iEmployedemandeurDAO ;
	
	@Override
	public void createEmploye(Employedemandeur employe) {
		// TODO Auto-generated method stub
		iEmployedemandeurDAO.createEmploye(employe);
	}

	@Override
	public Employedemandeur getEmployebyId(Integer employeid) {
		// TODO Auto-generated method stub
		return iEmployedemandeurDAO.getEmployebyId(employeid);
	}

	@Override
	public List<Employedemandeur> getAllEmploye() {
		// TODO Auto-generated method stub
		return iEmployedemandeurDAO.getAllEmploye();
	}

	@Override
	public Employedemandeur updateEmploye(Employedemandeur employe) {
		// TODO Auto-generated method stub
		return iEmployedemandeurDAO.updateEmploye(employe);
	}

}
