package teamProject.controllers.servlets;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	private final Logger LOG=LoggerFactory.getLogger(UserServlet.class);

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<User> getAllUser() {
		LOG.info("get all users request");
		return serviceManager.getUserService().getAll();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	private String registerUser(@RequestBody final User user) {
		LOG.info("Request register new user");
		return serviceManager.registerNewUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private User loginUser(@RequestBody final User user) {
		final String token=serviceManager.getUserService().loginUser(user);
		if(token==null)LOG.info("UNdefined user!");
		else LOG.info("User with name:{} get token:{}",user.getLogin(),token);
		return user;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	private ResponseEntity<String> updateUser(@RequestBody final User user) {
		if (serviceManager.getUserService().changeUser(user)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteUser(@RequestBody final User user) {
		if (serviceManager.getUserService().deleteUser(user)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
