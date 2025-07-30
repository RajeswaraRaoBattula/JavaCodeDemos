/*
 * The following are the superclass Bank and its subclasses Saving and Current.
Super class : Bank
public class Bank 
{
String accNo;  //customer account number with Bank
String custName; //customer name
int custGender;  //customer gender 1 = Male, 2 =Female
String custJob;  //customer job positions
double curBal;  //customer balance in the bank account
public String toString();
public abstract double calcBalance();
}

Subclass : Saving
public class Saving 
{
double savRate;  //percent interest rate per year
}

Subclass : Current
public class Current
{
boolean fixedDep;  //whether the customer keeps the fixed// deposit with the bank of not
double curRate;  //percent interest rate per year
}

The  above  classes  show  that  Bank  can  have  two  different  types  of  account  which  are
 Saving  and  Current  account. The  balance amount  in the  bank for  each account  is basedon 
 the following calculation :

Saving :Balance =  current balance + (savRate * current balance)
Current :Balance = current balance + (curRate * current balance)

If the customer has a fixed deposit with the bank, then the bank will charge RM150for the service fee.  
The amount will be deducted automatically yearly.

a)  Write a method of calcBalance() for both subclasses.
b)  Search  a  customer  based  on  the  account  number  entered  then  display  detailinformation 
 of  him/her.  If  the  customer  account  number  is  not  found,  display  anappropriate message.
c)  Count how many customers that have the current account with the bank and the totalbalance.
 */
package myjavacodes;
import java.util.*;
//import java.util.ArrayList;

abstract class Bank {
	String accNo;  //customer account number with Bank
	String custName; //customer name
	int custGender;  //customer gender 1 = Male, 2 =Female
	String custJob;  //customer job positions
	double curBal;  //customer balance in the bank account
	
	
	public Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
		//super();
		this.accNo = accNo;
		this.custName = custName;
		this.custGender = custGender;
		this.custJob = custJob;
		this.curBal = curBal;
	}
	public String toString() {
		return  "Account No: " +accNo+ "\n" + "Customer Name: " + custName + "\n" +"Gender: " + (custGender == 1 ? "Male" : "Female") + "\n" +
	               "Job: " + custJob + "\n" +
	               "Current Balance: RM " + curBal; 
	}
	public abstract double calcBalance();
}

class Saving extends Bank {
	double savRate;  //percent interest rate per year
	
	public Saving(String accNo, String custName, int custGender, String custJob, double curBal,double savRate) {
		super(accNo, custName, custGender, custJob, curBal);
		this.savRate=savRate;
		// TODO Auto-generated constructor stub
	}

	public double calcBalance() {
        return curBal + (savRate * curBal);
    }	
}

class Current extends Bank{
	boolean fixedDep;  //whether the customer keeps the fixed// deposit with the bank of not
	double curRate;  //percent interest rate per year
	public Current(String accNo, String custName, int custGender, String custJob, double curBal, double curRate, boolean fixedDep) {
		super(accNo, custName, custGender, custJob, curBal);
		this.fixedDep=fixedDep;
		this.curRate=curRate;
	}
	
	public double calcBalance() {
        double balance = curBal + (curRate * curBal);
        if (fixedDep) {
            balance -= 150; // Deduct service fee
        }
        return balance;
    }	
}


public class Problem19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Bank> customers = new ArrayList<>();
		
		customers.add(new Saving("101", "Raja", 1, "Software", 10000, 0.5 ));
		customers.add(new Saving("102", "Kaja", 1, "Hardware", 20000, 0.6 ));
		customers.add(new Current("103", "Rama", 2, "Software", 30000, 0.07, true));
		customers.add(new Current("101", "Raja", 1, "Teacher", 25000, 0.8, false ));
		
		Scanner sc = new Scanner(System.in);

        // b) Search customer
        System.out.print("Enter account number to search: ");
        String searchAccNo = sc.nextLine();
        boolean found = false;

        for (Bank b : customers) {
            if (b.accNo.equalsIgnoreCase(searchAccNo)) {
                System.out.println("\nCustomer Details:");
                System.out.println(b.toString());
                System.out.printf("Calculated Balance: RM %.2f\n", b.calcBalance());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer with account number " + searchAccNo + " not found.");
        }

        // c) Count Current account holders and total balance
        int countCurrent = 0;
        double totalCurrentBalance = 0;

        for (Bank b : customers) {
            if (b instanceof Current) {
                countCurrent++;
                totalCurrentBalance += b.calcBalance();
            }
        }

        System.out.println("\nTotal Current Account Customers: " + countCurrent);
        System.out.printf("Total Balance in Current Accounts: RM %.2f\n", totalCurrentBalance);
        sc.close();
		

	}

}
