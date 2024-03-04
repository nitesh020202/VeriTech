package task;

import java.util.Scanner;

//User class to represent ATM users
class User {
 private String userID;
 private String userPIN;
 private double accountBalance;

 // Constructor
 public User(String userID, String userPIN, double accountBalance) {
     this.userID = userID;
     this.userPIN = userPIN;
     this.accountBalance = accountBalance;
 }

 // Getters
 public String getUserID() {
     return userID;
 }

 public String getUserPIN() {
     return userPIN;
 }

 public double getAccountBalance() {
     return accountBalance;
 }

 // Method to withdraw money
 public void withdraw(double amount) {
     if (amount > 0 && amount <= accountBalance) {
         accountBalance -= amount;
         System.out.println("Withdrawal successful. Remaining balance: $" + accountBalance);
     } else {
         System.out.println("Invalid amount or insufficient funds.");
     }
 }

 // Method to deposit money
 public void deposit(double amount) {
     if (amount > 0) {
         accountBalance += amount;
         System.out.println("Deposit successful. New balance: $" + accountBalance);
     } else {
         System.out.println("Invalid amount.");
     }
 }
}

//ATM class to encapsulate ATM functionalities
public class ATM {
 private User currentUser;

 // Constructor
 public ATM(User currentUser) {
     this.currentUser = currentUser;
 }

 // Method to check balance
 public void checkBalance() {
     System.out.println("Current balance: $" + currentUser.getAccountBalance());
 }

 // Method to perform withdrawal
 public void withdraw(double amount) {
     currentUser.withdraw(amount);
 }

 // Method to perform deposit
 public void deposit(double amount) {
     currentUser.deposit(amount);
 }

 // Main method
 public static void main(String[] args) {
     // Sample user data
     User user = new User("123456", "7890", 1000.0); // userID, userPIN, accountBalance
     ATM atm = new ATM(user);
     Scanner scanner = new Scanner(System.in);

     // User authentication
     System.out.print("Enter user ID: ");
     String userID = scanner.nextLine();
     System.out.print("Enter PIN: ");
     String userPIN = scanner.nextLine();

     if (userID.equals(user.getUserID()) && userPIN.equals(user.getUserPIN())) {
         System.out.println("Authentication successful. Welcome!");

         // ATM functionalities
         while (true) {
             System.out.println("\nSelect an option:");
             System.out.println("1. Check Balance");
             System.out.println("2. Withdraw Money");
             System.out.println("3. Deposit Money");
             System.out.println("4. Exit");

             int choice = scanner.nextInt();
             double amount;

             switch (choice) {
                 case 1:
                     atm.checkBalance();
                     break;
                 case 2:
                     System.out.print("Enter amount to withdraw: $");
                     amount = scanner.nextDouble();
                     atm.withdraw(amount);
                     break;
                 case 3:
                     System.out.print("Enter amount to deposit: $");
                     amount = scanner.nextDouble();
                     atm.deposit(amount);
                     break;
                 case 4:
                     System.out.println("Thank you for using our ATM. Goodbye!");
                     System.exit(0);
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
     } else {
         System.out.println("Authentication failed. Please try again.");
     }
     scanner.close();
 }
}
