package mymainfiles;

import mypojos.Account;
import mypojos.Transaction;
import mydaodemos.AccountDAO;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {
            System.out.println("1. Create Account with Transactions");
            System.out.println("2. View All Accounts with Transactions");
            System.out.println("0. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                Account acc = new Account();
                System.out.print("Enter account holder name: ");
                acc.setHolderName(sc.next());

                List<Transaction> transactions = new ArrayList<>();
                System.out.print("Number of transactions: ");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    Transaction t = new Transaction();
                    System.out.print("Enter amount for transaction " + (i + 1) + ": ");
                    t.setAmount(sc.nextDouble());
                    t.setAccount(acc);
                    transactions.add(t);
                }

                acc.setTransactions(transactions);
                dao.saveAccount(acc);
                System.out.println("Account saved.");
            }

            else if (choice == 2) {
                List<Account> accounts = dao.getAllAccounts();
                for (Account a : accounts) {
                    System.out.println("Account ID: " + a.getId() + ", Holder: " + a.getHolderName());
                    for (Transaction t : a.getTransactions()) {
                        System.out.println("  -> Txn ID: " + t.getId() + ", Amount: " + t.getAmount());
                    }
                }
            }

            else if (choice == 0) {
                System.out.println("Exiting...");
                sc.close();
                break;
            }
        }
    }
}
