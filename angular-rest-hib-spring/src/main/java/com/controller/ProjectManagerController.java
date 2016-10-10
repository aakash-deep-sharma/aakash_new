package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Project;
import com.model.Resource;
import com.model.Role;
import com.model.RoleModel;
import com.model.Status;
import com.model.Team;
import com.model.TeamResourceModel;
import com.service.ProjectManagerServiceImpl;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("projectManager")
public class ProjectManagerController {
	
	@Autowired
	private ProjectManagerServiceImpl pmservice;
	
	final static Logger logger = Logger.getLogger(ProjectManagerController.class);
	
	public ProjectManagerController() {
		logger.warn("Project Manager controller created");
	}
	
	
	@RequestMapping(value="/addResourceToTeam/{rid}/{tid}",method=RequestMethod.GET,headers="Accept=application/json")
	public Status addResourceToTeam(@PathVariable("rid")Integer rid,@PathVariable("tid")Integer tid)
	{
		//System.out.println("updatestudent:controller called");
		logger.warn("update resource : "+rid+"in team "+tid );
		Status status= new Status();
		
		try 
		{
			Resource resource=new Resource();
			resource.setResourceId(rid);
			Team team=new Team();
			team.setTeamId(tid);
			pmservice.addResourceToTeam(resource, team);
			status.setCode(200);
			status.setMessage("resource updated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while updating resource with id :"+rid+" error :"+e);
			status.setCode(400);
			status.setMessage("resource not updated");
			e.printStackTrace();
		}
		return status;
	}

	@RequestMapping(value="/removeResourceFromTeam/{id}" ,headers="Accept=application/json",method=RequestMethod.DELETE)
	public Status removeResourceFromTeam(@PathVariable("id")Integer id)
	{
		
		logger.warn("delete resource  from team with id : "+id);
		Status status = new Status();
		
		try 
		{
			Resource resource=new Resource();
			resource.setResourceId(id);
			pmservice.removeResourceFromTeam(resource);
			status.setCode(200);
			status.setMessage("resource removed from team succesfully");
			
		} 
		catch (Exception e) 
		{
			logger.error("error occured while deleting resource from team with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("resource not deleted");
			e.printStackTrace();
			
		}
		return status;
	}
	
	@RequestMapping(value="/getTeamById/{id}" ,headers="Accept=application/json",method=RequestMethod.GET)
	public Team getTeamById(@PathVariable("id")Integer id)
	{
		logger.warn("Get Team id : "+id);
		Status status = new Status();
		try 
		{
		    Team team=new Team();
		    team.setTeamId(id);
		    
		    Team t=new Team();
		    Team tt=pmservice.getTeamById(team);
		    t.setTeamId(tt.getTeamId());
		    t.setTeamName(tt.getTeamName());
		    t.setTeamStatus(tt.getTeamStatus());
		    t.setStartDate(tt.getStartDate());
		    t.setEndDate(tt.getEndDate());
		  
		    status.setCode(200);
			status.setMessage("Team available");
			System.out.println(  pmservice.getTeamById(team));
			return t;
		}
		catch (Exception e) 
		{
			logger.error("error occured while getting student with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("Resource Not available");
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/createTeam",method=RequestMethod.PUT,headers="Accept=application/json")
	public Team createTeam(@RequestBody Team team)
	{
		logger.warn("create team : "+team);
		
		
		try 
		{
			Integer id = pmservice.createTeam(team);
			team.setTeamId(id);
			return team;
		}
		catch (Exception e)
		{
			logger.error("error occured while creating Team with name :"+team.getTeamName() +" error :"+e);
			
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="/getProjectById/{id}" ,headers="Accept=application/json",method=RequestMethod.GET)
	public TeamResourceModel getProjectById(@PathVariable("id")Integer id)
	{
		logger.warn("Get Team id : "+id);
		Status status = new Status();
		try 
		{
		    Project project=new Project();
		    project.setProjectId(id);
		    
		    TeamResourceModel trm=new TeamResourceModel();
		    Project pp=pmservice.getProjectById(project);
		    trm.setProjectName(pp.getProjectName());
		    trm.setTeamId(pp.getTeam().getTeamId());
		    trm.setTeamName(pp.getTeam().getTeamName());
		    trm.setTeamStatus(pp.getTeam().getTeamStatus());
		    trm.setStartDate(pp.getTeam().getStartDate());
		    trm.setEndDate(pp.getTeam().getEndDate());

		    List<Resource> rlist=new ArrayList<>();
		    for(Resource resource:pp.getTeam().getResources())
		    {
		    	Resource resource1=new Resource();
		    	resource1.setResourceId(resource.getResourceId());
		    	resource1.setResourceName(resource.getResourceName());
		    	rlist.add(resource1);
		    	
		    }
		   trm.setResourceList(rlist);		
		   status.setCode(200);
		   status.setMessage("Project available");
			return trm;
		}
		catch (Exception e) 
		{
			logger.error("error occured while getting Project with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("Project Not available");
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/createProject",method=RequestMethod.PUT,headers="Accept=application/json")
	public Project createProject(@RequestBody Project project)
	{
		logger.warn("create project : "+project);
		Status status= new Status();
		
		try 
		{
			
			status.setCode(200);
			status.setMessage("project created succesfully");
			Integer id = pmservice.createProject(project);
			project.setProjectId(id);
			System.out.println("hello edwdfe"+project);
			return project;
		}
		catch (Exception e)
		{
			logger.error("error occured while creating project with name :"+project.getProjectName() +" error :"+e);
			status.setCode(400);
			status.setMessage("resource not created");
			e.printStackTrace();
			return null;
		}
	
	}
	
	@RequestMapping(value="/updateTeam",method=RequestMethod.POST,headers="Accept=application/json")
	public Status updateTeam(@RequestBody Team team)
	{
		logger.warn("update team : "+team);
		Status status= new Status();
		
		try 
		{
			pmservice.updateTeam(team);
			status.setCode(200);
			status.setMessage("Team updated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while updating team with id :"+team.getTeamName()+" error :"+e);
			status.setCode(400);
			status.setMessage("team not updated");
			e.printStackTrace();
		}
		return status;
	}
	@RequestMapping(value="/deleteTeam/{teamId}" ,headers="Accept=application/json",method=RequestMethod.DELETE)
	public Status deleteTeam(@PathVariable("teamId")Integer id)
	{
		
		logger.warn("delete Team id : "+id);
		Status status=new Status();
		
		try 
		{
			Team team=new Team();
			team.setTeamId(id);
			pmservice.deleteTeam(team);
			status.setCode(200);
			status.setMessage("team deleted succesfully");
			
		} 
		catch (Exception e) 
		{
			logger.error("error occured while deleting team with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("team not deleted");
			e.printStackTrace();
			
		}
		return status;
	}
	
	@RequestMapping(value="/deleteProject/{projectId}" ,headers="Accept=application/json",method=RequestMethod.DELETE)
	public Status deleteProject(@PathVariable("projectId")Integer id)
	{
		
		logger.warn("delete Project id : "+id);
		Status status=new Status();
		
		try 
		{
			Project project=new Project();
			project.setProjectId(id);
			pmservice.deleteProject(project);
			status.setCode(200);
			status.setMessage("Project deleted succesfully");
			
		} 
		catch (Exception e) 
		{
			logger.error("error occured while deleting Project with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("Project not deleted");
			e.printStackTrace();
			
		}
		return status;
	}
	
	@RequestMapping(value="/updateProject",method=RequestMethod.POST,headers="Accept=application/json")
	public Status updateProject(@RequestBody Project project)
	{
		logger.warn("update project : "+project);
		Status status= new Status();
		
		try 
		{
			pmservice.updateProject(project);
			status.setCode(200);
			status.setMessage("project updated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while updating project with id :"+project.getProjectName()+" error :"+e);
			status.setCode(400);
			status.setMessage("project not updated");
			e.printStackTrace();
		}
		return status;
	}
	@RequestMapping(value="/deallocateProjectfromTeam",method=RequestMethod.POST,headers="Accept=application/json")
	public Status deallocateProjectfromTeam(@RequestBody Project project)
	{
		logger.warn("deallocate project with name: "+project.getProjectName());
		Status status= new Status();
		
		try 
		{
			pmservice.deallocateProjectfromTeam(project);
			
			status.setCode(200);
			status.setMessage("project deallocated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while deallocating project with id :"+project.getProjectId()+" error :"+e);
			status.setCode(400);
			status.setMessage("project not deallocated");
			e.printStackTrace();
		}
		return status;
	}
	@RequestMapping(value="/allocateProjectToTeam/{projectId}/{teamId}",method=RequestMethod.POST,headers="Accept=application/json")
	public Status allocateProjectToTeam(@PathVariable("projectId")Integer pid,@PathVariable("teamId")Integer tid)
	{
		logger.warn("allocate project with id : "+pid+"to team with id "+tid);
		Status status= new Status();
		System.out.println("hello "+pid +"bye"+tid);
		try 
		{
			Project p=new Project();
			p.setProjectId(pid);
			Team t=new Team();
			t.setTeamId(tid);
			pmservice.allocateProjectToTeam(t,p);
			status.setCode(200);
			status.setMessage("project allocated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while allocating project to team :"+" error :"+e);
			status.setCode(400);
			status.setMessage("project not allocated");
			e.printStackTrace();
		}
		return status;
	}
	
	
	@RequestMapping(value="/listTeam", headers="Accept=application/json",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Team> listTeam() {
		logger.warn("Get Team List : ");
		Status status=new Status();
		try 
		{
			 status.setCode(200);
			 status.setMessage("Team list available");
			 List<Team>list=new ArrayList<Team>();
			 for (Team team : pmservice.listTeam()) {
				 	
				 	Team t1=new Team();
					t1.setTeamId(team.getTeamId());
					t1.setTeamName(team.getTeamName());
					t1.setTeamStatus(team.getTeamStatus());
					t1.setStartDate(team.getStartDate());
					t1.setEndDate(team.getEndDate());
					  List<Project>projectList=new ArrayList<Project>();
					    if(team.getProjects()!=null)
						{
							for(Project project1:team.getProjects())
							{
								Project project=new Project();
								project.setProjectId(project1.getProjectId());
								project.setProjectName(project1.getProjectName());
								projectList.add(project);
								t1.setProjects(projectList);
							}
						}
					    List<Resource>list1=new ArrayList<Resource>();
						 if(team.getResources()!=null)
						 {
							 for(Resource resource1:team.getResources())
							 {
								 Resource resource=new Resource();
								 resource.setResourceId(resource1.getResourceId());
								 resource.setResourceName(resource1.getResourceName());
								 resource.setResourceStatus(resource1.getResourceStatus());
								 list1.add(resource);
								 t1.setResources(list1);
							 }
						 }
					list.add(t1);
			}
			
			return list;
			
		}
		catch (Exception e) 
		{
			logger.error("error occured while getting Teams :"+" error :"+e);
			status.setCode(400);
			status.setMessage("Teams Not available");
			e.printStackTrace();
			return null;
		}
	
	}
	
	@RequestMapping(value="/listProject", headers="Accept=application/json",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Project> listProject() {
		
		logger.warn("Get Project List : ");
		Status status=new Status();
		try 
		{
			
			 List<Project>list=new ArrayList<Project>();
			 for (Project project : pmservice.listProject()) {
				 Project p1=new Project();
				 p1.setProjectId(project.getProjectId());
				 p1.setProjectName(project.getProjectName());
				 list.add(p1);
			}
			 status.setCode(200);
			 status.setMessage("Project list available");
			 return list;
			
		}
		catch (Exception e) 
		{
			logger.error("error occured while getting Projects :"+" error :"+e);
			status.setCode(400);
			status.setMessage("Project Not available");
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	
	@RequestMapping(value="/addRoleToResource",method=RequestMethod.PUT,headers="Accept=application/json")
	public Status addRoleToResource(@RequestBody RoleModel rolemodel)
	{
		System.out.println("ROLE GIVEN"+rolemodel);
		logger.warn("allocate role with name: "+rolemodel.getRoleName());
		Status status= new Status();
		
		try 
		{	
			Role role=new Role();
			role.setRoleId(rolemodel.getRoleId());
			role.setRoleName(rolemodel.getRoleName());
			role.setRoleType(rolemodel.getRoleType());
			role.setStartDate(rolemodel.getStartDate());
			role.setEndDate(rolemodel.getEndDate());
			
			Resource resource=new Resource();
			resource.setResourceId(rolemodel.getResourceId());
			System.out.println("Role"+rolemodel+" "+"resource "+resource);
			pmservice.addRoleToResource(resource, role);
			System.out.println("8");
			status.setCode(200);
			status.setMessage("role allocated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while allocating role with id :"+rolemodel.getRoleName()+" error :"+e);
			status.setCode(400);
			status.setMessage("role not allocated");
			e.printStackTrace();
		}
		return status;
	}
	
	@RequestMapping(value="/updateRole",method=RequestMethod.POST,headers="Accept=application/json")
	public Status updateRole(@RequestBody RoleModel rolemodel)
	{
		logger.warn("update role with name: "+rolemodel.getRoleName());
		Status status= new Status();
		
		try 
		{
			Role role=new Role();
			role.setRoleName(rolemodel.getRoleName());
			role.setRoleType(rolemodel.getRoleType());
			role.setStartDate(rolemodel.getStartDate());
			role.setEndDate(rolemodel.getEndDate());
			pmservice.updateRole(role);
			
			status.setCode(200);
			status.setMessage("role updated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while updating role with id :"+rolemodel.getRoleName()+" error :"+e);
			status.setCode(400);
			status.setMessage("role not updated");
			e.printStackTrace();
		}
		return status;
	}
	
	
	@RequestMapping(value="/removeRoleFromResource/{id}" ,headers="Accept=application/json",method=RequestMethod.DELETE)
	public Status removeRoleFromResource(@PathVariable("id")Integer id)
	{
		
		logger.warn("delete role with resource id : "+id);
		Status status=new Status();
		
		try 
		{
			Resource resource=new Resource();
			resource.setResourceId(id);
			System.out.println("delete role 1");
			pmservice.removeRoleFromResource(resource);
			System.out.println("delete role 5");
			status.setCode(200);
			status.setMessage("role deleted succesfully");
			
		} 
		catch (Exception e) 
		{
			logger.error("error occured while deleting role with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("role not deleted");
			e.printStackTrace();
			
		}
		return status;
	}
	
}
