package domain;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SchoolOld {

	private Long schoolId;

	private String name, website;

	private Address address;

	private Contact adminContact;

	private SchoolExpense expense;

	private SchoolRank rank;

	private SchoolFact schoolFact;

	private SchoolRequirement requirement;

	private SchoolStudentBody studentBody;

	private Set<Long> bestMajors = new HashSet<Long>();

	private Date lastModified;

	public SchoolOld() {
	}

	private void setSchoolId(Long id) {
		this.schoolId = id;
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite() {
		return website;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAdminContact(Contact adminContact) {
		this.adminContact = adminContact;
	}

	public Contact getAdminContact() {
		return adminContact;
	}

	public void setSchoolFact(SchoolFact schoolFact) {
		this.schoolFact = schoolFact;
	}

	public SchoolFact getSchoolFact() {
		return schoolFact;
	}

	public void setStudentBody(SchoolStudentBody studentBody) {
		this.studentBody = studentBody;
	}

	public SchoolStudentBody getStudentBody() {
		return studentBody;
	}

	public void setBestMajors(Set<Long> bestMajors) {
		this.bestMajors = bestMajors;
	}

	public Set<Long> getBestMajors() {
		return bestMajors;
	}

	public void setExpense(SchoolExpense expens) {
		this.expense = expense;
	}

	public SchoolExpense getExpense() {
		return expense;
	}

	public void setRank(SchoolRank rank) {
		this.rank = rank;
	}

	public SchoolRank getRank() {
		return rank;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setRequirement(SchoolRequirement requiremen) {
		requiremen = requirement;
	}

	public SchoolRequirement getRequirement() {
		return requirement;
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
		if (!(obj instanceof SchoolOld))
			return false;
		SchoolOld school = (SchoolOld) obj;
		return schoolId == school.getSchoolId();
	}

	class SchoolComparator implements Comparator {
		public int compare(Object obj1, Object obj2) {
			SchoolOld s1 = (SchoolOld) obj1;
			SchoolOld s2 = (SchoolOld) obj2;
			int s1Rank = s1.getRank().getOverallRank();
			int s2Rank = s2.getRank().getOverallRank();

			if (s1Rank == s2Rank)
				return 0;
			else
				return (s1Rank > s2Rank ? 1 : -1);

		}

	}
}
