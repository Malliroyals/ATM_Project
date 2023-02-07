package Com.Bank;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
		//variables
		//non static data numbers
		private int customerNumber;
		private int pinNumber;
		private double checkingBalance = 0.0;
		private double savingBalance = 0.0;

		Scanner input = new Scanner(System.in);

		//ctrl + alt + 4 is for rupee symbol
		//alt key + 8377 is for rupee symbol|regex(regualar expression)

		DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");

		public Account()
		{

		}
		public Account(int customerNumber, int pinNumber)
		{
			this.customerNumber = customerNumber;
			this.pinNumber = pinNumber;
		}
		public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance)
		{
			this.customerNumber = customerNumber;
			this.pinNumber = pinNumber;
			this.checkingBalance = checkingBalance;
			this.savingBalance = savingBalance;
		}
		public int setCustomerNumber(int customerNumber)
		{
			this.customerNumber = customerNumber;
			return customerNumber;

		}
		public int getCustomerNumber()
		{
			return customerNumber;
		}
		public int getPinNumber() 
		{
			return pinNumber;
		}
		public void setPinNumber(int pinNumber) 
		{
			this.pinNumber = pinNumber;
		}
		public double getCheckingBalance() 
		{
			return checkingBalance;
		}
		public double getSavingBalance() 
		{
			return savingBalance;
		}
		public double calcCheckingWithdraw(double amount)
		{
			checkingBalance = (checkingBalance - amount);
			return checkingBalance;

		}
		public double calcSavingWithdraw(double amount)
		{
			savingBalance = (savingBalance - amount);
			return savingBalance;

		}
		public double calcCheckingDeposit(double amount)
		{
			checkingBalance = (checkingBalance + amount);
			return checkingBalance;
		}
		public double calcSavingDeposit(double amount)
		{
			savingBalance = (savingBalance + amount);
			return savingBalance;
		}
		//tra
		public void calcCheckingTranfer(double amount)
		{
			checkingBalance = checkingBalance - amount;
			savingBalance = savingBalance + amount;
		}
		//transferring the money from savings to checking
		public void calcSavingTransfer(double amount)
		{
			savingBalance = savingBalance - amount;
			checkingBalance = checkingBalance + amount;
		}
		public void getCheckingWithdrawInput()
		{
			boolean end = false;
			while(!end)
			{
				try
				{
					System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
					System.out.println("\nAmount you want to withdraw from Checkings Account");
					double amount = input.nextDouble();
					if((checkingBalance - amount) >=0 && amount >=0)
					{
						calcCheckingWithdraw(amount);
						System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
						end = true;
					}
					else
					{
						System.out.println("\n Balance Cannot be Negative");
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("\n Invalid choice");
					input.next();
				}
			}
		}

		public void getSavingWithdrawInput()
		{
			boolean end = false;
			while(!end)
			{
				try
				{
					System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
					System.out.println("\nAmount you want to withdraw from saving Account");
					double amount = input.nextDouble();
					if((savingBalance - amount) >=0 && amount >=0)
					{
						calcSavingWithdraw(amount);
						System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
						end = true;
					}
					else
					{
						System.out.println("\n Balance Cannot be Negative");
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("\n Invalid choice");
					input.next();
				}
			}
		}
		public void getCheckingDepositInput()
		{
			boolean end = false;
			while(!end)
			{
				try
				{
					System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
					System.out.println("\nAmount you want to deposit from checking Account");
					double amount = input.nextDouble();

					if(!(amount <= 0) && (checkingBalance + amount) >0 && amount >0)
					{
						calcCheckingDeposit(amount);
						System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(checkingBalance));
						end = true;
					}
					else
					{
						System.out.println("\nCannot Deposit Negative or 0 amount");
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("\n Invalid choice");
					input.next();
				}
			}
		}
		public void getSavingDepositInput()
		{
			boolean end = false;
			while(!end)
			{
				try
				{
					System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
					System.out.println("\nAmount you want to withdraw from saving Account");
					double amount = input.nextDouble();

					if(!(amount <= 0)&&(savingBalance + amount) >0 && amount >0)
					{
						calcSavingDeposit(amount);
						System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
						end = true;
					}
					else
					{
						System.out.println("\nCannot Deposit Negative or 0 amount");
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("\n Invalid choice");
					input.next();
				}
			}
		}
		public void getTransferInput(String accType)
		{
			boolean end = false;

			while(!end)
			{
				try
				{
					if(accType.equals("Checkings"))
					{
						System.out.println("\n Select an account you wish to transfer funds to: ");
						System.out.println("1. savings");
						System.out.println("2. Exit");
						System.out.println("\nChoice:");
						int choice = input.nextInt();
						switch(choice)
						{
						case 1: System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
						System.out.println("\nAmount you want to deposit into your Savings Account: ");
						double amount = input.nextDouble();
						if(!((amount <= 0) && (savingBalance + amount) >=0) && (checkingBalance - amount) >0 && amount >0)
						{
							calcCheckTranfer(amount);
							System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
							System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
							end = true;
						}
						else 
						{
							System.out.println("\nCannot Transer Negative or 0 amount.");
						}
						break;
						case 2:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;

						}
					}


					else if(accType.equals("Savings"))
					{
						System.out.println("\nSelect an account you wish to transfer funds to: ");
						System.out.println("1. checkings");
						System.out.println("2. Exit");
						System.out.println("\nChoice: ");
						int choice = input.nextInt();
						switch(choice)
						{
						case 1: System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
						System.out.println("\nAmount you want to deposit into your savings account: ");
						double amount = input.nextDouble();
						if(!(amount < 0) && (checkingBalance + amount) > 0 && (savingBalance - amount) > 0 && amount >= 0)
						{
							calcSavingTransfer(amount);
							System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkingBalance));
							System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
							end = true;
						}
						else
						{
							System.out.println("\n Cannot Transfer Negative or 0 amount");
						}
						break;
						case 2:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;
						}
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println(" \n Invalid Choice");
					input.next();
				}
			}

		}
		private void calcCheckTranfer(double amount) 
		{
			
		}
}
