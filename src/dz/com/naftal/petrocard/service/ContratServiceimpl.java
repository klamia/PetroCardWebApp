package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IContratDAO;
import dz.com.naftal.petrocard.model.Contrat;
@Transactional
@Service("iContratService")
public class ContratServiceimpl implements IContratService {

	@Autowired
	private IContratDAO contratdao;
	
	public IContratDAO getContratdao() {
		return contratdao;
	}

	public void setContratdao(IContratDAO contratdao) {
		this.contratdao = contratdao;
	}

	@Override
	public void createContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		contratdao.createContrat(contrat);
	}

	@Override
	public Contrat getContratbyId(String contratid) {
		// TODO Auto-generated method stub
		return contratdao.getContratbyId(contratid);
	}

	@Override
	public List<Contrat> getAllContrat() {
		// TODO Auto-generated method stub
		return contratdao.getAllContrat();
	}

	@Override
	public void updateContrat(Contrat contrat) {
		contratdao.updateContrat(contrat);

	}

}
