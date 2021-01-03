package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.TypeCarte;


public interface ITypeCarteDAO {

	
	public void createTypeCarte(TypeCarte typecarte);
	
	public  TypeCarte gettypecartebytype(String intitule);
	public  TypeCarte findById(Integer typecarteid);

    public  List<TypeCarte> getAllTypeCarte();
    
    public void updateTypeCarte(TypeCarte typecarte);

  // public void removeTypeCarte(TypeCarte typecarte);
}
