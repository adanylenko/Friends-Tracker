package teamProject.dao.database;

import java.util.List;

import teamProject.entities.User;

public interface UserDao {
	void addUser(User user);
	void updateUser(User user);
	List<User> getAllUsers();
	User getUser(String login);
	void deleteUser(User user);
	
	

}
