package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.BcChargRech;

public interface IBcChargRechService {

	public void createBC(BcChargRech bcchargrech);
	
	public  BcChargRech getBcById(Integer bcchargrechid);

    public  List<BcChargRech> getAllBc();
   
    public BcChargRech updateBc(BcChargRech bcchargrech);

    public BcChargRech removeBc(BcChargRech bcchargrech);
}
