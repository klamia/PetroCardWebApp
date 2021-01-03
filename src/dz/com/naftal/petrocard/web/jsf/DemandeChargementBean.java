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

import dz.com.naftal.petrocard.model.BcChargRech;

import dz.com.naftal.petrocard.service.IBcChargRechService;

@ManagedBean(name = "demandeChargementBean")
@SessionScoped
public class DemandeChargementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(name="iBcChargRechService", value="#{iBcChargRechService}")
	private IBcChargRechService iBcChargRechService;
	private BcChargRech bcchargrech;
	private List<BcChargRech> listBCcharg ;
	
	//private List<DemandeAcquisition> listdemandeNonTraite ;
	private List<BcChargRech> listBCchargByClient ;
	private BcChargRech bcEnCours;
	private BcChargRech editedBCcharg ;
	private BcChargRech deletedBCcharg ;
	
	int index;
	
	public IBcChargRechService getiBcChargRechService() {
		return iBcChargRechService;
	}
	public void setiBcChargRechService(IBcChargRechService iBcChargRechService) {
		this.iBcChargRechService = iBcChargRechService;
	}
	public BcChargRech getBcchargrech() {
		return bcchargrech;
	}
	public void setBcchargrech(BcChargRech bcchargrech) {
		this.bcchargrech = bcchargrech;
	}
	public List<BcChargRech> getListBCcharg() {
		
		listBCcharg = iBcChargRechService.getAllBc();
		return listBCcharg;
	}
	public void setListBCcharg(List<BcChargRech> listBCcharg) {
		this.listBCcharg = listBCcharg;
	}
	
	public List<BcChargRech> getListBCchargByClient() {
		return listBCchargByClient;
	}
	public void setListBCchargByClient(List<BcChargRech> listBCchargByClient) {
		this.listBCchargByClient = listBCchargByClient;
	}
	public BcChargRech getBcEnCours() {
		return bcEnCours;
	}
	public void setBcEnCours(BcChargRech bcEnCours) {
		this.bcEnCours = bcEnCours;
	}
	public BcChargRech getEditedBCcharg() {
		return editedBCcharg;
	}
	public void setEditedBCcharg(BcChargRech editedBCcharg) {
		this.editedBCcharg = editedBCcharg;
	}

	public BcChargRech getDeletedBCcharg() {
		return deletedBCcharg;
	}
	public void setDeletedBCcharg(BcChargRech deletedBCcharg) {
		this.deletedBCcharg = deletedBCcharg;
	}
	public void addDemandeChargement() {
		System.out.println("New Demande added");
		
		bcchargrech = new BcChargRech();
		
	}
	
	public void voirDemandeChargement(BcChargRech bcchargrech) {
		System.out.println(" Demande a voir");
		index = listBCcharg.indexOf(bcchargrech);
		bcEnCours = bcchargrech;
		

	}
	
	
	public void editDemandeChargement(BcChargRech bcchargrech) {
		System.out.println(" Demande updated");
		index = listBCcharg.indexOf(bcchargrech);
		editedBCcharg = bcchargrech;
		

	}

	public void supprimeDemandeChargement(BcChargRech bcchargrech) {
		System.out.println(" Demande deleted");
		index = listBCcharg.indexOf(bcchargrech);
		deletedBCcharg = bcchargrech;
		

	}

	
	public void updateDemandeChargement() {
		
		
		editedBCcharg = iBcChargRechService.updateBc(editedBCcharg);  
		listBCcharg.set(index, editedBCcharg);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Chargement mise à jour"));
	}

	public void ajoutDemandeChargement() {
		try{
			System.out.println("FFFFFFFFFFFFFFF");
			iBcChargRechService.createBC(bcchargrech);       
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Chargement ajoutée"));
	    //RequestContext.getCurrentInstance().reset("editD:display");
	    
	  
	}
		catch(Exception e ){
			FacesContext context = FacesContext.getCurrentInstance();
		    context.addMessage(null, new FacesMessage("Demande non enregistré"));
			e.printStackTrace();}
	}

	public void deleteDemandeChargement() {
		
		deletedBCcharg  = iBcChargRechService.removeBc(deletedBCcharg);
		listBCcharg.set(index, deletedBCcharg);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Chargement supprimée"));
		
	    
	}

	 public void reset() {  
	        RequestContext.getCurrentInstance().reset("editDC:display");  
	    }  
	
	 public void preProcessPDF(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Demandes Chargement Par Client "), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }

	
	
	
	
	
	

}
