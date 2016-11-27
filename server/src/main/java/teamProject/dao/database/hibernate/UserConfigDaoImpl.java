package teamProject.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teamProject.dao.database.UserConfigDao;
import teamProject.entities.UserConfig;

public class UserConfigDaoImpl implements UserConfigDao {
	private SessionFactory sessionFactory = null;
	private static final Logger LOG = LoggerFactory.getLogger(UserConfigDaoImpl.class);

	public UserConfigDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(UserConfig config) {
		try {
			sessionFactory.getCurrentSession().save(config);

		} catch (Exception ex) {
			LOG.error("Error when trying to add UserConfig.\n With User id: {}\n", config.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserConfig config) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(config);

		} catch (Exception ex) {
			LOG.error("Error when trying to change UserConfig.\n With User id: {}\n", config.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(UserConfig config) {
		try {
			sessionFactory.getCurrentSession().delete(config);
		} catch (Exception ex) {
			LOG.error("Error when trying to Delete UserConfig with User id: {}.", config.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public UserConfig getUserConfig(int id_user) {
		UserConfig config = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserConfig.class);
			config = (UserConfig) criteria.add(Restrictions.eq("id_user", id_user)).uniqueResult();
		} catch (Exception ex) {
			LOG.error("Error when trying to get UserConfig with User id: {}.", id_user, ex);
		}
		return config;
	}

	@Override
	public UserConfig getbyId(int id) {
		UserConfig userConfig = null;
		try {
			userConfig = (UserConfig) sessionFactory.getCurrentSession().get(UserConfig.class, id);
		} catch (Exception e) {
			LOG.error("Error when try get userConfig with id={}", id);
		}
		return userConfig;
	}

	@Override
	public List<UserConfig> getAll() {
		List<UserConfig> usersConfig = null;
		try {
			usersConfig = sessionFactory.getCurrentSession().createCriteria(UserConfig.class).list();
		} catch (Exception ex) {
			LOG.error("Error when trying to get all UserConfig.", ex);
		}
		return usersConfig;
	}

}
