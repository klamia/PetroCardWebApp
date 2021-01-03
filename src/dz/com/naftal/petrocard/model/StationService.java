package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the STATION_SERVICES database table.
 * 
 */
@Entity
@Table(name="STATION_SERVICES")
@NamedQueries({
@NamedQuery(name = "StationService.findAll", query = "SELECT sv FROM StationService sv ")
})
public class StationService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATION_SERVICES_STATIONSERVICEID_GENERATOR", sequenceName="STATIONSERVICE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATION_SERVICES_STATIONSERVICEID_GENERATOR")
	private String stationserviceid;

	private String typest;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="stationService", cascade=CascadeType.ALL)
	private Contrat contrat;
	
	//bi-directional many-to-one association to DemandeAcquisition
		@OneToMany(mappedBy="stationService", cascade=CascadeType.ALL)
		private List<DemandeAcquisition> demandeAcquisitions;

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	

	public StationService() {
	}

	public String getStationserviceid() {
		return this.stationserviceid;
	}

	public void setStationserviceid(String stationserviceid) {
		this.stationserviceid = stationserviceid;
	}

	public String getTypest() {
		return this.typest;
	}

	public void setTypest(String typest) {
		this.typest = typest;
	}

	public List<DemandeAcquisition> getDemandeAcquisitions() {
		return this.demandeAcquisitions;
	}

	public void setDemandeAcquisitions(List<DemandeAcquisition> demandeAcquisitions) {
		this.demandeAcquisitions = demandeAcquisitions;
	}

	public DemandeAcquisition addDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().add(demandeAcquisition);
		demandeAcquisition.setStationService(this);

		return demandeAcquisition;
	}

	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().remove(demandeAcquisition);
		demandeAcquisition.setStationService(null);

		return demandeAcquisition;
	}

}