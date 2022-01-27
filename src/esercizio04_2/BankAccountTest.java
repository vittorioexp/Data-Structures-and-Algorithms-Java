import java.util.Scanner;
public class BankAccountTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount BA = new BankAccount();
		String command; 
		do {
			command = sc.nextLine();
			if (command.equals("B")) {
				System.out.println(BA.getBalance());
			} else if (command.charAt(0)=='D') {
				String amountStr = command.substring(2);
				try {
				double amount = Double.parseDouble(amountStr);
				if (BA.deposit(amount)) {
					System.out.println("Deposit: " + amount);
				} else {
					System.out.println("Unable to deposit");
				}
				} catch (NumberFormatException e) {}
			} else if (command.charAt(0)=='W') {
				String amountStr = command.substring(2);
				try {
				double amount = Double.parseDouble(amountStr);
				if (BA.withdraw(amount)) {
					System.out.println("Withdraw: " + amount);
				} else {
					System.out.println("Unable to withdraw");
				}
				} catch (NumberFormatException e) {}
			} else if (command.charAt(0)=='A') {
				String amountStr = command.substring(2);
				try {
				double amount = Double.parseDouble(amountStr);
				double balance = BA.getBalance();
				if (amount > 0) {
					if (BA.deposit(amount*100/balance)) {
						System.out.println("Success");
					} else {
						System.out.println("Unable to deposit");
					}
				}
				System.out.println("Amount must be positive");
				} catch (NumberFormatException e) {}
			}
		} while (!command.equals("Q"));
	}
}