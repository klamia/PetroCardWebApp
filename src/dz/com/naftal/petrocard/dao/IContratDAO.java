package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.Contrat;


public interface IContratDAO {
	
    public  void createContrat(Contrat contrat);
	
	public   Contrat getContratbyId(String contratid);

    public  List< Contrat> getAllContrat();
   
    public  void updateContrat(Contrat contrat);

   // public void removeBc(BcChargRech bcchargrech);
}
