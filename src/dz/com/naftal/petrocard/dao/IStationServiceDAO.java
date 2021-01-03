package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.StationService;



public interface IStationServiceDAO {
	
   public  void createStationService(StationService stationservice);
	
	public  StationService getStationServicebyId(String stationserviceid);

    public  List<StationService> getAllStationService();
   
    public void updateStationService(StationService stationservice);

   
}
