package com.example;

import mebitechDemo.daos.DepartmentDao;
import mebitechDemo.daos.EmployeeDao;
import mebitechDemo.daos.MeetingsDao;
import mebitechDemo.models.Department;
import mebitechDemo.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Derya Othan
 * @version 0.0.1
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	MeetingsDao meetingsDao;

	@Test
	public void contextLoads() {
		Employee employee = new Employee("derya","othan",12.00);

		Department department = new Department("yazılım" , employee , "arge");
		Department department2 = new Department("yazılım2" , employee , "arge2");
		departmentDao.save(department);
		departmentDao.save(department2);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.save(department);
		session.save(department2);
		session.update(department);
		session.delete(department2);

		session.beginTransaction().commit();
		session.close();

	}

}
