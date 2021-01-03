package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Employedemandeur;

public interface IEmployedemandeurService {

	public  void createEmploye(Employedemandeur employe);
	
	public  Employedemandeur getEmployebyId(Integer employeid);

    public  List<Employedemandeur> getAllEmploye();
   
    public Employedemandeur updateEmploye(Employedemandeur employe);

}
