package com.studentManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService{
	
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory)
	{
		try {
			this.sessionFactory=sessionFactory;
			session=sessionFactory.getCurrentSession();
		}
		catch(HibernateException e)
		{
			session=sessionFactory.openSession();
		}
	}
	
	@Override
	public List<Student> findAll() {
		List<Student> students=session.createQuery("from Student").list();
		return students;
	}
	
	@Override
	@Transactional
	public Student findById(int id) {
		Transaction tx=session.beginTransaction();
		Student student=session.get(Student.class,id);
		tx.commit();
		return student;
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Transaction tx=session.beginTransaction();
		Student student=session.get(Student.class,id);
		session.delete(student);
		tx.commit();
	}

}
