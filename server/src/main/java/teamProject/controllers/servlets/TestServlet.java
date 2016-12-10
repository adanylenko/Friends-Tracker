package teamProject.controllers.servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamProject.entities.User;
import teamProject.service.interfaces.ServiceManager;

/**
 * Created by adanu on 31.10.2016.
 */

@RestController
@RequestMapping(value = "/test")
public class TestServlet {
	private static final Logger LOG = LoggerFactory.getLogger(TestServlet.class);
	private ServiceManager serviceManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void getAllCities() {
		LOG.info("GET request to a CityEndpoint. getAllCities()");
		serviceManager.getNearbyFriends(1);
//		List<Point> points = serviceManager.getPointService().getCntLastUserPoint(1, 2);
//		for (Point point : points) {
//			System.out.println("date" + point.getDate());
//		}
		User user=new User();
		user.setLogin("alex");
		user.setPassword("230395");
		System.out.println(serviceManager.getUserService().loginUser(user));

	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

}
