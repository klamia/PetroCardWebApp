package dz.com.naftal.petrocard.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;




import dz.com.naftal.petrocard.model.Commande;
import dz.com.naftal.petrocard.model.DemandeAcquisition;


import dz.com.naftal.petrocard.service.ICommandeService;
import dz.com.naftal.petrocard.service.IDemandeAcquisitionService;


@ManagedBean(name = "commandeBean")
@SessionScoped
public class CommandeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(name="iCommandeService", value="#{iCommandeService}")
	private ICommandeService iCommandeService;
	@ManagedProperty(name="iDemandeAcquisitionService", value="#{iDemandeAcquisitionService}")
	private IDemandeAcquisitionService iDemandeAcquisitionService;
	
	
	
	private Commande commande;
	private Commande commandeEnCours;
	private List<Commande> listCommande ;
	private List<Commande> listCommandeValidees ;
	private List<Commande> listCommandeEncours ;
	private List<Commande> listCommandeNonEnvoyees ;
	private List<Commande> listCommandeEnvoyees ;
	private List<Commande> listCommandeClient ;

	private Commande editCommande ;
	
	private boolean rendred;
	int index;
	String etat;
	
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public ICommandeService getiCommandeService() {
		return iCommandeService;
	}
	public void setiCommandeService(ICommandeService iCommandeService) {
		this.iCommandeService = iCommandeService;
	}
	
     
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public List<Commande> getListCommande() {
		
		listCommande = iCommandeService.getAllCommande();
		
		return listCommande;
	}
	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}
	public Commande getEditCommande() {
		
		return editCommande;
	}
	public void setEditCommande(Commande editCommande) {
		this.editCommande = editCommande;
	}
	
	
	public IDemandeAcquisitionService getiDemandeAcquisitionService() {
		return iDemandeAcquisitionService;
	}
	public void setiDemandeAcquisitionService(
			IDemandeAcquisitionService iDemandeAcquisitionService) {
		this.iDemandeAcquisitionService = iDemandeAcquisitionService;
	}
	
	
	public void addCommande(DemandeAcquisition  demandeacquisition) {
		System.out.println("New Commande added");
		
		commande = new Commande();
		commande.setDemandeAcquisition(demandeacquisition);
		
	}
	
	public void editCommandeEncours(Commande commande) {
		System.out.println(" Commande updated");
		index = listCommandeEncours.indexOf(commande);
		editCommande = commande;
		
	}
	
	public void voirCommande(Commande commande) {
		System.out.println(" Commande a voir");
		index = listCommande.indexOf(commande);
		commandeEnCours = commande;
		

	}
	
		
public void updateCommandeEncours() {
		
		
		editCommande = iCommandeService.updateCommande(editCommande);
		listCommandeEncours.set(index, editCommande);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Commande est Validée Avec Succés"));
	}
/*-------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	
public void editCommandeNonEnvoyees(Commande commande) {
	System.out.println(" Commande updated");
	index = listCommandeNonEnvoyees.indexOf(commande);
	editCommande = commande;
	
}

	
public void updateCommandeNonEnvoyees() {
	
	
	editCommande = iCommandeService.updateCommande(editCommande);
	listCommandeNonEnvoyees.set(index, editCommande);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Envoi Commande est Enregistré avec succés"));
}
	
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void editCommande(Commande commande) {
		System.out.println(" Commande updated");
		index = listCommande.indexOf(commande);
		editCommande = commande;
		
	}
	
		
public void updateCommande() {
		
		
		editCommande = iCommandeService.updateCommande(editCommande);
		listCommande.set(index, editCommande);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Commande mise à jour avec succés"));
	}

	public void ajoutCommande() {
		try{
			
			String traite="Oui";
			System.out.println("FFFFFFFFFFFFFFF");
			iCommandeService.createCommande(commande);
			DemandeAcquisition demandeAcquisition= commande.getDemandeAcquisition();
			demandeAcquisition.setTraite(traite);			
			iDemandeAcquisitionService.updateDemandeAcquisition(demandeAcquisition);
			
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Commande est ajoutée avec succés"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}
	
	
	public void reset() {  
        RequestContext.getCurrentInstance().reset("editCO:display");  
    }
	public List<Commande> getListCommandeValidees() {
		listCommandeValidees = iCommandeService.getCommandevalidees();
		
		return listCommandeValidees;
	}
	public void setListCommandeValidees(List<Commande> listCommandeValidees) {
		this.listCommandeValidees = listCommandeValidees;
	}
	
	public List<Commande> getListCommandeEncours() {
		
		listCommandeEncours = iCommandeService.getCommandeEncours();
		return listCommandeEncours;
	}
	public void setListCommandeEncours(List<Commande> listCommandeEncours) {
		this.listCommandeEncours = listCommandeEncours;
	}
	public List<Commande> getListCommandeNonEnvoyees() {
		
		listCommandeNonEnvoyees = iCommandeService.getCommandeNonEnvoyees();
		return listCommandeNonEnvoyees;
	}
	public void setListCommandeNonEnvoyees(List<Commande> listCommandeNonEnvoyees) {
		this.listCommandeNonEnvoyees = listCommandeNonEnvoyees;
	}
	public List<Commande> getListCommandeEnvoyees() {
		listCommandeEnvoyees = iCommandeService.getCommandeEnvoyees();
		return listCommandeEnvoyees;
	}
	public void setListCommandeEnvoyees(List<Commande> listCommandeEnvoyees) {
		this.listCommandeEnvoyees = listCommandeEnvoyees;
	}
	public List<Commande> getListCommandeClient() {
		return listCommandeClient;
	}
	public void setListCommandeClient(List<Commande> listCommandeClient) {
		this.listCommandeClient = listCommandeClient;
	}
	public Commande getCommandeEnCours() {
		return commandeEnCours;
	}
	public void setCommandeEnCours(Commande commandeEnCours) {
		this.commandeEnCours = commandeEnCours;
	}
	public boolean isRendred() {
		return rendred;
	}
	public void setRendred(boolean rendred) {
		this.rendred = rendred;
	}  
	
	public void showmotif( ActionEvent e){
		
		if (editCommande.getEtat().equals("Rejete"))
			rendred=true;
		else
		rendred=false;
		System.err.println("editCommande.getEtat() "+editCommande.getEtat());	
		System.err.println("rendred "+rendred);	
		
		
	}
	
	public void preProcessPDFCde(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Commandes"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	
	public void preProcessPDFCdeEnCours(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Commandes En Cours"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	
	}


