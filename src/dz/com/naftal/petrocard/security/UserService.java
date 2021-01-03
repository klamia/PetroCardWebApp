package dz.com.naftal.petrocard.security;

import java.util.List;



/**
 */
public interface UserService {

	public void persist(User users);

	public User merge(User users);

	// public Users find(Users users);

	public User findUserByMail(String email);

	public User findUsersByName(String user);

	public List<User> findAllUsers();

}