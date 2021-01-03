package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Structure;

public interface IStructureService {
	
    public  void createStructure(Structure structure);
	
	public  Structure getStructurebyname(String nomstruct);

    public  List<Structure> getAllStructure();
   
    public void updateStructure(Structure structure);
}
