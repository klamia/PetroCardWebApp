package dz.com.naftal.petrocard.dao;

import java.util.List;

import dz.com.naftal.petrocard.model.Client;



public interface IClientDAO {
	
    public  void createClient(Client client);
	
	public  Client getClientByName(String raisonsocial);

    public  List<Client> getAllclient();
   
    public Client updateClient(Client client);

	public Client findBayId(Integer clientId);

   // public void removeBc(BcChargRech bcchargrech);
}
