package com.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeamDaoImpl;
import com.model.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-servlet-test.xml")
@Transactional
public class TeamDaoTest {
@Autowired
TeamDaoImpl teamDao;

@Test
@Rollback(value=true)
public void TestCreateTeam() throws Exception{
	Team team= new Team();
	team.setTeamId(1);
	team.setTeamName("abc");
	team.setTeamStatus("active");
	team.setStartDate(new Date());
	team.setEndDate(new Date());
	teamDao.createTeam(team);
	
	
	
}

/*@Test
@Rollback(value=true)
public void TestUpdateTeam() throws Exception{
	Team team= new Team();
	team.setTeamId(1);
	team.setTeamName("pqr");
	team.setTeamStatus("active");
	team.setStartDate(new Date());
	team.setEndDate(new Date());
	teamDao.updateTeam(team);
	
	
	
}*/

/*@Test
@Rollback(value=true)
public void TestDeleteTeam() throws Exception{
	Team team= new Team();
	team.setTeamId(1);
	team.setTeamName("pqr");
	team.setTeamStatus("active");
	team.setStartDate(new Date());
	team.setEndDate(new Date());
	teamDao.deleteTeam(team);
	
	
	
}*/

/*@Test
@Rollback(value=true)
public void TestListTeams() throws Exception{
	
	List<Team> teamList=teamDao.listTeam();
	for (Team team : teamList) {
		System.out.println(team.toString());
		
	}
	
	
	
}*/

/*@Test
@Rollback(value=true)
public void TestGetTeamById() throws Exception{
	Team team1=new Team();
	team1.setTeamId(2);
	Team team= teamDao.getTeamById(team1);
	System.out.println(team.toString());
	
	
	
}
*/


}
