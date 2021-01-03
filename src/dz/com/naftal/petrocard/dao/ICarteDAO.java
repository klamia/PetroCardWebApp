package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.Carte;



public interface ICarteDAO {
	
	
    public  void createCarte(Carte carte);
	
	public  Carte getCartebyId(Integer carteid);

    public  List<Carte> getAllCarte();
   
    public  List<Carte> getCartePrepaid();
    
    public  List<Carte> getCarteExpire();
    
    public Carte updateCarte(Carte carte);
    

   // public void removeBc(BcChargRech bcchargrech);
}
