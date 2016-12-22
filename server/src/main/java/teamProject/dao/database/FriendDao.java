package teamProject.dao.database;

import java.util.List;

import teamProject.entities.Friend;

public interface FriendDao {
	Friend add(Friend friend) throws Exception;

	Friend update(Friend friend) throws Exception;

	Friend delete(Friend friend) throws Exception;

	Friend getbyId(int id) throws Exception;

	List<Friend> getAll() throws Exception;

	List<Friend> getUserFriends(int id_user) throws Exception;
	
	Friend deleteUserFriend(int id_user,int id_friend)throws Exception;
}
