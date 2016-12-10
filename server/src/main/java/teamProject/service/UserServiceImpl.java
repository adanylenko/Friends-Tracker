package teamProject.service;

import java.math.BigInteger;
import java.security.SecureRandom;
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
		List<User> users = null;
		try {
			users = userDao.getAll();
		} catch (Exception ex) {
			users = null;
		}
		return users;
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		try {
			userDao.add(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		try {
			userDao.delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean changeUser(User user) {
		try {
			userDao.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public User getUser(String login) {
		User user = null;
		try {
			user = userDao.getUser(login);
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	@Transactional
	public User getUser(int id_user) {
		User user = null;
		try {
			user = userDao.getbyId(id_user);
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	@Transactional
	public String loginUser(User user) {
		if (user == null || user.getLogin() == null || user.getLogin().length() == 0 || user.getPassword() == null
				|| user.getPassword().length() == 0)
			return null;
		final User currentUser = getUser(user.getLogin());
		if (currentUser == null)
			return null;
		if (currentUser.getLogin().compareTo(user.getLogin()) == 0
				&& currentUser.getPassword().compareTo(user.getPassword()) == 0) {
			final SecureRandom random = new SecureRandom();
			final String userToken = new BigInteger(130, random).toString(32);
			currentUser.setToken(userToken);
			changeUser(currentUser);
			return currentUser.getToken();
		}
		return null;
	}

	@Override
	public boolean checkUser(User user) {

		return false;
	}

}
