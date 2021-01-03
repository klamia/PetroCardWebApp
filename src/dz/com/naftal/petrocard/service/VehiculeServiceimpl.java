package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IVehiculeDAO;
import dz.com.naftal.petrocard.model.Vehicule;
@Transactional
@Service("iVehiculeService")
public class VehiculeServiceimpl implements IVehiculeService {

	@Autowired
	private IVehiculeDAO vehiculedao;
	
	public IVehiculeDAO getVehiculedao() {
		return vehiculedao;
	}

	public void setVehiculedao(IVehiculeDAO vehiculedao) {
		this.vehiculedao = vehiculedao;
	}

	@Override
	public void createVehicule(Vehicule vehicule) {
		vehiculedao.createVehicule(vehicule);

	}

	@Override
	public Vehicule getVehiculebyMatricule(String matricule) {
		// TODO Auto-generated method stub
		return vehiculedao.getVehiculebyMatricule(matricule);
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		// TODO Auto-generated method stub
		return vehiculedao.getAllVehicule();
	}

	@Override
	public void updateVehicule(Vehicule vehicule) {
		vehiculedao.updateVehicule(vehicule);

	}

	@Override
	public void removeVehicule(Vehicule vehicule) {
		vehiculedao.removeVehicule(vehicule);

	}

}
