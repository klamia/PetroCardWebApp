package dz.com.naftal.petrocard.web.jsf;

import java.io.Serializable;
import java.util.List;





import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dz.com.naftal.petrocard.security.Role;
import dz.com.naftal.petrocard.security.RoleService;

@ManagedBean(name= "roleBean")
@SessionScoped
public class RoleBean implements Serializable {

private static final long serialVersionUID = 1L;


@ManagedProperty(name="roleService", value="#{roleService}")
private RoleService roleService;
private Role roles;
private List<Role> listRole ;
private Role editRole ;
private Role deletedRole ;
int index;


public RoleService getRoleService() {
	return roleService;
}



public void setRoleService(RoleService roleService) {
	this.roleService = roleService;
}



public Role getRoles() {
	return roles;
}



public void setRoles(Role roles) {
	this.roles = roles;
}



public List<Role> getListRole() {
	
		listRole = roleService.findAllroles();
	
	return listRole;
}


public void setListRole(List<Role> listRole) {
	this.listRole = listRole;
}



public Role getEditRole() {
	return editRole;
}



public void setEditRole(Role editRole) {
	this.editRole = editRole;
}



public Role getDeletedRole() {
	return deletedRole;
}



public void setDeletedRole(Role deletedRole) {
	this.deletedRole = deletedRole;
}


public void addRole() {
	System.out.println("New Roles add");
	roles = new Role();

}

public void editRole(Role role) {
	System.out.println(" Roles updated");
	index = listRole.indexOf(role);
	editRole = role;
	

}

public void supprimeRole(Role role) {
	System.out.println(" Roles deleted");
	index = listRole.indexOf(role);
	deletedRole = role;
	

}


public void updateRole() {
	
	
	editRole = roleService.merge(editRole) ;  
	listRole.set(index, editRole);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Role mise � jour"));
}

public void ajoutRole() {
	try{
		System.out.println("FFFFFFFFFFFFFFF");
    roleService.persist(roles);       
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Role ajout�"));
  
}catch(Exception e ){e.printStackTrace();}
}

public void deleteRole() {
	
	deletedRole  = roleService.remove(deletedRole);
	listRole.set(index, deletedRole);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Role supprim�"));
	
    
}


}

