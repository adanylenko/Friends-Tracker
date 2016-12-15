package teamProject.dao.database;

import java.util.List;

import teamProject.entities.User;

public interface UserDao {
	User add(User user) throws Exception;

	User update(User user) throws Exception;

	User delete(User user) throws Exception;

	User getbyId(int id) throws Exception;

	List<User> getAll() throws Exception;

	User getUser(String login) throws Exception;

	User getByToken(String token)  throws Exception;
}
