package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	//	private int ID;
	//	private int customerID;
	private double limitingAmount;
	private double currentDebt;

	private double totalPaid;

	public Bill(double limitingAmount) {
		//		this.ID = ID;
		//		this.customerID = customerID;
		this.limitingAmount = limitingAmount;
		this.currentDebt = 0;
		totalPaid = 0;
	}

	public boolean check(double amount) {
		return currentDebt + amount <= limitingAmount;
	}
	public void add(double amount) {
		currentDebt += amount;
	}
	public void pay(double amount) {
		currentDebt -= amount;
		totalPaid += amount;
	}
	public void changeTheLimit(double amount) {
		limitingAmount = amount;
	}
	public void setLimitingAmount(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}
	public double getLimitingAmount() {
		return limitingAmount;
	}
	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
	}
	public double getTotalPaid() {
		return totalPaid;
	}
	public double getCurrentDebt() {
		return currentDebt;
	}
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}
