package dz.com.naftal.petrocard.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO rolesDAO;
	
	@Override
	public void persist(Role roles) {
		rolesDAO.persist(roles);
		
	}

	@Override
	public Role merge(Role roles) {
		
		return  rolesDAO.merge(roles);
	}

	@Override
	public Role findrolesId(Integer roleid) {
		return rolesDAO.findrolesId(roleid);
	}

	@Override
	public List<Role> findAllroles() {
		try {
			//List<Role> listRole = null;
			
		return  (List<Role>) rolesDAO.findAllroles();
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
 
	@Override
	public Role remove(Role roles) {
		return (Role) rolesDAO.remove(roles);
		
	}

	

}
