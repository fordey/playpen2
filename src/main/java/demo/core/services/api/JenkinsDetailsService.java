package demo.core.services.api;

import java.net.MalformedURLException;
import java.util.List;

import org.dom4j.DocumentException;

import demo.core.domain.JenkinsJob;


public interface JenkinsDetailsService {
	
	public String getApiUrl();
	
	public List<JenkinsJob> getMASJobs() throws MalformedURLException, DocumentException;


}
