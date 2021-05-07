package webSiteBackend.business.concretes;

import java.util.List;

import webSiteBackend.business.abstracts.ValidationService;
import webSiteBackend.entities.concretes.User;
import webSiteBackend.jValidations.jValidationsManagement;

public class ValidationManager implements ValidationService{

	private jValidationsManagement jValidationsManagement;

	public ValidationManager(jValidationsManagement jValidationsManagement) {
		
		this.jValidationsManagement = jValidationsManagement;
	} 
	
	@Override
	public boolean nameControl(String firstName,String lastName) {
		
		 return jValidationsManagement.nameControl(firstName, lastName);
	}
	
	@Override
	public boolean passwordControl(String password) {
		
		return jValidationsManagement.passwordControl(password);
	}
	
	
	@Override
	public boolean loginControl(String email, String password, List<User> users) {
		return jValidationsManagement.loginControl(email, password, users);
	}

	
}
