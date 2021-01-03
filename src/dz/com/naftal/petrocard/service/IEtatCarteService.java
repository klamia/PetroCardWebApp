package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.EtatCarte;

public interface IEtatCarteService {

	public  void createEtatCarte(EtatCarte etatcarte);
	
	public  EtatCarte getEtatCartebyTypeEtat(String typeEtat);
	
	 public  Carte getCartebyId(Integer carteid);

    public  List<EtatCarte> getAllEtatCarte();
   
    public void updateEtatCarte(EtatCarte etatcarte);


   public List<EtatCarte> getCartesConfectionne();
   public  List<EtatCarte> getCartesActivees();
   public  List<EtatCarte> getCartesActiveesPrepaid();
   public  List<EtatCarte> getCartesNonExpirees();
   public  List<EtatCarte> getCartesExpirees();
   public  List<EtatCarte> getCartesABloques();
   public  List<EtatCarte> getCartesBloques();
   public  List<EtatCarte> getCartesRemplace();
}
