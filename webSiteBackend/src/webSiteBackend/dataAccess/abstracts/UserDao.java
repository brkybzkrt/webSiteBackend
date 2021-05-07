package webSiteBackend.dataAccess.abstracts;

import java.util.List;

import webSiteBackend.entities.concretes.User;

public interface UserDao {

	
	void register(User user,List<User> users);
	void login (User user,List<User> users);
	
	void getAll(List<User> users);
}
