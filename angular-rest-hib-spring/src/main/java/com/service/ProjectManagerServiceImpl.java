package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProjectDao;
import com.dao.ResourceDao;
import com.dao.RoleDao;
import com.dao.TeamDao;
import com.model.Project;
import com.model.Resource;
import com.model.Role;
import com.model.Team;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService{

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private RoleDao roleDao;
	
	
	public boolean allocateProjectToTeam(Team team,Project project) throws Exception
	{
		project= projectDao.getProjectById(project);
		System.out.println("project" + project);
		Team team1 = teamDao.getTeamById(team);
		System.out.println("team" + team1);
		project.setTeam(team1);
		projectDao.updateProject(project);
		//teamDao.updateTeam(team);
		return true;
	}
	
	@Override
	public boolean addResourceToTeam(Resource resource, Team team) throws Exception {
		resource = resourceDao.getResource(resource);
		team = teamDao.getTeamById(team);
		resource.setTeam(team);
		resource.setResourceStatus("assign");
		resourceDao.updateResource(resource);
		return true;
	}

	@Override
	public boolean removeResourceFromTeam(Resource resource) throws Exception {
		resource = resourceDao.getResource(resource);
		resource.setTeam(null);
		resourceDao.updateResource(resource);
		return true;
	}

	@Override
	public boolean deallocateProjectfromTeam(Project project) throws Exception {
		project = projectDao.getProjectById(project);
		project.setTeam(null);
		projectDao.updateProject(project);
		return false;
	}

	@Override
	public int createTeam(Team team) throws Exception {
	Team team1=	teamDao.createTeam(team);
		return team1.getTeamId();
	}
	
	@Override
	public boolean deleteTeam(Team team) throws Exception {
		teamDao.deleteTeam(team);
		return true;
	}

	@Override
	public Team updateTeam(Team team) throws Exception {
		
		return teamDao.updateTeam(team);
	}

	@Override
	public List<Team> listTeam() throws Exception {

		return teamDao.listTeam();
	}

	@Override
	public Team getTeamById(Team team) throws Exception {
		
		return teamDao.getTeamById(team);
	}

	@Override
	public int createProject(Project project) throws Exception {
		Project project1=projectDao.createProject(project);
		return project1.getProjectId();
	}

	@Override
	public boolean deleteProject(Project project) throws Exception {
		projectDao.deleteProject(project);
		return true;
	}

	@Override
	public Project updateProject(Project project) throws Exception {
		
		return projectDao.updateProject(project);
	}

	@Override
	public List<Project> listProject() throws Exception {
		
		return projectDao.listProject();
	}

	@Override
	public Project getProjectById(Project project) throws Exception {
		
		return projectDao.getProjectById(project);
	}

	@Override
	public boolean addRoleToResource(Resource resource, Role role) throws Exception {
		System.out.println("1"+resource);
		resource=resourceDao.getResource(resource);
		System.out.println("4"+resource);
		role.setResource(resource);
		roleDao.createRole(role);
		System.out.println("7"+role);
		return true;
	}

	@Override
	public Role updateRole(Role role) throws Exception {
		
		return roleDao.updateRole(role);
	}

	

	@Override
	public boolean removeRoleFromResource(Resource resource) throws Exception {
		System.out.println("delete role 2");
		return roleDao.deleteRole(resource);
	}
	
}
