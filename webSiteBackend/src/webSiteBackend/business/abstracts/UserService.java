package webSiteBackend.business.abstracts;

import java.util.List;

import webSiteBackend.entities.concretes.User;

public interface UserService {

	
	void register(User user,List<User> users);
	void login (String email,String password,List<User> users);
	
	void getAll(List<User> users);
}
