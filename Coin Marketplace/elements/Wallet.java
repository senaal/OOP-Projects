package elements;
/**
 * 
 * @author SENA ALÇI
 *This class creates wallet object for each trader.
 */
public class Wallet {
	private double dollars;
	private double coins;
	private double blockedDollars;
	private double blockedCoins;
	/**
	 * Wallet constructor with trader's dollars and trader's coins.
	 * @param dollars
	 * @param coins
	 */
	public Wallet(double dollars, double coins) {
		this.dollars=dollars;
		this.coins=coins;
		this.blockedDollars=blockedDollars;
		this.blockedCoins=blockedCoins;
	}
	
	
	public double getDollars() {
		return dollars;
	}
	public void setDollars(double dollars) {
		this.dollars = dollars;
	}
	public double getCoins() {
		return coins;
	}
	public void setCoins(double coins) {
		this.coins = coins;
	}
	public double getBlockedDollars() {
		return blockedDollars;
	}
	public void setBlockedDollars(double blockedDollars) {
		this.blockedDollars = blockedDollars;
	}
	public double getBlockedCoins() {
		return blockedCoins;
	}
	public void setBlockedCoins(double blockedCoins) {
		this.blockedCoins = blockedCoins;
	}
}
