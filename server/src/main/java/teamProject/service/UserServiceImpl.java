package teamProject.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import teamProject.dao.database.UserDao;
import teamProject.entities.User;
import teamProject.service.interfaces.UserService;

public class UserServiceImpl implements UserService {
	private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

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
			LOG.error("Error when try to get all users.", ex);
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
		} catch (Exception ex) {
			LOG.error("Erro when try to add user with id:{}", user.getId(), ex);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		try {
			userDao.delete(user);
			return true;
		} catch (Exception ex) {
			LOG.error("Erro when try to delete user with id:{}", user.getId(), ex);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean changeUser(User user) {
		try {
			userDao.update(user);
			return true;
		} catch (Exception ex) {
			LOG.error("Erro when try to change user with id:{}", user.getId(), ex);
			return false;
		}
	}

	@Override
	@Transactional
	public User getUser(String login) {
		User user = null;
		try {
			user = userDao.getUser(login);
		} catch (Exception ex) {
			LOG.error("Erro when try to get user with login:{}", login, ex);
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
		} catch (Exception ex) {
			LOG.error("Erro when try to get user with id:{}", id_user, ex);
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
	@Transactional
	public User getUserByToken(String token) {
		if (token == null || token.length() == 0)
			return null;
		User user = null;
		try {
			user = userDao.getByToken(token);
		} catch (Exception ex) {
			LOG.error("Erro when try to get user with token:{}", token, ex);
			user = null;
		}
		return user;
	}

}
