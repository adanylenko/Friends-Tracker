package teamProject.service;

import java.sql.Timestamp;
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
	public List<User> getNearbyFriends(String token) {
		final User user = userService.getUserByToken(token);
		if (user == null)
			return null;

		final int id_user = user.getId();

		final List<Friend> friends = friendService.getAllUserFriend(id_user);
		final List<User> nearbyFriends = new ArrayList<>();
		final Point userPoint = pointService.getCntLastUserPoint(id_user, 1).get(0);
		// final UserConfig userConfig =
		// userConfigService.getUserConfig(id_user);

		if (friends == null || userPoint == null || friends.size() == 0)
			return null;

		final int alertDist = 50;

		for (int i = 0; i < friends.size(); i++) {
			final Point friendPoint = pointService.getCntLastUserPoint(friends.get(i).getId_friend(), 1).get(0);
			if (friendPoint == null)
				continue;

			final double dist = distFrom(userPoint.getLat(), userPoint.getLng(), friendPoint.getLat(),
					friendPoint.getLng());
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

	@Override
	public boolean registerNewUser(User user) {
		final User checkUser = userService.getUser(user.getLogin());
		if (checkUser != null)
			return false;

		if (userService.addUser(user)) {
			UserConfig userConfig = new UserConfig(userService.getUser(user.getLogin()).getId(), 10, 50);
			userConfigService.addUserConfig(userConfig);
			return true;
		}
		return false;
	}

	@Override
	public boolean addPoint(String token, Point point) {
		final User user = userService.getUserByToken(token);
		if (user == null)
			return false;

		point.setId_user(user.getId());
		point.setDate(new Timestamp(System.currentTimeMillis()));
		if (pointService.addPoint(point))
			return true;
		return false;
	}

	@Override
	public boolean addFriend(String token, User newfriend) {
		final User user = userService.getUserByToken(token);
		if (user == null)
			return false;

		final User userFriend = userService.getUser(newfriend.getLogin());

		if (userFriend == null)
			return false;
		final Friend friend = new Friend(user.getId(), userFriend.getId(), 1);
		if (friendService.addFriend(friend)) {
			return true;
		}

		return false;
	}

	@Override
	public List<User> getAllFriends(String token) {
		final User user = userService.getUserByToken(token);
		if (user == null)
			return null;

		final List<Friend> listFriend = friendService.getAllUserFriend(user.getId());
		final List<User> listUser = new ArrayList<>();

		for (Friend friend : listFriend) {
			listUser.add(userService.getUser(friend.getId_friend()));
		}
		return listUser;
	}

	@Override
	public boolean updateUserConfig(String token, UserConfig userConfig) {
		final User user = userService.getUserByToken(token);
		if (user == null)
			return false;

		final UserConfig userConfigOld = userConfigService.getUserConfig(user.getId());

		if (userConfig == null)
			return false;

		userConfig.setId_user(user.getId());
		userConfig.setId(userConfigOld.getId());

		return userConfigService.changeUserConfig(userConfig);
	}

	@Override
	public UserConfig getUserConfig(String token) {
		final User user = userService.getUserByToken(token);

		if (user == null)
			return null;

		return userConfigService.getUserConfig(user.getId());
	}

}