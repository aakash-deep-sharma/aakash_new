package com.model;

import java.util.Date;
import java.util.List;

public class TeamResourceModel {
	private String projectName;
	private Integer teamId;
	private String teamName;
	private String teamStatus;
	private Date startDate;
	private Date endDate;
	private List<Resource>resourceList;
	
	public TeamResourceModel() {
		super();
	}

	public TeamResourceModel(String projectName, Integer teamId, String teamName, String teamStatus, Date startDate,
			Date endDate, List<Resource> resourceList) {
		super();
		this.projectName = projectName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamStatus = teamStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceList = resourceList;
	}



	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamStatus() {
		return teamStatus;
	}
	public void setTeamStatus(String teamStatus) {
		this.teamStatus = teamStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	
	
}
