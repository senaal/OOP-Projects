package elements;

import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 * 
 * @author SENA ALÇI
 * This class calculates market actions.
 */
public class Market {
	private static int fee;
	private PriorityQueue<SellingOrder> sellingOrders;
	private PriorityQueue<BuyingOrder> buyingOrders;
	private ArrayList<Transaction> transactions;
	public static int Numberofinvalids;
	/**	Market constructor with market fee
	 * @param fee
	 */
	public Market(int fee) {
		Market.setFee(fee);
		sellingOrders = new PriorityQueue<SellingOrder>();
		buyingOrders = new PriorityQueue<BuyingOrder>();
		transactions = new ArrayList<Transaction>();
	}
	/**
	 * This method adds selling order to selling orders' array
	 * @param order
	 */
	public void giveSellOrder(SellingOrder order) {
		sellingOrders.add(order);
	}
	/**
	 * This method adds buying order to buying orders' array
	 * @param order
	 */
	public void giveBuyOrder(BuyingOrder order) {
		buyingOrders.add(order);
	}
	/**
	 * This method regulates market price.
	 * @param price
	 * @param traders
	 */
	public void makeOpenMarketOperation(double price, ArrayList<Trader> traders) {
			while(sellingOrders.isEmpty()==false && sellingOrders.peek().getPrice()<=price) {
				BuyingOrder buyingOrder = new BuyingOrder(0, sellingOrders.peek().getAmount(), sellingOrders.peek().getPrice());
				giveBuyOrder(buyingOrder);
				checkTransactions(traders);
			}
			while(buyingOrders.isEmpty()==false && buyingOrders.peek().getPrice()>=price) {
				SellingOrder sellingOrder = new SellingOrder(0, buyingOrders.peek().getAmount(), buyingOrders.peek().getPrice());
				giveSellOrder(sellingOrder);
				checkTransactions(traders);
			}
	}
	/**
	 * This method checks transactions and sets traders' coins and dollars.
	 * @param traders
	 */
	public void checkTransactions(ArrayList<Trader> traders) {
		if(buyingOrders.isEmpty()==false && sellingOrders.isEmpty()==false){
			while(buyingOrders.isEmpty()==false && sellingOrders.isEmpty()==false && buyingOrders.peek().getPrice() >= sellingOrders.peek().getPrice()) {
				Transaction transaction = new Transaction(sellingOrders.peek(),buyingOrders.peek());
				transactions.add(transaction);
			if(buyingOrders.peek().getPrice() == sellingOrders.peek().getPrice()) {
				if(buyingOrders.peek().getAmount() == sellingOrders.peek().getAmount()) {
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setBlockedDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice()));
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setCoins(traders.get(buyingOrders.peek().getTraderID()).getWallet().getCoins()+buyingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setBlockedCoins(traders.get(sellingOrders.peek().getTraderID()).getWallet().getBlockedCoins()-sellingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setDollars((traders.get(sellingOrders.peek().getTraderID()).getWallet().getDollars()) +((sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice())*(1.0-((double)Market.getFee()/1000.0))));
					buyingOrders.poll();
					sellingOrders.poll();
				}
				else if (buyingOrders.peek().getAmount() < sellingOrders.peek().getAmount()) {
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setBlockedDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(buyingOrders.peek().getAmount()*sellingOrders.peek().getPrice()));
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setCoins(traders.get(buyingOrders.peek().getTraderID()).getWallet().getCoins()+buyingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setBlockedCoins(traders.get(sellingOrders.peek().getTraderID()).getWallet().getBlockedCoins()-buyingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setDollars((traders.get(sellingOrders.peek().getTraderID()).getWallet().getDollars())+ ((buyingOrders.peek().getAmount()*buyingOrders.peek().getPrice())*(1.0-((double)Market.getFee()/1000.0))));
					sellingOrders.peek().setAmount(sellingOrders.peek().getAmount()-buyingOrders.peek().getAmount());
					buyingOrders.poll();
				}
				else if (buyingOrders.peek().getAmount() > sellingOrders.peek().getAmount()) {
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setBlockedDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice()));
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setCoins(traders.get(buyingOrders.peek().getTraderID()).getWallet().getCoins()+sellingOrders.peek().getAmount());
					buyingOrders.peek().setAmount(buyingOrders.peek().getAmount()-sellingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setBlockedCoins(traders.get(sellingOrders.peek().getTraderID()).getWallet().getBlockedCoins()-sellingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setDollars((traders.get(sellingOrders.peek().getTraderID()).getWallet().getDollars())+ ((sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice())*(1.0-((double)Market.getFee()/1000.0))));
					sellingOrders.poll();
				}
			}
			else if(buyingOrders.peek().getPrice() > sellingOrders.peek().getPrice()) {
				if(buyingOrders.peek().getAmount() == sellingOrders.peek().getAmount()) {
					double a = traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice());
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setBlockedDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(sellingOrders.peek().getPrice()*sellingOrders.peek().getAmount())-a);
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setCoins(traders.get(buyingOrders.peek().getTraderID()).getWallet().getCoins()+buyingOrders.peek().getAmount());
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getDollars()+a);
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setBlockedCoins(traders.get(sellingOrders.peek().getTraderID()).getWallet().getBlockedCoins()-buyingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setDollars((traders.get(sellingOrders.peek().getTraderID()).getWallet().getDollars())+((sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice())*(1.0-((double)Market.getFee()/1000.0))));
					buyingOrders.poll();
					sellingOrders.poll();
					}
				else if (buyingOrders.peek().getAmount() < sellingOrders.peek().getAmount()) {
					double a = traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(buyingOrders.peek().getAmount()*sellingOrders.peek().getPrice());
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setBlockedDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(sellingOrders.peek().getPrice()*buyingOrders.peek().getAmount())-a);
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setCoins(traders.get(buyingOrders.peek().getTraderID()).getWallet().getCoins()+buyingOrders.peek().getAmount());
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getDollars()+a);
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setBlockedCoins(traders.get(sellingOrders.peek().getTraderID()).getWallet().getBlockedCoins()-buyingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setDollars((traders.get(sellingOrders.peek().getTraderID()).getWallet().getDollars())+ ((buyingOrders.peek().getAmount()*sellingOrders.peek().getPrice())*(1.0-((double)Market.getFee()/1000.0))));
					sellingOrders.peek().setAmount(sellingOrders.peek().getAmount()-buyingOrders.peek().getAmount());
					buyingOrders.poll();
					}
				else if (buyingOrders.peek().getAmount() > sellingOrders.peek().getAmount()) {
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setBlockedDollars(traders.get(buyingOrders.peek().getTraderID()).getWallet().getBlockedDollars()-(sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice()));
					traders.get(buyingOrders.peek().getTraderID()).getWallet().setCoins(traders.get(buyingOrders.peek().getTraderID()).getWallet().getCoins()+sellingOrders.peek().getAmount());
					buyingOrders.peek().setAmount(buyingOrders.peek().getAmount()-sellingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setBlockedCoins(traders.get(sellingOrders.peek().getTraderID()).getWallet().getBlockedCoins()-sellingOrders.peek().getAmount());
					traders.get(sellingOrders.peek().getTraderID()).getWallet().setDollars((traders.get(sellingOrders.peek().getTraderID()).getWallet().getDollars())+ ((sellingOrders.peek().getAmount()*sellingOrders.peek().getPrice())*(1.0-((double)Market.getFee()/1000.0))));
					sellingOrders.poll();
				}
			}
		}
	}
		else {
			return;
		}
}

	public PriorityQueue<SellingOrder> getSellingOrders() {
		return sellingOrders;
	}

	public void setSellingOrders(PriorityQueue<SellingOrder> sellingOrders) {
		this.sellingOrders = sellingOrders;
	}

	public PriorityQueue<BuyingOrder> getBuyingOrders() {
		return buyingOrders;
	}

	public void setBuyingOrders(PriorityQueue<BuyingOrder> buyingOrders) {
		this.buyingOrders = buyingOrders;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public static int getFee() {
		return fee;
	}

	public static void setFee(int fee) {
		Market.fee = fee;
	}

	
	
}
