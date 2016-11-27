package teamProject.service;

import java.util.ArrayList;
import java.util.List;

import teamProject.entities.Friend;
import teamProject.entities.Point;
import teamProject.entities.User;
import teamProject.entities.UserConfig;
import teamProject.service.interfaces.FriendService;
import teamProject.service.interfaces.PointService;
import teamProject.service.interfaces.ServiceManager;
import teamProject.service.interfaces.UserConfigService;
import teamProject.service.interfaces.UserService;

public class ServiceManagerImpl implements ServiceManager {
	private UserService userService;
	private FriendService friendService;
	private PointService pointService;
	private UserConfigService userConfigService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public void setPointService(PointService pointService) {
		this.pointService = pointService;
	}

	public void setUserConfigService(UserConfigService userConfigService) {
		this.userConfigService = userConfigService;
	}

	@Override
	public UserService getUserService() {
		return userService;
	}

	@Override
	public FriendService getFriendService() {
		return friendService;
	}

	@Override
	public UserConfigService getUserConfigService() {
		return userConfigService;
	}

	@Override
	public PointService getPointService() {
		return pointService;
	}

	@Override
	public List<User> getNearbyFriends(int id_user) {
		List<Friend> friends = friendService.getAllUserFriend(id_user);
		List<User> nearbyFriends = new ArrayList<>();
		Point userPoint = pointService.getCntLastUserPoint(id_user, 1).get(0);
		UserConfig userConfig = userConfigService.getUserConfig(id_user);

		if (friends == null || userPoint == null || friends.size() == 0 || userConfig == null)
			return null;

		int alertDist = userConfig.getAlertZone();

		for (int i = 0; i < friends.size(); i++) {
			Point friendPoint = pointService.getCntLastUserPoint(friends.get(i).getId_friend(), 1).get(0);
			if (friendPoint == null)
				continue;

			double dist = distFrom(userPoint.getLat(), userPoint.getLng(), friendPoint.getLat(), friendPoint.getLng());
			if (dist <= alertDist)
				nearbyFriends.add(userService.getUser(friends.get(i).getId()));
		}

		return nearbyFriends;
	}

	private double distFrom(double lat1, double lng1, double lat2, double lng2) {
		double earthRadius = 6371000;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;

		return dist;
	}

}
