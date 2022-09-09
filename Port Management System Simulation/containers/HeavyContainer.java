
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * 
 * @author SENA ALÇI
 *class of heavy containers
 */
public class HeavyContainer extends Container {
	/**
	 * fuel consumption of container
	 */
	private double fuelConsumption = 3.50;
	/**
	 * This constructs a heavy container with ID and weight
	 * @param ID of container
	 * @param weight of container
	 */
	public HeavyContainer(int ID, int weight) {
		super(ID, weight);		
	}
	
	
	/**
	 * Gets fuel consumption of heavy container
	 * @return fuelConsumption
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	/**
	 * Sets fuel consumption of heavy container
	 * @param fuelConsumption
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

