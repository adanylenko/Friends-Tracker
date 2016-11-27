package teamProject.controllers.servlets;

import teamProject.service.interfaces.UserConfigService;

public class UserConfigServlet {
	private UserConfigService userConfigService;

	public void setUserConfigService(UserConfigService userConfigService) {
		this.userConfigService = userConfigService;
	}
	
}
