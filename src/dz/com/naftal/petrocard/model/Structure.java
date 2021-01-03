package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import dz.com.naftal.petrocard.security.User;

import java.util.List;


/**
 * The persistent class for the STRUCTURES database table.
 * 
 */
@Entity
@Table(name="STRUCTURES")
@NamedQueries({
@NamedQuery(name = "Structure.findAll", query = "SELECT str FROM Structure str ")
})
public class Structure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STRUCTURES_STRUCTUREID_GENERATOR", sequenceName="STRUCTURE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STRUCTURES_STRUCTUREID_GENERATOR")
	private Integer structureid;

	private String nomstruct;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="structure", cascade=CascadeType.ALL)
	private List<User> users;
	
	//bi-directional many-to-one association to DemandeAcquisition
		@OneToMany(mappedBy="structure", cascade=CascadeType.ALL)
		private List<DemandeAcquisition> demandeAcquisitions;
		
		@OneToMany(mappedBy="structure", cascade=CascadeType.ALL)
		private List<Vehicule> vehicules;

		@OneToMany(mappedBy="structure", cascade=CascadeType.ALL)
		private List<Employedemandeur> employedemandeurs;
		
	public Structure() {
	}

	

	public Integer getStructureid() {
		return structureid;
	}



	public void setStructureid(Integer structureid) {
		this.structureid = structureid;
	}



	public String getNomstruct() {
		return this.nomstruct;
	}

	public void setNomstruct(String nomstruct) {
		this.nomstruct = nomstruct;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setStructure(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setStructure(null);

		return user;
	}

	public List<DemandeAcquisition> getDemandeAcquisitions() {
		return demandeAcquisitions;
	}
	
	
	public void setDemandeAcquisitions(List<DemandeAcquisition> demandeAcquisitions) {
		this.demandeAcquisitions = demandeAcquisitions;
	}

	public DemandeAcquisition addDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().add(demandeAcquisition);
		demandeAcquisition.setStructure(this);

		return demandeAcquisition;
	}

	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().remove(demandeAcquisition);
		demandeAcquisition.setStructure(null);

		return demandeAcquisition;
	}
	
	
	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Vehicule addVehicule(Vehicule vehicule) {
		getVehicules().add(vehicule);
		vehicule.setStructure(this);

		return vehicule;
	}

	public Vehicule removeVehicule(Vehicule vehicule) {
		getVehicules().remove(vehicule);
		vehicule.setStructure(null);

		return vehicule;
	}

	public List<Employedemandeur> getEmployedemandeurs() {
		return employedemandeurs;
	}

	public void setEmployedemandeurs(List<Employedemandeur> employedemandeurs) {
		this.employedemandeurs = employedemandeurs;
	}
	
	public Employedemandeur addEmployedemandeur(Employedemandeur employedemandeur) {
		getEmployedemandeurs().add(employedemandeur);
		employedemandeur.setStructure(this);

		return employedemandeur;
	}

	public Employedemandeur removeEmployedemandeur(Employedemandeur employedemandeur) {
		getEmployedemandeurs().remove(employedemandeur);
		employedemandeur.setStructure(null);

		return employedemandeur;
	}
	
}