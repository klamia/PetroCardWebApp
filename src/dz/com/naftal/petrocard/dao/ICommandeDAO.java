package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.Commande;



public interface ICommandeDAO {

public  void createCommande(Commande commande);
	
	public  Commande getCommandeById(Integer commandeid);
	public  Commande getCommandeByEtat(String etat);

    public  List<Commande > getAllCommande();
    
    public  List<Commande > getCommandevalidees();
    
    public  List<Commande > getCommanderejetees();
    
    public  List<Commande > getCommandeEncours();
    public  List<Commande > getCommandeNonEnvoyees();
    public  List<Commande > getCommandeEnvoyees();
    public  List<Commande > getCommandeByClient();
   
    public Commande  updateCommande(Commande  commande);

   
}
