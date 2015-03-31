package dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import domain.School;

public class HibernateSchoolServiceDao implements SchoolServiceDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void store(School school) {
		hibernateTemplate.saveOrUpdate(school);
	}

	@Transactional
	public void delete(Long schoolId) {
		School school = (School) hibernateTemplate.get(School.class, schoolId);
		hibernateTemplate.delete(school);
	}

	@Transactional(readOnly = true)
	public School findById(Long schoolId) {
		return (School) hibernateTemplate.get(School.class, schoolId);
	}

	@Transactional(readOnly = true)
	public List<School> findAll() {
		return hibernateTemplate.find("from Course");
	}

}
