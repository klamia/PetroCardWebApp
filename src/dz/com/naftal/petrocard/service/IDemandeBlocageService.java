package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.DemandeBlocage;

public interface IDemandeBlocageService {
public  void  createDemandeBlocage(DemandeBlocage demandeblocage);
	
	public DemandeBlocage getDemandeBlocageId(Integer demandeblocageid);

    public  List<DemandeBlocage> getAllDemandeBlocage();
    
    public  List<DemandeBlocage> getAllDemandeBlocageNonTraite();
   
    public DemandeBlocage  updateDemandeBlocage(DemandeBlocage demandeblocage);

   public DemandeBlocage removedemandeblocage(DemandeBlocage demandeblocage);
}
