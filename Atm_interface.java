import java.util.*;
class Atm{
	
	static String getname(){
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the name of the person you want to transfer the amount");
		String name = scan.nextLine();
		return name;
	}
	
	static int withdraw(int balance){
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the amount to withdraw");
		int amount = scan1.nextInt();
		if (amount > 0 && amount <= balance){
			return amount;
		}
		else if (amount < 0){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	
	static int transfer(int balance){
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter the amount to be Transfer");
		int amount = scan2.nextInt();
		if (amount > 0 && amount <= balance){
			return amount;
		}
		else if (amount < 0){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	static int deposit(){
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Enter the amount to be Deposit");
		int amount = scan3.nextInt();
		if (amount > 0){
			return amount;
		}
		else{
			return 0;
		}
	}
	
	public static void main(String[] args){
		ArrayList <String> history = new ArrayList <>();
		int balance = 0;
		System.out.println("\t\t\t\t\tWelcome to our ATM");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter user Name");
		String username = input.nextLine();
		System.out.println("Enter Password");
		String password = input.nextLine();
		if (username.equals("karthi") && password.equals("123456")){
			System.out.println("\nLogged in Successfully\n");
			while (true){
				System.out.println("\t\t\t1. Transacation History");
				System.out.println("\t\t\t2. Withdraw");
				System.out.println("\t\t\t3. Deposit");
				System.out.println("\t\t\t4. Money transfer");
				System.out.println("\t\t\t5. Exit");
				System.out.println("\nEnter your Choice");
				int choice = input.nextInt();
				
				if (choice == 1){
					int length = 0;
					for (String item : history){
						length+=1;
					}
					if (length > 0){
						for (String item : history){
							System.out.println(item);
						}
					}
					else
					{
						System.out.println("\nThere is no Transaction history");
					}
				}
				
				else if (choice == 2){
					int with_amount = withdraw(balance);
					if (with_amount == 0){
						System.out.println("\nThere is no sufficient balance for withdrawing the amount");
						System.out.println("\n");
						System.out.println("\n The clear balance in your account is "+String.valueOf(balance));
						System.out.println("\n");
					}
					else if (with_amount > 0){
						balance -= with_amount;
						System.out.println("\nPlease collect your cash");
						System.out.println("\n");
						System.out.println("\n The clear balance in your account is "+String.valueOf(balance));
						System.out.println("\n");
						history.add("The amount of Rs "+String.valueOf(with_amount)+
						" has been withdrawn clear balance Rs "+String.valueOf(balance));
						
					}
					else{
						System.out.println("\n invalid amount");
						System.out.println("\n");
						history.add("Invalid Transaction");
					} 
				}
				
				else if (choice == 3){
					int depo_amount = deposit();
					if (depo_amount > 0){
						balance+=depo_amount;
						System.out.println("\nAmount has been successfully deposited");
						System.out.println("\n");
						System.out.println("\n The clear balance in your account is "+String.valueOf(balance));
						System.out.println("\n");
						history.add("The amount deposited of Rs "+String.valueOf(depo_amount)+
						" clear balance Rs "+String.valueOf(balance));
					}else{
						System.out.println("\n invalid amount");
						System.out.println("\n");
						history.add("Invalid Transaction");
					}
				}
				
				else if (choice == 4){
					int trans_amount = transfer(balance);
					if (trans_amount == 0){
						System.out.println("\nThere is no sufficient balance for transaction");
						System.out.println("\n");
						System.out.println("\n The clear balance in your account is "+String.valueOf(balance));
						System.out.println("\n");
					}
					else if (trans_amount > 0){
						balance -= trans_amount;
						String name = getname();
						System.out.println("\nAmount has been successfully Transfered to "+name);
						System.out.println("\n");
						System.out.println("\n The clear balance in your account is "+String.valueOf(balance));
						System.out.println("\n");
						history.add("The amount of Rs "+String.valueOf(trans_amount)+
						" is transfered to "+name+" clear balance Rs "+String.valueOf(balance));
						
					}
					else{
						System.out.println("\n invalid amount");
						System.out.println("\n");
						history.add("Invalid Transaction");
					} 
				}
				
				else if (choice == 5){
					System.out.println("Logged out Successfully");
					break;
				}
				
			}
		}
		else{
			System.out.println("\t\t\t\tThe UserName or Password is Incorrect");
		}			
	}
}