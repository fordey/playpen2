package demo.web.controllers;

import demo.core.domain.RequestMessage;
import demo.core.domain.Response;
import demo.core.services.api.BrokerDetailsService;
import demo.core.services.api.SimpleMessageProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


@Controller
public class JMSController extends AbstractSiteController {
	
	private static final Logger LOG = LoggerFactory.getLogger("SiteController.class");
	
	@Autowired
	private RequestMessage message;
	
	
	@Autowired
	private BrokerDetailsService brokerDetailsService;
	
	@Autowired
	private SimpleMessageProducer messageProducer;

	
	@RequestMapping(value ="/message",method = RequestMethod.GET)
	public String renderMessageSender(Model model){
		LOG.debug("Rendering Message Sender Page");
		
		return "message_sender";
		
	}
	
	
	@RequestMapping(value="/clear.htm", method = RequestMethod.GET)
	public String clearMessage(Model model){
		message.setPayLoad("");
		return "message_sender";
	}
	

	@RequestMapping(value="/sendMessage.htm", method = RequestMethod.POST)
	public ModelAndView sendMessage(@ModelAttribute("message")RequestMessage message, BindingResult result){
		LOG.info(String.format("Message Payload : %s", message.getPayLoad()));;
		
		Response response = messageProducer.sendMessage(message);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("message_sender");
		mav.addObject("success", response.isSuccess());
		if(response.isSuccess())
			mav.addObject("messageId", response.getMessageId());
		mav.addObject("queueSize", brokerDetailsService.getQueueSize());
		
		return mav;
	}
	
	
	@RequestMapping(value="/getQueueSize", method=RequestMethod.GET)
	public String getQueueSize(Model model){
		model.addAttribute("queueSize", brokerDetailsService.getQueueSize());
		
		return "message_sender::queue_size";
	}
	
	
	@ModelAttribute("message")
	public RequestMessage getMessage(){
		return message;
	}
	
	
	@ModelAttribute("brokerDetails")
	public String getBrokerDetails(){
		return brokerDetailsService.getBrokerDetails();
	}
	
	@ModelAttribute("destinationQ")
	public String getDestinationQ(){
		return brokerDetailsService.getDestinationQ();
	}
	
	@ModelAttribute("queueSize")
	public String getQueueSize(){
		return brokerDetailsService.getQueueSize();
	}
	
	@Override
	public String setPanelTitle(){
		return "JMS Sender Example";
	}
	
}
