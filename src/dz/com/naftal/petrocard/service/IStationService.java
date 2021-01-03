package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.StationService;

public interface IStationService {
    
	public  void createStationService(StationService stationservice);
	
	public  StationService getStationServicebyId(String stationserviceid);

    public  List<StationService> getAllStationService();
   
    public void updateStationService(StationService stationservice);
}
