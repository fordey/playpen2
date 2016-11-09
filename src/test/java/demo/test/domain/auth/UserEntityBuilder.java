package demo.test.domain.auth;

import static org.junit.Assert.*;
import org.junit.Test;

import demo.core.domain.UserEntity;
import demo.core.domain.enums.Role;

public class UserEntityBuilder {

	@Test
	public void testUserEntityBuilder()
	{
		UserEntity user = UserEntity.builder()
		.email("test.test@gmail.com")
		.password("testpassword")
		.role(Role.ADMIN)
		.build();
		
		assertNotNull(user);
		
		assertEquals("test.test@gmail.com", user.getEmail());
		assertEquals("testpassword", user.getPassword());
		assertEquals(Role.ADMIN, user.getRole());
		
	
		
	}
	
	
	
}
