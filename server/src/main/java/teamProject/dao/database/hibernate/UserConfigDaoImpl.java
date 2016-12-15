package teamProject.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import teamProject.dao.database.UserConfigDao;
import teamProject.entities.UserConfig;

public class UserConfigDaoImpl implements UserConfigDao {
	private SessionFactory sessionFactory = null;

	public UserConfigDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserConfig add(UserConfig config) throws Exception {
		sessionFactory.getCurrentSession().save(config);
		return config;
	}

	@Override
	public UserConfig update(UserConfig config) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(config);
		return config;
	}

	@Override
	public UserConfig delete(UserConfig config) throws Exception {
		sessionFactory.getCurrentSession().delete(config);
		return config;
	}

	@Override
	public UserConfig getUserConfig(int id_user) throws Exception {
		UserConfig config = null;
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserConfig.class);
		config = (UserConfig) criteria.add(Restrictions.eq("id_user", id_user)).uniqueResult();

		return config;
	}

	@Override
	public UserConfig getbyId(int id) throws Exception {
		UserConfig userConfig = null;
		userConfig = (UserConfig) sessionFactory.getCurrentSession().get(UserConfig.class, id);
		return userConfig;
	}

	@Override
	public List<UserConfig> getAll() throws Exception {
		List<UserConfig> usersConfig = null;
		usersConfig = sessionFactory.getCurrentSession().createCriteria(UserConfig.class).list();
		return usersConfig;
	}

}
