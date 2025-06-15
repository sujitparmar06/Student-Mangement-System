import java.util.*;
public class NumberGuesiing {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Random ran=new Random();

        boolean guessedCorrectly=false;
        int maxAttempts=7;
        int attempt=0;
        int randomNumber=ran.nextInt(100)+1;

        System.out.println("Select numbers from 1 to 100");
        System.out.println("You have"+maxAttempts+"left");

        while(attempt<maxAttempts)
        {
            System.out.println("Enter yourr guess number");
            int guessNumber=sc.nextInt();
            attempt++;

            if(guessNumber==randomNumber)
            {
                System.out.println("Congrats you have found number");
                guessedCorrectly=true;
                break;
            }
            else if(guessNumber<randomNumber)
            {
               System.out.println("your number is low");
            }
            else{
                System.out.println("your number is high");
            }
           System.out.println("Attempts left"+(maxAttempts-attempt));
        }

        if(!guessedCorrectly)
        {
            System.out.println("Sorry you used all your attempts");
            System.out.println("The random number was:"+randomNumber);
        }
    }
}
