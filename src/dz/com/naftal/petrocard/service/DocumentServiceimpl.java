package dz.com.naftal.petrocard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.naftal.petrocard.dao.IDocumentDAO;
import dz.com.naftal.petrocard.model.Document;
@Transactional
@Service("iDocumentService")
public class DocumentServiceimpl implements IDocumentService {

	@Autowired
	private IDocumentDAO documentdao ;
	
	
	public IDocumentDAO getDocumentdao() {
		return documentdao;
	}

	public void setDocumentdao(IDocumentDAO documentdao) {
		this.documentdao = documentdao;
	}

	@Override
	public void createDocument(Document document) {
		
		documentdao.createDocument(document);
	}

	@Override
	public Document getDocumentbyId(String documentid) {
		// TODO Auto-generated method stub
		return documentdao.getDocumentbyId(documentid);
	}

	@Override
	public List<Document> getAllDocument() {
		// TODO Auto-generated method stub
		return documentdao.getAllDocument();
	}

	@Override
	public void updateDocument(Document document) {
		documentdao.updateDocument(document);
		
	}

	@Override
	public void removeDocument(Document document) {
		documentdao.removeDocument(document);
		
	}

	

}
