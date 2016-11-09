package demo.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.core.domain.UserEntity;
import demo.core.domain.auth.CurrentUser;
import demo.core.repository.UserRepository;


@Service
public class CurrentUserDetailsService implements UserDetailsService {

	UserRepository userRepository;
	
	@Autowired
	public CurrentUserDetailsService (UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	public UserEntity retrieveUser(String userName) {
		return userRepository.findOneByEmail(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		UserEntity userEntity = retrieveUser(userName);
		
		if(userEntity ==null)
			throw new UsernameNotFoundException(String.format("User with email %s could not be found", userName));
		
		
		return new CurrentUser(userEntity);
	}


	
	

}
