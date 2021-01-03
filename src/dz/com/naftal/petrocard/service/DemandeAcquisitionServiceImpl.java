package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IDemandeAcquisitionDAO;
import dz.com.naftal.petrocard.model.DemandeAcquisition;

@Service("iDemandeAcquisitionService")
@Transactional
public class DemandeAcquisitionServiceImpl implements
		IDemandeAcquisitionService {

	@Autowired
	private IDemandeAcquisitionDAO demandeacquisitiondao;
	
	
	public IDemandeAcquisitionDAO getDemandeacquisitiondao() {
		return demandeacquisitiondao;
	}

	public void setDemandeacquisitiondao(IDemandeAcquisitionDAO demandeacquisitiondao) {
		this.demandeacquisitiondao = demandeacquisitiondao;
	}

	@Override
	public void createDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		demandeacquisitiondao.createDemandeAcquisition(demandeAcquisition);

	}

	@Override
	public DemandeAcquisition getDemandeAcquisitionbyId(
			Integer demandeacquisitionid) {
		// TODO Auto-generated method stub
		return demandeacquisitiondao.getDemandeAcquisitionbyId(demandeacquisitionid);
	}

	@Override
	public List<DemandeAcquisition> getAllDemandeAcquisition() {
		// TODO Auto-generated method stub
		return demandeacquisitiondao.getAllDemandeAcquisition();
	}

	@Override
	public DemandeAcquisition updateDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		return demandeacquisitiondao.updateDemandeAcquisition(demandeAcquisition);

	}

	@Override
	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		return  demandeacquisitiondao.removeDemandeAcquisition(demandeAcquisition);

	}

	@Override
	public List<DemandeAcquisition> getDemandeAcquisitionByClient() {
		// TODO Auto-generated method stub
		return demandeacquisitiondao.getDemandeAcquisitionByClient();
	}

	@Override
	public List<DemandeAcquisition> getDemandeAcquisitionNonTraite() {
		// TODO Auto-generated method stub
		return demandeacquisitiondao.getDemandeAcquisitionNonTraite();
	}

}
