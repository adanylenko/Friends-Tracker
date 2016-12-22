package teamProject.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import teamProject.dao.database.FriendDao;
import teamProject.entities.Friend;

public class FriendDaoImpl implements FriendDao {
	private SessionFactory sessionFactory = null;

	public FriendDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Friend add(Friend friend) throws Exception {
		sessionFactory.getCurrentSession().save(friend);
		return friend;
	}

	@Override
	public Friend delete(Friend friend) throws Exception {
		sessionFactory.getCurrentSession().delete(friend);
		return friend;
	}

	@Override
	public Friend update(Friend friend) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return friend;
	}

	@Override
	public List<Friend> getUserFriends(int id_user) throws Exception {
		List<Friend> friends = null;
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Friend.class);
		friends = criteria.add(Restrictions.eq("id_user", id_user)).list();
		return friends;
	}

	@Override
	public Friend getbyId(int id) throws Exception {
		Friend friend = null;
		friend = (Friend) sessionFactory.getCurrentSession().get(Friend.class, id);
		return friend;
	}

	@Override
	public List<Friend> getAll() throws Exception {
		List<Friend> friends = null;
		friends = sessionFactory.getCurrentSession().createCriteria(Friend.class).list();
		return friends;
	}

	@Override
	public Friend deleteUserFriend(int id_user, int id_friend) throws Exception {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Friend.class);
		criteria.add(Restrictions.eq("id_user", id_user));
		criteria.add(Restrictions.eq("id_friend", id_friend));

		final Friend friend = (Friend) criteria.uniqueResult();
		if (friend != null)
			delete(friend);

		return friend;
	}

}
