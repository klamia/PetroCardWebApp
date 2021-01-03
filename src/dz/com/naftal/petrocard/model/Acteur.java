package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The persistent class for the acteur database table.
 * 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "audit-apps/dz/com/naftal/audit/business/model/bo", name = "Acteur")
@XmlRootElement(namespace = "audit-apps/dz/com/naftal/audit/business/model/bo") 
@NamedQueries({
		@NamedQuery(name = "Acteur.findAll", query = "SELECT a FROM Acteur a"),
		//@NamedQuery(name = "Acteur.findAllSeDeplace", query = "SELECT count (a) FROM Acteur a  where a.deplacement = '1' "),
		//@NamedQuery(name = "Acteur.findAllListSeDeplace", query = "SELECT a FROM Acteur a  where a.deplacement = '1'"),
		@NamedQuery(name = "Acteur.findByActeurId", query = "SELECT a FROM Acteur a WHERE a.acteurId = :acteurId"),
		@NamedQuery(name = "Acteur.findByAdresse", query = "SELECT a FROM Acteur a WHERE a.adresse = :adresse"),
		@NamedQuery(name = "Acteur.findByNom", query = "SELECT a FROM Acteur a WHERE a.nom = :nom"),
		@NamedQuery(name = "Acteur.findByPrenom", query = "SELECT a FROM Acteur a WHERE a.prenom = :prenom"),
		@NamedQuery(name = "Acteur.findByQualite", query = "SELECT a FROM Acteur a WHERE a.qualite = :qualite"),
		@NamedQuery(name = "Acteur.findByStructure", query = "SELECT a FROM Acteur a WHERE a.structure = :structure"),
		@NamedQuery(name = "Acteur.findByTel", query = "SELECT a FROM Acteur a WHERE a.tel = :tel"),
		@NamedQuery(name = "findActeurByActeurId", query = "select myActeur from Acteur myActeur where myActeur.acteurId = :acteurId"),
		@NamedQuery(name = "findActeurByAdresse", query = "select myActeur from Acteur myActeur where myActeur.adresse = :adresse"),
		@NamedQuery(name = "findActeurByAdresseContaining", query = "select myActeur from Acteur myActeur where myActeur.adresse like :adresse"),
		@NamedQuery(name = "findActeurByNom", query = "select myActeur from Acteur myActeur where myActeur.nom = :nom"),
		@NamedQuery(name = "findActeurByNomContaining", query = "select myActeur from Acteur myActeur where myActeur.nom like :nom"),
		@NamedQuery(name = "findActeurByPrenom", query = "select myActeur from Acteur myActeur where myActeur.prenom = :prenom"),
		@NamedQuery(name = "findActeurByPrenomContaining", query = "select myActeur from Acteur myActeur where myActeur.prenom like :prenom"),
		@NamedQuery(name = "findActeurByPrimaryKey", query = "select myActeur from Acteur myActeur where myActeur.acteurId = :acteurId"),
		@NamedQuery(name = "findActeurByQualite", query = "select myActeur from Acteur myActeur where myActeur.qualite = :qualite"),
		@NamedQuery(name = "findActeurByQualiteContaining", query = "select myActeur from Acteur myActeur where myActeur.qualite like :qualite"),
		@NamedQuery(name = "findActeurByStructure", query = "select myActeur from Acteur myActeur where myActeur.structure = :structure"),
		@NamedQuery(name = "findActeurByStructureContaining", query = "select myActeur from Acteur myActeur where myActeur.structure like :structure"),
		@NamedQuery(name = "findActeurByTel", query = "select myActeur from Acteur myActeur where myActeur.tel = :tel"),
		@NamedQuery(name = "findActeurByTelContaining", query = "select myActeur from Acteur myActeur where myActeur.tel like :tel"),
		@NamedQuery(name = "findAllActeurs", query = "select myActeur from Acteur myActeur") }) 

public class Acteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "ACTEUR_ACTEURID_GENERATOR", sequenceName = "ACTEUR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTEUR_ACTEURID_GENERATOR")
	@Column(name = "acteur_id")
	private Integer acteurId;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "fonction")
	private String fonction;

	@Column(name = "qualite")
	private String qualite;

	@Column(name = "structure")
	private String structure;

	@Column(name = "tel")
	private String tel;

	@Column(name = "email")
	private String email;

	@Column(name = "type_acteur")
	private String typeActeur;

	@Column(name = "deplacement")
	private boolean deplacement = true;

	public Acteur() {
	}

	public Integer getActeurId() {
		return this.acteurId;
	}

	public void setActeurId(Integer acteurId) {
		this.acteurId = acteurId;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getQualite() {
		return this.qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}

	public String getStructure() {
		return this.structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeActeur() {
		return typeActeur;
	}

	public void setTypeActeur(String typeActeur) {
		this.typeActeur = typeActeur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Acteur [acteurId=" + acteurId + ", adresse=" + adresse
				+ ", nom=" + nom + ", prenom=" + prenom + ", qualite="
				+ qualite + ", structure=" + structure + ", tel=" + tel + "]";
	}

	public boolean isDeplacement() {
		return deplacement;
	}

	public void setDeplacement(boolean deplacement) {
		this.deplacement = deplacement;
	}

}