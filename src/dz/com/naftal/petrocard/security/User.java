package dz.com.naftal.petrocard.security;

import java.io.Serializable;
import javax.persistence.*;

import dz.com.naftal.petrocard.model.DemandeAcquisition;
import dz.com.naftal.petrocard.model.DemandeBlocage;
import dz.com.naftal.petrocard.model.DemandeRemplacement;
import dz.com.naftal.petrocard.model.Structure;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQueries({
	@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u  where trim(u.username)=:username"),
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ")

})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_USERID_GENERATOR", sequenceName="USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_USERID_GENERATOR")
	private Integer userid;

	boolean enabled;

	private String password;

	private String username;
	
	private String email;
	
	private String nom;
	
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date datenaissance;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(schema = "PETROCARD", name = "USER_ROLES", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "ROLEID"))
	private List<Role> roles;

	//bi-directional many-to-one association to DemandeAcquisition
	@OneToMany(mappedBy="user", cascade = { CascadeType.ALL })
	private List<DemandeAcquisition> demandeAcquisitions;

	//bi-directional many-to-one association to DemandeBlocage
	@OneToMany(mappedBy="user", cascade = { CascadeType.ALL })
	private List<DemandeBlocage> demandeBlocages;

	//bi-directional many-to-one association to DemandeRemplacement
	@OneToMany(mappedBy="user", cascade = { CascadeType.ALL })
	private List<DemandeRemplacement> demandeRemplacements;

	//bi-directional many-to-one association to IStructureDAO
	@ManyToOne
	@JoinColumn(name="STRUCTUREID",
            insertable=false, updatable=false,
            nullable=false)
	private Structure structure;

	public User() {
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Boolean  getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<DemandeAcquisition> getDemandeAcquisitions() {
		return this.demandeAcquisitions;
	}

	public void setDemandeAcquisitions(List<DemandeAcquisition> demandeAcquisitions) {
		this.demandeAcquisitions = demandeAcquisitions;
	}

	public DemandeAcquisition addDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().add(demandeAcquisition);
		demandeAcquisition.setUser(this);

		return demandeAcquisition;
	}

	public DemandeAcquisition removeDemandeAcquisition(DemandeAcquisition demandeAcquisition) {
		getDemandeAcquisitions().remove(demandeAcquisition);
		demandeAcquisition.setUser(null);

		return demandeAcquisition;
	}

	public List<DemandeBlocage> getDemandeBlocages() {
		return this.demandeBlocages;
	}

	public void setDemandeBlocages(List<DemandeBlocage> demandeBlocages) {
		this.demandeBlocages = demandeBlocages;
	}

	public DemandeBlocage addDemandeBlocage(DemandeBlocage demandeBlocage) {
		getDemandeBlocages().add(demandeBlocage);
		demandeBlocage.setUser(this);

		return demandeBlocage;
	}

	public DemandeBlocage removeDemandeBlocage(DemandeBlocage demandeBlocage) {
		getDemandeBlocages().remove(demandeBlocage);
		demandeBlocage.setUser(null);

		return demandeBlocage;
	}

	public List<DemandeRemplacement> getDemandeRemplacements() {
		return this.demandeRemplacements;
	}

	public void setDemandeRemplacements(List<DemandeRemplacement> demandeRemplacements) {
		this.demandeRemplacements = demandeRemplacements;
	}

	public DemandeRemplacement addDemandeRemplacement(DemandeRemplacement demandeRemplacement) {
		getDemandeRemplacements().add(demandeRemplacement);
		demandeRemplacement.setUser(this);

		return demandeRemplacement;
	}

	public DemandeRemplacement removeDemandeRemplacement(DemandeRemplacement demandeRemplacement) {
		getDemandeRemplacements().remove(demandeRemplacement);
		demandeRemplacement.setUser(null);

		return demandeRemplacement;
	}

	public Structure getStructure() {
		return this.structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	public void setRole(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 */
	public List<Role> getRole() {
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		return roles;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String password, Boolean enabled,
			List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}



	
	/**
	 * Copies the contents of the specified bean into this bean.
	 * 
	 */
	public void copy(User that) {
		setUserid(that.getUserid());
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setEnabled(that.getEnabled());
		setRole(new ArrayList<Role>(that.getRole()));
	}

	/**
	 * Returns a textual representation of a bean.
	 * 
	 */
	@Override
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(userid).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("enabled=[").append(enabled).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	/**
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof User))
			return false;
		User equalCheck = (User) obj;
		if ((userid == null && equalCheck.userid != null)
				|| (userid != null && equalCheck.userid == null))
			return false;
		if (userid != null && !userid.equals(equalCheck.userid))
			return false;
		return true;
	}
}