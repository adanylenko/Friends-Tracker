package teamProject.controllers.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamProject.entities.UserConfig;
import teamProject.service.interfaces.ServiceManager;

@RestController
@RequestMapping(value = "/userConfig")
public class UserConfigServlet {
	private static final Logger LOG = LoggerFactory.getLogger(UserConfigServlet.class);
	private ServiceManager serviceManager;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@RequestMapping(value = "/{token}", method = RequestMethod.POST)
	private ResponseEntity<String> updateUserConfig(@PathVariable final String token,
			@RequestBody UserConfig userConfig) {
		LOG.debug("Update user config request for user with token:{}", token);
		if (serviceManager.updateUserConfig(token, userConfig)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
