package dz.com.naftal.petrocard.web.jsf;

import java.io.Serializable;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;

import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.DemandeBlocage;
import dz.com.naftal.petrocard.model.DemandeRemplacement;



import dz.com.naftal.petrocard.model.EtatCarte;
import dz.com.naftal.petrocard.service.IDemandeBlocageService;
import dz.com.naftal.petrocard.service.IDemandeRemplacementService;
import dz.com.naftal.petrocard.service.IEtatCarteService;

@ManagedBean(name = "etatCarteBean")
@SessionScoped
public class EtatCarteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name="iEtatCarteService", value="#{iEtatCarteService}")
	private IEtatCarteService iEtatCarteService;
	
	@ManagedProperty(name="iDemandeBlocageService", value="#{iDemandeBlocageService}")
	private IDemandeBlocageService iDemandeBlocageService;
	
	@ManagedProperty(name="iDemandeRemplacementService", value="#{iDemandeRemplacementService}")
	private IDemandeRemplacementService iDemandeRemplacementService;
	
	private Carte carte;
	
	private List<EtatCarte> listetatcarte ;
	private List<EtatCarte> listetatCarteConfectionne ;
	private List<EtatCarte> listetatCarteActive ;
	private List<EtatCarte> listetatCarteNonExpire ;
	private List<EtatCarte> listetatCarteExpire ;
	private List<EtatCarte> listetatCarteABloque ;
	private List<EtatCarte> listetatCarteBloque ;
	private List<EtatCarte> listetatCarteRemplace ;
	
	
	private EtatCarte etatcarte;
	private EtatCarte etatcarte2;
	private EtatCarte etatcarteB;
	private EtatCarte etatcarteR;
	
	private EtatCarte editedEtatCarte ;
	
	int index;

	public IEtatCarteService getiEtatCarteService() {
		return iEtatCarteService;
	}

	public void setiEtatCarteService(IEtatCarteService iEtatCarteService) {
		this.iEtatCarteService = iEtatCarteService;
	}

	

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public List<EtatCarte> getListetatcarte() {
		
		listetatcarte= iEtatCarteService.getAllEtatCarte();
		return listetatcarte;
	}

	public void setListetatcarte(List<EtatCarte> listetatcarte) {
		this.listetatcarte = listetatcarte;
	}

	public List<EtatCarte> getListetatCarteConfectionne() {
		
		listetatCarteConfectionne = iEtatCarteService.getCartesConfectionne();
		return listetatCarteConfectionne;
	}

	public void setListetatCarteConfectionne(
			List<EtatCarte> listetatCarteConfectionne) {
		this.listetatCarteConfectionne = listetatCarteConfectionne;
	}

	

	public List<EtatCarte> getListetatCarteActive() {
		
		listetatCarteActive = iEtatCarteService.getCartesActivees();
		return listetatCarteActive;
	}

	public void setListetatCarteActive(List<EtatCarte> listetatCarteActive) {
		this.listetatCarteActive = listetatCarteActive;
	}

	public List<EtatCarte> getListetatCarteNonExpire() {
		
		listetatCarteNonExpire = iEtatCarteService.getCartesNonExpirees();
		return listetatCarteNonExpire;
	}

	public void setListetatCarteNonExpire(List<EtatCarte> listetatCarteNonExpire) {
		this.listetatCarteNonExpire = listetatCarteNonExpire;
	}

	public List<EtatCarte> getListetatCarteExpire() {
		listetatCarteExpire = iEtatCarteService.getCartesExpirees();
		return listetatCarteExpire;
	}

	public void setListetatCarteExpire(List<EtatCarte> listetatCarteExpire) {
		this.listetatCarteExpire = listetatCarteExpire;
	}

	public List<EtatCarte> getListetatCarteABloque() {
		
		listetatCarteABloque = iEtatCarteService.getCartesABloques();
		return listetatCarteABloque;
	}

	public void setListetatCarteABloque(List<EtatCarte> listetatCarteABloque) {
		this.listetatCarteABloque = listetatCarteABloque;
	}

	public List<EtatCarte> getListetatCarteBloque() {
		listetatCarteBloque = iEtatCarteService.getCartesBloques();
		return listetatCarteBloque;
	}

	public void setListetatCarteBloque(List<EtatCarte> listetatCarteBloque) {
		this.listetatCarteBloque = listetatCarteBloque;
	}

	public List<EtatCarte> getListetatCarteRemplace() {
		listetatCarteRemplace = iEtatCarteService.getCartesRemplace();
		return listetatCarteRemplace;
	}

	public void setListetatCarteRemplace(List<EtatCarte> listetatCarteRemplace) {
		this.listetatCarteRemplace = listetatCarteRemplace;
	}

	public EtatCarte getEtatcarte() {
		return etatcarte;
	}

	public void setEtatcarte(EtatCarte etatcarte) {
		this.etatcarte = etatcarte;
	}

	
	public IDemandeBlocageService getiDemandeBlocageService() {
		return iDemandeBlocageService;
	}

	public void setiDemandeBlocageService(
			IDemandeBlocageService iDemandeBlocageService) {
		this.iDemandeBlocageService = iDemandeBlocageService;
	}	
	
	
	public IDemandeRemplacementService getiDemandeRemplacementService() {
		return iDemandeRemplacementService;
	}

	public void setiDemandeRemplacementService(
			IDemandeRemplacementService iDemandeRemplacementService) {
		this.iDemandeRemplacementService = iDemandeRemplacementService;
	}

	public EtatCarte getEditedEtatCarte() {
		return editedEtatCarte;
	}

	public void setEditedEtatCarte(EtatCarte editedEtatCarte) {
		this.editedEtatCarte = editedEtatCarte;
	}

	public EtatCarte getEtatcarte2() {
		return etatcarte2;
	}

	public void setEtatcarte2(EtatCarte etatcarte2) {
		this.etatcarte2 = etatcarte2;
	}

	public EtatCarte getEtatcarteB() {
		return etatcarteB;
	}

	public void setEtatcarteB(EtatCarte etatcarteB) {
		this.etatcarteB = etatcarteB;
	}
	
	

	public EtatCarte getEtatcarteR() {
		return etatcarteR;
	}

	public void setEtatcarteR(EtatCarte etatcarteR) {
		this.etatcarteR = etatcarteR;
	}

	public void addEtatCarte(Carte  carte) {
		System.out.println("New Etat added");
		
		etatcarte = new EtatCarte();
		etatcarte.setCarte(carte);
		}
	

	
	
	
	public void editEtatCarte(EtatCarte etatcarte) {
		System.out.println(" EtatCarte updated");
		index = listetatCarteConfectionne.indexOf(etatcarte);
		editedEtatCarte = etatcarte;
		

	}
	
	public void addEtatCarteInitial(EtatCarte etatcarte) {
		System.out.println("New Etat added");
		
		etatcarte2 = new EtatCarte();
		etatcarte2.setCarte(etatcarte.getCarte());
		etatcarte2.setTypeEtat(etatcarte.getTypeEtat());
		
	}

	public void addEtatCarteBloque(DemandeBlocage demandeblocage) {
		System.out.println("New Etat added");
		
		etatcarteB = new EtatCarte();
		etatcarteB.setCarte(demandeblocage.getCarte());
	
		
		
	}

	public void addEtatCarteRemplace(DemandeRemplacement demanderemplacement) {
		System.out.println("New Etat added");
		
		etatcarteR = new EtatCarte();
		etatcarteR.setCarte(demanderemplacement.getCarte());
	
		
		
	}
	
	public void ajoutEtatCarte() {
		try{
			
			System.out.println("FFFFFFFFFFFFFFF");
			iEtatCarteService.createEtatCarte(etatcarte2);			
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Carte MAJ  avec succés"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}
	
	public void ajoutEtatCarteB() {
		try{
			
			
			String traite="Oui";
			System.out.println("FFFFFFFFFFFFFFF");
			iEtatCarteService.createEtatCarte(etatcarteB);	
			DemandeBlocage demandeblocage = etatcarteB.getCarte().getDemandeBlocage();
			demandeblocage.setTraite(traite);			
			iDemandeBlocageService.updateDemandeBlocage(demandeblocage); 
			
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Carte MAJ  avec succés"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}
	
	public void ajoutEtatCarteR() {
		try{
			
			
			String traite="Oui";
			System.out.println("FFFFFFFFFFFFFFF");
			iEtatCarteService.createEtatCarte(etatcarteR);	
			DemandeRemplacement demanderemplacement = etatcarteR.getCarte().getDemandeRemplacement();
			demanderemplacement.setTraite(traite);			
			iDemandeRemplacementService.updateDemandeRemplacement(demanderemplacement); 
			
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Carte MAJ  avec succés"));
	    
	  
	}catch(Exception e ){e.printStackTrace();}
	}
	
	
	
	public void preProcessPDFCarteActive(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Cartes Activées"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	
	}
	
	public void preProcessPDFCarteBloque(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Cartes Bloquées"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	
	}
	
	public void preProcessPDFCarteRemplace(Object document){
		 Document pdf= (Document) document;  
		 HeaderFooter header = new HeaderFooter(new Phrase("Liste des Cartes Remplacées"), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("Page: "), true);
	        pdf.setHeader(header);
		 pdf.addCreationDate();
		 pdf.setFooter(footer);
	
	}
}
