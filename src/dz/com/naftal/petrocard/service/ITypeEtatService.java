package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.TypeEtat;

public interface ITypeEtatService {

    public  void createTypeEtat(TypeEtat typeetat);
	
    public  TypeEtat getTypeEtatbyId(Integer typeetatid);
    public  TypeEtat getTypeEtatbyType(String intitule);

    public  List<TypeEtat> getAllTypeEtat();
   
    public  void  updateTypeEtat(TypeEtat typeetat);

	
}
