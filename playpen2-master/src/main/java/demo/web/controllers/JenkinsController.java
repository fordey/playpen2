package demo.web.controllers;

import java.net.MalformedURLException;
import java.util.List;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.core.domain.JenkinsJob;
import demo.core.services.api.JenkinsDetailsService;


@Controller
public class JenkinsController extends AbstractSiteController {
	
	@Autowired
	private JenkinsDetailsService jenkinsDetailService;
	
	
	private static final Logger logger = LoggerFactory.getLogger("JenkinsController.class");
	
	@RequestMapping(value="/jenkins", method = RequestMethod.GET)
	public ModelAndView sendToHome(Model model) throws MalformedURLException, DocumentException{
		logger.debug("returning jenkins view");
		List<JenkinsJob> masJobs = jenkinsDetailService.getMASJobs();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jenkins");
		mav.addObject("masJobs", masJobs);
		
		logger.debug("MAS Jobs Returned : {}", masJobs);
		
		return mav;
	}
	
	
	
	@Override
	public String setPanelTitle(){
		return "MAS Jenkins Builds";
	}
	
	
}
