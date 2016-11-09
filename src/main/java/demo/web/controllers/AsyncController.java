package demo.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.core.domain.AsynchSampleObject;


@Controller
public class AsyncController extends AbstractSiteController {

	private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);
	
	@Autowired
	AsynchSampleObject modelObject;  //scope is session
	
	@RequestMapping(value="/asynch", method = RequestMethod.GET)
	public String returnAsyncView(Model model){
		return "asynchView";
	}
	
	
	@Override
	public String setPanelTitle() {
		// TODO Auto-generated method stubs
		return "AsynchContoller Demo";
	}
	
	@ModelAttribute("asynModelObject")
	public AsynchSampleObject returnModelObject(){
		 return modelObject;
	}
	
	
	@ModelAttribute("currentThread")
	public String returnThreadID(){
		return Thread.currentThread().toString();
	}
}
