package demo.core.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AsynchSampleObject {
	private String sampleText;
	private String threadExecuted;
	
}
