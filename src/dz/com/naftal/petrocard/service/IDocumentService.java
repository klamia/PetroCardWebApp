package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Document;

public interface IDocumentService {
	
   public  void createDocument(Document document);
	
	public  Document getDocumentbyId(String documentid);

    public  List<Document> getAllDocument();
   
    public void updateDocument(Document document);

   public void removeDocument(Document document);
}
