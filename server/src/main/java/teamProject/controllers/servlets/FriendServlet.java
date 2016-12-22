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

import teamProject.entities.NearbyFriendsResponseEntity;
import teamProject.entities.User;
import teamProject.service.interfaces.ServiceManager;

@RestController
@RequestMapping(value="/friend")
public class FriendServlet {
	private static final Logger LOG=LoggerFactory.getLogger(FriendServlet.class);
	private ServiceManager serviceManager;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@RequestMapping(value = "/{token}", method = RequestMethod.PUT)
	private ResponseEntity<String> addFriend(@PathVariable final String token, @RequestBody final User friend) {
		LOG.debug("Add friend for user with token:{}", token);
		if (serviceManager.addFriend(token, friend)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{token}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteFriend(@PathVariable final String token, @RequestBody final User user) {
		LOG.debug("Add friend for user with token:{}", token);
		if (serviceManager.deleteFriend(token, user.getLogin())) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{token}", method = RequestMethod.GET)
	private List<User> getAllFriends(@PathVariable final String token) {
		LOG.debug("Get all friend for user with token:{}", token);
		return serviceManager.getAllFriends(token); 

	}
	
	@RequestMapping(value = "/nearby/{token}", method = RequestMethod.GET)
	private List<NearbyFriendsResponseEntity> getNearbyFriends(@PathVariable final String token) {
		LOG.debug("Get nearby friend for user with token:{}", token);
		return serviceManager.getNearbyFriends(token); 

	}
}
