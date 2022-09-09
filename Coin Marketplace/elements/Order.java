package elements;
/**
 * 
 * @author SENA ALÇI
 *This class creates order object and it has two child classes.
 */
public class Order {
	private double amount;
	private double price;
	private int traderID;
	/**
	 * Order constructor with ID, amount and price.
	 * @param traderID
	 * @param amount
	 * @param price
	 */
	public Order(int traderID, double amount, double price) {
		this.setTraderID(traderID);
		this.setAmount(amount);
		this.setPrice(price);
	}
	public int getTraderID() {
		return traderID;
	}
	public void setTraderID(int traderID) {
		this.traderID = traderID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}

