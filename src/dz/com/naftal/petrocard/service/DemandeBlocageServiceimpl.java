package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IDemandeBlocageDAO;
import dz.com.naftal.petrocard.model.DemandeBlocage;
@Transactional
@Service("iDemandeBlocageService")
public class DemandeBlocageServiceimpl implements IDemandeBlocageService {

	

	@Autowired
	private IDemandeBlocageDAO iDemandeBlocageDAO;
	
	
	public IDemandeBlocageDAO getiDemandeBlocageDAO() {
		return iDemandeBlocageDAO;
	}

	public void setiDemandeBlocageDAO(IDemandeBlocageDAO iDemandeBlocageDAO) {
		this.iDemandeBlocageDAO = iDemandeBlocageDAO;
	}
	
	@Override
	public void createDemandeBlocage(DemandeBlocage demandeblocage) {
		iDemandeBlocageDAO.createDemandeBlocage(demandeblocage);

	}

	@Override
	public DemandeBlocage getDemandeBlocageId(Integer demandeblocageid) {
		// TODO Auto-generated method stub
		return iDemandeBlocageDAO.getDemandeBlocageId(demandeblocageid);
	}

	@Override
	public List<DemandeBlocage> getAllDemandeBlocage() {
		// TODO Auto-generated method stub
		return iDemandeBlocageDAO.getAllDemandeBlocage();
	}

	@Override
	public DemandeBlocage updateDemandeBlocage(DemandeBlocage demandeblocage) {
		return iDemandeBlocageDAO.updateDemandeBlocage(demandeblocage);

	}

	@Override
	public DemandeBlocage removedemandeblocage(DemandeBlocage demandeblocage) {
		return iDemandeBlocageDAO.removedemandeblocage(demandeblocage);

	}

	@Override
	public List<DemandeBlocage> getAllDemandeBlocageNonTraite() {
		// TODO Auto-generated method stub
		return iDemandeBlocageDAO.getAllDemandeBlocageNonTraite();
	}

	
}
