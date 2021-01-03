package dz.com.naftal.petrocard.security;

import java.util.List;




/**
 */
public interface UserDAO {
	
	

	public void persist(User users);
	
	public User merge(User users);

	public User findUserByMail(String email);
	
	public User findUsersByName(String username);
	
	public List<User> findAllUsers();


}