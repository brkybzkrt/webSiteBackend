package webSiteBackend.business.abstracts;

import java.util.List;

import webSiteBackend.entities.concretes.User;

public interface ValidationService {

	
    boolean nameControl(String firstName,String lastName);
	boolean passwordControl(String password); 
	boolean loginControl(String email,String password,List<User> users);
	
}
