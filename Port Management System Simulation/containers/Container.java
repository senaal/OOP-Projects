
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

import ports.Port;
/**
 * 
 * @author SENA ALÇI
 * class of containers
 */
public abstract class Container {
	/**
	 * ID of container
	 */
	private int ID;
	/**
	 * weight of container
	 */
	private int weight;
	/**
	 * port of container
	 */
	private Port port;
	/**
	 * This constructs a container with ID and weight
	 * @param ID of container
	 * @param weight of container
	 */
	public Container(int ID, int weight) {
		this.ID = ID;
		this.weight = weight;
		this.port = port;
	}

	/**
	 * Calculates consumption per km for containers
	 * @return consumption per km for containers
	 */
	public double consumption() {
		if (this instanceof BasicContainer) {
			return this.weight*(double)2.50;
		}
		else if (this instanceof LiquidContainer) {
			return this.weight*(double)4.00;
		}
		else if (this instanceof RefrigeratedContainer) {
			return this.weight*(double)5.00;
		}
		else if (this instanceof HeavyContainer) {
			return this.weight*(double)3.00;
		}
		else {
			return 0;
		}
		
	}
		
	/**
	 * Checks container's ID and weight 
	 * @param other container
	 * @return true-false
	 */
	public boolean equals(Container other) {
		if (ID==other.ID) {
			if (weight==other.weight) {
				if(this.getClass()==other.getClass()) {
					return true;
				}
			}
			
		}
		return false;
	
	}


	
	/**
	 * Gets ID of container
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Sets ID of container
	 * @param iD
	 */
	
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Gets weight of container
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * Sets weight of container
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * Gets port of container
	 * @return port
	 */
	public Port getPort() {
		return port;
	}
	/**
	 * Sets port of container
	 * @param port
	 */
	public void setPort(Port port) {
		this.port = port;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

