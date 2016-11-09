package demo.core.services.impl;

import javax.inject.Inject;

import demo.core.services.api.EncodingService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodingServiceImpl implements EncodingService {

	BCryptPasswordEncoder passwordEncoder;
	
	
	@Inject
	public void sePasswordEncoder(BCryptPasswordEncoder passwordEncoder){
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public String encodeString(String passWordToEncode) {
		passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(passWordToEncode);
		
		
	}

}
