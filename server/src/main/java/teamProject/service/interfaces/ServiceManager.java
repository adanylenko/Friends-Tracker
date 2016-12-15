package teamProject.service.interfaces;

import java.util.List;

import teamProject.entities.Point;
import teamProject.entities.User;

public interface ServiceManager {
	UserService getUserService();

	FriendService getFriendService();

	UserConfigService getUserConfigService();

	PointService getPointService();
	
	List<User> getNearbyFriends(int id_user);
	
	boolean registerNewUser(User user);

	boolean addPoint(String token, Point point);

	boolean addFriend(String token, User friend);

	List<User> getAllFriends(String token);

	List<User> getNearbyFriends(String token);
}
