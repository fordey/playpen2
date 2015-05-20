package demo.core.services.impl;

import demo.core.services.api.EncodingService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodingServiceImpl implements EncodingService {

	@Override
	public String encodeString(String passWordToEncode) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(passWordToEncode);
		
		
	}

}
