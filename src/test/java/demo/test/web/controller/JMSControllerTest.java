package demo.test.web.controller;

import demo.core.services.api.BrokerDetailsService;
import demo.core.services.api.VersionService;
import demo.web.controllers.JMSController;

import org.junit.Before;
import org.junit.Test;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;


public class JMSControllerTest {

	private static final String FORWARDED_URL = "/templates/playpen.html";
    private static final String VIEW = "home";
	
	
	MockMvc mockMvc;
	
	@InjectMocks //class under test to be annotated with this to state going to inject mocks
	JMSController controller;
	
	@Mock  // all collaborators annotated with @mock
	BrokerDetailsService brokerDetailService;
	
	@Mock
	VersionService versionService;
	
	
	@Before
	public void setUp(){
		
		//tell unit test framework to perform the mockito injection before starting the test.
		MockitoAnnotations.initMocks(this);
		
		mockMvc =standaloneSetup(controller)
				.setViewResolvers(viewResolver())
				.build();
		
		when(brokerDetailService.getBrokerDetails()).thenReturn(getTestProvider());
		
		when(versionService.getVersionNumber()).thenReturn("1.0.0");
		
		
		
	}
		
	
	@Test
	public void testRootPopulatesViewModel() throws Exception{
		mockMvc.perform(get("/message"))
		.andDo(print())
		.andExpect(model().attribute("brokerDetails", equalToIgnoringCase(getTestProvider())));
	}
	
	
	
	private InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");
		
		return viewResolver;
		
		
	}
	
	
	private String getTestProvider(){
				
		return "tcp://localhost:8080";
		
	}
	
	
	
	
}
