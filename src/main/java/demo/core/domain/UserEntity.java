package demo.core.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import lombok.Data;
import lombok.experimental.Builder;
import demo.core.domain.enums.Role;

@Entity
@Data 
@Table(name="USERS")
@Builder

public class UserEntity {
	
	@Id
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	//needed for hibernate/jpa for construction
	public UserEntity(){
	}
	
	public UserEntity(String email, String password, Role role){
		this.email =email;
		this.password = password;
		this.role = role;
	}
	
	
	/*public static class UserBuilder{
		private String emailAddress;
		private String password;
		private Role role;
		
		public UserBuilder emailAddress(String emailAddress){
			this.emailAddress = emailAddress;
			return this;
		}
		
		public UserBuilder password(String password){
			this.password = password;
			return this;
		}
		
		public UserBuilder role(Role role){
			this.role = role;
			return this;
		}
		
		public UserEntity build(){
			return new UserEntity(this);
		}
		
	}*/
	
	public static void main(String[] args){
		UserEntity usr = UserEntity.builder().email("test").password("wwe").role(Role.SALESREP).build();
		
		Assert.notNull(usr);
	}
	
}
