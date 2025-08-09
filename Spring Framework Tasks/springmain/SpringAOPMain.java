package springmain;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springprograms.BankServiceAOPDemo;

public class SpringAOPMain {

	public static void main(String[] args) {

		 ApplicationContext context = new ClassPathXmlApplicationContext("WIPROIOCContainer.xml");
		 BankServiceAOPDemo bank = (BankServiceAOPDemo) context.getBean("bankServiceobj");

	     Scanner sc = new Scanner(System.in);
	     while (true) {
	         System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
	         System.out.print("Enter choice: ");
	         int ch = sc.nextInt();
	         try {
	             switch (ch) {
	                 case 1:
	                     System.out.print("Enter amount to deposit: ");
	                     double d = sc.nextDouble();
	                     bank.deposit(d);
	                     break;
	                 case 2:
	                     System.out.print("Enter amount to withdraw: ");
	                     double w = sc.nextDouble();
	                     bank.withdraw(w);
	                     break;
	                 case 3:
	                     bank.checkBalance();
	                     break;
	                 case 4:
	                     System.out.println("Thank you. Exiting...");
	                     return;
	                 default:
	                     System.out.println("Invalid choice.");
	             }
	         } catch (Exception e) {
	             System.out.println("[MAIN] Error: " + e.getMessage());
	         }
	     }



	}

}
/*
Jul 31, 2025 3:03:48 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@5a2e4553: startup date [Thu Jul 31 15:03:48 IST 2025]; root of context hierarchy
Jul 31, 2025 3:03:48 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [WIPROIOCContainer.xml]

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 3
[LOG] Starting method: checkBalance
Current Balance: ₹0.0
[Around] Method checkBalance took 30ms
[LOG] Method returned: Balance: ₹0.0
[LOG] Completed method: checkBalance

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 1
Enter amount to deposit: 10000
[LOG] Starting method: deposit
Deposited: ₹10000.0
[Around] Method deposit took 3ms
[LOG] Method returned: New Balance: ₹10000.0
[LOG] Completed method: deposit

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 3
[LOG] Starting method: checkBalance
Current Balance: ₹10000.0
[Around] Method checkBalance took 0ms
[LOG] Method returned: Balance: ₹10000.0
[LOG] Completed method: checkBalance

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 2
Enter amount to withdraw: 78000
[LOG] Starting method: withdraw
[LOG] Exception in method: withdraw
[LOG] Error: Insufficient funds
[LOG] Completed method: withdraw
[MAIN] Error: Insufficient funds

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 2
Enter amount to withdraw: 1000
[LOG] Starting method: withdraw
Withdrawn: ₹1000.0
[Around] Method withdraw took 0ms
[LOG] Method returned: New Balance: ₹9000.0
[LOG] Completed method: withdraw

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 3
[LOG] Starting method: checkBalance
Current Balance: ₹9000.0
[Around] Method checkBalance took 0ms
[LOG] Method returned: Balance: ₹9000.0
[LOG] Completed method: checkBalance

1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter choice: 4
Thank you. Exiting...
*/