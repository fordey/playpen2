package demo.core.services.api;

import org.springframework.stereotype.Service;


public interface BrokerDetailsService {
	
	public String getBrokerDetails();
	
	public String getDestinationQ();
	
	public String getQueueSize();

}
