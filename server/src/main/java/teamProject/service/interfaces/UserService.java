package teamProject.service.interfaces;

import java.util.List;

import teamProject.entities.User;

public interface UserService {
	List<User> getAll();

	boolean addUser(User user);

	boolean deleteUser(User user);

	boolean changeUser(User user);

	User getUser(String login);

	User getUser(int id_user);

	String loginUser(User user);
}
