
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * 
 * @author SENA AL�I
 *class of liquid containers
 */
public class LiquidContainer extends HeavyContainer {
	/**
	 * fuel consumption of container
	 */
	private double fuelConsumption = 4.00;
	/**
	 * This constructs a liquid container with ID and weight
	 * @param ID of container
	 * @param weight of container
	 */
	public LiquidContainer(int ID, int weight) {
		super(ID, weight);
	}
	
	
	/**
	 * Gets fuel consumption of liquid container
	 * @return fuelConsumption
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	/**
	 * Sets fuel consumption of liquid container
	 * @param fuelConsumption
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

