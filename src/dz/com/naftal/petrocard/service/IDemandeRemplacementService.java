package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.DemandeRemplacement;

public interface IDemandeRemplacementService {
public  void createDemandeRemplacement(DemandeRemplacement demanderemplacement);
	
	public DemandeRemplacement getDemandeRemplacementbyId(Integer demanderemplacementid);

    public  List<DemandeRemplacement> getAllDemandeRemplacement();
    
    public  List<DemandeRemplacement> getDemandeRemplacementNonTraite();
   
    public DemandeRemplacement updateDemandeRemplacement(DemandeRemplacement demanderemplacement);

   public DemandeRemplacement removeDemandeRemplacement(DemandeRemplacement demanderemplacement);
}
