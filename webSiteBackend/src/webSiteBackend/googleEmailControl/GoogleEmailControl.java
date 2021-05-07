package webSiteBackend.googleEmailControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleEmailControl {

	
	public boolean emailControl(String email) {
		Pattern eslesme= Pattern.compile("[a-zA-Z0-9]{5,}@gmail.com");
		
		Matcher kontrol = eslesme.matcher(email);
		
		if(kontrol.matches()) {
			
			return true;
			
		}
		else {
			
			return false;
		}
		
	}
}
