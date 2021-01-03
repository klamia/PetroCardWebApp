package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import dz.com.naftal.petrocard.security.User;

import java.util.Date;


/**
 * The persistent class for the DEMANDE_BLOCAGES database table.
 * 
 */
@Entity
@Table(name="DEMANDE_BLOCAGES")
@NamedQueries({
@NamedQuery(name = "DemandeBlocage.findAll", query = "SELECT db FROM DemandeBlocage db "),
@NamedQuery(name = "DemandeBlocage.findDemandeBloqueNonTraite", query = "SELECT db FROM DemandeBlocage db WHERE db.traite = 'Non' ")
})

public class DemandeBlocage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMANDE_BLOCAGES_DEMANDEBLOCAGEID_GENERATOR", sequenceName="DEMANDEBLOCAGE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMANDE_BLOCAGES_DEMANDEBLOCAGEID_GENERATOR")
	private Integer demandeblocageid;

	@Temporal(TemporalType.DATE)
	private Date datedemb;

	private String motifbloc;

	private String typeblocage;

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

	public DemandeBlocage() {
	}

	public Integer getDemandeblocageid() {
		return this.demandeblocageid;
	}

	public void setDemandeblocageid(Integer demandeblocageid) {
		this.demandeblocageid = demandeblocageid;
	}

	public Date getDatedemb() {
		return this.datedemb;
	}

	public void setDatedemb(Date datedemb) {
		this.datedemb = datedemb;
	}

	public String getMotifbloc() {
		return this.motifbloc;
	}

	public void setMotifbloc(String motifbloc) {
		this.motifbloc = motifbloc;
	}

	public String getTypeblocage() {
		return this.typeblocage;
	}

	public void setTypeblocage(String typeblocage) {
		this.typeblocage = typeblocage;
	}

	public String getTraite() {
		return traite;
	}

	public void setTraite(String traite) {
		this.traite = traite;
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

}