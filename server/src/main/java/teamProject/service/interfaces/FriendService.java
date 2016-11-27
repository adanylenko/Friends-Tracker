package teamProject.service.interfaces;

import java.util.List;

import teamProject.entities.Friend;

public interface FriendService {
	boolean addFriend(Friend friend);

	boolean changeFriend(Friend friend);

	boolean deleteFriend(Friend friend);

	Friend getFriend(int id_friend);

	List<Friend> getAllUserFriend(int id_user);

	List<Friend> getAll();
}
