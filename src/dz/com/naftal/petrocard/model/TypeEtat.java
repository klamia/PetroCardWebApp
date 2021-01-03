package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TYPE_ETAT database table.
 * 
 */
@Entity
@Table(name="TYPE_ETAT")
@NamedQueries({
@NamedQuery(name = "TypeEtat.findAll", query = "SELECT te FROM TypeEtat te ")
})
public class TypeEtat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TYPE_ETAT_TYPEETATID_GENERATOR", sequenceName="TYPEETAT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPE_ETAT_TYPEETATID_GENERATOR")
	private Integer typeetatid;

	private String intitule;

	//bi-directional many-to-one association to EtatCarte
	@OneToMany(mappedBy="typeEtat", cascade=CascadeType.ALL)
	private List<EtatCarte> etatCartes;

	public TypeEtat() {
	}

	public Integer getTypeetatid() {
		return this.typeetatid;
	}

	public void setTypeetatid(Integer typeetatid) {
		this.typeetatid = typeetatid;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<EtatCarte> getEtatCartes() {
		return this.etatCartes;
	}

	public void setEtatCartes(List<EtatCarte> etatCartes) {
		this.etatCartes = etatCartes;
	}

	public EtatCarte addEtatCarte(EtatCarte etatCarte) {
		getEtatCartes().add(etatCarte);
		etatCarte.setTypeEtat(this);

		return etatCarte;
	}

	public EtatCarte removeEtatCarte(EtatCarte etatCarte) {
		getEtatCartes().remove(etatCarte);
		etatCarte.setTypeEtat(null);

		return etatCarte;
	}

}