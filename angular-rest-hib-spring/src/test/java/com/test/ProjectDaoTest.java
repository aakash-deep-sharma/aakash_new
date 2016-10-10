package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProjectDaoImpl;
import com.dao.RsourceDaoImpl;
import com.dao.TeamDaoImpl;
import com.model.Project;
import com.model.Resource;
import com.model.Role;
import com.model.Team;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-servlet-test.xml")
@Transactional
public class ProjectDaoTest {
@Autowired
ProjectDaoImpl projectDao;
@Autowired
TeamDaoImpl teamDao;
@Autowired
RsourceDaoImpl resourceDao;

@Test
@Rollback(value=true)
public void TestCreateproject() throws Exception{
	List<Role> roleList=new ArrayList<Role>();
	List<Project> projectList=new ArrayList<Project>();
	
	Team team=new Team();
	team.setTeamId(2);
	
	
	Resource resource=new Resource("psw","active", roleList,projectList, teamDao.getTeamById(team));
resourceDao.createResource(resource);

Project project=new Project();
project.setProjectId(2);
	project.setProjectName("testproject11");
	//project.setResource(resource);
	project.setTeam(team);

	projectDao.createProject(project);


}

/*@Test
@Rollback(value=true)
public void TestUpdateProject() throws Exception{
	List<Role> roleList=new ArrayList<Role>();
	List<Project> projectList=new ArrayList<Project>();
	
	Team team=new Team();
	team.setTeamId(2);
	

	Resource resource=new Resource("w","active", roleList,projectList, teamDao.getTeamById(team));
resourceDao.createResource(resource);

	Project project=new Project();
	project.setProjectId(2);
	project.setProjectName("testproject22");
	project.setResource(resource);
	project.setTeam(team);

	projectDao.updateProject(project);
}
*/
/*@Test
@Rollback(value=true)
public void TestDeleteTeam() throws Exception{
	List<Role> roleList=new ArrayList<Role>();
	List<Project> projectList=new ArrayList<Project>();
	
	Team team=new Team();
	team.setTeamId(2);
	

	Resource resource=new Resource("w","active", roleList,projectList, teamDao.getTeamById(team));
resourceDao.createResource(resource);

	Project project=new Project();
	project.setProjectId(2);
	project.setProjectName("testproject22");
	project.setResource(resource);
	project.setTeam(team);

	projectDao.deleteProject(project);

	
	
	
}
*/


 /* @Test
@Rollback(value=true)
public void TestListProjects() throws Exception{
	
	List<Project> projectList=projectDao.listProject();
	for (Project project : projectList) {
		System.out.println(project.getProjectName());
	}
	
	
	
}*/

/*@Test
@Rollback(value=true)
public void TestGetProjectById() throws Exception{
	Project project=new Project();
	project.setProjectId(2);
	Project project1= projectDao.getProjectById(project);
	System.out.println(project1.getProjectId()+" "+project1.getProjectName()+" "+project1.getResource().getResourceName()+" "+project1.getTeam().getTeamName());
	
	
	
}*/



}
