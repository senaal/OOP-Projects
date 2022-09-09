package elements;
/**
 * 
 * @author SENA ALÇI
 *This class creates buying order object.
 */
public class BuyingOrder extends Order implements Comparable<BuyingOrder> {
	/**
	 * Buying order constructor with ID, amount and price.
	 * @param traderID
	 * @param amount
	 * @param price
	 */
	public BuyingOrder(int traderID, double amount, double price) {
		super(traderID, amount, price);
	}
	/**
	 *This method sorts buying objects in descending order.
	 */
	@Override
	public int compareTo(BuyingOrder e) {
		if(this.getPrice()==e.getPrice()) {
			if(this.getAmount()==e.getAmount()) {
				if(this.getTraderID() < e.getTraderID()) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else if(this.getAmount() < e.getAmount()) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if(this.getPrice() < e.getPrice()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
