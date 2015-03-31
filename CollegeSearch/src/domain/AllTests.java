package domain;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class AllTests {

	static SessionFactory sf;
	static Address address;

	public static void setup() {
		sf = HibernateUtil.getSessionFactory();
		address = new Address();
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());

		// $JUnit-BEGIN$
		suite.addTestSuite(BestMajorsTest.class);
		suite.addTestSuite(AddressTest.class);
		// suite.addTestSuite(SchoolExpenseTest.class);
		suite.addTestSuite(SchoolTest.class);
		// $JUnit-END$
		return suite;
	}

}
