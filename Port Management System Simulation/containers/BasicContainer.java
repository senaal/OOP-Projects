
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * 
 * @author SENA ALÇI
 *class of basic containers
 */
public class BasicContainer extends Container {
	/**
	 * fuel consumption of container
	 */
	private double fuelConsumption = 2.50;
	/**
	 * This constructs a basic container with ID and weight
	 * @param ID of container
	 * @param weight of container
	 */
	public BasicContainer(int ID, int weight) {
		super(ID, weight);
		}

	
	
	/**
	 * Gets fuel consumption of basic container
	 * @return fuelConsumption
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	/**
	 * Sets fuel consumption of basic container
	 * @param fuelConsumption
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

