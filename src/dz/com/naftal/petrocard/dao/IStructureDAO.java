package dz.com.naftal.petrocard.dao;

import java.util.List;


import dz.com.naftal.petrocard.model.Structure;

public interface IStructureDAO {
	
public  void createStructure(Structure structure);
	
	public  Structure getStructurebyname(String nomstruct);

    public  List<Structure> getAllStructure();
   
    public void updateStructure(Structure structure);

   //public void removeDocument(Document document);
}
