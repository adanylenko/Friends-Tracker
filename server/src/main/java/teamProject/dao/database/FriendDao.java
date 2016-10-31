package teamProject.dao.database;

import java.util.List;

import teamProject.entities.Friend;

public interface FriendDao {
	void addFriend(Friend friend);
	void deleteFriend(Friend friend);
	void updateFriend(Friend friend);
	List<Friend> getUserFriends(int id_user);
}
