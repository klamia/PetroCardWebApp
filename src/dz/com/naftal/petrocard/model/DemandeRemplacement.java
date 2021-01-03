package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import dz.com.naftal.petrocard.security.User;

import java.util.Date;


/**
 * The persistent class for the DEMANDE_REMPLACEMENTS database table.
 * 
 */
@Entity
@Table(name="DEMANDE_REMPLACEMENTS")
@NamedQueries({
@NamedQuery(name = "DemandeRemplacement.findAll", query = "SELECT dr FROM DemandeRemplacement dr "),
@NamedQuery(name = "DemandeRemplacement.findDemandeRemplacementNonTraite", query = "SELECT dr FROM DemandeRemplacement dr WHERE dr.traite = 'Non' ")
})
public class DemandeRemplacement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMANDE_REMPLACEMENTS_DEMANDEREMPLACEMENTID_GENERATOR", sequenceName="DEMANDEREMPLACEMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMANDE_REMPLACEMENTS_DEMANDEREMPLACEMENTID_GENERATOR")
	private Integer demanderemplacementid;

	@Temporal(TemporalType.DATE)
	private Date datedemr;

	private String motifremp;

	//bi-directional many-to-one association to Carte
	@OneToOne
	@JoinColumn(name="CARTEID")
	private Carte carte;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENTID")
	private Client client;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;
	
	private String traite;

	public DemandeRemplacement() {
	}

	public Integer getDemanderemplacementid() {
		return this.demanderemplacementid;
	}

	public void setDemanderemplacementid(Integer demanderemplacementid) {
		this.demanderemplacementid = demanderemplacementid;
	}

	public Date getDatedemr() {
		return this.datedemr;
	}

	public void setDatedemr(Date datedemr) {
		this.datedemr = datedemr;
	}

	public String getMotifremp() {
		return this.motifremp;
	}

	public void setMotifremp(String motifremp) {
		this.motifremp = motifremp;
	}

	public Carte getCarte() {
		return this.carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTraite() {
		return traite;
	}

	public void setTraite(String traite) {
		this.traite = traite;
	}

}