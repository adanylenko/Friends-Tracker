package teamProject.controllers.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamProject.entities.User;
import teamProject.service.interfaces.ServiceManager;

@RestController
@RequestMapping(value = "/user")
public class UserServlet {
	private ServiceManager serviceManager;
	private final Logger LOG = LoggerFactory.getLogger(UserServlet.class);

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	private ResponseEntity<String> registerUser(@RequestBody final User user) {
		LOG.debug("Request register new user with login:{}", user.getLogin());
		if (serviceManager.registerNewUser(user)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String loginUser(@RequestBody final User user) {
		LOG.debug("USER login with name:" + user.getLogin());
		return serviceManager.getUserService().loginUser(user);
	}
}
