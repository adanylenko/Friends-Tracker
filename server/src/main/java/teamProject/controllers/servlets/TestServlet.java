package teamProject.controllers.servlets;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamProject.entities.Point;
import teamProject.service.TestService;
import teamProject.service.UserServiceImpl;
import teamProject.service.interfaces.PointService;
import teamProject.service.interfaces.UserService;

/**
 * Created by adanu on 31.10.2016.
 */

@RestController
@RequestMapping(value = "/rest")
public class TestServlet {
    private static final Logger LOG = LoggerFactory.getLogger(TestServlet.class);
    private UserService userService;
    private PointService pointService;
    
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

    

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getAllCities() {
        LOG.info("GET request to a CityEndpoint. getAllCities()");
       // dao.printAllUser();
        userService.printAll();
        
        List<Point> points=pointService.getCntLastUserPoint(1, 2);
        for(Point point:points){
        	System.out.println("date"+point.getDate());
        }

    }

	public void setPointService(PointService pointService) {
		this.pointService = pointService;
	}


}
