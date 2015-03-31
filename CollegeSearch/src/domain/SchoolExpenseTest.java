package domain;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class SchoolExpenseTest extends TestCase {

	private SessionFactory sf;
	Session session = null;
	Transaction tx = null;
	SchoolExpense expense;

	public SchoolExpenseTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		sf = HibernateUtil.getSessionFactory();
		expense = new SchoolExpense();
		session = sf.getCurrentSession();
		tx = session.beginTransaction();
		try {
			session.save(expense);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSchoolExpense() {
		// int String streetAddress = "3278 Spruce Street";
		// assertNull(address.getStreetAddress());
		// address.setStreetAddress(streetAddress);
		// assertEquals(streetAddress, address.getStreetAddress());

	}

	public void testSetAndGetTuitionAndFee() {
		int tf = 100;
		assertEquals(0, 0, 0);
		expense.setTuitionAndFee(tf);
		assertEquals(tf, expense.getTuitionAndFee(), 0);
	}

	public void testSetAndGetRoomAndBoard() {
		int rb = 100;
		assertEquals(0, 0, 0);
		expense.setRoomAndBoard(rb);
		assertEquals(rb, expense.getRoomAndBoard(), 0);
	}

	/*
	 * public void testSetApplicationFee() { fail("Not yet implemented"); }
	 * 
	 * public void testSetTotalCost() { fail("Not yet implemented"); }
	 * 
	 * public void testGetTotalCost() { fail("Not yet implemented"); }
	 * 
	 * public void testGetApplicationFee() { fail("Not yet implemented"); }
	 */
}
