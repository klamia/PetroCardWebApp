package dz.com.naftal.petrocard.service;



import java.util.List;

import dz.com.naftal.petrocard.model.Client;
import dz.com.naftal.petrocard.model.Ident;

public interface IdentService {

    public  void createIdent(Ident porteur);
	
	public  Ident getIdentbyClient(Client client);

    public Ident updateIdent(Ident porteur);
    
    public Ident removeIdent(Ident porteur);
    
    public  Ident getIdentbyID(Integer porteurid);
    public  List<Ident> getAllIdent();
    public List<Ident> findbycdevalidees();
    public List<Ident> findbyCdeID();
   
	
}
