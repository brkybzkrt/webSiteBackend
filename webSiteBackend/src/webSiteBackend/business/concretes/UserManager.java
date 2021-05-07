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
			System.out.println(user.getEmail()+ ": adl� mail adresine do�rulama maili yollanm��t�r.");
			this.userDao.register(user, users);
			
			
		}
		else {
			
			System.out.println("Hatal� kay�t i�lemi, l�tfen girmi� oldu�unuz bilgileri kontrol ediniz. ");
			
		}
		
	}

	@Override
	public void login(String email,String password,List<User> users) {
		if(validationService.loginControl(email,password, users)) {
			
			System.out.println("Giri� i�leminiz ba�ar�l�");
			
		}
		else {
			System.out.println("Email adresi veya parola hatal�.");
		}
		
		
	}

	@Override
	public void getAll(List<User> users) {
		
		this.userDao.getAll(users);
		
	}
	
	
	

}
