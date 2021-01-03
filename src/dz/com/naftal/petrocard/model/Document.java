package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DOCUMENTS database table.
 * 
 */
@Entity
@Table(name="DOCUMENTS")
@NamedQueries({
@NamedQuery(name = "Document.findAll", query = "SELECT dct FROM Document dct ")
})
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTS_DOCUMENTID_GENERATOR", sequenceName="DOCUMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTS_DOCUMENTID_GENERATOR")
	private String documentid;

	private String intitule;

	//bi-directional many-to-many association to TypeCarte
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="TYPECARTES_DOCUMENTS"
		, joinColumns={
			@JoinColumn(name="DOCUMENTID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="TYPECARTEID")
			}
		)
private List<TypeCarte> typeCartes;

	public Document() {
	}

	public String getDocumentid() {
		return this.documentid;
	}

	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<TypeCarte> getTypeCartes() {
		return this.typeCartes;
	}

	public void setTypeCartes(List<TypeCarte> typeCartes) {
		this.typeCartes = typeCartes;
	}

}