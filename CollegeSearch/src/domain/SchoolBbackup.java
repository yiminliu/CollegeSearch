package domain;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SchoolBbackup {

	private Long schoolId;
	private String name, type, category, setting;
	private String streetAddress, city, state, zipCode, location, country;
	private String phoneNumber, emailAddress;
	private int tuitionAndFee, roomAndBoard, appplicationFee, totalCost;
	private int toefl, sat1Min, sat1Up, numOfSat2, numOfRecomLetter;
	private int overallRank, selectivityRank, reputationScore, acceptRate,
			facultyStudentRatio;
	private String academicCalendar, internationalAid, website;
	private int numOfStudents, foreignPercent, asianPercent;
	private Date lastModified, applicationDeadline;
	private Set<Long> bestMajors = new HashSet<Long>();

	/**
	 * @return the schoolId
	 */
	public Long getSchoolId() {
		return schoolId;
	}

	/**
	 * @param schoolId
	 *            the schoolId to set
	 */
	private void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the setting
	 */
	public String getSetting() {
		return setting;
	}

	/**
	 * @param setting
	 *            the setting to set
	 */
	public void setSetting(String setting) {
		this.setting = setting;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress
	 *            the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the tuitionFee
	 */
	public int getTuitionAndFee() {
		return tuitionAndFee;
	}

	/**
	 * @param tuitionFee
	 *            the tuitionFee to set
	 */
	public void setTuitionAndFee(int tuitionAndFee) {
		this.tuitionAndFee = tuitionAndFee;
	}

	/**
	 * @return the roomAndBoard
	 */
	public int getroomAndBoard() {
		return roomAndBoard;
	}

	/**
	 * @param roomAndBoard
	 *            the roomAndBoard to set
	 */
	public void setroomAndBoard(int roomAndBoard) {
		this.roomAndBoard = roomAndBoard;
	}

	/**
	 * @return the appplicationFee
	 */
	public int getAppplicationFee() {
		return appplicationFee;
	}

	/**
	 * @param appplicationFee
	 *            the appplicationFee to set
	 */
	public void setAppplicationFee(int appplicationFee) {
		this.appplicationFee = appplicationFee;
	}

	/**
	 * @return the totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the toefl
	 */
	public int getToefl() {
		return toefl;
	}

	/**
	 * @param toefl
	 *            the toefl to set
	 */
	public void setToefl(int toefl) {
		this.toefl = toefl;
	}

	/**
	 * @return the sat1Min
	 */
	public int getSat1Min() {
		return sat1Min;
	}

	/**
	 * @param sat1Min
	 *            the sat1Min to set
	 */
	public void setSat1Min(int sat1Min) {
		this.sat1Min = sat1Min;
	}

	/**
	 * @return the sat1Up
	 */
	public int getSat1Up() {
		return sat1Up;
	}

	/**
	 * @param sat1Up
	 *            the sat1Up to set
	 */
	public void setSat1Up(int sat1Up) {
		this.sat1Up = sat1Up;
	}

	/**
	 * @return the numOfSat2
	 */
	public int getNumOfSat2() {
		return numOfSat2;
	}

	/**
	 * @param numOfSat2
	 *            the numOfSat2 to set
	 */
	public void setNumOfSat2(int numOfSat2) {
		this.numOfSat2 = numOfSat2;
	}

	/**
	 * @return the numOfRecomLetter
	 */
	public int getNumOfRecomLetter() {
		return numOfRecomLetter;
	}

	/**
	 * @param numOfRecomLetter
	 *            the numOfRecomLetter to set
	 */
	public void setNumOfRecomLetter(int numOfRecomLetter) {
		this.numOfRecomLetter = numOfRecomLetter;
	}

	/**
	 * @return the overallRank
	 */
	public int getoverallRank() {
		return overallRank;
	}

	/**
	 * @param overallRank
	 *            the overallRank to set
	 */
	public void setoverallRank(int overallRank) {
		this.overallRank = overallRank;
	}

	/**
	 * @return the selectivityRank
	 */
	public int getSelectivityRank() {
		return selectivityRank;
	}

	/**
	 * @param selectivityRank
	 *            the selectivityRank to set
	 */
	public void setSelectivityRank(int selectivityRank) {
		this.selectivityRank = selectivityRank;
	}

	/**
	 * @return the reputationScore
	 */
	public int getReputationScore() {
		return reputationScore;
	}

	/**
	 * @param reputationScore
	 *            the reputationScore to set
	 */
	public void setReputationScore(int reputationScore) {
		this.reputationScore = reputationScore;
	}

	/**
	 * @return the acceptRate
	 */
	public int getAcceptRate() {
		return acceptRate;
	}

	/**
	 * @param acceptRate
	 *            the acceptRate to set
	 */
	public void setAcceptRate(int acceptRate) {
		this.acceptRate = acceptRate;
	}

	/**
	 * @return the facultyStudentRatio
	 */
	public int getFacultyStudentRatio() {
		return facultyStudentRatio;
	}

	/**
	 * @param facultyStudentRatio
	 *            the facultyStudentRatio to set
	 */
	public void setFacultyStudentRatio(int facultyStudentRatio) {
		this.facultyStudentRatio = facultyStudentRatio;
	}

	/**
	 * @return the academicCalendar
	 */
	public String getAcademicCalendar() {
		return academicCalendar;
	}

	/**
	 * @param academicCalendar
	 *            the academicCalendar to set
	 */
	public void setAcademicCalendar(String academicCalendar) {
		this.academicCalendar = academicCalendar;
	}

	/**
	 * @return the internationalAid
	 */
	public String getInternationalAid() {
		return internationalAid;
	}

	/**
	 * @param internationalAid
	 *            the internationalAid to set
	 */
	public void setInternationalAid(String internationalAid) {
		this.internationalAid = internationalAid;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the numberOfStudents
	 */
	public int getNumOfStudents() {
		return numOfStudents;
	}

	/**
	 * @param numberOfStudents
	 *            the numberOfStudents to set
	 */
	public void setNumOfStudents(int numberOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	/**
	 * @return the foriegnPercent
	 */
	public int getForeignPercent() {
		return foreignPercent;
	}

	/**
	 * @param foriegnPercent
	 *            the foriegnPercent to set
	 */
	public void setForeignPercent(int foreignPercent) {
		this.foreignPercent = foreignPercent;
	}

	/**
	 * @return the asianPercent
	 */
	public int getAsianPercent() {
		return asianPercent;
	}

	/**
	 * @param asianPercent
	 *            the asianPercent to set
	 */
	public void setAsianPercent(int asianPercent) {
		this.asianPercent = asianPercent;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the applicationDeadLine
	 */
	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	/**
	 * @param applicationDeadLine
	 *            the applicationDeadLine to set
	 */
	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	/**
	 * @return the bestMajors
	 */
	public Set<Long> getBestMajors() {
		return bestMajors;
	}

	/**
	 * @param bestMajors
	 *            the bestMajors to set
	 */
	public void setBestMajors(Set<Long> bestMajors) {
		this.bestMajors = bestMajors;
	}

	// need to implement hashCode() and equals() methods
	// because Schools are added to a Set as the savedSchool in
	// Applicant
	public int hashCode() {
		int result = 17;
		result = result * 37 + schoolId.intValue();
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SchoolBbackup))
			return false;
		SchoolBbackup school = (SchoolBbackup) obj;
		return schoolId == school.getSchoolId();
	}

	class SchoolComparator implements Comparator {
		public int compare(Object obj1, Object obj2) {
			SchoolBbackup s1 = (SchoolBbackup) obj1;
			SchoolBbackup s2 = (SchoolBbackup) obj2;
			int s1Rank = s1.getoverallRank();
			int s2Rank = s2.getoverallRank();

			if (s1Rank == s2Rank)
				return 0;
			else
				return (s1Rank > s2Rank ? 1 : -1);

		}
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", type="
				+ type + ", category=" + category + ", setting=" + setting
				+ ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", location="
				+ location + ", country=" + country + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress
				+ ", tuitionAndFee=" + tuitionAndFee + ", roomAndBoard="
				+ roomAndBoard + ", appplicationFee=" + appplicationFee
				+ ", totalCost=" + totalCost + ", toefl=" + toefl
				+ ", sat1Min=" + sat1Min + ", sat1Up=" + sat1Up
				+ ", numOfSat2=" + numOfSat2 + ", numOfRecomLetter="
				+ numOfRecomLetter + ", overallRank=" + overallRank
				+ ", selectivityRank=" + selectivityRank + ", reputationScore="
				+ reputationScore + ", acceptRate=" + acceptRate
				+ ", facultyStudentRatio=" + facultyStudentRatio
				+ ", academicCalendar=" + academicCalendar
				+ ", internationalAid=" + internationalAid + ", website="
				+ website + ", numOfStudents=" + numOfStudents
				+ ", foreignPercent=" + foreignPercent + ", asianPercent="
				+ asianPercent + ", lastModified=" + lastModified
				+ ", applicationDeadline=" + applicationDeadline
				+ ", bestMajors=" + bestMajors + "]";
	}

}
