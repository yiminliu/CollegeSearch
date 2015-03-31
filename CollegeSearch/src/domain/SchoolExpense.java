package domain;

public class SchoolExpense {

	private long schoolExpenseId;
	private int tuitionAndFee, roomAndBoard, applicationFee, totalCost;

	public SchoolExpense() {
	}

	private void setSchoolExpenseId(long schoolExpenseId) {
		this.schoolExpenseId = schoolExpenseId;
	}

	public long getSchoolExpenseId() {
		return schoolExpenseId;
	}

	public void setTuitionAndFee(int tuitionAndFee) {
		this.tuitionAndFee = tuitionAndFee;
	}

	public int getTuitionAndFee() {
		return tuitionAndFee;
	}

	public void setRoomAndBoard(int roomAndBoard) {
		this.roomAndBoard = roomAndBoard;
	}

	public int getRoomAndBoard() {
		return roomAndBoard;
	}

	private void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setApplicationFee(int applicationFee) {
		this.applicationFee = applicationFee;
	}

	public int getApplicationFee() {
		return applicationFee;
	}
}
