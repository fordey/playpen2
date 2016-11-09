package demo.core.domain.enums;


public enum Role {

	SALESREP,
	ADMIN
	
	/*private String displayRole;
	
	
	public String getDisplayRole() {
		return displayRole;
	}


	public void setDisplayRole(String displayRole) {
		this.displayRole = displayRole;
	}


	private Role(String displayRole){
		this.displayRole =  displayRole;
	}
	
	
	public static Role getRole(String value){
		for(Role r: values()){
			if(r.getDisplayRole().equalsIgnoreCase(value)){
				return r;
			}
		}
		
		throw new IllegalArgumentException(String.format("could not find mapping to Role for %s value ", value));
	}*/
}
