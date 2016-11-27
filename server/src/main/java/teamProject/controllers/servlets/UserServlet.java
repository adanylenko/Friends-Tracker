package teamProject.controllers.servlets;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teamProject.entities.User;
import teamProject.service.interfaces.ServiceManager;

@RestController
@RequestMapping(value="/user")
public class UserServlet {
	private static final Logger LOG=LoggerFactory.getLogger(UserServlet.class);
	private ServiceManager serviceManager;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private String getAllUser(@PathVariable final int id){
		return "hello="+id;
		//LOG.info("get all user request");
		//return serviceManager.getUserService().getAll().get(0).getPassword();
	}
}
