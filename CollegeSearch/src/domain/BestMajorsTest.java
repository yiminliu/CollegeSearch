package domain;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class BestMajorsTest extends TestCase {

	private BestMajors bestmajors;

	private SessionFactory sf;
	Session session = null;
	Transaction tx = null;

	protected void setUp() throws Exception {
		bestmajors = new BestMajors();
		sf = HibernateUtil.getSessionFactory();
		session = sf.getCurrentSession();
		tx = session.beginTransaction();
		try {
			session.save(bestmajors);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
	}

	public void testSetBestmajors() {
		String majorName = "Accounting";
		assertNull(bestmajors.getMajorName());
		bestmajors.setMajorName(majorName);
		assertEquals(majorName, bestmajors.getMajorName());
	}
	/*
	 * public void testGetBestSchools() { // String streetbestmajors =
	 * "Philadelphia"; // assertNull(bestmajors.getCity());
	 * System.out.println("num of School = " +
	 * bestmajors.getBestSchools().size()); for (Iterator it =
	 * bestmajors.getBestSchools().iterator(); it.hasNext();) {
	 * System.out.println("School Id = " + it.next()); }
	 * assertNotNull(bestmajors.getBestSchools());
	 * 
	 * }
	 */
}