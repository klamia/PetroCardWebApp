package dz.com.naftal.petrocard.service;

import java.util.List;

import dz.com.naftal.petrocard.model.Client;

public interface IClientService {

	 public  void createClient(Client client);
		
		public  Client getClientByName(String raisonsocial);
		
		public  Client findBayId(Integer clientId);

	    public  List<Client> getAllclient();
	   
	    public  Client updateClient(Client client);

	   // public void removeBc(BcChargRech bcchargrech);
}
