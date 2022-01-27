public class BankAccount {
	private double balance;
	public BankAccount() {
		balance=0;
	}
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	public boolean deposit(double amount) {
		boolean success;
		if (amount > 0) {
			balance += amount;
			success = true;
		} else {
			success = false;
		}
		return success;
	}
	public boolean withdraw(double amount) {
		boolean success;
		if (amount <= balance && amount > 0) {
			balance -= amount;
			success = true;
		} else {
			success = false;
		}
		return success;
	}
	public double getBalance() {
		return balance;
	}
}