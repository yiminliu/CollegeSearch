package domain;

public class TestingScore {

	private long id;

	private int toefl, sat1Min, sat1Up, sat2;

	public TestingScore() {
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setToefl(int toefl) {
		this.toefl = toefl;
	}

	public int getToefl() {
		return toefl;
	}

	public void setSat1Min(int sat1Min) {
		this.sat1Min = sat1Min;
	}

	public int getSat1Min() {
		return sat1Min;
	}

	public void setSat1Up(int sat1Up) {
		this.sat1Up = sat1Up;
	}

	public int getSat1Up() {
		return sat1Up;
	}

	public void setSat2(int sat2) {
		this.sat2 = sat2;
	}

	public int getSat2() {
		return sat2;
	}
}
