package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	
	private int totalTalking;
	private int totalMessage;
	private double totalNetwork;
	
	public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		totalTalking = 0;
		totalMessage = 0;
		totalNetwork = 0;
	}
	
	public double calculateTalkingCost(int minute, Customer customer) {
		double discount = 0;
		if (customer.getAge()<18 || customer.getAge()>65) { 
			discount = 1.0*discountRate/100.0;
		}
		return talkingCharge*minute*(1-discount);
	}
	double calculateMessageCost(int quantity, Customer customer, Customer other) {
		double discount = 0;
		if(this.ID == other.getOperator().getID()) {
			discount = 1.0*discountRate/100.0;
		}
		return messageCost*quantity*(1-discount);
	}
	double calculateNetworkCost(double amount) {
		return networkCharge*amount;
	}
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	public double getTalkingCharge() {
		return talkingCharge;
	}
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	public double getMessageCost() {
		return messageCost;
	}
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	public double getNetworkCharge() {
		return networkCharge;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	
	public void addTotalMessage(int totalMessage) {
		this.totalMessage += totalMessage;
	}
	public void addTotalNetwork(double totalNetwork) {
		this.totalNetwork += totalNetwork;
	}
	public void addTotalTalking(int totalTalking) {
		this.totalTalking += totalTalking;
	}
	public int getTotalMessage() {
		return totalMessage;
	}
	
	public double getTotalNetwork() {
		return totalNetwork;
	}
	public int getTotalTalking() {
		return totalTalking;
	}
	public int getID() {
		return ID;
	}
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}
