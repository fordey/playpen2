package demo.core.services.api;

import demo.core.domain.RequestMessage;
import demo.core.domain.Response;


public interface SimpleMessageProducer {
	
	public Response sendMessage(RequestMessage messageToSend);
}
