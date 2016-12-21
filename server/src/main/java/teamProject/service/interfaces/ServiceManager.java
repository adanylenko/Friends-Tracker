package teamProject.service.interfaces;

import java.util.List;

import teamProject.entities.Point;
import teamProject.entities.User;
import teamProject.entities.UserConfig;

public interface ServiceManager {
	UserService getUserService();

	FriendService getFriendService();

	UserConfigService getUserConfigService();

	PointService getPointService();
	
	List<User> getNearbyFriends(String token);
	
	boolean registerNewUser(User user);

	boolean addPoint(String token, Point point);

	boolean addFriend(String token, User friend);

	List<User> getAllFriends(String token);

	boolean updateUserConfig(String token, UserConfig userConfig);

	UserConfig getUserConfig(String token);
}
