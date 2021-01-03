package dz.com.naftal.petrocard.service;

import java.util.List;


import dz.com.naftal.petrocard.model.TypeCarte;

public interface ITypeCarteService {
public void createTypeCarte(TypeCarte typecarte);
	
	public  TypeCarte gettypecartebytype(String intitule);
	public  TypeCarte findById(Integer typecarteid);

    public  List<TypeCarte> getAllTypeCarte();
    
    public void updateTypeCarte(TypeCarte typecarte);

}
