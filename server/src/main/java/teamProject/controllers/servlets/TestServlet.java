package teamProject.controllers.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamProject.service.TestService;

/**
 * Created by adanu on 31.10.2016.
 */

@RestController
@RequestMapping(value = "/rest")
public class TestServlet {
    private static final Logger LOG = LoggerFactory.getLogger(TestServlet.class);
    private TestService dao;
    
    public void setDao(TestService dao){
    	this.dao=dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getAllCities() {
        LOG.info("GET request to a CityEndpoint. getAllCities()");
        dao.printAllUser();

    }

}
