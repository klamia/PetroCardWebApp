package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IStructureDAO;
import dz.com.naftal.petrocard.model.Structure;
@Transactional
@Service("iStructureService")
public class StructureServiceimpl implements IStructureService {

	@Autowired
	private IStructureDAO structuredao;
	
	@Override
	public void createStructure(Structure structure) {
		structuredao.createStructure(structure);

	}

	public IStructureDAO getStructuredao() {
		return structuredao;
	}

	public void setStructuredao(IStructureDAO structuredao) {
		this.structuredao = structuredao;
	}

	@Override
	public Structure getStructurebyname(String nomstruct) {
		// TODO Auto-generated method stub
		return structuredao.getStructurebyname(nomstruct);
	}

	@Override
	public List<Structure> getAllStructure() {
		// TODO Auto-generated method stub
		return structuredao.getAllStructure();
	}

	@Override
	public void updateStructure(Structure structure) {
		structuredao.updateStructure(structure);

	}

}
