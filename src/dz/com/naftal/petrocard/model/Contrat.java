package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the CONTRATS database table.
 * 
 */
@Entity
@Table(name="CONTRATS")
@NamedQueries({
@NamedQuery(name = "Contrat.findAll", query = "SELECT ctr FROM Contrat ctr ")
})

public class Contrat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTRATS_CONTRATID_GENERATOR", sequenceName="CONTRAT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTRATS_CONTRATID_GENERATOR")
	private String contratid;

	@Temporal(TemporalType.DATE)
	private Date datectr;

	@Temporal(TemporalType.DATE)
	private Date datenaisssoussigne;

	private String nomsoussigne;

	private String prenomsoussigne;

	private String typectr;

	@Temporal(TemporalType.DATE)
	private Date validitecontrat;

	//bi-directional many-to-one association to Client
	@OneToOne
	@JoinColumn(name="CLIENTID")
	private Client client;
	
	@OneToOne
	@JoinColumn(name="STATIONSERVICEID")
	private StationService stationService;

	public Contrat() {
	}

	public String getContratid() {
		return this.contratid;
	}

	public void setContratid(String contratid) {
		this.contratid = contratid;
	}

	public Date getDatectr() {
		return this.datectr;
	}

	public void setDatectr(Date datectr) {
		this.datectr = datectr;
	}

	public Date getDatenaisssoussigne() {
		return this.datenaisssoussigne;
	}

	public void setDatenaisssoussigne(Date datenaisssoussigne) {
		this.datenaisssoussigne = datenaisssoussigne;
	}

	public String getNomsoussigne() {
		return this.nomsoussigne;
	}

	public void setNomsoussigne(String nomsoussigne) {
		this.nomsoussigne = nomsoussigne;
	}

	public String getPrenomsoussigne() {
		return this.prenomsoussigne;
	}

	public void setPrenomsoussigne(String prenomsoussigne) {
		this.prenomsoussigne = prenomsoussigne;
	}

	public String getTypectr() {
		return this.typectr;
	}

	public void setTypectr(String typectr) {
		this.typectr = typectr;
	}

	public Date getValiditecontrat() {
		return this.validitecontrat;
	}

	public void setValiditecontrat(Date validitecontrat) {
		this.validitecontrat = validitecontrat;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public StationService getStationService() {
		return stationService;
	}

	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

}