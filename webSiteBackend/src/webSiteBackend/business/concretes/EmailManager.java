package webSiteBackend.business.concretes;

import webSiteBackend.business.abstracts.EmailService;
import webSiteBackend.googleEmailControl.GoogleEmailControl;

public class EmailManager implements EmailService{

	
	private GoogleEmailControl googleEmailControl; 
	
	public EmailManager(GoogleEmailControl googleEmailControl) {
		
		this.googleEmailControl = googleEmailControl;
	}

	@Override
	public boolean emailControl(String email) {
		
		return this.googleEmailControl.emailControl(email);
	}

}
