package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CARTES database table.
 * 
 */
@Entity
@Table(name="CARTES")
@NamedQueries({
@NamedQuery(name = "Carte.findAll", query = "SELECT ct FROM Carte ct "),
@NamedQuery(name = "Carte.findCartePrepaid", query = "SELECT ct FROM Carte ct WHERE ct.commande.demandeAcquisition.typeCarte.intitule = 'Prepaid' "),
@NamedQuery(name = "Carte.findExpiryCarte", query = "SELECT ct FROM Carte ct WHERE ct.date_exp <= current_date ")


})
public class Carte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARTES_CARTEID_GENERATOR", sequenceName="CARTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARTES_CARTEID_GENERATOR")
	private Integer carteid;
	
	private Integer numcarte;
	
	@Temporal(TemporalType.DATE)
	private Date date_exp;

	//bi-directional many-to-one association to BcChargRech
	@OneToMany(mappedBy="carte", cascade=CascadeType.ALL)
	private List<BcChargRech> bcChargRechs;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="COMMANDEID", nullable=false)
	private Commande commande;

	//bi-directional many-to-one association to EtatCarte
	@OneToMany(mappedBy="carte", cascade=CascadeType.ALL)
	private List<EtatCarte> etatCartes;
	
	@OneToOne(mappedBy="carte", cascade = CascadeType.ALL)
	private DemandeBlocage demandeBlocage;

	@OneToOne(mappedBy="carte", cascade = CascadeType.ALL)
	private DemandeRemplacement demandeRemplacement;
	
	@OneToOne
	@JoinColumn(name="PORTEURID")
	private Ident porteur;
	
	public Carte() {
	}

	public Integer getCarteid() {
		return this.carteid;
	}

	public void setCarteid(Integer carteid) {
		this.carteid = carteid;
	}

	public Date getDate_exp() {
		return date_exp;
	}

	public void setDate_exp(Date date_exp) {
		this.date_exp = date_exp;
	}

	

	public Integer getNumcarte() {
		return numcarte;
	}

	public void setNumcarte(Integer numcarte) {
		this.numcarte = numcarte;
	}

	public DemandeBlocage getDemandeBlocage() {
		return demandeBlocage;
	}

	public void setDemandeBlocage(DemandeBlocage demandeBlocage) {
		this.demandeBlocage = demandeBlocage;
	}

	public DemandeRemplacement getDemandeRemplacement() {
		return demandeRemplacement;
	}

	public void setDemandeRemplacement(DemandeRemplacement demandeRemplacement) {
		this.demandeRemplacement = demandeRemplacement;
	}

	public List<BcChargRech> getBcchargrechs() {
		return this.bcChargRechs;
	}

	public void setBcchargrechs(List<BcChargRech> bcChargRechs) {
		this.bcChargRechs = bcChargRechs;
	}

	public BcChargRech addBcchargrech(BcChargRech bcChargRech) {
		getBcchargrechs().add(bcChargRech);
		bcChargRech.setCarte(this);

		return bcChargRech;
	}

	public BcChargRech removeBcchargrech(BcChargRech bcChargRech) {
		getBcchargrechs().remove(bcChargRech);
		bcChargRech.setCarte(null);

		return bcChargRech;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public Ident getPorteur() {
		return porteur;
	}

	public void setPorteur(Ident porteur) {
		this.porteur = porteur;
	}

	public List<EtatCarte> getEtatCartes() {
		return this.etatCartes;
	}

	public void setEtatCartes(List<EtatCarte> etatCartes) {
		this.etatCartes = etatCartes;
	}

	public EtatCarte addEtatCarte(EtatCarte etatCarte) {
		getEtatCartes().add(etatCarte);
		etatCarte.setCarte(this);

		return etatCarte;
	}

	public EtatCarte removeEtatCarte(EtatCarte etatCarte) {
		getEtatCartes().remove(etatCarte);
		etatCarte.setCarte(null);

		return etatCarte;
	}

}