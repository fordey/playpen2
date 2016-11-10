package demo.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PlayPenController extends AbstractSiteController {

	private static final Logger logger = LoggerFactory.getLogger("PlayPenController.class");
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String redirectToHomePage(Model model){
		logger.info("redirecting to playpen.htm");
		
		return sendToHome(model);
	}
	
	@RequestMapping(value="/salesMaster.htm", method = RequestMethod.GET)
	public String sendToHome(Model model){
		logger.debug("returning playpen view");
		
		return "salesHome";
	}
	
	@Override
	public String setPanelTitle(){
		return "Sales Master";
	}
	
	
	
}
