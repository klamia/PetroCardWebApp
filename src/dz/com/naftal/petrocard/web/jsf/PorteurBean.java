package dz.com.naftal.petrocard.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;




import dz.com.naftal.petrocard.model.Ident;


import dz.com.naftal.petrocard.service.IdentService;

@ManagedBean(name = "porteurBean")
@SessionScoped
public class PorteurBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(name="identService", value="#{identService}")
	private IdentService identService;
	private Ident porteur;
	private List<Ident> listPorteur ;
	private List<Ident> listPorteurCdeValidees ;
	private List<Ident> listPorteurByCdeID ;
	
	private Ident editedPorteur ;
	int index;
	private Ident deletedPorteur ;
	
	public IdentService getIdentService() {
		return identService;
	}

	public void setIdentService(IdentService identService) {
		this.identService = identService;
	}

	public Ident getPorteur() {
		return porteur;
	}

	public void setPorteur(Ident porteur) {
		this.porteur = porteur;
	}
	
	
	public Ident getEditedPorteur() {
		return editedPorteur;
	}

	public void setEditedPorteur(Ident editedPorteur) {
		this.editedPorteur = editedPorteur;
	}

	public Ident getDeletedPorteur() {
		return deletedPorteur;
	}

	public void setDeletedPorteur(Ident deletedPorteur) {
		this.deletedPorteur = deletedPorteur;
	}
	

	public List<Ident> getListPorteur() {
		
		listPorteur = identService.getAllIdent();
		return listPorteur;
	}

	public void setListPorteur(List<Ident> listPorteur) {
		this.listPorteur = listPorteur;
	}

	

	public List<Ident> getListPorteurCdeValidees() {
		
		listPorteurCdeValidees = identService.findbycdevalidees();
		return listPorteurCdeValidees;
	}

	public void setListPorteurCdeValidees(List<Ident> listPorteurCdeValidees) {
		this.listPorteurCdeValidees = listPorteurCdeValidees;
	}

	public List<Ident> getListPorteurByCdeID() {
		
		listPorteurByCdeID = identService.findbyCdeID();
		return listPorteurByCdeID;
	}

	public void setListPorteurByCdeID(List<Ident> listPorteurByCdeID) {
		this.listPorteurByCdeID = listPorteurByCdeID;
	}

	public void ajoutPorteur() {
		System.out.println("New Porteur added");
		porteur = new Ident();
	
		
	}

	public void editPorteur(Ident porteur) {
		
		System.out.println(" Porteur updated");
		index = listPorteur.indexOf(porteur);
		editedPorteur = porteur;
		
	}
	
	public void supprimePorteur(Ident porteur) {
		System.out.println(" Porteur deleted");
		index = listPorteur.indexOf(porteur);
		deletedPorteur = porteur;
		

	}
	
public void updatePorteur() {
		
		
	editedPorteur = identService.updateIdent(editedPorteur);  
		listPorteur.set(index, editedPorteur);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Porteur mise à jour"));
	}

	public void addPorteur() {
		try{
			
			System.out.println("FFFFFFFFFFFFFFF");
			identService.createIdent(porteur);     
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Porteur ajouté"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}

	public void deletePorteur() {
		System.out.println(" couccccccc");
		deletedPorteur  = identService.removeIdent(deletedPorteur);
		listPorteur.set(index, deletedPorteur);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Porteur supprimé"));
		
	    
	}
	
	
	
}
