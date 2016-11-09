package demo.test.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.core.config.RepositoryConfig;
import demo.core.domain.UserEntity;
import demo.core.domain.enums.Role;
import demo.core.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={RepositoryConfig.class})
public class UserRepositoryTest {

	private UserRepository userRepository;
	private UserEntity defaultUser;
	
	
	@Autowired
	public void setUserRepository(UserRepository userRepository){
		this.userRepository = userRepository;	
	}
	
	@Before
	public void setUp(){
		defaultUser = UserEntity.builder()
		.email("test@test.com")
		.password("passwordsdsd")
		.role(Role.ADMIN)
		.build();
		
		userRepository.save(defaultUser);
	}
	
	
	
	@Test
	public void testUserSaveAndFetch(){
		UserEntity user = UserEntity.builder()
		.email("john.x.forde@gmail.com")
		.password("test")
		.role(Role.SALESREP)
		.build();
		
		userRepository.save(user);
		
		//fetch user just created
		UserEntity fetchedUser = userRepository.findOne(user.getEmail());
		
		assertNotNull(fetchedUser);
		assertEquals(fetchedUser.getEmail(), user.getEmail());
		
		assertEquals(fetchedUser.getRole(), user.getRole());
	}
	
		
	@Test
	public void testRetrievelByEmail(){
		UserEntity fetchedUser = userRepository.findOneByEmail("test@test.com");
		
		assertNotNull(fetchedUser);
		assertEquals("test@test.com", fetchedUser.getEmail());
	}
	
	@Test
	public void testFindAll(){
		List<UserEntity> fetchedUser = userRepository.findAll();
		assertNotNull(fetchedUser);
	}
	
}
