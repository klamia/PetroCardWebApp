package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMMANDES database table.
 * 
 */
@Entity
@Table(name="COMMANDES")
@NamedQueries({
@NamedQuery(name = "Commande.findAll", query = "SELECT cmd FROM Commande cmd "),
@NamedQuery(name = "Commande.findCommandeValidees", query = "SELECT cmd FROM Commande cmd WHERE cmd.etat = 'Valide'  "),
@NamedQuery(name = "Commande.findCommandeNonEnvoyees", query = "SELECT cmd FROM Commande cmd WHERE cmd.etat = 'Valide' and cmd.envoi ='Non' "),
@NamedQuery(name = "Commande.findCommandeEnvoyees", query = "SELECT cmd FROM Commande cmd WHERE cmd.etat = 'Valide' and cmd.envoi ='Oui' "),
@NamedQuery(name = "Commande.findCommandeRejetees", query = "SELECT cmd FROM Commande cmd WHERE cmd.etat ='Rejete' "),
@NamedQuery(name = "Commande.findCommandeEncours", query = "SELECT cmd FROM Commande cmd WHERE cmd.etat ='En cours' "),
@NamedQuery(name = "Commande.findCommandeByClient", query = "SELECT cmd FROM Commande cmd WHERE cmd.demandeAcquisition.client.raisonsocial = :raisonsocial"),
})

public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMANDES_COMMANDEID_GENERATOR", sequenceName="COMMANDE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMANDES_COMMANDEID_GENERATOR")
	private Integer commandeid;

	@Temporal(TemporalType.DATE)
	private Date datecmd;

	private String etat;
	
	private String motif_rejet;
	
	private String envoi;
	
	@Temporal(TemporalType.DATE)
	private Date datenvoi;

	//bi-directional many-to-one association to Carte
	@OneToMany(mappedBy="commande", cascade=CascadeType.ALL)
	private List<Carte> cartes;

	//bi-directional one-to-one association to DemandeAcquisition
	@OneToOne
	@JoinColumn(name="DEMANDEACQUISITIONID")
	private DemandeAcquisition demandeAcquisition;

	public Commande() {
	}

	

	public Integer getCommandeid() {
		return commandeid;
	}



	public void setCommandeid(Integer commandeid) {
		this.commandeid = commandeid;
	}



	public Date getDatecmd() {
		return this.datecmd;
	}

	public void setDatecmd(Date datecmd) {
		this.datecmd = datecmd;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Carte> getCartes() {
		return this.cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public Carte addCarte(Carte carte) {
		getCartes().add(carte);
		carte.setCommande(this);

		return carte;
	}

	public Carte removeCarte(Carte carte) {
		getCartes().remove(carte);
		carte.setCommande(null);

		return carte;
	}

	public DemandeAcquisition getDemandeAcquisition() {
		return this.demandeAcquisition;
	}

	public void setDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		this.demandeAcquisition = demandeAcquisition;
	}



	public String getMotif_rejet() {
		return motif_rejet;
	}



	public void setMotif_rejet(String motif_rejet) {
		this.motif_rejet = motif_rejet;
	}



	public String getEnvoi() {
		return envoi;
	}



	public void setEnvoi(String envoi) {
		this.envoi = envoi;
	}



	public Date getDatenvoi() {
		return datenvoi;
	}



	public void setDatenvoi(Date datenvoi) {
		this.datenvoi = datenvoi;
	}



	
}