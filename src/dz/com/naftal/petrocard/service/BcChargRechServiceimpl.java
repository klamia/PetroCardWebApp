package dz.com.naftal.petrocard.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IBcChargRechDAO;
import dz.com.naftal.petrocard.model.BcChargRech;
@Transactional
@Service("iBcChargRechService")
public class BcChargRechServiceimpl implements IBcChargRechService {

	@Autowired
	private IBcChargRechDAO iBcChargRechDAO;
	
	
	public IBcChargRechDAO getiBcChargRechDAO() {
		return iBcChargRechDAO;
	}

	public void setiBcChargRechDAO(IBcChargRechDAO iBcChargRechDAO) {
		this.iBcChargRechDAO = iBcChargRechDAO;
	}

	@Override
	public void createBC(BcChargRech bcchargrech) {
		iBcChargRechDAO.createBC(bcchargrech);

	}

	@Override
	public BcChargRech getBcById(Integer bcchargrechid) {
		
		return iBcChargRechDAO.getBcById(bcchargrechid);
	}

	@Override
	public List<BcChargRech> getAllBc() {
		// TODO Auto-generated method stub
		return iBcChargRechDAO.getAllBc();
	}

	@Override
	public BcChargRech updateBc(BcChargRech bcchargrech) {
		return iBcChargRechDAO.updateBc(bcchargrech);

	}

	@Override
	public BcChargRech removeBc(BcChargRech bcchargrech) {
		// TODO Auto-generated method stub
		return iBcChargRechDAO.removeBc(bcchargrech);
	}

}
