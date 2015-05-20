package demo.core.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)

public class EncodedMessage {

	private String rawPassword;
	private String encodePassword;
	
	
	public String getRawPassword() {
		return rawPassword;
	}
	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}
	public String getEncodePassword() {
		return encodePassword;
	}
	public void setEncodePassword(String encodePassword) {
		this.encodePassword = encodePassword;
	}
	
	
	
	
}
