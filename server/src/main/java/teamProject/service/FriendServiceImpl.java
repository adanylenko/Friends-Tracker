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
		if (friendDao.add(friend))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean changeFriend(Friend friend) {
		if (friendDao.update(friend))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean deleteFriend(Friend friend) {
		if (friendDao.delete(friend))
			return true;
		return false;
	}

	@Override
	@Transactional
	public Friend getFriend(int id_friend) {
		return friendDao.getbyId(id_friend);
	}

	@Override
	@Transactional
	public List<Friend> getAllUserFriend(int id_user) {
		return friendDao.getUserFriends(id_user);
	}

	@Override
	@Transactional
	public List<Friend> getAll() {
		return friendDao.getAll();
	}
}
