package service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import util.HibernateUtil;
import domain.School;

public class RetrieveSchoolService {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public RetrieveSchoolService() {
	}

	// private School school = new School();

	private List<School> schools = null;

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<School> getSchools() {
		return schools;
	}

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/service/school.xml");
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "/service/school.xml");

		RetrieveSchoolService retrieveSchoolService = (RetrieveSchoolService) context
				.getBean("retrieveSchoolService");
		School s = retrieveSchoolService.getSchoolByName("U Penn");
		System.out.println("retrieved: " + s.getName());
		// List<School> schools = retrieveSchoolService.getAllSchools();
		// List<School> schools = retrieveSchoolService.getTopSchools(20);
		// for (Iterator it = (Iterator) schools.iterator(); it.hasNext();) {
		// retrieveSchoolService.displaySchool((School) it.next());
		// System.out.println(it.next());
		// }
	}

	public School getSchoolById(Long schoolId) {
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

	public School getSchoolByName(String schoolName) {
		Session session = null;
		Transaction tx = null;
		School aSchool = null;
		Query query = null;
		String queryString = "select s.* from School s where s.name = :name order by s.Rank_Overall asc";

		try {
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			query = session.createSQLQuery(queryString).addEntity(School.class);

			query.setParameter("name", schoolName);
			// query.setMaxResults(1);
			List list = query.list();

			if (list != null && list.size() >= 1)
				aSchool = (School) query.list().get(0);
			logger.debug("query: " + query.getQueryString());
			if (aSchool != null)
				logger.debug("after retrive  school = " + aSchool.getName());
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
		// String queryString = "select s.* from beans.School s";
		String queryString = "select s.* from School s order by s.Rank_Overall asc";

		Query query = null;

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			// query = session.createQuery(queryString);
			query = session.createSQLQuery(queryString).addEntity(School.class);

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

	public List<School> getTopSchools(int rank) {

		logger.info("RetrieveSchoolService.getTopSchools(): rank =" + rank);
		Session session = null;
		Transaction tx = null;
		String queryString = "select s.* from School s where s.Rank_Overall <= :rank "
				+ "order by s.Rank_Overall asc";

		try {
			session = sf.getCurrentSession();

			tx = session.beginTransaction();

			Query query = session.createSQLQuery(queryString).addEntity("s",
					School.class);

			// Query query = session.createQuery(queryString);

			query.setParameter("rank", rank);
			System.out.println("RetrieveSchoolService: rank set: " + rank);
			query.setTimeout(30);
			query.setReadOnly(true);
			query.setCacheable(true);
			// query.setMaxResults(numOfTop);

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

		String columnName = "s." + column;
		String queryString = "select s from domain.School s where "
				+ columnName + " = :data order by s.overallRank asc";

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
		System.out.println("School tuition and fee= "
				+ aSchool.getSchoolExpense().getTuitionAndFee());
		System.out.println("School total expense= "
				+ aSchool.getSchoolExpense().getTotalCost());

	}
}
