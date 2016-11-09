package demo.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import demo.core.services.api.VersionService;

@Controller
public class AbstractSiteController {
	
	@Autowired
	private VersionService versionService;
	
	
	@ModelAttribute("title")
	public String setPanelTitle(){
		return "This is a default title - implement your own!!!";
	}
	
	@ModelAttribute("version")
	public String getVersion(){
		return versionService.getVersionNumber();
	}

	
	@ModelAttribute("userName")
	public String getUserName(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
		
	}
	
}
