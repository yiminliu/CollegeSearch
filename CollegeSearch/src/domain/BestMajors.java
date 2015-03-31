package domain;

import java.util.HashSet;
import java.util.Set;

public class BestMajors {

	private int majorId;
	private String majorName;
	private int majorRank;

	private Set<BestMajorSchools> bestMajoredSchools = new HashSet<BestMajorSchools>();

	BestMajors() {
	}

	public int getMajorId() {
		return majorId;
	}

	private void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorRank(int majorRank) {
		this.majorRank = majorRank;
	}

	public int getMajorRank() {
		return majorRank;
	}

	public Set<BestMajorSchools> getBestMajorSchools() {
		return bestMajoredSchools;
	}

	public void setBestMajorSchools(Set<BestMajorSchools> bestMajoredSchools) {
		this.bestMajoredSchools = bestMajoredSchools;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((majorName == null) ? 0 : majorName.hashCode());
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
		BestMajors other = (BestMajors) obj;
		if (majorName == null) {
			if (other.majorName != null)
				return false;
		} else if (!majorName.equals(other.majorName))
			return false;
		return true;
	}

	// public void addABestSchool(School aSchool) {
	// bestMajorSchools.add(aSchool);
	// aSchool.getBestMajorSchools().add(this);
	// }

}
