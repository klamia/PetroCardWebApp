package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.DemandeAcquisition;

public interface IDemandeAcquisitionService {
	
public  void createDemandeAcquisition(DemandeAcquisition demandeAcquisition);
	
	public DemandeAcquisition getDemandeAcquisitionbyId(Integer demandeAcquisitionid);

    public  List<DemandeAcquisition> getAllDemandeAcquisition();
    public  List<DemandeAcquisition> getDemandeAcquisitionByClient();
   
    public DemandeAcquisition updateDemandeAcquisition(DemandeAcquisition demandeAcquisition);
    public List<DemandeAcquisition> getDemandeAcquisitionNonTraite();

   public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition);
}
