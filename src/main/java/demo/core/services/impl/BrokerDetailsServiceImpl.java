package demo.core.services.impl;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.stereotype.Service;

import demo.core.services.api.BrokerDetailsService;

@Service
public class BrokerDetailsServiceImpl implements BrokerDetailsService {

	@Autowired
	private MBeanServerConnectionFactoryBean  mbeanServerConnection;
	
	@Value("${spring.activemq.broker-url}")
	private String brokerConnectionURL;
	
	@Value("${app.destination_queue}")
	private String getDestinationQ;
	
	
	private static final Logger LOG = LoggerFactory.getLogger("BrokerDetailsServiceImpl.class");
	
	@Override
	public String getBrokerDetails() {
		
		return brokerConnectionURL;
	}



	@Override
	public String getDestinationQ() {
		return getDestinationQ;
	}



	@Override
	public String getQueueSize() {
		String queueSize = "Not Available";
		try{
			MBeanServerConnection connection = mbeanServerConnection.getObject();
			
			ObjectName objectNameRequest = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");
			BrokerViewMBean mbean = (BrokerViewMBean)MBeanServerInvocationHandler.newProxyInstance(connection, objectNameRequest, BrokerViewMBean.class, true);
			
			for(ObjectName name: mbean.getQueues()){
				QueueViewMBean qviewmBean = (QueueViewMBean)MBeanServerInvocationHandler.newProxyInstance(connection, name, QueueViewMBean.class, true);
				if(qviewmBean.getName().equalsIgnoreCase(getDestinationQ)){
					queueSize = Long.toString(qviewmBean.getQueueSize());
					break;
				}
			}
			
		}catch(Exception e){
				LOG.error(e.getMessage());
				e.printStackTrace();
				queueSize = "Not Available Currently";
				
		}
		
		return queueSize;
	}


	
	
}
