package demo.core.domain;

import java.util.Arrays;
import java.util.List;

public enum JenkinsBuildStatus {

	red("red"),
	red_anime("red_anime"),
	yellow("yellow"),
	yellow_anime("yellow_anime"),
	blue("blue"), 
	blue_anime("blue_anime"),
	grey("grey"),
	disabled("disabled"),
	notbuilt("notBuilt");
	
	private String statusColor;
	
	
	//in case need to return a list of the enumeration values
	private static final List<JenkinsBuildStatus> values = Arrays.asList(JenkinsBuildStatus.values());
	
	private JenkinsBuildStatus(String status){
		this.statusColor = status;
	}
	
	public String getStatusColor(){
		return this.statusColor;
	}
	
	public static JenkinsBuildStatus fromColorString(String color){
		for(JenkinsBuildStatus status : values())
			if(status.statusColor.equalsIgnoreCase(color))
				return status;
			
		return null;
	}
	
	
	
}
