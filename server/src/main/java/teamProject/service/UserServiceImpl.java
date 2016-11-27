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
	public void printAll() {
		System.out.println("user service class");
		for (User user : userDao.getAll()) {
			System.out.println(user.getLogin());
		}
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

}
