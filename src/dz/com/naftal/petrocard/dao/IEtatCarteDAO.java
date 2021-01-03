package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.EtatCarte;



public interface IEtatCarteDAO {

public  void createEtatCarte(EtatCarte etatcarte);
	
	public  EtatCarte getEtatCartebyTypeEtat(String typeEtat);

    public  List<EtatCarte> getAllEtatCarte();
   
    public void updateEtatCarte(EtatCarte etatcarte);

    public  Carte getCartebyId(Integer carteid);
    
   public List<EtatCarte> getCartesConfectionne();
   public  List<EtatCarte> getCartesActivees();
   public  List<EtatCarte> getCartesActiveesPrepaid();
   public  List<EtatCarte> getCartesNonExpirees();
   public  List<EtatCarte> getCartesExpirees();
   public  List<EtatCarte> getCartesBloques();
   public  List<EtatCarte> getCartesABloques();
   public  List<EtatCarte> getCartesRemplace();
}
