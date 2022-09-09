package executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import elements.Market;
import elements.Trader;
/**
 * 
 * @author SENA ALÇI
 * This class takes inputs and gives outputs, and regulates economic transactions. 
 */
public class Main {
	public static Random myRandom; 
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		int seed = in.nextInt();
		myRandom = new Random(seed);
	int B,C,D;
	B = in.nextInt();
	C = in.nextInt();
	D = in.nextInt();
	ArrayList<Trader> traders = new ArrayList<Trader>();
	Market market = new Market(B);
	
	for (int i=0;i<C && in.hasNextLine();i++) {
		double dollar = in.nextDouble();
		double PQoin = in.nextDouble();
		Trader trader = new Trader(dollar, PQoin);
		trader.setId(Trader.numberOfUsers);
		traders.add(trader);
		Trader.numberOfUsers++;
	}
	for (int i=0;i<D && in.hasNextLine();i++) {
		int query = in.nextInt();
		if(query==10) {
			int id = in.nextInt();
			double price = in.nextDouble();
			double amount = in.nextDouble();
			if(traders.get(id).buy(amount, price, market) == 1) {
				market.checkTransactions(traders);
				}
			}
		else if(query==11) { 
			int id = in.nextInt();
			double amount = in.nextDouble();
			if(market.getSellingOrders().isEmpty()==false){
				if(traders.get(id).buy(amount, market.getSellingOrders().peek().getPrice(), market) == 1) {
					market.checkTransactions(traders);
						}
					}
			else {
				Market.Numberofinvalids++;
					}
			}
		else if(query==20) {
			int id = in.nextInt();
			double price = in.nextDouble();
			double amount = in.nextDouble();
			if (traders.get(id).sell(amount, price, market) == 1) {
				market.checkTransactions(traders);
				}
			}
		else if(query==21) {
			int id = in.nextInt();
			double amount = in.nextDouble();
			if(market.getBuyingOrders().isEmpty()==false) {
			if(traders.get(id).sell(amount, market.getBuyingOrders().peek().getPrice(), market) == 1) {
				market.checkTransactions(traders);
					}
				}
			else {
				Market.Numberofinvalids++;
				}
			}
		else if(query==3) {
			int id = in.nextInt();
			double amount = in.nextDouble();
			traders.get(id).getWallet().setDollars(traders.get(id).getWallet().getDollars()+amount);
			}
		else if(query==4) {
			int id = in.nextInt();
			double amount = in.nextDouble();
			if (traders.get(id).getWallet().getDollars()>=amount) {
				traders.get(id).getWallet().setDollars(traders.get(id).getWallet().getDollars()-amount);
			}
			else {
				Market.Numberofinvalids++;
			}
			}
		else if(query==5) {
			int id = in.nextInt();
			out.println("Trader "+traders.get(id).getId()+": "+String.format("%.5f", (traders.get(id).getWallet().getDollars()+traders.get(id).getWallet().getBlockedDollars()))+"$ "+String.format("%.5f", (traders.get(id).getWallet().getCoins()+traders.get(id).getWallet().getBlockedCoins()))+"PQ");
			}
		else if(query==777) {
			for (int z=0;z<C ;z++) {
				double t = myRandom.nextDouble()*10;
				traders.get(z).getWallet().setCoins(traders.get(z).getWallet().getCoins()+t);
				}
			}
		else if(query==666) {
			double price = in.nextDouble();
			market.makeOpenMarketOperation(price, traders);
			}
		else if(query==500) {
			double totdol = 0;
			double totPQ = 0;
			for (int z=1; z<C; z++) {
				totdol += traders.get(z).getWallet().getBlockedDollars();
				totPQ += traders.get(z).getWallet().getBlockedCoins();
			}
			out.println("Current market size: " +String.format("%.5f",totdol)+ " "+String.format("%.5f",totPQ));
			}
		else if(query==501) {
			out.println("Number of successful transactions: "+market.getTransactions().size());
			}
		else if(query==502) {
			out.println("Number of invalid queries: "+Market.Numberofinvalids);
			}
		else if(query==505) {
			if(market.getBuyingOrders().isEmpty()==false && market.getSellingOrders().isEmpty()==false) {
			out.println("Current prices: "+String.format("%.5f",market.getBuyingOrders().peek().getPrice())+" "+String.format("%.5f",market.getSellingOrders().peek().getPrice())+" "+String.format("%.5f",((market.getBuyingOrders().peek().getPrice())+market.getSellingOrders().peek().getPrice())/2));
				}
			if(market.getBuyingOrders().isEmpty()==true && market.getSellingOrders().isEmpty()==true) {
				out.println("Current prices: "+"0.00000"+" "+"0.00000"+" "+"0.00000");
					}
			else if(market.getBuyingOrders().isEmpty()==true) {
				out.println("Current prices: "+"0.0000"+" "+String.format("%.5f",market.getSellingOrders().peek().getPrice())+" "+String.format("%.5f",market.getSellingOrders().peek().getPrice()));
					}
			else if(market.getSellingOrders().isEmpty()==true) {
				out.println("Current prices: "+String.format("%.5f",market.getBuyingOrders().peek().getPrice())+" "+"0.00000"+" "+String.format("%.5f",market.getBuyingOrders().peek().getPrice()));
					}
			}
		else if(query==555) {
			for (int z=0;z<C ;z++) {
				out.println("Trader "+traders.get(z).getId()+": "+String.format("%.5f", (traders.get(z).getWallet().getDollars()+traders.get(z).getWallet().getBlockedDollars()))+"$ "+String.format("%.5f", (traders.get(z).getWallet().getCoins()+traders.get(z).getWallet().getBlockedCoins()))+"PQ");
				}
			}

		}
	}
}

