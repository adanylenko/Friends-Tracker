package teamProject.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import teamProject.dao.database.UserDao;
import teamProject.entities.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory = null;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User add(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;

	}

	@Override
	public User update(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> users = null;
		users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return users;
	}

	@Override
	public User getUser(String login) {
		User user = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();

		return user;
	}

	@Override
	public User delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return user;

	}

	@Override
	public User getbyId(int id) {
		User user = null;
		user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

}
