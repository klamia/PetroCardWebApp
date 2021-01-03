package dz.com.naftal.petrocard.dao;


import java.util.List;

import dz.com.naftal.petrocard.model.BcChargRech;




public interface IBcChargRechDAO {

	
	public void createBC(BcChargRech bcchargrech);
	
	public  BcChargRech getBcById(Integer bcchargrechid);

    public  List<BcChargRech> getAllBc();
   
    public BcChargRech updateBc(BcChargRech bcchargrech);

   public BcChargRech removeBc(BcChargRech bcchargrech);
}	


	

