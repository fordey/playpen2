package demo.core.services.impl;

import java.util.concurrent.atomic.AtomicReference;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;



import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import demo.core.domain.RequestMessage;
import demo.core.domain.Response;
import demo.core.services.api.SimpleMessageProducer;

@Service
public class SimpleMessageProducerImpl implements SimpleMessageProducer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${app.destination_queue}")
	private String message_Queue;

	@Override
	public Response sendMessage(final RequestMessage requestMessage) {
		
		Response response = new Response();
		
		response.setSuccess(true);
		
		final AtomicReference<Message> message = new AtomicReference<Message>();
		
		
		try{
			MessageCreator messageCreator = new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					message.set(session.createTextMessage(requestMessage.getPayLoad()));
					return message.get();
				}
			};
		
			jmsTemplate.send(message_Queue, messageCreator);
			
			response.setMessageId(message.get().getJMSMessageID());
			
			
		}catch(JmsException|JMSException e){
			response.setSuccess(false);
		}
		
		return response;
		
	}

}
