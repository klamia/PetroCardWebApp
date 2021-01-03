package dz.com.naftal.petrocard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import dz.com.naftal.petrocard.model.Document;

@Repository("iDocumentDAO")
@Transactional
public class DocumentDAOimpl implements IDocumentDAO {
	
	@PersistenceContext(unitName = "PetroCardWebApp")
	private EntityManager em;

	@Override
	public void createDocument(Document document) {
		em.persist(document); 

	    
	}

	@Override
	public Document getDocumentbyId(String documentid) {
		return em.find(Document.class, documentid);
	}

	@Override
	public List<Document> getAllDocument() {
		return em.createNamedQuery("Document.findAll").getResultList();
	}

	@Override
	public void updateDocument(Document document) {
		em.merge(document);
	}

	@Override
	public void removeDocument(Document document) {
		em.remove(em.merge(document));

	}

}
