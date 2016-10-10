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
public class ResourceDaoTest {
	
	@Autowired
	RsourceDaoImpl resourceDao;
	@Autowired
	
	TeamDaoImpl teamDao;
	
	@Autowired
     ProjectDaoImpl projectDao;
	
	@Test
	@Rollback(value=true)
	public void TestCreateResource() throws Exception{
		
		
		
		List<Role> roleList=new ArrayList<Role>();
		List<Project> projectList=projectDao.listProject();
		
		Team team=new Team();
		team.setTeamId(2);
		//roleList.add(e);
		
		
		Resource resource=new Resource("poojawadekar","active", roleList,projectList, teamDao.getTeamById(team));
	resourceDao.createResource(resource);
}
	 /*@Test
	@Rollback(value=true)
public void TestUpdateResource() throws Exception{
		List<Role> roleList=new ArrayList<Role>();
	List<Project> projectList=projectDao.listProject();	
		Team team=new Team();
	team.setTeamId(2);
		//roleList.add(e);
		
	
	Resource resource=new Resource("poojawadekar","inactive", roleList,projectList, teamDao.getTeamById(team));
	resourceDao.updateResource(resource);		
		
	}
*/
	/*throws error
	 * @Test
	@Rollback(value=true)
	public void TestDeleteResource() throws Exception{
		List<Role> roleList=new ArrayList<Role>();
		List<Project> projectList=projectDao.listProject();
		
		Team team=new Team();
		team.setTeamId(2);
		//roleList.add(e);
		
		
		Resource resource=new Resource("poojawadekar","active", roleList,projectList, teamDao.getTeamById(team));
	resourceDao.deleteResource(resource);
		
		
		
	}*/

	/*@Test
	@Rollback(value=true)
	public void TestListResources() throws Exception{
		
		List<Resource> resourceList=resourceDao.listResource();
		for (Resource resource : resourceList) {
			System.out.println(resource.toString());
		}
		
		
		
	}*/

	/*@Test
	@Rollback(value=true)
	public void TestGetResourceById() throws Exception{
		Resource resource=new Resource();
		resource.setResourceId(6);
		Resource resource1=resourceDao.getResource(resource);
		System.out.println(resource1.toString());
		List<Project> projectList=resource1.getProjects();
		//System.out.println(projectList);
		for (Project project : projectList) {
			System.out.println(project.getProjectName());
		}
		
		
		
	}
*/	

	
	
	
	
	
}
