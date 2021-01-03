package dz.com.naftal.petrocard.security;

import java.io.Serializable;
import javax.persistence.*;





import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="ROLES")
@NamedQueries({
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r ")
})
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Basic(fetch = FetchType.EAGER)
	@Id
@SequenceGenerator(name="ROLES_ROLEID_GENERATOR", sequenceName="SEQ_ROLES_ROLEID")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_ROLEID_GENERATOR")
	private Integer roleid;

	@Basic(fetch = FetchType.EAGER)
	private String rolename;

	
	@ManyToMany(mappedBy ="roles", cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<User> users;
	
	public Role(){
		
	}
	
	

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 */
	

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Role that) {
		setRoleid(that.getRoleid());
		setRolename(that.getRolename());
		setUsers(new ArrayList<User>(that.getUsers()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	@Override
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("roleid=[").append(roleid).append("] ");
		buffer.append("rolename=[").append(rolename).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
		return result;
	}

	/**
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Role))
			return false;
		Role equalCheck = (Role) obj;
		if ((roleid == null && equalCheck.roleid != null) || (roleid != null && equalCheck.roleid == null))
			return false;
		if (roleid != null && !roleid.equals(equalCheck.roleid))
			return false;
		return true;
	}
	

}