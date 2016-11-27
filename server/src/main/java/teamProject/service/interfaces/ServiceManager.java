package teamProject.service.interfaces;

import java.util.List;

import teamProject.entities.User;

public interface ServiceManager {
	UserService getUserService();

	FriendService getFriendService();

	UserConfigService getUserConfigService();

	PointService getPointService();
	
	List<User> getNearbyFriends(int id_user);
}
