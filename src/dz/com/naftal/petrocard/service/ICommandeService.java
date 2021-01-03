package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Commande;

public interface ICommandeService {
	
	public  void createCommande(Commande commande);
	public  Commande getCommandeById(Integer commandeid);
	public  Commande getCommandeByEtat(String etat);

    public  List<Commande > getAllCommande();
   
    public Commande updateCommande(Commande  commande);
   
    public  List<Commande > getCommandevalidees();
    
    public  List<Commande > getCommanderejetees();
    
    public  List<Commande > getCommandeByClient();
    public  List<Commande > getCommandeEncours();
    
    public  List<Commande > getCommandeNonEnvoyees();
    public  List<Commande > getCommandeEnvoyees();
}
