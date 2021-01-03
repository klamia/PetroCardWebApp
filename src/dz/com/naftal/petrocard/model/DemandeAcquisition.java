package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import dz.com.naftal.petrocard.security.User;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DEMANDE_ACQUISITIONS database table.
 * 
 */
@Entity
@Table(name="DEMANDE_ACQUISITIONS")
@NamedQueries({
@NamedQuery(name = "DemandeAcquisition.findAll", query = "SELECT da FROM DemandeAcquisition da "),
@NamedQuery(name = "DemandeAcquisition.findNonTraite", query = "SELECT da FROM DemandeAcquisition da WHERE da.traite='Non' "),
@NamedQuery(name = "DemandeAcquisition.findDemandeByClient", query = "SELECT da FROM DemandeAcquisition da WHERE da.client.raisonsocial = :raisonsocial")

})

public class DemandeAcquisition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMANDE_ACQUISITIONS_DEMANDEACQUISITIONID_GENERATOR", sequenceName="DEMANDEACQUISITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMANDE_ACQUISITIONS_DEMANDEACQUISITIONID_GENERATOR")
	private Integer demandeacquisitionid;

	private String agencebea;

	@Temporal(TemporalType.DATE)
	private Date datedemac;

	private String numbc;

	private String nomdem;
	private String prenomdem;
	private String traite;
 
	
	public String getNomdem() {
		return nomdem;
	}
	
	
	
	@OneToMany(mappedBy="demandeacquisition", cascade=CascadeType.ALL)
	private List<Ident> idents;

	//bi-directional one-to-one association to Commande
	@OneToOne(mappedBy="demandeAcquisition")
	private Commande commande;
	
	//bi-directional many-to-one association to Client
		@ManyToOne
		@JoinColumn(name="CLIENTID",
	            updatable=false)
		private Client client;

		//bi-directional many-to-one association to StationService
		@ManyToOne
		@JoinColumn(name="STATIONSERVICEID",
	             updatable=false)
		private StationService stationService;
		
		//bi-directional many-to-one association to StationService
		@ManyToOne
			@JoinColumn(name="STRUCTUREID",
		            updatable=false)
			private Structure structure;

		//bi-directional many-to-one association to TypeCarte
		@ManyToOne
		@JoinColumn(name="TYPECARTEID",
	            updatable=false)
	           
		private TypeCarte typeCarte;

		//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="USERID",
	           updatable=false)
	           
		private User user;
	
	public void setNomdem(String nomdem) {
		this.nomdem = nomdem;
	}

	public String getPrenomdem() {
		return prenomdem;
	}

	public void setPrenomdem(String prenomdem) {
		this.prenomdem = prenomdem;
	}

	

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	

	public DemandeAcquisition() {
	}

	public Integer getDemandeacquisitionid() {
		return this.demandeacquisitionid;
	}

	public void setDemandeacquisitionid(Integer demandeacquisitionid) {
		this.demandeacquisitionid = demandeacquisitionid;
	}

	public String getAgencebea() {
		return this.agencebea;
	}

	public void setAgencebea(String agencebea) {
		this.agencebea = agencebea;
	}

	

	public Date getDatedemac() {
		return this.datedemac;
	}

	public void setDatedemac(Date datedemac) {
		this.datedemac = datedemac;
	}

	public String getNumbc() {
		return this.numbc;
	}

	public void setNumbc(String numbc) {
		this.numbc = numbc;
	}

	
	
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public StationService getStationService() {
		return this.stationService;
	}

	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

	public TypeCarte getTypeCarte() {
		return this.typeCarte;
	}

	public void setTypeCarte(TypeCarte typeCarte) {
		this.typeCarte = typeCarte;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Ident> getIdents() {
		return this.idents ;
	}

	public void setIdents(List<Ident> idents) {
		this.idents = idents;
	}

	public Ident addIdent(Ident ident) {
		getIdents().add(ident);
		ident.setDemandeacquisition(this);

		return ident;
	}

	public Ident removeIdent(Ident ident) {
		getIdents().remove(ident);
		ident.setDemandeacquisition(null);

		return ident;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public String getTraite() {
		return traite;
	}

	public void setTraite(String traite) {
		this.traite = traite;
	}




    
}