package dz.com.naftal.petrocard.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("usersService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO usersDAO;
	
	@Override
	public void persist(User users) {
		usersDAO.persist(users);
		
	}

	@Override
	public User merge(User users) {
		
		return usersDAO.merge(users);
	}

	
//	@Override
//	public Users find(Users users) {
//		
//		return usersDAO.find(users);
//	}
//
//	
//	
	@Override
	public User findUserByMail(String email) {
		
		return usersDAO.findUserByMail(email);
	}

	@Override
	public User findUsersByName(String user) {
		// TODO Auto-generated method stub
		return usersDAO.findUsersByName(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return usersDAO.findAllUsers();
	}

	

	

}
