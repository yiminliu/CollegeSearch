package service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.HibernateUtil;
import domain.School;

public class DeleteSchoolService {

	public DeleteSchoolService() {
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

		DeleteSchoolService us = (DeleteSchoolService) context
				.getBean("updateSchoolService");

		us.deleteSchoolByName("U Penn");
	}

	public void deleteSchoolByName(String schoolName) {
		Session session = null;
		Transaction tx, tx2 = null;
		School retrievedSchool;

		try {
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("select s from domain.School s where s.name = :name");
			query.setParameter("name", schoolName);
			retrievedSchool = (School) (query.list().get(0));

			session.delete(retrievedSchool);
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
