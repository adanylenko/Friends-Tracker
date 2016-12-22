package teamProject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import teamProject.dao.database.FriendDao;
import teamProject.entities.Friend;
import teamProject.service.interfaces.FriendService;

public class FriendServiceImpl implements FriendService {
	private final static Logger LOG = LoggerFactory.getLogger(FriendServiceImpl.class);

	private FriendDao friendDao;

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@Override
	@Transactional
	public boolean addFriend(Friend friend) {
		try {
			friendDao.add(friend);
			return true;
		} catch (Exception ex) {
			LOG.error("Error when try to add friend for user:{}", friend.getId_user(), ex);
			return false;
		}

	}

	@Override
	@Transactional
	public boolean changeFriend(Friend friend) {
		try {
			friendDao.update(friend);
			return true;
		} catch (Exception ex) {
			LOG.error("Error when try to change friend for user:{}", friend.getId_user(), ex);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteFriend(Friend friend) {
		try {
			friendDao.delete(friend);
			return true;
		} catch (Exception ex) {
			LOG.error("Error when try to delete friend for user:{}", friend.getId_user(), ex);
			return false;
		}
	}

	@Override
	@Transactional
	public Friend getFriend(int id_friend) {
		Friend friend = null;
		try {
			friend = friendDao.getbyId(id_friend);
		} catch (Exception ex) {
			LOG.error("Error when try to get friend with id:{}", id_friend, ex);
			friend = null;
		}
		return friend;
	}

	@Override
	@Transactional
	public List<Friend> getAllUserFriend(int id_user) {
		List<Friend> friends = null;
		try {
			friends = friendDao.getUserFriends(id_user);
		} catch (Exception ex) {
			LOG.error("Error when try to get all friends for user:{}", id_user, ex);
			friends = null;
		}
		return friends;
	}

	@Override
	@Transactional
	public List<Friend> getAll() {
		List<Friend> friends = null;
		try {
			friends = friendDao.getAll();
		} catch (Exception ex) {
			LOG.error("Error when try to all friends", ex);
			friends = null;
		}
		return friends;
	}

	@Override
	@Transactional
	public boolean deleteUserFriend(int id_user, int id_friend) {
		try {
			friendDao.deleteUserFriend(id_user, id_friend);
			return true;
		} catch (Exception ex) {
			LOG.error("Error when try to delete friend for user with id:{}", id_user, ex);
			return false;
		}
	}
}
