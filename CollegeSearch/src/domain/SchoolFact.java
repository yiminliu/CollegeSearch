package domain;

import java.util.Date;

public class SchoolFact {

	private String type, setting, category, academicCalendar, internationalAid;
	private int id, acceptRate, facultyStudentRatio;
	private Date applicationDeadline;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}

	public String getSetting() {
		return setting;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setAcceptRate(int acceptRate) {
		this.acceptRate = acceptRate;
	}

	public int getAcceptRate() {
		return acceptRate;
	}

	public void setInternationalAid(String internationalAid) {
		this.internationalAid = internationalAid;
	}

	public String getInternationalAid() {
		return internationalAid;
	}

	public void setAcademicCalendar(String calendar) {
		this.academicCalendar = academicCalendar;
	}

	public String getAcademicCalendar() {
		return academicCalendar;
	}

	public void setFacultyStudentRatio(int facultyStudentRatio) {
		this.facultyStudentRatio = facultyStudentRatio;
	}

	public int getFacultyStudentRatio() {
		return facultyStudentRatio;
	}

	public int getId() {
		return id;
	}

}
