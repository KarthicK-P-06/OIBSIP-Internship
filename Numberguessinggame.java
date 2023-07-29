import java.util.*;
class Game{
	public static void main(String[] args){
		Random random = new Random();
		int number = random.nextInt(101);
		Scanner scanner = new Scanner(System.in);
		int guess = 0;
		int entries = 5;
		int score = 100;
		while (guess != number){
			System.out.println("Guess the number between 1 and 100 : ");
			guess = scanner.nextInt();
			if (entries==1 && guess != number){
				System.out.println("There are no entries left");
				System.out.println("You have loss the game");
				System.out.println("Your score is 0");
                                                                                System.out.println("System generated random number is : "+String.valueOf(number));
				break;
			}
			
			else if (guess == number ){
				System.out.println("you have correctly guessed the number.");
				System.out.println("Your score is "+String.valueOf(score));
				break;
			}
			
			else if (guess> number){
				entries-=1;
				System.out.println("The generated number is less than the guessed number  "+
				"entries left : "+ String.valueOf(entries));
				score-=20;
				continue;
			}
			
			else if (guess < number){
				entries-=1;
				System.out.println("The generated number is greater than the guessed number  "+
				"entries left : "+ String.valueOf(entries));
				score-=20;
				continue;
			}
		}
	}
	
}