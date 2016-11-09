package demo.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import demo.core.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	UserEntity findOneByEmail(String email);
	
}
