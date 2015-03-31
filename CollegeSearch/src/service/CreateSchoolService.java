package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.HibernateUtil;
import domain.School;

public class CreateSchoolService {

	public CreateSchoolService() {
	}

	private School school = new School();
	private List<School> schools = new ArrayList<School>();

	public void setSchool(School school) {
		this.school = school;
	}

	public School getSchool() {
		return school;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<School> getSchools() {
		return schools;
	}

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		// ApplicationContext context = new FileSystemXmlApplicationContext(
		// "/school.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/service/school.xml");

		CreateSchoolService createSchoolService = (CreateSchoolService) context
				.getBean("createSchoolService");

		// Long schoolId = createSchoolService.createSchool();
		// School aSchool = createSchoolService.getSchool(schoolId);
		createSchoolService.createSchools();
	}

	public Long createSchool() {

		Session session = null;
		Transaction tx = null;
		Long schoolId = null;

		sf = HibernateUtil.getSessionFactory();
		session = sf.getCurrentSession();
		tx = session.beginTransaction();
		try {
			schoolId = (Long) session.save(school);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}

		return schoolId;
	}

	public Long createSchool(School aSchool) {

		Session session = null;
		Transaction tx = null;
		Long schoolId = null;

		sf = HibernateUtil.getSessionFactory();
		session = sf.getCurrentSession();
		tx = session.beginTransaction();
		try {
			schoolId = (Long) session.save(aSchool);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}

		return schoolId;
	}

	public void createSchools() {

		Session session = null;
		Transaction tx = null;

		session = sf.getCurrentSession();
		tx = session.beginTransaction();
		try {
			for (School s : schools) {
				session.save(s);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public School getSchool(Long schoolId) {
		Session session = null;
		Transaction tx = null;
		School aSchool;

		try {
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			aSchool = (School) session.get(School.class, schoolId);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}
		System.out.println("school name: " + aSchool.getName());
		return aSchool;
	}

	public void displaySchool(School aSchool) {

		System.out.println("School name= " + aSchool.getName());
	}
}
