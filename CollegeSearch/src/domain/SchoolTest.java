package domain;

import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class SchoolTest extends TestCase {

	static final String name = "University of Pessylvinia";

	private SessionFactory sf;
	Session session = null;
	Transaction tx = null;
	private School aSchool = new School();
	Address address;
	SchoolExpense expense;
	SchoolFact fact = new SchoolFact();

	public SchoolTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {

		// address = AddressTest.address;
		address = new Address();
		address.setAddressId(new Random().nextLong());
		address.setStreetAddress("3278 Spruce Street");
		address.setCity("Philadelphia");
		address.setState("Pennsylvinia");
		address.setZipCode("19104");

		// aSchool.setAddress(address);

		expense = new SchoolExpense();
		expense.setTuitionAndFee(20000);
		expense.setRoomAndBoard(10000);
		// aSchool.setExpense(expense);

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
	}

	/*
	 * session = sf.getCurrentSession();
	 * 
	 * tx = session.beginTransaction(); try { session.save(aSchool);
	 * tx.commit(); } catch (HibernateException he) { he.printStackTrace();
	 * tx.rollback(); } }
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	// public void testSchool() {
	// assertNotNull(aSchool);
	// }

	public void testCreateSchool() {

		session = sf.getCurrentSession();
		tx = session.beginTransaction();

		aSchool.setName("U of Penn");
		aSchool.setSchoolAddress(address);
		aSchool.setSchoolFact(fact);
		aSchool.setSchoolExpense(expense);

		Long schoolId;
		School s = null;

		try {
			schoolId = (Long) session.save(aSchool);
			s = (School) session.get(School.class, schoolId);

			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
		assertNotNull(s);
	}

	public void testGetSchools() {
		Session session = null;
		Transaction tx = null;
		List<School> schools = null;
		String queryString = "select s.* from School s order by s.name asc";

		try {
			session = sf.getCurrentSession();
			tx = session.beginTransaction();

			// schools = session.createQuery(queryString).list();
			Query q = session.createSQLQuery(queryString).addEntity(
					School.class);
			schools = q.list();
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}

		System.out.println("Number of schools: " + schools.size());
		for (School s : schools) {
			System.out.println("school name: " + s.getName());
		}
	}

	// public void testGetSchoolId() {
	// / assertNotNull(aSchool.getSchoolId());
	// }

	/*
	 * public void testSetAndGetName() {
	 * 
	 * assertNull(aSchool.getName()); aSchool.setName(name); assertNotNull(name,
	 * aSchool.getName()); }
	 */
	// public void testSetWebsite() {
	// fail("Not yet implemented");
	// }

	// public void testGetWebsite() {
	// fail("Not yet implemented");
	// }
	/*
	 * public void testSetAddress() { assertNotNull(aSchool.getAddress()); }
	 * 
	 * public void testGetAddress() { assertNotNull(aSchool.getAddress()); }
	 * 
	 * public void testSetAdminContact() { fail("Not yet implemented"); }
	 * 
	 * public void testGetAdminContact() { fail("Not yet implemented"); }
	 * 
	 * public void testSetSchoolFact() { fail("Not yet implemented"); }
	 * 
	 * public void testGetSchoolFact() { fail("Not yet implemented"); }
	 * 
	 * public void testSetStudentBody() { fail("Not yet implemented"); }
	 * 
	 * public void testGetStudentBody() { fail("Not yet implemented"); }
	 * 
	 * public void testSetBestMajors() { fail("Not yet implemented"); }
	 * 
	 * public void testGetBestMajors() { fail("Not yet implemented"); }
	 * 
	 * public void testSetExpense() { fail("Not yet implemented"); }
	 * 
	 * public void testGetExpense() { fail("Not yet implemented"); }
	 * 
	 * public void testSetRank() { fail("Not yet implemented"); }
	 * 
	 * public void testGetRank() { fail("Not yet implemented"); }
	 * 
	 * public void testSetLastModified() { fail("Not yet implemented"); }
	 * 
	 * public void testGetLastModified() { fail("Not yet implemented"); }
	 * 
	 * public void testSetRequirement() { fail("Not yet implemented"); }
	 * 
	 * public void testGetRequirement() { fail("Not yet implemented"); }
	 * 
	 * public void testEqualsObject() { fail("Not yet implemented"); }
	 */
	void displaySchool(School s) {
		System.out.println("name =" + s.getName());

	}
}
