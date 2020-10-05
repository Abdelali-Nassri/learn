package app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.dao.AdminRepo;
import app.models.Admin;
@Service
public class MyUserServiceDetails implements UserDetailsService {

	@Autowired
	AdminRepo ar;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = ar.findByEmail(username);
		if(admin == null)
			throw new UsernameNotFoundException("Not found");

		return  new UserPrincipale(admin);
	}

}
