package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.DemandeRemplacement;



public interface IDemandeRemplacementDAO {
	
    public  void createDemandeRemplacement(DemandeRemplacement demanderemplacement);
	
	public DemandeRemplacement getDemandeRemplacementbyId(Integer demanderemplacementid);

    public  List<DemandeRemplacement> getAllDemandeRemplacement();
    public  List<DemandeRemplacement> getDemandeRemplacementNonTraite();
   
    public DemandeRemplacement updateDemandeRemplacement(DemandeRemplacement demanderemplacement);

   public DemandeRemplacement removeDemandeRemplacement(DemandeRemplacement demanderemplacement);
}
