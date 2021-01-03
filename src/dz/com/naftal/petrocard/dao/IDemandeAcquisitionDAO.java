package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.DemandeAcquisition;



public interface IDemandeAcquisitionDAO {
	
   public  void createDemandeAcquisition(DemandeAcquisition demandeAcquisition);
	
	public DemandeAcquisition getDemandeAcquisitionbyId(Integer demandeacquisitionid);

    public  List<DemandeAcquisition> getAllDemandeAcquisition();
    
    public List<DemandeAcquisition> getDemandeAcquisitionNonTraite();
    
    public  List<DemandeAcquisition> getDemandeAcquisitionByClient();
    
    public DemandeAcquisition updateDemandeAcquisition(DemandeAcquisition demandeAcquisition);

   public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition);
}
