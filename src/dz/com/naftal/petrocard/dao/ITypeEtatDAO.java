package dz.com.naftal.petrocard.dao;

import java.util.List;


import dz.com.naftal.petrocard.model.TypeEtat;

public interface ITypeEtatDAO {
   
	public  void createTypeEtat(TypeEtat typeetat);
	
	public  TypeEtat getTypeEtatbyId(Integer typeetatid);
	
	public  TypeEtat getTypeEtatbyType(String intitule);

    public  List<TypeEtat> getAllTypeEtat();
   
    public  void  updateTypeEtat(TypeEtat typeetat);

   //public void removeTypeEtat(TypeEtat typeetat);
}
