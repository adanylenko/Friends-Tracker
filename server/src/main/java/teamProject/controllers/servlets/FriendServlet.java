package teamProject.controllers.servlets;

import teamProject.service.interfaces.FriendService;

public class FriendServlet {
	private FriendService friendService;

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

}
