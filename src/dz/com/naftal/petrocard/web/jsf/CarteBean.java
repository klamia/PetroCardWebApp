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

import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.Commande;
import dz.com.naftal.petrocard.service.ICarteService;
@ManagedBean(name = "carteBean")
@SessionScoped
public class CarteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(name="iCarteService", value="#{iCarteService}")
	private ICarteService iCarteService;
	private Carte carte;
	private List<Carte> listcarte ;
	private List<Carte> listcarteExpire ;
	private Carte editedCarte ;
	private Carte carteEnCours;
	
	int index;

	public ICarteService getiCarteService() {
		return iCarteService;
	}

	public void setiCarteService(ICarteService iCarteService) {
		this.iCarteService = iCarteService;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public List<Carte> getListcarte() {
		
	listcarte=iCarteService.getAllCarte();	
		return listcarte;
	}

	public void setListcarte(List<Carte> listcarte) {
		this.listcarte = listcarte;
	}

	public List<Carte> getListcarteExpire() {
		listcarteExpire = iCarteService.getCarteExpire();
		return listcarteExpire;
	}

	public void setListcarteExpire(List<Carte> listcarteExpire) {
		this.listcarteExpire = listcarteExpire;
	}

	public Carte getEditedCarte() {
		return editedCarte;
	}

	public void setEditedCarte(Carte editCarte) {
		this.editedCarte = editCarte;
	}

	public Carte getCarteEnCours() {
		return carteEnCours;
	}

	public void setCarteEnCours(Carte carteEnCours) {
		this.carteEnCours = carteEnCours;
	}

	public void addCarte(Commande commande) {
		System.out.println("New Carte added");
		
		carte = new Carte();
		carte.setCommande(commande);
		
	}

	public void editCarte(Carte carte) {
		System.out.println(" Carte updated");
		index = listcarte.indexOf(carte);
		editedCarte = carte;
		

	}
	
	public void voirCarte(Carte carte) {
		System.out.println(" Carte a voir");
		index = listcarte.indexOf(carte);
		carteEnCours = carte;
		

	}

	
	public void updateCarte() {
		
		
		editedCarte = iCarteService.updateCarte(editedCarte);  
		listcarte.set(index, editedCarte);
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Carte mise à jour avec succés"));
	}

	public void ajoutCarte() {
		try{
			System.out.println("FFFFFFFFFFFFFFF");
			iCarteService.createCarte(carte);       
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Carte ajoutée avec succés"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}



	 public void reset() {  
	        RequestContext.getCurrentInstance().reset("editCART:displayCA");  
	    }  
	
	 public void preProcessPDFCarteCommande(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Cartes Confectionnées par Commande"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	 
	 public void preProcessPDFCarte(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Cartes Confectionnées"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	 
	 public void preProcessPDFCarteExpire(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Cartes Expirées"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	 }
	 
	 
}
