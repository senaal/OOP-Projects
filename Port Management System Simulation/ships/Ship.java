
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package ships;
import java.util.ArrayList;
import containers.BasicContainer;
import containers.Container;
import containers.HeavyContainer;
import containers.LiquidContainer;
import containers.RefrigeratedContainer;
import interfaces.IShip;
import ports.Port;
/**
 * 
 * @author SENA ALÇI
 * class of ships
 */
public class Ship implements IShip {
	/**
	 * ID of ship
	 */
	private int ID;
	/**
	 * fuel of ship
	 */
	private double fuel;
	/**
	 * port of ship
	 */
	private Port currentPort;
	/**
	 * weight capacity of ship
	 */
	private int totalWeightCapacity;
	/**
	 * max number of all containers of ship
	 */
	private int maxNumberOfAllContainers;
	/**
	 * max number of heavy containers of ship
	 */
	private int maxNumberOfHeavyContainers;
	/**
	 * max number of refrigerated containers of ship
	 */
	private int maxNumberOfRefrigeratedContainers;
	/**
	 * max number of liquid containers of ship
	 */
	private int maxNumberOfLiquidContainers;
	/**
	 * fuel consumption per km of ship
	 */
	private double fuelConsumptionPerKM;
	/**
	 * limit of cuurent weight
	 */
	public int currentWeight;
	/**
	 * limit of max containers
	 */
	private int currentCont;
	/**
	 * limit of heavy containers
	 */
	private int currentHeavy;
	/**
	 * limit of refrigerated containers
	 */
	private int currentRef;
	/**
	 * limit of liquid containers
	 */
	private int currentLiq;
	/**
	 * total consumption
	 */
	private double toplam;
	/**
	 * list of current containers in ship
	 */
	ArrayList<Container> contsInShip ;
	/**This constructs a ship with ID, currentPort, totalWeightCapacity, maxNumberOfAllContainers,
	 * maxNumberOfHeavyContainers, maxNumberOfRefrigeratedContainers, maxNumberOfLiquidContainers
	 * and fuelConsumptionPerKM 
	 * @param ID of ship
	 * @param p of ship
	 * @param totalWeightCapacity of ship
	 * @param maxNumberOfAllContainers of ship
	 * @param maxNumberOfHeavyContainers of ship
	 * @param maxNumberOfRefrigeratedContainers of ship
	 * @param maxNumberOfLiquidContainers of ship
	 * @param fuelConsumptionPerKM of ship
	 */
	public Ship(int ID, Port p, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfRefrigeratedContainers, int maxNumberOfLiquidContainers, double fuelConsumptionPerKM) {
		this.ID = ID;
		this.fuel = 0;
		this.currentPort = p;
		this.totalWeightCapacity = totalWeightCapacity;
		this.maxNumberOfAllContainers = maxNumberOfAllContainers;
		this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
		this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
		this.maxNumberOfRefrigeratedContainers = maxNumberOfRefrigeratedContainers;
		this.fuelConsumptionPerKM = fuelConsumptionPerKM;
		this.currentWeight = totalWeightCapacity;
		contsInShip = new ArrayList<Container>();
	}
	/**
	 * Gets current list of containers in the ship
	 * @return list of containers
	 */
	public ArrayList<Container> getCurrentContainers() {
		return contsInShip; 
	}

	@Override
	/**Checks the ship can go to the other port and calculates total consumption of ship
	 * @param p the destination port
	 */
	public boolean sailTo(Port p) {
		for(int i=0;this.contsInShip.size()>i; i++) {
			double cons = this.getCurrentContainers().get(i).consumption();
			toplam = toplam+cons;
		}
		double tuketim = (toplam + this.fuelConsumptionPerKM)*(this.getCurrentPort().getDistance(p));
		if (tuketim <= this.fuel) {
			fuel = fuel-tuketim;
			return true;
		}
		return false;
	}

	@Override
	/**
	 * Calculates new fuel of ship
	 * @param newFuel
	 */
	public void reFuel(double newFuel) {
		
		fuel = fuel+newFuel;
	}

	@Override
	/**
	 * Checks the container can load to the ship by using limits of the ship
	 * @param cont
	 */
	public boolean load(Container cont) {
		cont.equals(cont);
		currentWeight = currentWeight - cont.getWeight();
		if (currentWeight >= 0 ) {
			if (currentCont<maxNumberOfAllContainers) {
				if (cont instanceof BasicContainer) {
					currentCont++;
					contsInShip.add(cont);
					currentPort.removingCont(cont);
					return true;
				}
				else if (cont instanceof HeavyContainer) {
					if (currentHeavy<maxNumberOfHeavyContainers) {
						if (cont instanceof LiquidContainer) {
							if (currentLiq<maxNumberOfLiquidContainers) {
								currentLiq++;
								currentHeavy++;
								currentCont++;
								contsInShip.add(cont);
								currentPort.removingCont(cont);
								return true;
							}
						}
						
						else if (cont instanceof RefrigeratedContainer) {
							if (currentRef<maxNumberOfRefrigeratedContainers) {
								currentRef++;
								currentHeavy++;
								currentCont++;
								contsInShip.add(cont);
								currentPort.removingCont(cont);
								return true;
							}
						}
						else {
							currentHeavy++;
							currentCont++;
							contsInShip.add(cont);
							currentPort.removingCont(cont);
							return true;
						}
					}
				}
				
			}
		}
		else {
			currentWeight = currentWeight + cont.getWeight();
			return false;
		}
		

		return false;
	}
	@Override
	/**Checks the container can unload from the ship and updates limits
	 * 
	 */
	public boolean unLoad(Container cont) {
		cont.equals(cont);
		currentWeight = currentWeight + cont.getWeight();
		currentCont--;
		contsInShip.remove(cont);
		currentPort.addingCont(cont);
		if (cont instanceof HeavyContainer) {
			currentHeavy--;
			if (cont instanceof LiquidContainer) {
				currentLiq--;
				return true;
			}
			else if (cont instanceof RefrigeratedContainer) {
				currentRef--;
				return true;
			}
			else {
				return true;
			}
		}
		else if(cont instanceof BasicContainer) {
			return true;
		}
		
		return false;
	}

	
	
	
	/**
	 * Gets ID of ship
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Sets ID of ship
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Gets fuel of ship
	 * @return fuel
	 */
	public double getFuel() {
		return fuel;
	}
	/**
	 * Sets fuel of ship
	 * @param fuel
	 */
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	/**
	 * Gets port of ship
	 * @return currentPort
	 */
	public Port getCurrentPort() {
		return currentPort;
	}
	/**
	 * Sets port of ship
	 * @param currentPort
	 */
	public void setCurrentPort(Port currentPort) {
		this.currentPort = currentPort;
	}
	/**
	 * Gets total weight capacity of ship
	 * @return totalWeightCapacity
	 */
	public int getTotalWeightCapacity() {
		return totalWeightCapacity;
	}
	/**
	 * Sets total weight capacity of ship
	 * @param totalWeightCapacity
	 */
	public void setTotalWeightCapacity(int totalWeightCapacity) {
		this.totalWeightCapacity = totalWeightCapacity;
	}
	/**
	 * Gets max number of all cont of ship
	 * @return maxNumberOfAllContainers
	 */
	public int getMaxNumberOfAllContainers() {
		return maxNumberOfAllContainers;
	}
	/**
	 * Sets max number of all cont of ship
	 * @param maxNumberOfAllContainers
	 */
	public void setMaxNumberOfAllContainers(int maxNumberOfAllContainers) {
		this.maxNumberOfAllContainers = maxNumberOfAllContainers;
	}
	/**
	 * Gets max number of heavy cont of ship
	 * @return maxNumberOfHeavyContainers
	 */
	public int getMaxNumberOfHeavyContainers() {
		return maxNumberOfHeavyContainers;
	}
	/**
	 * Sets max number of heavy cont of ship
	 * @param maxNumberOfHeavyContainers
	 */
	public void setMaxNumberOfHeavyContainers(int maxNumberOfHeavyContainers) {
		this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
	}
	/**
	 * Gets max number of ref cont of ship
	 * @return maxNumberOfRefrigeratedContainers
	 */
	public int getMaxNumberOfRefrigeratedContainers() {
		return maxNumberOfRefrigeratedContainers;
	}
	/**
	 * Sets max number of ref cont of ship
	 * @param maxNumberOfRefrigeratedContainers
	 */
	public void setMaxNumberOfRefrigeratedContainers(int maxNumberOfRefrigeratedContainers) {
		this.maxNumberOfRefrigeratedContainers = maxNumberOfRefrigeratedContainers;
	}
	/**
	 * Gets max number of liq cont of ship
	 * @return maxNumberOfLiquidContainers
	 */
	public int getMaxNumberOfLiquidContainers() {
		return maxNumberOfLiquidContainers;
	}
	/**
	 * Sets max number of liq cont of ship
	 * @param maxNumberOfLiquidContainers
	 */
	public void setMaxNumberOfLiquidContainers(int maxNumberOfLiquidContainers) {
		this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
	}
	/**
	 * Gets fuel cons of ship
	 * @return fuelConsumptionPerKM
	 */
	public double getFuelConsumptionPerKM() {
		return fuelConsumptionPerKM;
	}
	/**
	 * Sets fuel Cons of ship
	 * @param fuelConsumptionPerKM
	 */
	public void setFuelConsumptionPerKM(double fuelConsumptionPerKM) {
		this.fuelConsumptionPerKM = fuelConsumptionPerKM;
	}


}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

