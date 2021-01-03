package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



/**
 * The persistent class for the CLIENTS database table.
 * 
 */
@Entity
@Table(name="CLIENTS")
@NamedQueries({
@NamedQuery(name = "Client.findAll", query = "SELECT cl FROM Client cl ")
})

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENTS_CLIENTID_GENERATOR", sequenceName="CLIENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTS_CLIENTID_GENERATOR")
	private Integer clientid;

	private String adresse;

	private String raisonsocial;

	private String tel;

	
	private String ville;
	
	private String email;

	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<DemandeAcquisition> demandeAcquisitions;
	
    @OneToOne(mappedBy="client", cascade=CascadeType.ALL)
	private Contrat contrat;
	
	public List<DemandeAcquisition> getDemandeAcquisitions() {
		return demandeAcquisitions;
	}


	public void setDemandeAcquisitions(List<DemandeAcquisition> demandeAcquisitions) {
		this.demandeAcquisitions = demandeAcquisitions;
	}


	public Client() {
	}


	public Integer getClientid() {
		return clientid;
	}


	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getRaisonsocial() {
		return this.raisonsocial;
	}

	public void setRaisonsocial(String raisonsocial) {
		this.raisonsocial = raisonsocial;
	}

	public Contrat getContrat() {
		return contrat;
	}


	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}


	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public DemandeAcquisition addDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().add(demandeAcquisition);
		demandeAcquisition.setClient(this);

		return demandeAcquisition;
	}

	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().remove(demandeAcquisition);
		demandeAcquisition.setClient(null);

		return demandeAcquisition;
	}

	
}