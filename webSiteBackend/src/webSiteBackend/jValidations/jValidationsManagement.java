package webSiteBackend.jValidations;

import java.util.List;



import webSiteBackend.entities.concretes.User;

public class jValidationsManagement {

	
	public boolean nameControl(String firstName,String lastName) {

		
		if(firstName.length() <2 && lastName.length()<2) {
			
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean passwordControl(String password) {
		if(password.length()<6) {
			
			return false;
			
		}
		
		return true;
	}
	
	
	
	
	
	public boolean existEmail(String email, List<User> entities) {
		
		boolean exist=false;
		
		for (User entity : entities) {
			
			if(entity.getEmail()==email) {
				
				exist=false;
			}
			else {
				
				exist=true;
			}
		}
		
		return exist;
		
	}
	
	
	public boolean loginControl(String email,String password,List<User> users) {
		
		boolean result=false;
		for (User user : users) {
			
			if(user.getEmail()==email && user.getPassword()==password) {
				
				result=true;
				
			}
			else {
				
				result= false;
			}
			
		}
		
		return result;
		
	}
}
