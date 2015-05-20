package demo.web.controllers;

import demo.core.domain.EncodedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
public class EncoderController extends AbstractSiteController {
	
	private static final Logger LOG = LoggerFactory.getLogger("EncoderController.class");
	
	@Autowired
	private EncodedMessage encodedMessage;

	
	@RequestMapping(value ="/encodeMessage",method = RequestMethod.GET)
	public String renderMessageSender(Model model){
		LOG.debug("Rendering encoder page");
		
		return "encoding";
		
	}
	
	
	@RequestMapping(value="/clearEncoded.htm", method = RequestMethod.GET)
	public String clearMessage(Model model){
		encodedMessage.setRawPassword("");
		encodedMessage.setEncodePassword("");
		return "encoding";
	}
	

	@RequestMapping(value="/encodeMessage", method = RequestMethod.POST)
	public String encodeMessage(@ModelAttribute("encodedMessage")EncodedMessage encodedMessage, BindingResult result){
		LOG.info(String.format("Message to encode : %s", encodedMessage.getRawPassword()));;
		
		String encoding  = "dfdfdfdfdfdf";
		
		encodedMessage.setEncodePassword(encoding);
		
		
		return "encoding";
	}
	
	
	@ModelAttribute("encodedMessage")
	public EncodedMessage getEncodedMessage(){
		return encodedMessage;
	}
	

	
	@Override
	public String setPanelTitle(){
		return "BCryptPasswordEncoder";
	}
	
}
