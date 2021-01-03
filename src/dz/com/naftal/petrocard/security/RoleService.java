package dz.com.naftal.petrocard.security;

import java.util.List;




/**
 */
public interface RoleService {
	
    public void persist(Role roles);
	
	public Role merge(Role roles);

	public Role findrolesId(Integer roleid);
	
	public List<Role> findAllroles () ;
	public Role remove(Role roles);


}