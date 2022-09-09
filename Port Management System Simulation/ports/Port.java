
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package ports;

import java.util.ArrayList;
import java.util.Collections;

import containers.Container;
import interfaces.IPort;
import ships.Ship;
/**
 * 
 * @author SENA ALÇI
 *class of ports
 */
public class Port implements IPort  {
	/**
	 * ID of port
	 */
	private int ID;
	/**
	 * x coordinate of port
	 */
	private double X;
	/**
	 * y coordinate of port 
	 */
	private double Y;
	/**
	 * arraylist for containers in the port
	 */
	private ArrayList<Container> containers;
	/**
	 * arraylist for ships in the port sometime
	 */
	private ArrayList<Ship> history;
	/***
	 * arraylist for ships in the port now
	 */
	private ArrayList<Ship> current;
	/**
	 * arraylist for ships's IDs in the port now
	 */
	private ArrayList<Integer> currentIDs;
	/**This constructs a port with ID, x and y coordinates 
	 * 
	 * @param ID of port
	 * @param X coordinates of port
	 * @param Y coordinates of port
	 */
	public Port(int ID, double X, double Y) {
		this.ID = ID;
		this.X = X;
		this.Y = Y;
		containers = new ArrayList<Container>();
		history = new ArrayList<Ship>();
		current = new ArrayList<Ship>();
		currentIDs = new  ArrayList<Integer>();
	}
	/**
	 * Calculates distance between he object itself and another Port.

	 * @param other port's coordinates
	 * @return distance
	 */
	public double getDistance(Port other) {
		double distance = Math.pow((other.Y-this.Y),2)+Math.pow((other.X-this.X),2);
		return Math.sqrt(distance);
	}
	/**
	 * Adds container to the port's containers.
	 * @param cont loading container
	 */
	public void addingCont(Container cont) {
		containers.add(cont);
	}
	/**
	 * Removes container to the port's containers.
	 * @param cont removing container
	 */
	public void removingCont(Container cont) {
		containers.remove(cont);
	}
	/**
	 * Takes IDs of ships that in the port and sorts IDs.
	 * @return sorted IDs list.
	 */
	public  ArrayList<Integer> IDs() {
		for(int i=0; current.size()>i; i++) {
			currentIDs.add(current.get(i).getID());
		}
		Collections.sort(currentIDs);
		return currentIDs;
	}

	
	@Override
	/** Adds ships to the port's current ships list.
	 * @param incoming ship to the port
	 */
	public void incomingShip(Ship s) {
		if (current.contains(s)== false) {
			current.add(s);
		}
	}
	@Override
	/** 
	 *  Adds ships to the port's history ships list.
	 * @param  outgoing ship from the port
	 */
	public void outgoingShip(Ship s) {
		if (history.contains(s) == false){
			history.add(s);
		}	
	}

	
	//getter-setter
	/**
	 *  Gets ID
	 * @return ID of port
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Sets ID
	 * @param iD 
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Gets X param of port
	 * @return X param of port
	 */
	public double getX() {
		return X;
	}
	/**
	 * Sets X param of port
	 * @param x
	 */
	public void setX(double x) {
		X = x;
	}
	/**
	 * Gets Y param of port
	 * @return Y param of port
	 */
	public double getY() {
		return Y;
	}
	/**
	 * Sets Y param of port
	 * @param y
	 */
	public void setY(double y) {
		Y = y;
	}
	/**
	 * Gets list of containers at the port
	 * @return list of containers at the port
	 */
	public ArrayList<Container> getContainers() {
		return containers;
	}
	/**
	 * Sets list of containers at the port
	 * @param containers
	 */

	public void setContainers(ArrayList<Container> containers) {
		this.containers = containers;
	}
	/**
	 * Gets list of ships that already arrived at the port
	 * @return list of history ships
	 */
	public ArrayList<Ship> getHistory() {
		return history;
	}
	/**
	 * Sets list of ships that already arrived at the port
	 * @param history
	 */
	public void setHistory(ArrayList<Ship> history) {
		this.history = history;
	}
	/**
	 * Gets list of ships that are in the port now
	 * @return list of current ships
	 */
	public ArrayList<Ship> getCurrent() {
		return current;
	}
	/**
	 * Sets list of ships that are in the port now
	 * @param current
	 */
	public void setCurrent(ArrayList<Ship> current) {
		this.current = current;
	}
	
	//getter-setter
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

