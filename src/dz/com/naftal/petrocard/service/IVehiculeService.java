package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Vehicule;

public interface IVehiculeService {

	public  void createVehicule(Vehicule vehicule);
	
	public  Vehicule getVehiculebyMatricule(String matricule);

    public  List<Vehicule> getAllVehicule();
   
    public void updateVehicule(Vehicule vehicule);

   public void removeVehicule(Vehicule vehicule);
}
