package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		for(String s: args) {
			System.out.println(s);
		}
		
//		Customer[] customers;
//		Operator[] operators;
//
//		int C, O, N;
//
//		File inFile = new File(args[0]);  // args[0] is the input file
//		File outFile = new File(args[1]);  // args[1] is the output file
//		try {
//			PrintStream outstream = new PrintStream(outFile);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//
//		Scanner reader;
//		try {
//			reader = new Scanner(inFile);
//		} catch (FileNotFoundException e) {
//			System.out.println("Cannot find input file");
//			return;
//		}
//
//		C = reader.nextInt();
//		O = reader.nextInt();
//		N = reader.nextInt();
//
//		customers = new Customer[C];
//		operators = new Operator[O];
//
//		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
//		int c = 0, o = 0;
//		for (int i=0;i<N && reader.hasNextLine();i++) {
//			int op = reader.nextInt();
//			switch (op) {
//
//			// create customer
//			case 1: 
//				String name = reader.next();
//				int age = reader.nextInt();
//				int opID = reader.nextInt();
//				double limit = reader.nextDouble();
//				customers[c] = new Customer(c, name, age, limit, operators[opID]);
//				// bills[c] = customers[c].getBill();
//				c++;
//				break;
//
//				// create operator
//			case 2: 
//				double talkingCharge = reader.nextDouble();
//				double messageCost = reader.nextDouble();
//				double networkCharge = reader.nextDouble();
//				int discountRate = reader.nextInt();
//				operators[o] = new Operator(o++, talkingCharge, messageCost, networkCharge, discountRate);
//				break;
//
//				// add talking
//			case 3: { 
//				int c1 = reader.nextInt();
//				int c2 = reader.nextInt(); 
//				int time = reader.nextInt();
//				customers[c1].talk(time,customers[c2]);
//				break;
//			}
//
//			// add message
//			case 4: {
//				int c1 = reader.nextInt();
//				int c2 = reader.nextInt();
//				int quantity = reader.nextInt();
//				customers[c1].message(quantity, customers[c2]);
//				break;
//			}
//
//			// add network usage
//			case 5: {
//				int c1 = reader.nextInt();
//				double amount = reader.nextDouble();
//				customers[c1].connection(amount);
//				break;
//			}
//
//			// pay bill
//			case 6: {
//				int c1 = reader.nextInt();
//				double amount = reader.nextDouble();
//				customers[c1].getBill().pay(amount);
//				break;
//			}
//
//			// switch operator
//			case 7: {
//				int c1 = reader.nextInt();
//				int o1 = reader.nextInt();
//				customers[c1].changeOperator(operators[o1]);
//				break;
//			}
//
//			// change limit
//			case 8: {
//				int c1 = reader.nextInt();
//				double l1 = reader.nextInt();
//				customers[c1].getBill().changeTheLimit(l1);
//			}
//			}
//		}
//		reader.close();

//		for (Operator op : operators) {
//			System.out.print("Operator "+op.getID()+" : " + op.getTotalTalking() + " " + op.getTotalMessage() + " " );
//			System.out.printf("%.2f",op.getTotalNetwork());
//			System.out.println();
//		}
//		Customer maxTalking = customers[0];
//		Customer maxMessage = customers[0];
//		Customer maxNetwork = customers[0];
//		for (Customer cust : customers) {
//			Bill bill = cust.getBill();
//			System.out.print("Customer "+cust.getID()+" : " );
//			System.out.printf("%.2f",bill.getTotalPaid());
//			System.out.print(" ");
//			System.out.printf("%.2f",bill.getCurrentDebt());
//			System.out.println();
//			if (cust.getTotalTalking()>maxTalking.getTotalTalking())
//				maxTalking = cust;
//			if (cust.getTotalMessage()>maxTalking.getTotalMessage())
//				maxMessage = cust;
//			if (cust.getTotalNetwork()>maxTalking.getTotalNetwork())
//				maxNetwork = cust;
//		}
//		System.out.println(maxTalking.getName() + " " + maxTalking.getTotalTalking());
//		System.out.println(maxMessage.getName() + " " + maxMessage.getTotalMessage());
//		System.out.print(maxNetwork.getName() + " " );
//		System.out.printf("%.2f",maxNetwork.getTotalNetwork());
//		System.out.println();

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}
