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

import teamProject.entities.Point;
import teamProject.service.interfaces.ServiceManager;

@RestController
@RequestMapping(value = "/point")
public class PointServlet {
	private static final Logger LOG = LoggerFactory.getLogger(PointServlet.class);
	private ServiceManager serviceManager;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@RequestMapping(value = "/{token}", method = RequestMethod.PUT)
	private ResponseEntity<String> addPoint(@PathVariable final String token, @RequestBody final Point point) {
		LOG.debug("Add point for user with token:{}", token);
		if (serviceManager.addPoint(token, point)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
