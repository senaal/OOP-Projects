
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import containers.BasicContainer;
import containers.Container;
import containers.HeavyContainer;
import containers.LiquidContainer;
import containers.RefrigeratedContainer;
import ports.Port;
import ships.Ship;
/**
 * 
 * @author SENA ALÇI
 *@since 05/06/2021-13/06/2021
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		//
		// Main receives two arguments: path to input file and path to output file.
		// You can assume that they will always be provided, so no need to check them.
		// Scanner and PrintStream are already defined for you.
		// Use them to read input and write output.
		// 
		// Good Luck!
		// 
		
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		
		int N = in.nextInt();
		/**
		 * list of all containers
		 */
		ArrayList<Container> allContainers = new ArrayList<Container>();
		/**
		 * list of all ships 
		 */
		ArrayList<Ship> ships = new ArrayList<Ship>();
		/**
		 * list of all ports
		 */
		ArrayList<Port> ports = new ArrayList<Port>();
		/**
		 * number of containers
		 */
		int countContainer = 0;
		/**
		 * number of ships
		 */
		int countShip = 0;
		/**
		 * number of ports
		 */
		int countPort = 0;
		
		for (int i=0; i<N; i++) {	
			int A = in.nextInt();
			if (A == 1) { 
				String line = in.nextLine();
				String[] list = line.split(" ");
				
				int ID = Integer.parseInt(list[1]);
				int weight = Integer.parseInt(list[2]);
					if (list.length == 4) {
						if (list[3].equals("R")) {
							RefrigeratedContainer container = new RefrigeratedContainer(countContainer, weight);
							allContainers.add(container);
							ports.get(ID).addingCont(container);
							container.setPort(ports.get(ID));
						}
						
						else if (list[3].equals("L")) {
							LiquidContainer container = new LiquidContainer(countContainer, weight);
							allContainers.add(container);
							ports.get(ID).addingCont(container);
							container.setPort(ports.get(ID));
						}
					}
					
					else if (list.length == 3) {
						if (weight <= 3000) {
							BasicContainer container = new BasicContainer(countContainer, weight);
							allContainers.add(container);
						ports.get(ID).addingCont(container);
							container.setPort(ports.get(ID));
						}
						
						else if (weight > 3000) {
							HeavyContainer container = new HeavyContainer(countContainer, weight);
						allContainers.add(container);
						ports.get(ID).addingCont(container);
						container.setPort(ports.get(ID));
					}
				}
			
				countContainer ++;
		}
			
			else if (A == 2) {
				int ID = in.nextInt();
				int totalWeightCapacity = in.nextInt();
				int maxNumberOfAllContainers = in.nextInt();
				int maxNumberOfHeavyContainers = in.nextInt();
				int maxNumberOfRefrigeratedContainers = in.nextInt();
				int maxNumberOfLiquidContainers = in.nextInt();
				double fuelConsumptionPerKM = in.nextDouble();
				Ship ship = new Ship(countShip, ports.get(ID), totalWeightCapacity, maxNumberOfAllContainers, maxNumberOfHeavyContainers, maxNumberOfRefrigeratedContainers, maxNumberOfLiquidContainers, fuelConsumptionPerKM);
				ships.add(ship);
				ports.get(ID).incomingShip(ships.get(countShip));
				countShip ++;
				
			}
			
			else if (A == 3) {
				double X = in.nextDouble();
				double Y = in.nextDouble();
				Port port = new Port(countPort, X, Y);
				ports.add(port);
				countPort ++;
				}
		
			else if (A == 4) {
				int IDofShip = in.nextInt();
				int IDofCont = in.nextInt();
				int PortofShip = ships.get(IDofShip).getCurrentPort().getID();
				if ( allContainers.get(IDofCont).getPort()!=null) {
					int PortofCont = allContainers.get(IDofCont).getPort().getID();
					if (PortofShip == PortofCont ) {
						if(ships.get(IDofShip).load(allContainers.get(IDofCont))==true){
							allContainers.get(IDofCont).setPort(null);
						}
					}
				}
			}
			else if (A == 5) {
				int IDofShip = in.nextInt();
				int IDofCont = in.nextInt();
				if (ships.get(IDofShip).getCurrentContainers().contains(allContainers.get(IDofCont)) == true) {
					if(ships.get(IDofShip).unLoad(allContainers.get(IDofCont))==true){
						allContainers.get(IDofCont).setPort(ships.get(IDofShip).getCurrentPort());
					}
				}
			}
			else if (A == 6) {
				int IDofShip = in.nextInt();
				int IDofPort = in.nextInt();
				if (ships.get(IDofShip).sailTo(ports.get(IDofPort)) == true) {
					ships.get(IDofShip).getCurrentPort().outgoingShip(ships.get(IDofShip));
					ports.get(ships.get(IDofShip).getCurrentPort().getID()).getCurrent().remove(ships.get(IDofShip));
					ships.get(IDofShip).setCurrentPort(ports.get(IDofPort));
					ships.get(IDofShip).getCurrentPort().incomingShip(ships.get(IDofShip));
				
				}
				
			}
			else if (A == 7) {
				int IDofShip = in.nextInt();
				double amountofFuel = in.nextDouble();
				ships.get(IDofShip).reFuel(amountofFuel);
			}
			
		}
		/**
		 * list for basic containers
		 */
		ArrayList<Integer> basics = new ArrayList<Integer>();
		/**
		 * list for liquid containers
		 */
		ArrayList<Integer> liquids = new ArrayList<Integer>();
		/**
		 * list for refrigerated containers
		 */
		ArrayList<Integer> refs = new ArrayList<Integer>();
		/**
		 * list for heavy containers
		 */
		ArrayList<Integer> heavys = new ArrayList<Integer>();
		/**
		 * list for IDs of ships
		 */
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		
		for (int i=0; ports.size()>i; i++ ) {
			double x = ports.get(i).getX();
			double y = ports.get(i).getY();
			out.println("Port"+" "+i+": ("+String.format("%.2f",x)+", "+String.format("%.2f",y)+")");
			for(int k=0; ports.get(i).getContainers().size()>k; k++) {
				if(ports.get(i).getContainers().get(k) instanceof BasicContainer) {	
					int ID = ports.get(i).getContainers().get(k).getID();
					if(basics.contains(ID)==false) {
					basics.add(ID);
					}
					Collections.sort(basics);
				}
				else if(ports.get(i).getContainers().get(k) instanceof LiquidContainer) {	
					int ID = ports.get(i).getContainers().get(k).getID();
					if(liquids.contains(ID)==false) {
					liquids.add(ID);
					}
					Collections.sort(liquids);
				}
				else if(ports.get(i).getContainers().get(k) instanceof RefrigeratedContainer) {
					int ID = ports.get(i).getContainers().get(k).getID();
					if(refs.contains(ID)==false) {
					refs.add(ID);
					}
					Collections.sort(refs);
				}
				else if(ports.get(i).getContainers().get(k) instanceof HeavyContainer) {	
					int ID = ports.get(i).getContainers().get(k).getID();
					if(heavys.contains(ID)==false) {
					heavys.add(ID);
					}
					Collections.sort(heavys);
				}
				
			}
			if (basics.size() != 0) {
				out.print("  BasicContainer:");
				for(int t=0; basics.size()>t; t++) {
					out.print(" "+basics.get(t));  
				}
				out.println();
			}
			if (heavys.size() != 0) {
			out.print("  HeavyContainer:"); 
				for(int t=0; heavys.size()>t; t++) {
					out.print(" "+heavys.get(t));  
				}
				out.println();
			}
			if (refs.size() != 0) {
				out.print("  RefrigeratedContainer:");
				for(int t=0; refs.size()>t; t++) {
					out.print(" "+refs.get(t)); 
				}
				out.println();
			}
			if (liquids.size() != 0) {
			out.print("  LiquidContainer:");
				for(int t=0; liquids.size()>t; t++) {
					out.print(" "+liquids.get(t));
				}
				out.println();
			}
			basics.clear();
			heavys.clear();
			refs.clear();
			liquids.clear();
			
			IDs = ports.get(i).IDs();
			for (int j=0; IDs.size()>j; j++ ) {
				int ID = IDs.get(j);
				out.println("  Ship"+" "+ID+": "+String.format("%.2f",ships.get(ID).getFuel()));
				for(int k=0; ships.get(ID).getCurrentContainers().size()>k; k++) {
					if(ships.get(ID).getCurrentContainers().get(k) instanceof BasicContainer) {	
						Container cont = ships.get(ID).getCurrentContainers().get(k);
						if(basics.contains(cont.getID())==false) {
							basics.add(ships.get(ID).getCurrentContainers().get(k).getID());
						}
						Collections.sort(basics);
					}
					else if(ships.get(ID).getCurrentContainers().get(k) instanceof LiquidContainer) {	
						Container cont = ships.get(ID).getCurrentContainers().get(k);
						if(liquids.contains(cont.getID())==false) {
							liquids.add(ships.get(ID).getCurrentContainers().get(k).getID());
						}
						Collections.sort(liquids);
					}
					else if(ships.get(ID).getCurrentContainers().get(k) instanceof RefrigeratedContainer) {
						Container cont = ships.get(ID).getCurrentContainers().get(k);
						if(refs.contains(cont.getID())==false) {
							refs.add(ships.get(ID).getCurrentContainers().get(k).getID());
						}
						Collections.sort(refs);
					}
					else if(ships.get(ID).getCurrentContainers().get(k) instanceof HeavyContainer) {	
						Container cont = ships.get(ID).getCurrentContainers().get(k);
						if(heavys.contains(cont.getID())==false) {
							heavys.add(ships.get(ID).getCurrentContainers().get(k).getID());
						}
						Collections.sort(heavys);
					}
					
				}
				if (basics.size() != 0) {
					out.print("    BasicContainer:");
					for(int t=0; basics.size()>t; t++) {
						out.print(" "+basics.get(t));  
					}
					out.println();
				}
				if (heavys.size() != 0) {
				out.print("    HeavyContainer:"); 
					for(int t=0; heavys.size()>t; t++) {
						out.print(" "+heavys.get(t));  
					}
					out.println();
				}
				if (refs.size() != 0) {
					out.print("    RefrigeratedContainer:");
					for(int t=0; refs.size()>t; t++) {
						out.print(" "+refs.get(t)); 
					}
					out.println();
				}
				if (liquids.size() != 0) {
				out.print("    LiquidContainer:");
					for(int t=0; liquids.size()>t; t++) {
						out.print(" "+liquids.get(t));
					}
					out.println();
				}
				
				basics.clear();
				heavys.clear();
				refs.clear();
				liquids.clear();
			}
		}
		

		
		in.close();
		out.close();
	}
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

