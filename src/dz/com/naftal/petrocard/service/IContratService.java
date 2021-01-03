package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Contrat;

public interface IContratService {

public  void createContrat(Contrat contrat);
	
	public   Contrat getContratbyId(String contratid);

    public  List< Contrat> getAllContrat();
   
    public  void updateContrat(Contrat contrat);
	
	
}
