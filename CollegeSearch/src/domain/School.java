package domain;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class School {

	private Long schoolId;
	private String name;
	private Set<String> alternativeNames;
	private String website;
	private Date lastModified;

	private Set<BestMajors> bestMajors = new HashSet<BestMajors>();

	private Address schoolAddress;
	private Contact schoolContact;
	private SchoolExpense schoolExpense;
	private SchoolFact schoolFact;
	private SchoolRank schoolRank;
	private SchoolRequirement schoolRequirement;
	private SchoolStudentBody schoolStudentBody;

	/**
	 * @param schoolId
	 *            the schoolId to set
	 */
	private void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * @return the schoolId
	 */
	public Long getSchoolId() {
		return schoolId;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * @param name
	 *            the name to set
	 */
	public void setSchoolAddress(Address schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	/**
	 * @return the name
	 */
	public Address getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolExpense(SchoolExpense schoolExpense) {
		this.schoolExpense = schoolExpense;
	}

	public SchoolExpense getSchoolExpense() {
		return schoolExpense;
	}

	public void setSchoolFact(SchoolFact schoolFact) {
		this.schoolFact = schoolFact;
	}

	public SchoolFact getSchoolFact() {
		return schoolFact;
	}

	public void setSchoolRank(SchoolRank schoolRank) {
		this.schoolRank = schoolRank;
	}

	public SchoolRank getSchoolRank() {
		return schoolRank;
	}

	public SchoolRequirement getSchoolRequirement() {
		return schoolRequirement;
	}

	public void setSchoolRequirement(SchoolRequirement schoolRequirement) {
		this.schoolRequirement = schoolRequirement;
	}

	public Contact getSchoolContact() {
		return schoolContact;
	}

	public void setSchoolContact(Contact schoolContact) {
		this.schoolContact = schoolContact;
	}

	public SchoolStudentBody getSchoolStudentBody() {
		return schoolStudentBody;
	}

	public void setSchoolStudentBody(SchoolStudentBody schoolStudentBody) {
		this.schoolStudentBody = schoolStudentBody;
	}

	/**
	 * @return the bestMajors
	 */
	public Set<BestMajors> getBestMajors() {
		return bestMajors;
	}

	/**
	 * @param bestMajors
	 *            the bestMajors to set
	 */
	public void setBestMajors(Set<BestMajors> bestMajors) {
		this.bestMajors = bestMajors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	class SchoolComparator implements Comparator {
		public int compare(Object obj1, Object obj2) {
			School s1 = (School) obj1;
			School s2 = (School) obj2;
			int s1Rank = s1.getSchoolRank().getOverallRank();
			int s2Rank = s2.getSchoolRank().getOverallRank();

			if (s1Rank == s2Rank)
				return 0;
			else
				return (s1Rank > s2Rank ? 1 : -1);

		}
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", website="
				+ website + ", lastModified=" + lastModified + ", bestMajors="
				+ bestMajors + ", schoolAddress=" + schoolAddress
				+ ", schoolContact=" + schoolContact + ", schoolExpense="
				+ schoolExpense + ", schoolFact=" + schoolFact
				+ ", schoolRank=" + schoolRank + ", schoolRequirement="
				+ schoolRequirement + ", schoolStudentBody="
				+ schoolStudentBody + "]";
	}

	public Set<String> getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(Set<String> alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

}
