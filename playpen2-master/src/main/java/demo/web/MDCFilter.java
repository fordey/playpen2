package demo.web;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/* note:
 * 
 */
public class MDCFilter implements Filter	 {

	private static final Logger LOG = LoggerFactory.getLogger(MDCFilter.class);
	private static final String SESSION_ID_MDC_KEY = "sessionId";
	private static final String USER_ID_MDC_KEY = "userId";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.info("Initialsing MDC Filter");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		boolean bSessionRegistered = false;
		boolean bUserRegistered = false;
	
		try{
			if(request instanceof HttpServletRequest){
				HttpServletRequest httpRequest = (HttpServletRequest)request;
				bSessionRegistered = registerSession(httpRequest);
				bUserRegistered = registerUser(httpRequest);
			}
			chain.doFilter(request, response);
		}finally{
			if (bSessionRegistered)
				MDC.remove(SESSION_ID_MDC_KEY);
				
			if(bUserRegistered)
				MDC.remove(USER_ID_MDC_KEY);
		}
		
	}

	
	private boolean registerSession(HttpServletRequest request){
		boolean success = false;
		
		HttpSession session = request.getSession(false);
		if(session != null){
			MDC.put(SESSION_ID_MDC_KEY, session.getId());
			success = true;
		}
		
		return success;
	}
	
	private boolean registerUser(HttpServletRequest request){
		boolean bsuccess = false;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null && auth.getName() != null && !auth.getName().isEmpty()){
				MDC.put(USER_ID_MDC_KEY, auth.getName());
				bsuccess = true;
		}else{
			//may be null id if this filter executed before spring security persistence filter
			//if so get the auth object off session
			HttpSession session =  request.getSession(false);
			
			
		}
		
		
		
		MDC.put(USER_ID_MDC_KEY, "test user");
		bsuccess = true;
		
		return bsuccess;
	}
	
	@Override
	public void destroy() {
		LOG.info("Tearing down MDC Filter");
		
	}

}
