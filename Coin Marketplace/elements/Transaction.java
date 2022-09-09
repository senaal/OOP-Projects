package elements;
/**
 * 
 * @author SENA ALÇI
 *This class creates transaction object.
 */
public class Transaction {
	private SellingOrder sellingOrder;
	private BuyingOrder buyingOrder;
	/**
	 * Transaction constructor with selling order object and buying order object.
	 * @param sellingOrder
	 * @param buyingOrder
	 */
	public Transaction(SellingOrder sellingOrder, BuyingOrder buyingOrder) {
		this.sellingOrder = sellingOrder;
		this.buyingOrder = buyingOrder;
	}

}
