package dz.com.naftal.petrocard.web.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.model.Client;
import dz.com.naftal.petrocard.model.Commande;
import dz.com.naftal.petrocard.model.DemandeAcquisition;
import dz.com.naftal.petrocard.model.EtatCarte;
import dz.com.naftal.petrocard.model.Ident;
import dz.com.naftal.petrocard.model.TypeCarte;
import dz.com.naftal.petrocard.model.TypeEtat;
import dz.com.naftal.petrocard.service.ICarteService;
import dz.com.naftal.petrocard.service.IClientService;
import dz.com.naftal.petrocard.service.IDemandeAcquisitionService;
import dz.com.naftal.petrocard.service.IEtatCarteService;
import dz.com.naftal.petrocard.service.ITypeCarteService;
import dz.com.naftal.petrocard.service.ITypeEtatService;
import dz.com.naftal.petrocard.service.IdentService;

@ManagedBean(name = "autoCompleteBean")
@RequestScoped
public class AutoCompleteBean {
	private String txt1;

	private String txt2;

	private String txt3;

	private String txt4;

	private String txt5;

	private String txt6;

	private String txt7;

	private Client selectedClient;

	private List<Client> clients;
	
	private List<SelectItem> selectItemClients;
	@ManagedProperty(name = "iClientService", value = "#{iClientService}")
	private IClientService iClientService;
	
	private TypeCarte selectedTypeCarte;
	private List<TypeCarte> typecartes;
	private List<SelectItem> selectItemTypeCarte;
    @ManagedProperty(name = "iTypeCarteService", value = "#{iTypeCarteService}")
	private ITypeCarteService iTypeCarteService;
	private List<TypeCarte> selectedTypeCartes;
	
	private TypeEtat selectedTypeEtat;
	private List<TypeEtat> typeEtats;
	private List<SelectItem> selectItemTypeEtat;
    @ManagedProperty(name = "iTypeEtatService", value = "#{iTypeEtatService}")
	private ITypeEtatService iTypeEtatService;
	private List<TypeEtat> selectedTypeEtats;
	
	
	private DemandeAcquisition selectedDemandeAcquisition;
	private Commande commande;
	private List<DemandeAcquisition> demandeacquisitions;
	private List<SelectItem> selectItemDemandeAcquisitions;
	@ManagedProperty(name = "iDemandeAcquisitionService", value = "#{iDemandeAcquisitionService}")
	private IDemandeAcquisitionService iDemandeAcquisitionService;
	
	private Carte selectedCarte;
	private List<Carte> listcartes;
	private List<EtatCarte> listcartesActivePrepaid;
	private List<SelectItem> selectItemCarte;
	@ManagedProperty(name = "iCarteService", value = "#{iCarteService}")
	private ICarteService iCarteService;
	
	@ManagedProperty(name = "iEtatCarteService", value = "#{iEtatCarteService}")
	private IEtatCarteService iEtatCarteService;

	private Ident selectedIdent;
	private List<Ident> idents;
	private List<SelectItem> selectItemIdent;
	private List<SelectItem> selectItemIdent2;
	@ManagedProperty(name = "identService", value = "#{identService}")
	private IdentService identService;

	
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public DemandeAcquisition getSelectedDemandeAcquisition() {
		return selectedDemandeAcquisition;
	}

	public void setSelectedDemandeAcquisition(
			DemandeAcquisition selectedDemandeAcquisition) {
		this.selectedDemandeAcquisition = selectedDemandeAcquisition;
	}

	public List<DemandeAcquisition> getDemandeacquisitions() {
		
		demandeacquisitions = iDemandeAcquisitionService.getAllDemandeAcquisition();
		return demandeacquisitions;
	}

	public void setDemandeacquisitions(List<DemandeAcquisition> demandeacquisitions) {
		this.demandeacquisitions = demandeacquisitions;
	}

	public List<SelectItem> getSelectItemDemandeAcquisitions() {
		
		getDemandeacquisitions();
		
		selectItemDemandeAcquisitions = new ArrayList<SelectItem>();
			
			for (DemandeAcquisition da:demandeacquisitions){
				
				selectItemDemandeAcquisitions.add(new SelectItem(da, da.getDemandeacquisitionid().toString()));
			}
			
			System.out.println("Size:" +selectItemDemandeAcquisitions.size());

		return selectItemDemandeAcquisitions;
	}

	public void setSelectItemDemandeAcquisitions(
			List<SelectItem> selectItemDemandeAcquisitions) {
		this.selectItemDemandeAcquisitions = selectItemDemandeAcquisitions;
	}

	public IDemandeAcquisitionService getiDemandeAcquisitionService() {
		return iDemandeAcquisitionService;
	}

	public void setiDemandeAcquisitionService(
			IDemandeAcquisitionService iDemandeAcquisitionService) {
		this.iDemandeAcquisitionService = iDemandeAcquisitionService;
	}

/*----------------------------------------------------------------------------------------------------------------------------------------*/
	
	public TypeCarte getSelectedTypeCarte() {
		return selectedTypeCarte;
	}

	public void setSelectedTypeCarte(TypeCarte selectedTypeCarte) {
		this.selectedTypeCarte = selectedTypeCarte;
	}
	
public List<TypeCarte> getTypecartes() {
		
		typecartes = iTypeCarteService.getAllTypeCarte();
       return typecartes;
	}

	public void setTypecartes(List<TypeCarte> typecartes) {
		this.typecartes = typecartes;
	}

	public List<SelectItem> getSelectItemTypeCarte() {
		
		getTypecartes();
		
       selectItemTypeCarte = new ArrayList<SelectItem>();
		
		for (TypeCarte tc:typecartes){
			
			selectItemTypeCarte.add(new SelectItem(tc, tc.getIntitule()));
		}
		
		System.out.println("Size:" +selectItemTypeCarte.size());

		return selectItemTypeCarte;
	}

	public void setSelectItemTypeCarte(List<SelectItem> selectItemTypeCarte) {
		this.selectItemTypeCarte = selectItemTypeCarte;
	}

	public ITypeCarteService getiTypeCarteService() {
		return iTypeCarteService;
	}

	public void setiTypeCarteService(ITypeCarteService iTypeCarteService) {
		this.iTypeCarteService = iTypeCarteService;
	}
	
	
	public List<TypeCarte> getSelectedTypeCartes() {
		return selectedTypeCartes;
	}

	public void setSelectedTypeCartes(List<TypeCarte> selectedTypeCartes) {
		this.selectedTypeCartes = selectedTypeCartes;
	}
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------*/	

public TypeEtat getSelectedTypeEtat() {
		return selectedTypeEtat;
	}

	public void setSelectedTypeEtat(TypeEtat selectedTypeEtat) {
		this.selectedTypeEtat = selectedTypeEtat;
	}

	public List<TypeEtat> getTypeEtats() {
		typeEtats = iTypeEtatService.getAllTypeEtat();
		return typeEtats;
	}

	public void setTypeEtats(List<TypeEtat> typeEtats) {
		this.typeEtats = typeEtats;
	}

	public List<SelectItem> getSelectItemTypeEtat() {
		
		getTypeEtats();
		
       selectItemTypeEtat = new ArrayList<SelectItem>();
		
		for (TypeEtat te:typeEtats){
			
			selectItemTypeEtat.add(new SelectItem(te, te.getIntitule()));
		}
		
		System.out.println("Size:" +selectItemTypeEtat.size());
		
		
		return selectItemTypeEtat;
	}

	public void setSelectItemTypeEtat(List<SelectItem> selectItemTypeEtat) {
		this.selectItemTypeEtat = selectItemTypeEtat;
	}

	public ITypeEtatService getiTypeEtatService() {
		return iTypeEtatService;
	}

	public void setiTypeEtatService(ITypeEtatService iTypeEtatService) {
		this.iTypeEtatService = iTypeEtatService;
	}

	public List<TypeEtat> getSelectedTypeEtats() {
		return selectedTypeEtats;
	}

	public void setSelectedTypeEtats(List<TypeEtat> selectedTypeEtats) {
		this.selectedTypeEtats = selectedTypeEtats;
	}

/*--------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	
public Carte getSelectedCarte() {
		return selectedCarte;
	}

	public void setSelectedCarte(Carte selectedCarte) {
		this.selectedCarte = selectedCarte;
	}

	public List<Carte> getListcartes() {
		
		listcartes = iCarteService.getCartePrepaid();
		return listcartes;
	}
	
	

	public void setListcartes(List<Carte> listcartes) {
		this.listcartes = listcartes;
	}

	public List<EtatCarte> getListcartesActivePrepaid() {
		listcartesActivePrepaid = iEtatCarteService.getCartesActiveesPrepaid();
		return listcartesActivePrepaid;
	}

	public void setListcartesActivePrepaid(List<EtatCarte> listcartesActivePrepaid) {
		this.listcartesActivePrepaid = listcartesActivePrepaid;
	}

	public List<SelectItem> getSelectItemCarte() {
		getListcartes();
		
		selectItemCarte = new ArrayList<SelectItem>();
		
		for (Carte etca:listcartes){
			
			selectItemCarte.add(new SelectItem(etca, etca.getNumcarte().toString()));
		}
		
		System.out.println("Size:" +selectItemCarte.size());
		
		
		return selectItemCarte;
	}

	public void setSelectItemCarte(List<SelectItem> selectItemCarte) {
		this.selectItemCarte = selectItemCarte;
	}

	public ICarteService getiCarteService() {
		return iCarteService;
	}

	public void setiCarteService(ICarteService iCarteService) {
		this.iCarteService = iCarteService;
	}
	
public IEtatCarteService getiEtatCarteService() {
		return iEtatCarteService;
	}

	public void setiEtatCarteService(IEtatCarteService iEtatCarteService) {
		this.iEtatCarteService = iEtatCarteService;
	}
	
/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	


public Ident getSelectedIdent() {
		return selectedIdent;
	}

	public void setSelectedIdent(Ident selectedIdent) {
		this.selectedIdent = selectedIdent;
	}

	public List<Ident> getIdents() {
		
		idents = identService.getAllIdent();
		
		return idents;
	}

	public void setIdents(List<Ident> idents) {
		this.idents = idents;
	}

	public List<SelectItem> getSelectItemIdent() {
		
		getIdents();
		
		selectItemIdent = new ArrayList<SelectItem>();
			
			for (Ident idt:idents){
				
				selectItemIdent.add(new SelectItem(idt, idt.getNomporteur()));
				
			}
			
			System.out.println("Size:" +selectItemIdent.size());
		return selectItemIdent;
	}

	public void setSelectItemIdent(List<SelectItem> selectItemIdent) {
		this.selectItemIdent = selectItemIdent;
	}

	public List<SelectItem> getSelectItemIdent2() {
          
		getIdents();
		
		selectItemIdent2 = new ArrayList<SelectItem>();
			
			for (Ident idt:idents){
				
				selectItemIdent2.add(new SelectItem(idt, idt.getNomembosse()));
			}
			
			System.out.println("Size:" +selectItemIdent2.size());
		
		
		return selectItemIdent2;
	}

	public void setSelectItemIdent2(List<SelectItem> selectItemIdent2) {
		this.selectItemIdent2 = selectItemIdent2;
	}

	public IdentService getIdentService() {
		return identService;
	}

	public void setIdentService(IdentService identService) {
		this.identService = identService;
	}
	

	

	/*---------------------------------------------------------------------------------------------------------------------------------------------*/
	public IClientService getiClientService() {
		return iClientService;
	}

	public void setiClientService(IClientService iClientService) {
		this.iClientService = iClientService;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	private List<Client> selectedClients;

	private List<String> selectedTexts;

	

	public List<Client> getClients() {

		clients = iClientService.getAllclient();

		return clients;
	}

	
	public List<String> complete(String query) {
		List<String> results = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public List<Client> completeClient(String query) {
		List<Client> suggestions = new ArrayList<Client>();

		for (Client c : clients) {
			if (c.getRaisonsocial().startsWith(query))
				suggestions.add(c);
		}

		return suggestions;
	}
	
	public List<TypeCarte> completeTypeCarte(String query) {
		List<TypeCarte> suggestions2 = new ArrayList<TypeCarte>();

		for (TypeCarte tc : typecartes) {
			if (tc.getIntitule().startsWith(query))
				suggestions2.add(tc);
		}

		return suggestions2;
		
	}
	
	public List<TypeEtat> completeTypeEtat(String query) {
		List<TypeEtat> suggestions5 = new ArrayList<TypeEtat>();

		for (TypeEtat te : typeEtats) {
			if (te.getIntitule().startsWith(query))
				suggestions5.add(te);
		}

		return suggestions5;
		
	}
	
	public List<Ident> completeIdent(String query) {
		List<Ident> suggestions3 = new ArrayList<Ident>();

		for (Ident idt : idents) {
			if (idt.getNomporteur().startsWith(query))
				suggestions3.add(idt);
		}

		return suggestions3;
	}
	
	
	public List<Ident> completeIdent2(String query) {
		List<Ident> suggestions4 = new ArrayList<Ident>();

		for (Ident idt : idents) {
			if (idt.getNomembosse().startsWith(query))
				suggestions4.add(idt);
		}

		return suggestions4;
	}
	
	public List<EtatCarte> completeCarte(String query) {
		List<EtatCarte> suggestions6 = new ArrayList<EtatCarte>();

		for (EtatCarte etca : listcartesActivePrepaid) {
			if (etca.getCarte().getCarteid().toString().startsWith(query))
				suggestions6.add(etca);
		}

		return suggestions6;
	}
	

	public List<String> completeArea(String query) {
		List<String> results = new ArrayList<String>();

		if (query.equals("PrimeFaces")) {
			results.add("PrimeFaces Rocks!!!");
			results.add("PrimeFaces has 100+ components.");
			results.add("PrimeFaces is lightweight.");
			results.add("PrimeFaces is easy to use.");
			results.add("PrimeFaces is developed with passion!");
		} else {
			for (int i = 0; i < 10; i++) {
				results.add(query + i);
			}
		}

		return results;
	}

	public void handleSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Selected:" + event.getObject().toString(), null);

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void handleUnselect(UnselectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Unselected:" + event.getObject().toString(), null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public String getTxt3() {
		return txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	public String getTxt4() {
		return txt4;
	}

	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}

	public String getTxt5() {
		return txt5;
	}

	public void setTxt5(String txt5) {
		this.txt5 = txt5;
	}

	public String getTxt6() {
		return txt6;
	}

	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}

	public String getTxt7() {
		return txt7;
	}

	public void setTxt7(String txt7) {
		this.txt7 = txt7;
	}

	public List<String> getSelectedTexts() {
		return selectedTexts;
	}

	public void setSelectedTexts(List<String> selectedTexts) {
		this.selectedTexts = selectedTexts;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getSelectedClients() {
		return selectedClients;
	}

	public void setSelectedClients(List<Client> selectedClients) {
		this.selectedClients = selectedClients;
	}

	public List<SelectItem> getSelectItemClients() {
		getClients();
		
		selectItemClients = new ArrayList<SelectItem>();
		
		for (Client c:clients){
			
			selectItemClients.add(new SelectItem(c, c.getRaisonsocial()));
		}
		
		System.out.println("Size:" +selectItemClients.size());
		
		return selectItemClients;
	}

	public void setSelectItemClients(List<SelectItem> selectItemClients) {
		this.selectItemClients = selectItemClients;
	}

	
}
