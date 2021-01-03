package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the VEHICULES database table.
 * 
 */
@Entity
@Table(name="VEHICULES")
@NamedQueries({
@NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v ")
})
public class Vehicule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VEHICULES_VEHICULEID_GENERATOR", sequenceName="VEHICULE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VEHICULES_VEHICULEID_GENERATOR")
	private String vehiculeid;

	private String matricule;

	private String typev;
	
	@ManyToOne
	@JoinColumn(name="STRUCTUREID",
            insertable=false, updatable=false,
            nullable=false)
	private Structure structure;

	

	public Vehicule() {
	}

	public String getVehiculeid() {
		return this.vehiculeid;
	}

	public void setVehiculeid(String vehiculeid) {
		this.vehiculeid = vehiculeid;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getTypev() {
		return this.typev;
	}

	public void setTypev(String typev) {
		this.typev = typev;
	}

	

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

}