
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * 
 * @author SENA ALÇI
 *class of refrigerated containers
 */
public class RefrigeratedContainer extends HeavyContainer {
	/**
	 * fuel consumption of container
	 */
	private double fuelConsumption = 5.00;
	/**
	* This constructs a refrigerated container with ID and weight
	 * @param ID of container
	 * @param weight of container
	 */
	public RefrigeratedContainer(int ID, int weight) {
		super(ID, weight);
	}
	
	
	/**
	 * Gets fuel consumption of refrigerated container
	 * @return fuelConsumption
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	/**
	 * Sets fuel consumption of refrigerated container
	 * @param fuelConsumption
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

