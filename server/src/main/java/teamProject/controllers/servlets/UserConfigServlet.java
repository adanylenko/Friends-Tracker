package teamProject.controllers.servlets;

import teamProject.service.interfaces.ServiceManager;

public class UserConfigServlet {
	private ServiceManager serviceManager;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

}
