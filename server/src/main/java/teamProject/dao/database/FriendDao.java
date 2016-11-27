package teamProject.dao.database;

import java.util.List;

import teamProject.entities.Friend;

public interface FriendDao {
	boolean add(Friend friend);

	boolean update(Friend friend);

	boolean delete(Friend friend);

	Friend getbyId(int id);

	List<Friend> getAll();

	List<Friend> getUserFriends(int id_user);
}
