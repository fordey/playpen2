package demo.test.jms.activemq;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.Application;

@ActiveProfiles("default")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class, loader = SpringApplicationContextLoader.class)
public class TestActiveMQ {

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Test
	public void testJmsConnectionFactory() throws Exception{
		ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
		Assert.assertNotNull(connectionFactory);
		
		MessageCreator messageCreator = new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("ping!!");
			}
		};
		
		jmsTemplate.send("testq", messageCreator);
		
	}
}
