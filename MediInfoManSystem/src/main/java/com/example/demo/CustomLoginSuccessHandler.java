package com.example.demo;
/*
 * Class description:
 * Custom page handler 
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl=determineTargetUrl(authentication);
		if(response.isCommitted()) {
			return;
		}
		RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
		
	}

	protected String determineTargetUrl(Authentication authentication) {
		String url="/login?error=true";
		
		//fetch role
		Collection<? extends GrantedAuthority>authorities=authentication.getAuthorities();
		List<String>roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities) {
			roles.add(a.getAuthority());
		}
		
		//user redirect page
		if(roles.contains("Admin")) {
			url="/adminPage";                           // set page for user*
		}
		else if(roles.contains("Doctor")) {             // set page for user*
			url="/doctorPage";
		}
		else if(roles.contains("Receptionist")) {       // set page for user*
			url="/receptionistPage";
		}
		
		else if(roles.contains("Lab")) {       // set page for user*
			url="/labPage";
		}
		else if(roles.contains("Nurse")) {       // set page for user*
			url="/nursePage";
		}
		
		else if(roles.contains("Officer")) {       // set page for user*
			url="/officerPage";
		}
		
		else if(roles.contains("Head")) {       // set page for user*
			url="/headPage";
		}
		
		else if(roles.contains("Transport")) {       // set page for user*
			url="/transportPage";
		}
		
		else if(roles.contains("Pharmacy")) {       // set page for user*
			url="/pharmacyPage";
		}
		
		return url;
		
		
	}
	

	
	
}
