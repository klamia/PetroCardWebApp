package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the BCCHARGRECHS database table.
 * 
 */
@Entity
@Table(name="BCCHARGRECHS" )
@NamedQueries({
@NamedQuery(name = "BcChargRech.findAll", query = "SELECT bc FROM BcChargRech bc ")

})
public class BcChargRech implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BCCHARGRECHS_BCCHARGRECHID_GENERATOR", sequenceName="BCCHARGRECH_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BCCHARGRECHS_BCCHARGRECHID_GENERATOR")
	private Integer bcchargrechid;

	@Temporal(TemporalType.DATE)
	private Date datebc;

	private double montantcharrecharg;

	//bi-directional many-to-one association to Carte
	@ManyToOne
	@JoinColumn(name="CARTEID")
	private Carte carte;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENTID")
	private Client client;

	public BcChargRech() {
	}
	
	
	public Integer getBcchargrechid() {
		return this.bcchargrechid;
	}

	public void setBcchargrechid(Integer bcchargrechid) {
		this.bcchargrechid = bcchargrechid;
	}

	public Date getDatebc() {
		return this.datebc;
	}

	public void setDatebc(Date datebc) {
		this.datebc = datebc;
	}

	public double getMontantcharrecharg() {
		return this.montantcharrecharg;
	}

	public void setMontantcharrecharg(double montantcharrecharg) {
		this.montantcharrecharg = montantcharrecharg;
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

}