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

import dz.com.naftal.petrocard.model.DemandeBlocage;

import dz.com.naftal.petrocard.service.IDemandeBlocageService;

@ManagedBean(name = "blocageBean")
@SessionScoped
public class BlocageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name="iDemandeBlocageService", value="#{iDemandeBlocageService}")
	private IDemandeBlocageService iDemandeBlocageService;
	

	
	private DemandeBlocage demandeblocage;
	private List<DemandeBlocage> listDemandeBlocage;
	private List<DemandeBlocage> listDemandeBlocageNonTraite;
	
	
	//private List<DemandeBlocage> listDemandeBlocageByClient ;
	private DemandeBlocage DemandeBlocageEnCours;
	private DemandeBlocage editedDemandeBlocage ;
	private DemandeBlocage deletedDemandeBlocage ;
	
	int index;

	public IDemandeBlocageService getiDemandeBlocageService() {
		return iDemandeBlocageService;
	}

	public void setiDemandeBlocageService(
			IDemandeBlocageService iDemandeBlocageService) {
		this.iDemandeBlocageService = iDemandeBlocageService;
	}

	public DemandeBlocage getDemandeblocage() {
		return demandeblocage;
	}

	public void setDemandeblocage(DemandeBlocage demandeblocage) {
		this.demandeblocage = demandeblocage;
	}

	public List<DemandeBlocage> getListDemandeBlocage() {
		listDemandeBlocage = iDemandeBlocageService.getAllDemandeBlocage();
		return listDemandeBlocage;
	}

	public void setListDemandeBlocage(List<DemandeBlocage> listDemandeBlocage) {
		this.listDemandeBlocage = listDemandeBlocage;
	}

	public List<DemandeBlocage> getListDemandeBlocageNonTraite() {
		listDemandeBlocageNonTraite = iDemandeBlocageService.getAllDemandeBlocageNonTraite();
		return listDemandeBlocageNonTraite;
	}

	public void setListDemandeBlocageNonTraite(
			List<DemandeBlocage> listDemandeBlocageNonTraite) {
		this.listDemandeBlocageNonTraite = listDemandeBlocageNonTraite;
	}

	public DemandeBlocage getDemandeBlocageEnCours() {
		
		return DemandeBlocageEnCours;
	}

	public void setDemandeBlocageEnCours(DemandeBlocage demandeBlocageEnCours) {
		DemandeBlocageEnCours = demandeBlocageEnCours;
	}

	public DemandeBlocage getEditedDemandeBlocage() {
		return editedDemandeBlocage;
	}

	public void setEditedDemandeBlocage(DemandeBlocage editedDemandeBlocage) {
		this.editedDemandeBlocage = editedDemandeBlocage;
	}

	public DemandeBlocage getDeletedDemandeBlocage() {
		return deletedDemandeBlocage;
	}

	public void setDeletedDemandeBlocage(DemandeBlocage deletedDemandeBlocage) {
		this.deletedDemandeBlocage = deletedDemandeBlocage;
	}

	
	public void addDemandeBlocage() {
		System.out.println("New Demande added");
		
		demandeblocage = new DemandeBlocage();
		
	}
	
	public void voirDemandeBlocage(DemandeBlocage demandeblocage) {
		System.out.println(" Demande a voir");
		index = listDemandeBlocage.indexOf(demandeblocage);
		DemandeBlocageEnCours = demandeblocage;
		

	}
	
	
	public void editDemandeBlocage(DemandeBlocage demandeblocage) {
		System.out.println(" Demande updated");
		index = listDemandeBlocage.indexOf(demandeblocage);
		editedDemandeBlocage = demandeblocage;
		

	}

	public void supprimeDemandeBlocage(DemandeBlocage demandeblocage) {
		System.out.println(" Demande deleted");
		index = listDemandeBlocage.indexOf(demandeblocage);
		deletedDemandeBlocage = demandeblocage;
		

	}
	
public void updateDemandeBlocage() {
		
		
	editedDemandeBlocage = iDemandeBlocageService.updateDemandeBlocage(editedDemandeBlocage);  
		listDemandeBlocage.set(index, editedDemandeBlocage);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Blocage mise à jour"));
	}

	public void ajoutDemandeBlocage() {
		try{
			System.out.println("FFFFFFFFFFFFFFF");
			iDemandeBlocageService.createDemandeBlocage(demandeblocage);       
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Blocage ajoutée"));
	    //RequestContext.getCurrentInstance().reset("editD:display");
	    
	  
	}
		catch(Exception e ){
			FacesContext context = FacesContext.getCurrentInstance();
		    context.addMessage(null, new FacesMessage("Demande non enregistré"));
			e.printStackTrace();}
	}

	public void deleteDemandeBlocage() {
		System.out.println("SSSSSSSSSSSSSSSSSS");
		deletedDemandeBlocage  = iDemandeBlocageService.removedemandeblocage(deletedDemandeBlocage);
		listDemandeBlocage.set(index, deletedDemandeBlocage);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Blocage supprimée"));
		
	    
	}

	 public void reset() {  
	        RequestContext.getCurrentInstance().reset("editDB:display");  
	    }  

	 public void preProcessPDF(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Demandes Blocages "), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	 
	
	
}
