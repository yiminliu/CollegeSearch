package domain;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressTest extends TestCase {

	// private SessionFactory sf;
	Session session = null;
	Transaction tx = null;

	static Address address;

	protected void setUp() throws Exception {
		super.setUp();
		AllTests.setup();
		address = new Address();
		session = AllTests.sf.getCurrentSession();
		tx = session.beginTransaction();
		try {
			session.save(address);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
	}

	public void testSetStreetAddress() {
		String streetAddress = "3278 Spruce Street";
		assertNull(address.getStreetAddress());
		address.setStreetAddress(streetAddress);
		assertEquals(streetAddress, address.getStreetAddress());
		System.out.println("street = " + address.getStreetAddress());
	}

	public void testSetCity() {
		String streetAddress = "Philadelphia";
		assertNull(address.getCity());
		address.setCity(streetAddress);
		assertEquals(streetAddress, address.getCity());
	}

	public void testSetState() {
		String state = "Pennsylvina";
		assertNull(address.getState());
		address.setState(state);
		assertEquals(state, address.getState());
	}
}