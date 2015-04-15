package demo.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SslController extends AbstractSiteController {

	private static final Logger logger = LoggerFactory.getLogger("AbstractSiteController.class");
	
	@RequestMapping(value="/springssl", method = RequestMethod.GET)
	public String sendToHome(Model model){
		logger.debug("returning ws view");
		
		return "spring-ssl"; //this is a fine name
	}
	
	@Override
	public String setPanelTitle() {
		// TODO Auto-generated method stub
		return "Spring WS Sample";
	}
	
}
