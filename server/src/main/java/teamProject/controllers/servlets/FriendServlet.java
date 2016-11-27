package teamProject.controllers.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamProject.service.interfaces.ServiceManager;

@RestController
@RequestMapping(value="/friend")
public class FriendServlet {
	private static final Logger LOG=LoggerFactory.getLogger(FriendServlet.class);
	private ServiceManager serviceManager;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

}
