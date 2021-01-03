package dz.com.naftal.petrocard.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import dz.com.naftal.petrocard.model.Client;

import dz.com.naftal.petrocard.service.IClientService;



@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(name="iClientService", value="#{iClientService}")
	private IClientService iClientService;
	private Client client;
	private List<Client> listClient ;
	private Client editClient ;
	int index;
	
	
	public IClientService getiClientService() {
		return iClientService;
	}
	public void setiClientService(IClientService iClientService) {
		this.iClientService = iClientService;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getListClient() {

		listClient = iClientService.getAllclient();
		
		return listClient;
	}
	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}
	public Client getEditClient() {
		return editClient;
	}
	public void setEditClient(Client editClient) {
		this.editClient = editClient;
	}
	
	public void addClient() {
		System.out.println("New Client added");
		
		client = new Client();
		
	}

	public void editClient(Client client) {
		System.out.println(" Client updated");
		index = listClient.indexOf(client);
		editClient = client;
		
	}
	
public void updateClient() {
		
		
		editClient = iClientService.updateClient(editClient);  
		listClient.set(index, editClient);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Client mise à jour"));
	}

public void ajoutClient() {
		try{
			
			System.out.println("FFFFFFFFFFFFFFF");
			iClientService.createClient(client);       
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Client ajouté"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}
	
}
