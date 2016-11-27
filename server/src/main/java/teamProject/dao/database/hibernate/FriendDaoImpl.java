package teamProject.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teamProject.dao.database.FriendDao;
import teamProject.entities.Friend;

public class FriendDaoImpl implements FriendDao {
	private SessionFactory sessionFactory = null;
	private static final Logger LOG = LoggerFactory.getLogger(FriendDaoImpl.class);

	public FriendDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);

		} catch (Exception ex) {
			LOG.error("Error when trying to add Friend.\n With User id: {}\n", friend.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Friend friend) {
		try {
			sessionFactory.getCurrentSession().delete(friend);
		} catch (Exception ex) {
			LOG.error("Error when trying to Delete Friend with User id: {}.", friend.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Friend friend) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);

		} catch (Exception ex) {
			LOG.error("Error when trying to change Friend.\n With User id: {}\n", friend.getId_user(), ex);
			return false;
		}
		return true;
	}

	@Override
	public List<Friend> getUserFriends(int id_user) {
		List<Friend> friends = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Friend.class);
			friends = criteria.add(Restrictions.eq("id_user", id_user)).list();
		} catch (Exception ex) {
			LOG.error("Error when trying to get all Friend for user with id: {}.", id_user, ex);
		}
		return friends;
	}

	@Override
	public Friend getbyId(int id) {
		Friend friend = null;
		try {
			friend = (Friend) sessionFactory.getCurrentSession().get(Friend.class, id);
		} catch (Exception e) {
			LOG.error("Error when try get Friend with id={}", id);
		}
		return friend;
	}

	@Override
	public List<Friend> getAll() {
		List<Friend> friends = null;
		try {
			friends = sessionFactory.getCurrentSession().createCriteria(Friend.class).list();
		} catch (Exception ex) {
			LOG.error("Error when trying to get all Friend.", ex);
		}
		return friends;
	}

}
