package elements;
/**
 * 
 * @author SENA ALÇI
 *This class creates selling order object.
 */
public class SellingOrder extends Order implements Comparable<SellingOrder> {
	/**
	 * Selling order constructor with ID, amount and price.
	 * @param traderID
	 * @param amount
	 * @param price
	 */
	public SellingOrder(int traderID, double amount, double price) {
		super(traderID, amount, price);

	}
	/**
	 * This method rows selling orders in ascending order.
	 */
	@Override
	public int compareTo(SellingOrder e) {
		if(this.getPrice()==e.getPrice()) {
			if(this.getAmount()==e.getAmount()) {
				if(this.getTraderID() > e.getTraderID()) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else if(this.getAmount() > e.getAmount()) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if(this.getPrice() > e.getPrice()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
