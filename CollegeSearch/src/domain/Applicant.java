package domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Applicant {

	private int applicantId;
	private String userName, password, firstName, lastName;
	private Date dateOfBirth;
	private String billingMethod;

	private Set<String> emailAddresses = new HashSet<String>();
	private Set<Address> addresses = new HashSet<Address>();
	private SortedSet<School> savedSchools = new TreeSet<School>();
	private Set<TestingScore> scores = new HashSet<TestingScore>();

	public Applicant() {
	}

	public int getApplicantId() {
		return applicantId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<String> getEmailAddresses() {
		return emailAddresses;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Set<Address> getAddress() {
		return addresses;
	}

	public Set getSavedSchools() {
		return savedSchools;
	}

	public String getBillingMethod() {
		return billingMethod;
	}

	private void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddresses(Set<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public void setSavedSchools(SortedSet savedSchools) {
		this.savedSchools = savedSchools;
	}

	public void setBillingmethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}
}
