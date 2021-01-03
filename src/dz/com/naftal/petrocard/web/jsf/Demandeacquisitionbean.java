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

import dz.com.naftal.petrocard.model.DemandeAcquisition;

import dz.com.naftal.petrocard.service.IDemandeAcquisitionService;



@ManagedBean(name = "demandeacquisitionbean")
@SessionScoped
public class Demandeacquisitionbean  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(name="iDemandeAcquisitionService", value="#{iDemandeAcquisitionService}")
	private IDemandeAcquisitionService iDemandeAcquisitionService;
	private DemandeAcquisition demandeAcquisition;
	private List<DemandeAcquisition> listdemandeAcquisition ;
	private List<DemandeAcquisition> listdemandeNonTraite ;
	private List<DemandeAcquisition> listdemByClient ;
	private DemandeAcquisition demandeEnCours;
	private DemandeAcquisition editedDemandeAcquisition ;
	private DemandeAcquisition deletedDemandeAcquisition ;
	int index;


	//private String clientSelected;
    //private List< SelectItem> selectClients;
	

	public IDemandeAcquisitionService getiDemandeAcquisitionService() {
		return iDemandeAcquisitionService;
	}

	public void setiDemandeAcquisitionService(
			IDemandeAcquisitionService iDemandeAcquisitionService) {
		this.iDemandeAcquisitionService = iDemandeAcquisitionService;
	}

	public DemandeAcquisition getDemandeAcquisition() {
		return demandeAcquisition;
	}

	public void setDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		this.demandeAcquisition = demandeAcquisition;
	}

	public List<DemandeAcquisition> getListdemandeAcquisition() {
		
		listdemandeAcquisition = iDemandeAcquisitionService.getAllDemandeAcquisition();
		
		return listdemandeAcquisition;
	}

	public void setListdemandeAcquisition(
			List<DemandeAcquisition> listdemandeAcquisition) {
		this.listdemandeAcquisition = listdemandeAcquisition;
	}

	

	public List<DemandeAcquisition> getListdemandeNonTraite() {
		
		listdemandeNonTraite = iDemandeAcquisitionService.getDemandeAcquisitionNonTraite();
		return listdemandeNonTraite;
	}

	public void setListdemandeNonTraite(List<DemandeAcquisition> listdemandeNonTraite) {
		this.listdemandeNonTraite = listdemandeNonTraite;
	}

	public DemandeAcquisition getDemandeEnCours() {
		return demandeEnCours;
	}

	public void setDemandeEnCours(DemandeAcquisition demandeEnCours) {
		this.demandeEnCours = demandeEnCours;
	}

	public DemandeAcquisition getDeletedDemandeAcquisition() {
		return deletedDemandeAcquisition;
	}

	public void setDeletedDemandeAcquisition(
			DemandeAcquisition deletedDemandeAcquisition) {
		this.deletedDemandeAcquisition = deletedDemandeAcquisition;
	}

	public DemandeAcquisition getEditedDemandeAcquisition() {
		return editedDemandeAcquisition;
	}

	public void setEditedDemandeAcquisition(DemandeAcquisition editedDemandeAcquisition) {
		this.editedDemandeAcquisition = editedDemandeAcquisition;
	}

	public List<DemandeAcquisition> getListdemByClient() {
		listdemByClient = iDemandeAcquisitionService.getDemandeAcquisitionByClient();
		
		return listdemByClient;
	}

	public void setListdemByClient(List<DemandeAcquisition> listdemByClient) {
		this.listdemByClient = listdemByClient;
	}

	public void addDemandeAcquisition() {
		System.out.println("New Demande added");
		
		demandeAcquisition = new DemandeAcquisition();
		
	}
	
	public void voirDemandeAcquisition(DemandeAcquisition demandeacquisition) {
		System.out.println(" Demande a voir");
		index = listdemandeAcquisition.indexOf(demandeacquisition);
		demandeEnCours = demandeacquisition;
		

	}
	
	
	public void editDemandeAcquisition(DemandeAcquisition demandeacquisition) {
		System.out.println(" Demande updated");
		index = listdemandeAcquisition.indexOf(demandeacquisition);
		editedDemandeAcquisition = demandeacquisition;
		

	}

	public void supprimeDemandeAcquisition(DemandeAcquisition demandeacquisition) {
		System.out.println(" Demande deleted");
		index = listdemandeAcquisition.indexOf(demandeacquisition);
		deletedDemandeAcquisition = demandeacquisition;
		

	}

	
	public void updateDemandeAcquisition() {
		
		
		editedDemandeAcquisition = iDemandeAcquisitionService.updateDemandeAcquisition(editedDemandeAcquisition);  
		listdemandeAcquisition.set(index, editedDemandeAcquisition);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Acquisition mise à jour"));
	}

	public void ajoutDemandeAcquisition() {
		try{
			System.out.println("FFFFFFFFFFFFFFF");
			iDemandeAcquisitionService.createDemandeAcquisition(demandeAcquisition);       
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Acquisition ajoutée"));
	    RequestContext.getCurrentInstance().reset("editD:display");
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}

	public void deleteDemandeAcquisition() {
		
		deletedDemandeAcquisition  = iDemandeAcquisitionService.removeDemandeAcquisition(deletedDemandeAcquisition);
		listdemandeAcquisition.set(index, deletedDemandeAcquisition);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Demande Acquisition supprimée"));
		
	    
	}

	 public void reset() {  
	        RequestContext.getCurrentInstance().reset("editD:display");  
	    }  
	
	 public void preProcessPDF(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Demandes Acquisition Carte Par Client "), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }

}
	


