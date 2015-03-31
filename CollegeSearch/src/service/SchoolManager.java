package service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Address;
import domain.School;
import domain.SchoolExpense;
import domain.SchoolFact;

import util.HibernateUtil;

public class SchoolManager {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {
		SchoolManager bs = new SchoolManager();
		Long schoolId = bs.createSchool();
		// School aSchool = bs.getSchool(schoolId);
		// List<School> schools = bs.getSchools();
		List<School> schools = bs.getSchoolsByUserParameter("state", "PA");
		// bs.displaySchool(aSchool);
		for (Iterator it = (Iterator) schools.iterator(); it.hasNext();) {
			bs.displaySchool((School) it.next());
			// System.out.println(it.next());
		}
	}

	public Long createSchool() {

		Session session = null;
		Transaction tx = null;
		Long schoolId = null;

		School aSchool = new School();
		aSchool.setName("University of Pennsylvinia");
		aSchool.setWebsite("upenn.edu");

		Address address = new Address();
		// address.setAddressId(new Random().nextLong());
		address.setStreetAddress("3278 Spruce Street");
		address.setCity("Philadelphia");
		address.setState("PA");
		address.setZipCode("19104");

		aSchool.setSchoolAddress(address);

		// aSchool.setStreetAddress("3278 Spruce Street");
		// aSchool.setCity("Philadelphia");
		// aSchool.setState("PA");
		// aSchool.setZipCode("19104");
		SchoolExpense expense = new SchoolExpense();
		expense.setTuitionAndFee(20000);
		expense.setRoomAndBoard(10000);
		// aSchool.setExpense(expense);

		SchoolFact fact = new SchoolFact();
		fact.setAcademicCalendar("Semester");
		fact.setAcceptRate(20);
		// fact.setApplicationDeadline(new Date("09-01"));
		fact.setCategory("general");
		fact.setFacultyStudentRatio(6);
		fact.setInternationalAid("yes");
		fact.setSetting("Urban");
		fact.setType("Public");

		// aSchool.setSchoolFact(fact);

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

		return aSchool;
	}

	public List<School> getAllSchools() {
		Session session = null;
		Transaction tx = null;
		List<School> schools = null;
		String queryString = "select s from beans.School s order by s.overallRank";

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			// Query query = session.createSQLQuery(queryString).addEntity(
			// School.class);

			// query.setTimeout(10);
			// query.setReadOnly(true);
			// query.setCacheable(true);

			schools = session.createQuery(queryString).list();

			// System.out.println("query = " + query);
			// schools = query.list();

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
		String queryString = "select s from beans.School s order by s.overallRank asc";

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			// Query query = session.createSQLQuery(queryString).addEntity(
			// School.class);

			Query query = session.createQuery(queryString);
			query.setTimeout(30);
			query.setReadOnly(true);
			query.setCacheable(true);
			query.setMaxResults(numOfTop);

			// schools = session.createQuery(queryString).list();

			// System.out.println("query = " + query);
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
	}
}
