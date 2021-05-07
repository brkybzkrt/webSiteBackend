package webSiteBackend.business.concretes;

import java.util.List;

import webSiteBackend.business.abstracts.EmailService;
import webSiteBackend.business.abstracts.UserService;
import webSiteBackend.business.abstracts.ValidationService;
import webSiteBackend.dataAccess.abstracts.UserDao;
import webSiteBackend.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private ValidationService validationService; 
	private EmailService emailService;

	public UserManager(UserDao userDao,ValidationService validationService,EmailService emailService) {
		
		this.userDao = userDao;
		this.validationService=validationService;
		this.emailService=emailService;
	}

	@Override
	public void register(User user,List<User> users) {
		
		if (this.validationService.nameControl(user.getFirstName(), user.getLastName()) 
				&&
				this.validationService.passwordControl(user.getPassword())
				&& 
				this.emailService.emailControl(user.getEmail())) 
		{
			System.out.println(user.getEmail()+ ": adlý mail adresine doðrulama maili yollanmýþtýr.");
			this.userDao.register(user, users);
			
			
		}
		else {
			
			System.out.println("Hatalý kayýt iþlemi, lütfen girmiþ olduðunuz bilgileri kontrol ediniz. ");
			
		}
		
	}

	@Override
	public void login(String email,String password,List<User> users) {
		if(validationService.loginControl(email,password, users)) {
			
			System.out.println("Giriþ iþleminiz baþarýlý");
			
		}
		else {
			System.out.println("Email adresi veya parola hatalý.");
		}
		
		
	}

	@Override
	public void getAll(List<User> users) {
		
		this.userDao.getAll(users);
		
	}
	
	
	

}
