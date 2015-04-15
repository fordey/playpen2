package demo.core.services.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import demo.core.domain.JenkinsJob;
import demo.core.services.api.JenkinsDetailsService;

@Service
public class JenkinsDetailsServiceImpl implements JenkinsDetailsService {

	@Value("${jenkins.api.url}")
	private String jenkinsApi;
	
	@Value("${mas.jobs.prefix}")
	private String masJobPrefix;
	
	@Override
	public String getApiUrl() {
		return jenkinsApi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JenkinsJob> getMASJobs() throws MalformedURLException, DocumentException {
		List<JenkinsJob> jobList = new ArrayList<JenkinsJob>();
		
		URL jenkinsURL = new URL(jenkinsApi);
		
		Document dom = new SAXReader().read(jenkinsURL);
		
		for(Element jobElement : (List<Element>)dom.getRootElement().elements("job")){
			JenkinsJob jenkinsJob = new JenkinsJob(jobElement);
			jobList.add(jenkinsJob);
		}
		
	
		
		return filterMASJobs(jobList);
	}
	
	private List<JenkinsJob> filterMASJobs(List<JenkinsJob> allJobs){
		
		return Lists.newArrayList(Iterables.filter(allJobs, new Predicate<JenkinsJob>() {

			@Override
			public boolean apply(JenkinsJob job) {
				
				return StringUtils.startsWith(job.getName(), masJobPrefix);
			}
		}));
		
	}
	

}
