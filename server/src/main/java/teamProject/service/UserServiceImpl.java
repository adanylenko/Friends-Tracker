package teamProject.service;

import java.util.List;

import javax.transaction.Transactional;

import teamProject.dao.database.UserDao;
import teamProject.entities.User;
import teamProject.service.interfaces.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		List<User> users = userDao.getAll();
		return users;
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		if (userDao.add(user))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		if (userDao.delete(user))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean changeUser(User user) {
		if (userDao.update(user))
			return true;
		return false;
	}

	@Override
	@Transactional
	public User getUser(String login) {
		return userDao.getUser(login);
	}

	@Override
	@Transactional
	public User getUser(int id_user) {
		return userDao.getbyId(id_user);
	}

	@Override
	@Transactional
	public String loginUser(User user) {
		if (user == null || user.getLogin().length() == 0 || user.getPassword().length() == 0)
			return null;
		User currentUser = userDao.getUser(user.getLogin());
		if (currentUser == null)
			return null;
		if (currentUser.getLogin().compareTo(user.getLogin()) == 0
				&& currentUser.getPassword().compareTo(user.getPassword()) == 0)
			return currentUser.getToken();
		return null;
	}

}
