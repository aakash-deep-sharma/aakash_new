package com.test;

import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RoleDaoImpl;
import com.dao.RsourceDaoImpl;
import com.model.Resource;
import com.model.Role;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-servlet-test.xml")
@Transactional
public class RoleDaoTest {

@Autowired
RsourceDaoImpl resourceDao;

@Autowired
RoleDaoImpl roleDao;

/*@Test
@Rollback(value=true)
public void TestCreateRole() throws Exception{
		Resource resource1=new Resource();
	resource1.setResourceId(6);

	Resource resource=resourceDao.getResource(resource1);
	Role role=new Role();
	role.setRoleId(1);
	role.setRoleName("dev");
	role.setRoleType("core");
	role.setStartDate(new Date());
	role.setEndDate(new Date());
	role.setResource(resource);
	
	roleDao.createRole(role);


}
*/
/*@Test
@Rollback(value=true)
public void TestUpdateProject() throws Exception{
	
	Resource resource1=new Resource();
	resource1.setResourceId(6);

	Resource resource=resourceDao.getResource(resource1);
	Role role=new Role();
	role.setRoleId(1);
	role.setRoleName("QA");
	role.setRoleType("sudo");
	role.setStartDate(new Date());
	role.setEndDate(new Date());
	role.setResource(resource);
	roleDao.updateRole(role);
	
	

	
}
*/

@Test
@Rollback(value=true)
public void TestDeleteTeam() throws Exception{
		
	Resource resource1=new Resource();
	resource1.setResourceId(6);

	Resource resource=resourceDao.getResource(resource1);
	Role role=new Role();
	role.setRoleId(1);
	role.setRoleName("QA");
	role.setRoleType("sudo");
	role.setStartDate(new Date());
	role.setEndDate(new Date());
	role.setResource(resource);
	
	roleDao.deleteRole(resource);

	
}



 


}
