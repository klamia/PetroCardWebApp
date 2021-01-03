package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.ICommandeDAO;
import dz.com.naftal.petrocard.model.Commande;

@Service("iCommandeService")
@Transactional
public class CommandeServiceImpl implements  ICommandeService{

	@Autowired
	private ICommandeDAO commandedao;
	
	public ICommandeDAO getCommandedao() {
		return commandedao;
	}

	public void setCommandedao(ICommandeDAO commandedao) {
		this.commandedao = commandedao;
	}

	@Override
	public  void createCommande(Commande commande){
		commandedao.createCommande(commande);
	}
	@Override
	public Commande getCommandeById(Integer commandeid) {
		// TODO Auto-generated method stub
		return commandedao.getCommandeById(commandeid);
	}

	@Override
	public Commande getCommandeByEtat(String etat) {
		// TODO Auto-generated method stub
		return commandedao.getCommandeByEtat(etat);
	}

	@Override
	public List<Commande> getAllCommande() {
		// TODO Auto-generated method stub
		return commandedao.getAllCommande();
	}

	@Override
	public Commande updateCommande(Commande commande) {
		return commandedao.updateCommande(commande);
	}

	@Override
	public List<Commande> getCommandevalidees() {
		// TODO Auto-generated method stub
		return commandedao.getCommandevalidees();
	}

	@Override
	public List<Commande> getCommanderejetees() {
		// TODO Auto-generated method stub
		return commandedao.getCommanderejetees();
	}

	@Override
	public List<Commande> getCommandeByClient() {
		// TODO Auto-generated method stub
		return commandedao.getCommandeByClient();
	}

	@Override
	public List<Commande> getCommandeEncours() {
		// TODO Auto-generated method stub
		return commandedao.getCommandeEncours();
	}

	@Override
	public List<Commande> getCommandeNonEnvoyees() {
		// TODO Auto-generated method stub
		return commandedao.getCommandeNonEnvoyees();
	}

	@Override
	public List<Commande> getCommandeEnvoyees() {
		// TODO Auto-generated method stub
		return commandedao.getCommandeEnvoyees();
	}
	
	

}
