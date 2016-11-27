package teamProject.controllers.servlets;

import teamProject.service.interfaces.UserService;

public class UserServlet {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
