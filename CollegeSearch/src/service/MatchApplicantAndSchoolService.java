package service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.HibernateUtil;
import domain.School;

public class MatchApplicantAndSchoolService {

	public MatchApplicantAndSchoolService() {
	}

	private School school = new School();

	public void setSchool(School school) {
		this.school = school;
	}

	public School getSchool() {
		return school;
	}

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		// ApplicationContext context = new FileSystemXmlApplicationContext(
		// "/school.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/service/school.xml");

		MatchApplicantAndSchoolService retrieveSchoolService = (MatchApplicantAndSchoolService) context
				.getBean("retrieveSchoolService");

		// List<School> schools = retrieveSchoolService.getAllSchools();
		List<School> schools = retrieveSchoolService.getTopSchools(20);
		// School aSchool = createSchoolService.getSchool(schoolId);
		// List<School> schools = bs.getSchools();
		// List<School> schools = bs.getSchoolsByUserParameter("state", "PA");
		// bs.displaySchool(aSchool);
		for (Iterator it = (Iterator) schools.iterator(); it.hasNext();) {
			retrieveSchoolService.displaySchool((School) it.next());
			// System.out.println(it.next());
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

	public List<School> getAllSchools() {
		Session session = null;
		Transaction tx = null;
		List<School> schools = null;
		// String queryString = "select s.* from beans.School s";
		String queryString = "from beans.School s order by s.name asc";

		Query query = null;

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			query = session.createQuery(queryString);
			// query =
			// session.createSQLQuery(queryString).addEntity(School.class);

			query.setTimeout(10);
			// query.setReadOnly(true);
			query.setCacheable(true);

			System.out.println("query = " + query.getQueryString());

			if (query != null)
				schools = query.list();
			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			throw he;
		}

		return schools;
	}

	public List<School> getTopSchools(int numOfTop) {
		Session session = null;
		Transaction tx = null;
		List<School> schools = null;
		String queryString = "select s.name, s.schoolAddress from beans.School s, beans.Address a "
				// + "where s.schoolAddress.addressId = a.addressId "
				+ "order by s.schoolRank.overallRank asc";

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			Query query = session.createSQLQuery(queryString).addEntity("s",
					School.class);

			// Query query = session.createQuery(queryString);

			query.setTimeout(30);
			query.setReadOnly(true);
			query.setCacheable(true);
			query.setMaxResults(numOfTop);

			schools = query.list();

			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			throw he;
		}

		return schools;
	}

	public List<School> getSchoolsByUserParameter(String column, String data) {
		Session session = null;
		Transaction tx = null;
		List<School> schools = null;

		String columnName = "s." + column;
		String queryString = "select s from beans.School s where " + columnName
				+ " = :data order by s.overallRank asc";

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			// Query query = session.createSQLQuery(queryString).addEntity(
			// School.class);

			Query query = session.createQuery(queryString);
			query.setParameter("data", data);

			query.setTimeout(10);
			query.setReadOnly(true);
			query.setCacheable(true);

			// schools = session1.createQuery(queryString).list();

			System.out.println("query = " + query);
			schools = query.list();

			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			throw he;
		}

		return schools;
	}

	public void displaySchool(School aSchool) {

		System.out.println("School name= " + aSchool.getName());
		System.out.println("City = " + aSchool.getSchoolAddress().getCity());
	}
}
