package demo.core.domain;

import lombok.Data;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Data
public class EncodedMessage {

	private String rawPassword = "";
	private String encodePassword = "";
	
}
