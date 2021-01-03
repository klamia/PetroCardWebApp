package dz.com.naftal.petrocard.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;


import dz.com.naftal.petrocard.model.DemandeRemplacement;

import dz.com.naftal.petrocard.service.IDemandeRemplacementService;

@ManagedBean(name = "remplacementBean")
@SessionScoped
public class RemplacementBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name="iDemandeRemplacementService", value="#{iDemandeRemplacementService}")
	private IDemandeRemplacementService iDemandeRemplacementService;
	

	
	private DemandeRemplacement demanderemplacement;
	private List<DemandeRemplacement> listDemandeRemplacement;
	private List<DemandeRemplacement> listDemandeRempNonTraite;
	
	
	//private List<DemandeBlocage> listDemandeBlocageByClient ;
	private DemandeRemplacement DemandeRempEnCours;
	private DemandeRemplacement editedDemandeRemp ;
	private DemandeRemplacement deletedDemandeRemp ;
	
	int index;

	public IDemandeRemplacementService getiDemandeRemplacementService() {
		return iDemandeRemplacementService;
	}

	public void setiDemandeRemplacementService(
			IDemandeRemplacementService iDemandeRemplacementService) {
		this.iDemandeRemplacementService = iDemandeRemplacementService;
	}

	public DemandeRemplacement getDemanderemplacement() {
		return demanderemplacement;
	}

	public void setDemanderemplacement(DemandeRemplacement demanderemplacement) {
		this.demanderemplacement = demanderemplacement;
	}

	public List<DemandeRemplacement> getListDemandeRemplacement() {
		listDemandeRemplacement = iDemandeRemplacementService.getAllDemandeRemplacement();
		return listDemandeRemplacement;
	}

	public void setListDemandeRemplacement(
			List<DemandeRemplacement> listDemandeRemplacement) {
		this.listDemandeRemplacement = listDemandeRemplacement;
	}

	public List<DemandeRemplacement> getListDemandeRempNonTraite() {
		listDemandeRempNonTraite = iDemandeRemplacementService.getDemandeRemplacementNonTraite();
		return listDemandeRempNonTraite;
	}

	public void setListDemandeRempNonTraite(
			List<DemandeRemplacement> listDemandeRempNonTraite) {
		this.listDemandeRempNonTraite = listDemandeRempNonTraite;
	}

	public DemandeRemplacement getDemandeRempEnCours() {
		return DemandeRempEnCours;
	}

	public void setDemandeRempEnCours(DemandeRemplacement demandeRempEnCours) {
		DemandeRempEnCours = demandeRempEnCours;
	}

	public DemandeRemplacement getEditedDemandeRemp() {
		return editedDemandeRemp;
	}

	public void setEditedDemandeRemp(DemandeRemplacement editedDemandeRemp) {
		this.editedDemandeRemp = editedDemandeRemp;
	}

	public DemandeRemplacement getDeletedDemandeRemp() {
		return deletedDemandeRemp;
	}

	public void setDeletedDemandeRemp(DemandeRemplacement deletedDemandeRemp) {
		this.deletedDemandeRemp = deletedDemandeRemp;
	}


	
	
	public void addDemandeRemplacement() {
		System.out.println("New Demande added");
		
		demanderemplacement = new DemandeRemplacement();
		
	}
	
	public void voirDemandeRemplacement(DemandeRemplacement demanderemplacement) {
		System.out.println(" Demande a voir");
		index = listDemandeRemplacement.indexOf(demanderemplacement);
		DemandeRempEnCours = demanderemplacement;
		

	}
	
	
	public void editDemandeRemplacement(DemandeRemplacement demanderemplacement) {
		System.out.println(" Demande updated");
		index = listDemandeRemplacement.indexOf(demanderemplacement);
		editedDemandeRemp = demanderemplacement;
		

	}

	public void supprimeDemandeRemplacement(DemandeRemplacement demanderemplacement) {
		System.out.println(" Demande deleted");
		index = listDemandeRemplacement.indexOf(demanderemplacement);
		deletedDemandeRemp = demanderemplacement;
		

	}
	
public void updateDemandeRemplacement() {
		
		
	editedDemandeRemp = iDemandeRemplacementService.updateDemandeRemplacement(editedDemandeRemp);  
		listDemandeRemplacement.set(index, editedDemandeRemp);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Blocage mise à jour"));
	}

	public void ajoutDemandeRemplacement() {
		try{
			System.out.println("FFFFFFFFFFFFFFF");
			iDemandeRemplacementService.createDemandeRemplacement(demanderemplacement);       
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Remplacement ajoutée"));
	    //RequestContext.getCurrentInstance().reset("editD:display");
	    
	  
	}
		catch(Exception e ){
			FacesContext context = FacesContext.getCurrentInstance();
		    context.addMessage(null, new FacesMessage("Demande non enregistré"));
			e.printStackTrace();}
	}

	public void deleteDemandeRemplacement() {
		System.out.println("SSSSSSSSSSSSSSSSSS");
		deletedDemandeRemp  = iDemandeRemplacementService.removeDemandeRemplacement(deletedDemandeRemp);
		listDemandeRemplacement.set(index, deletedDemandeRemp);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Remplacement supprimée"));
		
	    
	}

	 public void reset() {  
	        RequestContext.getCurrentInstance().reset("editDR:display");  
	    }  

	 public void preProcessPDF(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Demandes Remplacement "), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	 
	
	
	
}
