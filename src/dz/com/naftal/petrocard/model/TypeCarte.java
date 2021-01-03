package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TYPE_CARTES database table.
 * 
 */
@Entity
@Table(name="TYPE_CARTES")
@NamedQueries({
@NamedQuery(name = "TypeCarte.findAll", query = "SELECT tc FROM TypeCarte tc "),

})
public class TypeCarte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TYPE_CARTES_TYPECARTEID_GENERATOR", sequenceName="TYPECARTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPE_CARTES_TYPECARTEID_GENERATOR")
	private Integer typecarteid;

	private String intitule;

	

	//bi-directional many-to-one association to DemandeAcquisition
	
	@OneToMany(mappedBy="typeCarte", cascade=CascadeType.ALL)
	private List<DemandeAcquisition> demandeAcquisitions;

	//bi-directional many-to-many association to Document
	
	@ManyToMany(mappedBy="typeCartes")
	private List<Document> documents;

	public TypeCarte() {
	}

	

	public Integer getTypecarteid() {
		return typecarteid;
	}



	public void setTypecarteid(Integer typecarteid) {
		this.typecarteid = typecarteid;
	}


	public List<DemandeAcquisition> getDemandeAcquisitions() {
		return this.demandeAcquisitions;
	}

	public void setDemandeAcquisitions(List<DemandeAcquisition> demandeAcquisitions) {
		this.demandeAcquisitions = demandeAcquisitions;
	}

	public DemandeAcquisition addDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().add(demandeAcquisition);
		demandeAcquisition.setTypeCarte(this);

		return demandeAcquisition;
	}

	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().remove(demandeAcquisition);
		demandeAcquisition.setTypeCarte(null);

		return demandeAcquisition;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}



	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

}