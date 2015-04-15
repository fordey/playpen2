package demo.core.domain;

import org.dom4j.Element;

public class JenkinsJob {

	private String name;

	private JenkinsBuildStatus buildStatus;
	
		
	public JenkinsJob(Element jobElement) {
		this.name = jobElement.elementText("name");
		this.buildStatus = JenkinsBuildStatus.fromColorString(jobElement.elementText("color"));
	}

	public JenkinsBuildStatus getBuildStatus() {
		return buildStatus;
	}

	public void setBuildStatus(JenkinsBuildStatus buildStatus) {
		this.buildStatus = buildStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
