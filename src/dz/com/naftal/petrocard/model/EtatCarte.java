package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;


/**
 * The persistent class for the ETAT_CARTES database table.
 * 
 */
@Entity
@Table(name="ETAT_CARTES")
@NamedQueries({
@NamedQuery(name = "EtatCarte.findAll", query = "SELECT ec FROM EtatCarte ec "),
@NamedQuery(name = "EtatCarte.findCartesConfectionne", query = "SELECT econf FROM EtatCarte econf WHERE  econf.typeEtat.intitule = 'Confectionne' "),
@NamedQuery(name = "EtatCarte.findCartesActivees", query = "SELECT ecv FROM EtatCarte ecv WHERE  ecv.typeEtat.intitule = 'Active' "),
@NamedQuery(name = "EtatCarte.findCartesPrepaidActives", query = "SELECT ecvp FROM EtatCarte ecvp WHERE  ecvp.typeEtat.intitule = 'Active' AND ecvp.carte.commande.demandeAcquisition.typeCarte.intitule = 'Prepaid' "),
@NamedQuery(name = "EtatCarte.findCartesNonExpirees", query = "SELECT ece FROM EtatCarte ece  WHERE  ece.typeEtat.intitule = 'Active' AND ece.carte.date_exp > current_date "),
@NamedQuery(name = "EtatCarte.findCartesExpirees", query = "SELECT ece FROM EtatCarte ece  WHERE  ece.typeEtat.intitule = 'Active' AND ece.carte.date_exp <= current_date "),
@NamedQuery(name = "EtatCarte.findCartesABloques", query = "SELECT cab FROM DemandeBlocage cab "),
@NamedQuery(name = "EtatCarte.findCartesBloques", query = "SELECT ecb FROM EtatCarte ecb WHERE  ecb.typeEtat.intitule = 'Bloque' "),
@NamedQuery(name = "EtatCarte.findCartesRemplace", query = "SELECT ecr FROM EtatCarte ecr where  ecr.typeEtat.intitule = 'Remplace' ")
})
public class EtatCarte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ETAT_CARTES_ETATCARTEID_GENERATOR", sequenceName="ETATCARTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ETAT_CARTES_ETATCARTEID_GENERATOR")
	private Integer etatcarteid;

	@Temporal(TemporalType.DATE)
	private Date datetat;

	//bi-directional many-to-one association to Carte
	@ManyToOne
	@JoinColumn(name="CARTEID")
	private Carte carte;

	//bi-directional many-to-one association to TypeEtat
	@ManyToOne
	@JoinColumn(name="TYPEETATID")
	private TypeEtat typeEtat;

	public EtatCarte() {
	}

	

	public Integer getEtatcarteid() {
		return this.etatcarteid;
	}

	public void setEtatcarteid(Integer etatcarteid) {
		this.etatcarteid = etatcarteid;
	}

	public Date getDatetat() {
		return this.datetat;
	}

	public void setDatetat(Date dateetat) {
		this.datetat = dateetat;
	}

	public Carte getCarte() {
		return this.carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public TypeEtat getTypeEtat() {
		return this.typeEtat;
	}

	public void setTypeEtat(TypeEtat typeEtat) {
		this.typeEtat = typeEtat;
	}

}