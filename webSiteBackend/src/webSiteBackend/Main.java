package webSiteBackend;


import java.util.ArrayList;

import webSiteBackend.business.concretes.EmailManager;
import webSiteBackend.business.concretes.UserManager;
import webSiteBackend.business.concretes.ValidationManager;
import webSiteBackend.dataAccess.concretes.HibernateUserDao;
import webSiteBackend.entities.concretes.User;
import webSiteBackend.googleEmailControl.GoogleEmailControl;
import webSiteBackend.jValidations.jValidationsManagement;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<User>();
		
		UserManager userManager = new UserManager(new HibernateUserDao(),new ValidationManager(new jValidationsManagement()),new EmailManager(new GoogleEmailControl()));
		
		User user1= new User(10,"Ali","Güneþ","deneme@gmail.com","1234567");
		
		userManager.register(user1, users);
		
		userManager.login("deneme@gmail.com","1234567", users);
		userManager.getAll(users);
		
		System.out.println("********************************************");
		
		
		User user2= new User(12,"Ali","Güneþ","deneme@hotmail.com","12345"); // gmail dýþýnda mail türü kabu letmediði için eklemedi.
		
		userManager.register(user2, users);
		userManager.getAll(users);
		
		
		System.out.println("********************************************");
		
		
		User user3= new User(40,"Ahmet","Uzun","deneme@hotmail.com","12345345"); // ayný mail adresiyle baþkasýnýn da kayýt olmasýný kabul etmedi.
		userManager.register(user3, users);
		userManager.getAll(users);
		
		
		
	}

}
