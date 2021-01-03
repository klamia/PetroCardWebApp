package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IStationServiceDAO;
import dz.com.naftal.petrocard.model.StationService;
@Transactional
@Service("iStationService")
public class StationServiceimpl implements IStationService {

	@Autowired
	private IStationServiceDAO stationservicedao ;
	
	

	public IStationServiceDAO getStationservicedao() {
		return stationservicedao;
	}

	public void setStationservicedao(IStationServiceDAO stationservicedao) {
		this.stationservicedao = stationservicedao;
	}

	@Override
	public void createStationService(StationService stationservice) {
		stationservicedao.createStationService(stationservice);

	}

	@Override
	public StationService getStationServicebyId(String stationserviceid) {
		// TODO Auto-generated method stub
		return stationservicedao.getStationServicebyId(stationserviceid);
	}

	@Override
	public List<StationService> getAllStationService() {
		// TODO Auto-generated method stub
		return stationservicedao.getAllStationService();
	}

	@Override
	public void updateStationService(StationService stationservice) {
		stationservicedao.updateStationService(stationservice);

	}

}
