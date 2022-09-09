package elements;
/**
 * 
 * @author SENA ALÇI
 * This class creates trader object in the economy. 
 */
public class Trader {
	private int id;
	private double dollars;
	private double coins;
	private Wallet wallet;
	public static int numberOfUsers = 0;
	/**
	 * Trader constructor with dollars and coins 
	 * @param dollars
	 * @param coins
	 */
	public Trader(double dollars, double coins) {
		this.id = id;
		this.dollars = dollars;
		this.coins = coins;
		wallet = new Wallet(dollars, coins);
	}

	/**
	 * This method checks seller's coins are enough for the transaction.
	 * @param amount
	 * @param price
	 * @param market
	 * @return
	 */
	public int sell(double amount, double price, Market market) {
		if(this.wallet.getCoins() >= amount) {
			SellingOrder sellingOrder = new SellingOrder(id, amount, price);
			market.giveSellOrder(sellingOrder);
			this.wallet.setBlockedCoins(this.wallet.getBlockedCoins()+amount);
			this.wallet.setCoins(this.wallet.getCoins()-amount);
			return 1;
		}
		else {
			Market.Numberofinvalids++;
			return 0;
		}
	}
	/**
	 * This method checks buyer's money is enough for transaction.
	 * @param amount
	 * @param price
	 * @param market
	 * @return
	 */
	public int buy(double amount, double price, Market market) {
		double n = amount*price;
		if (n <= getWallet().getDollars()) {
			BuyingOrder buyingOrder = new BuyingOrder(id, amount, price);
			market.giveBuyOrder(buyingOrder);
			this.wallet.setBlockedDollars(this.wallet.getBlockedDollars()+n);
			this.wallet.setDollars(this.wallet.getDollars()-n);
			return 1;
		}
		else {
			Market.Numberofinvalids++;
			return 0;
		}
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}
