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
public class JavaScriptController extends AbstractSiteController {
	
	private static final Logger LOG = LoggerFactory.getLogger("JavaScriptController.class");
	
	@RequestMapping(value ="/javascript",method = RequestMethod.GET)
	public String renderMessageSender(Model model){
		LOG.debug("Rendering Message Sender Page");
		
		return "javascript_page";
		
	}
	
	
	
	
	@Override
	public String setPanelTitle(){
		return "JavaScript Framework";
	}
	
}
