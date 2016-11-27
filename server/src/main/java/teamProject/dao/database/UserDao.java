package teamProject.dao.database;

import java.util.List;

import teamProject.entities.User;

public interface UserDao {
	boolean add(User user);

	boolean update(User user);

	boolean delete(User user);

	User getbyId(int id);

	List<User> getAll();

	User getUser(String login);
}
