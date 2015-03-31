package domain;

public class BestMajorSchools {

	private BestMajors bestMajor;
	private School school;
	private int majorRank;

	BestMajorSchools(BestMajors bestMajor, School school, int majorRank) {
		this.bestMajor = bestMajor;
		this.school = school;
		this.majorRank = majorRank;
	}

	public BestMajors getBestMajor() {
		return bestMajor;
	}

	public void setBestMajor(BestMajors bestMajor) {
		this.bestMajor = bestMajor;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getMajorRank() {
		return majorRank;
	}

	public void setMajorRank(int majorRank) {
		this.majorRank = majorRank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bestMajor == null) ? 0 : bestMajor.hashCode());
		result = prime * result + majorRank;
		result = prime * result + ((school == null) ? 0 : school.hashCode());
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
		BestMajorSchools other = (BestMajorSchools) obj;
		if (bestMajor == null) {
			if (other.bestMajor != null)
				return false;
		} else if (!bestMajor.equals(other.bestMajor))
			return false;
		if (majorRank != other.majorRank)
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		return true;
	}

}
