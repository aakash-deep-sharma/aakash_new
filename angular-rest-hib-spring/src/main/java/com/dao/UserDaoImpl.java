package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.User;

@Repository
public class UserDaoImpl implements UserDao
{

	@Autowired
	private SessionFactory factory;
	@Override
	public String validate(User user)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", user.getUsername()));
		cr.add(Restrictions.eq("password", user.getPassword()));
		User user1 =(User) cr.uniqueResult();
		tx.commit();
		session.close();
		System.out.println("user" + user1);
		return user1.getRole();
		
		
	}
	
}
