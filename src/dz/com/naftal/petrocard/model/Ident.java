package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IDENTS database table.
 * 
 */
@Entity
@Table(name="IDENTS")
@NamedQueries({
@NamedQuery(name = "Ident.findAll", query = "SELECT idt FROM Ident idt "),
@NamedQuery(name = "Ident.findbycdevalidees", query = "SELECT idt FROM Ident idt where idt.demandeacquisition.commande.etat= 'Valide' and idt.demandeacquisition.commande.envoi= 'Non' "),
@NamedQuery(name = "Ident.findIdentByCdeID", query = "SELECT idt FROM Ident idt WHERE idt.demandeacquisition.commande.commandeid = :commandeid")
})
public class Ident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IDENTS_PORTEURID_GENERATOR", sequenceName="PORTEUR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDENTS_PORTEURID_GENERATOR")
	private Integer porteurid;
	
	private String nomporteur;

	private String nomembosse;

	
	//bi-directional many-to-one association to Client
		@ManyToOne
		@JoinColumn(name="DEMANDEACQUISITIONID", nullable=false)
		private DemandeAcquisition demandeacquisition; 
		
		@OneToOne(mappedBy="porteur", cascade = CascadeType.ALL)
		private Carte carte;
		
		
	public Integer getPorteurid() {
		return porteurid;
	}



	public void setPorteurid(Integer porteurid) {
		this.porteurid = porteurid;
	}



	public String getNomporteur() {
		return nomporteur;
	}



	public void setNomporteur(String nomporteur) {
		this.nomporteur = nomporteur;
	}



	public String getNomembosse() {
		return nomembosse;
	}



	public void setNomembosse(String nomembosse) {
		this.nomembosse = nomembosse;
	}

	

	public Carte getCarte() {
		return carte;
	}



	public void setCarte(Carte carte) {
		this.carte = carte;
	}



	public Ident() {
	}



	public DemandeAcquisition getDemandeacquisition() {
		
		return demandeacquisition;
	}



	public void setDemandeacquisition(DemandeAcquisition demandeacquisition) {
		this.demandeacquisition = demandeacquisition;
	}

	

	
}