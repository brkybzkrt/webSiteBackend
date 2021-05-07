package webSiteBackend.dataAccess.concretes;

import java.util.List;

import webSiteBackend.dataAccess.abstracts.UserDao;
import webSiteBackend.entities.concretes.User;

public class HibernateUserDao  implements UserDao{

	@Override
	public void register(User user,List<User> users) {
		
		users.add(user);
		
		System.out.println("kayd�n�z ba�ar�yla olmu�tur.");
		
	}

	@Override
	public void login(User user,List<User> users) {
		
		System.out.println("giri� yap�lm��t�r.");
	}

	@Override
	public void getAll(List<User> users) {
		
		for (User user : users) {
			
			System.out.println(user.getFirstName());
		}
		
	}

}
