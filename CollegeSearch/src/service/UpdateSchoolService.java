package service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.HibernateUtil;
import domain.BestMajors;
import domain.School;

public class UpdateSchoolService {

	public UpdateSchoolService() {
	}

	/*
	 * private School school = new School(); private Contact schoolContact = new
	 * Contact(); private Address schoolAddress = new Address(); private
	 * SchoolExpense schoolExpense = new SchoolExpense(); private SchoolFact
	 * schoolFact = new SchoolFact(); private SchoolRank schoolRank = new
	 * SchoolRank(); private SchoolRequirement schoolRequirement = new
	 * SchoolRequirement(); private SchoolStudentBody schoolStudentBody = new
	 * SchoolStudentBody();
	 */
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/service/school.xml");

		UpdateSchoolService us = (UpdateSchoolService) context
				.getBean("updateSchoolService");

		School s = new School();
		s.setName("U Penn");
		s.setWebsite("upenn.edu");
		us.updateSchool(s);
	}

	public void updateSchool(School newSchool) {
		Session session = null;
		Transaction tx, tx2 = null;
		School retrievedSchool;

		try {
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("select s from domain.School s where s.name = :name");
			query.setParameter("name", newSchool.getName());
			retrievedSchool = (School) (query.list().get(0));
			System.out.println("retrievedSchool name = "
					+ retrievedSchool.getName());
			System.out.println("retrievedSchool website = "
					+ retrievedSchool.getWebsite());

			// retrievedSchool.s = newSchool;
			retrievedSchool.setWebsite("upenn.edu");
			session.update(retrievedSchool);
			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}
	}

	public void addBestMajorToSchool(School school, BestMajors major) {
		Session session = null;
		Transaction tx = null;
		School retrievedSchool = null;
		Set bestMajors = null;
		retrievedSchool.getBestMajors();

		try {
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			retrievedSchool = (School) session.get(School.class,
					school.getName());
			bestMajors = retrievedSchool.getBestMajors();
			if (bestMajors == null)
				bestMajors = new HashSet<BestMajors>();

			bestMajors.add(major);
			retrievedSchool.setBestMajors(bestMajors);
			session.update(retrievedSchool);

			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}
	}

	public void displaySchool(School aSchool) {

		System.out.println("School name= " + aSchool.getName());
	}
}
