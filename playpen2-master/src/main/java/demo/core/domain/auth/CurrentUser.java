package demo.core.domain.auth;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import demo.core.domain.UserEntity;

public class CurrentUser extends User {
	private static final long serialVersionUID = 1L;
	
	private UserEntity userEntity;
	
	public CurrentUser(UserEntity userEntity){
		
		
		super(userEntity.getEmail(), userEntity.getPassword(), 
				AuthorityUtils.createAuthorityList(userEntity.getRole().toString()));
		
		this.userEntity = userEntity;
	}
	
	public UserEntity getUserEntity(){
		return userEntity;
	}
	
	
}
