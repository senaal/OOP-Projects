package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
	
	private int totalTalking;
	private int totalMessage;
	private double totalNetwork;
	
	public Customer(int _ID, String _name, int _age, double limit, Operator _operator) {

		ID = _ID;
		name = _name;
		age = _age;
		operator = _operator;
		bill = new Bill(limit);

		totalTalking = 0;
		totalMessage = 0;
		totalNetwork = 0;
	}
	public void talk(int minute, Customer other) {
		double cost = operator.calculateTalkingCost(minute, this);
		if(bill.check(cost)) {		
			bill.add(cost);
			operator.addTotalTalking(minute);
			totalTalking += minute;
			other.addTotalTalking(minute);
			other.getOperator().addTotalTalking(minute);
		}
	}
	public void message(int quantity, Customer other) {
		double cost = operator.calculateMessageCost(quantity,this,other);
		if (bill.check(cost)) {
			bill.add(cost);
			operator.addTotalMessage(quantity);
			totalMessage += quantity;
		}
	}

	public void connection(double amount) {
		double cost = operator.calculateNetworkCost(amount);
		if (bill.check(cost)) {
			bill.add(cost);
			operator.addTotalNetwork(amount);
			totalNetwork += amount;
		}
	}
	public void changeOperator(Operator newOperator) {
		this.operator = newOperator;
	}
	public int getAge() {
		return age;
	}
	public Operator getOperator() {
		return operator;
	}
	public Bill getBill() {
		return bill;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getID() {
		return ID;
	}
	public void addTotalTalking(int time) {
		totalTalking += time;
	}
	public int getTotalTalking() {
		return totalTalking;
	}
	public int getTotalMessage() {
		return totalMessage;
	}
	public double getTotalNetwork() {
		return totalNetwork;
	}
	public String getName() {
		return name;
	}
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}
