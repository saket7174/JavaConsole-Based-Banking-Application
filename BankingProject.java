import java.util.Scanner;

class Bank {
	String userName = "ABC", uName;
	int userid = 123, balance = 0, uid, menu, amount;
	String options[] = new String[5];

	Scanner r = new Scanner(System.in);

	boolean Login() {
		System.out.println("Enter User Name :");
		uName = r.next();
		System.out.println("Enter user id :");
		uid = r.nextInt();
		// r.close().
		if (uName.equals(userName) && uid == userid) {
			System.out.println("Login Successful !");
			System.out.println("------------------------------");
			Operations();
			return true;
		} else {
			System.out.println("Login Failed ! Incorrect Credentials");
			return false;

		}
	}

	void Exit() {
		System.out.println("Thank You");
		System.exit(0);
	}

	void Transfer() {
		if (balance >= amount) {
			balance = balance - amount;
			System.out.println("Your account Balance after transfer Rs :" + amount + "is Rs :" + balance);
		} else {
			System.out.println("Insufficient Balance");
		}
		System.out.println("-------------------");
	}

	void Withdraw() {
		if (balance > amount) {
			balance = balance - amount;
			System.out.println("Your account balance after withdrowel of Rs :" + amount + "is Rs" + balance);
		} else {
			System.out.println("insufficient Balance");
		}
		System.out.println("-----------------");
	}

	void Deposite() {
		balance = balance + amount;
		System.out.println("Your account balance after depositing Rs: "+amount+"is Rs " + balance);
		System.out.println("-------------------------");
	}

	void CheckBalance() {
		System.out.println("Your acaccount balance is Rs :");
		System.out.println(balance);
		System.out.println("\n------------------");
	}

	void Operations() {
		System.out.println("Operations Menue");
		System.out.println("-----------------------------");
		options[0] = "Check Balance ";
		options[1] = "Deposite Cash ";
		options[2] = "Withdraw Cash ";
		options[3] = "Transfer Cash ";
		options[4] = "Exit";

		for (int i = 0; i < options.length; i++) {
			System.out.println(i + 1 + " " + options[i]);
		}
		System.out.println("---------------------------");
		do {
			System.out.println("Select the operations(Select your option . )");
			menu = r.nextInt() - 1;
			switch (menu) {
			case 0: {
				CheckBalance();
				break;
			}
			case 1: {
				System.out.println("Enter Amount to Deposit : Rs ");
				amount = r.nextInt();
				Deposite();
				break;
			}
			case 2: {
				System.out.println("Enter amount to withdraw : Rs ");
				amount = r.nextInt();
				Withdraw();
				break;
			}
			case 3: {
				System.out.println("Amount to be Transfered: Rs  ");
				amount = r.nextInt();
				Transfer();
				break;
			}
			case 4: {
				Exit();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value:" + (menu + 1));
			}
		} while (menu < 4);
		r.close();
	}

}

public class BankingProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*-------Welcome to Banking  Application-------*\n\n ");
		Bank bank = new Bank();
		bank.Login();
	}
}


