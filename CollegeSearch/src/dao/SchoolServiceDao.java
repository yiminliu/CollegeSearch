package dao;

import java.util.List;

import domain.School;

public interface SchoolServiceDao {

	public void store(School school);

	public void delete(Long schoolId);

	public School findById(Long schoolId);

	public List<School> findAll();

}
