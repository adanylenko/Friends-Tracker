package teamProject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import teamProject.dao.database.UserDao;
import teamProject.entities.User;

public class TestService {
	private UserDao user;

	public void setUser(UserDao user){
		this.user=user;
	}
	
	@Transactional
	public void printAllUser(){
		List<User> users=user.getAllUsers();
		for (User user : users) {
			System.out.println(user.getLogin());
		}
	}
}
