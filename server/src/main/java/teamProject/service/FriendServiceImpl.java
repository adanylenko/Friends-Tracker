package teamProject.service;

import java.util.List;

import javax.transaction.Transactional;

import teamProject.dao.database.FriendDao;
import teamProject.entities.Friend;
import teamProject.service.interfaces.FriendService;

public class FriendServiceImpl implements FriendService {
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
			friends = null;
		}
		return friends;
	}
}
