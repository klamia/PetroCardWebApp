package dz.com.naftal.petrocard.dao;

import java.util.List;


import dz.com.naftal.petrocard.model.Document;

public interface IDocumentDAO {
	
    public  void createDocument(Document document);
	
	public  Document getDocumentbyId(String documentid);

    public  List<Document> getAllDocument();
   
    public void updateDocument(Document document);

   public void removeDocument(Document document);
}
