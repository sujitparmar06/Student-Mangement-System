import java.util.*;

class Reservation{
    String username;
    String destination;
    String date;

    Reservation(String username,String destination,String date)
    {
        this.username=username;
        this.destination=destination;
        this.date=date;
    }
    
    public String toString(){
        return "User: " + username + ", Destination: " + destination + ", Date: " + date;
    }
}

public class OnlineReservationSystem{
    static HashMap<String,String> userDB=new HashMap<>();
    static ArrayList<Reservation> reservations=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
      
        userDB.put("user1", "pass123");
        userDB.put("user2", "pass456");

        System.out.println("Enter the username:");
        String username = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        if (!userDB.containsKey(username) || !userDB.get(username).equals(password)) {
            System.out.println("Invalid username or password");
            return;
        }

        int choice;
            do{
                System.out.println("\n 1. Book a flight");
                System.out.println("\n 2. View a flight");
                System.out.println("\n 3. Cancel a flight");
                System.out.println("\n 4. Exit");
                System.out.println("\n Enter your choice:");
                choice=sc.nextInt();
                sc.nextLine();

                switch(choice)
                {
                    case 1:bookFlight(username);
                    break;
                    case 2:viewFlight(username);
                    break;
                    case 3:cancelFlight(username);
                    break;
                    case 4:System.out.println(":Exited");
                    break;
                    default:System.out.println("Invalid choice");
                }

            }while(choice!=4);
        

    }

   

    public static void bookFlight(String username)
    {
        System.out.println("Enter destination:");
        String destination=sc.nextLine();

        System.out.println("enter date in format dd-mm-yyyy");
        String date=sc.nextLine();

        Reservation res=new Reservation(username,destination,date);

        reservations.add(res);
    }

    public static void viewFlight(String username)
    {
        boolean found=false;

        for(Reservation r:reservations)
        {
            if(r.username.equals(username))
            {
                System.out.println(r);
                found=true;
            }
           
        }
        if(!found)
        {
           System.out.println("No reservations found");
        }
    }

    public static void cancelFlight(String username)
    {
        System.out.println("Enter destination of a flight to cancel");
        String destination=sc.nextLine();
       
        boolean found=false;

       for(int i=0;i<reservations.size();i++)
       {
           Reservation res=reservations.get(i);

           if(res.username.equals(username) && res.destination.equals(destination))
           {
              reservations.remove(i);
              found=true;
              break;
           }
       }
       if(!found)
       {
        System.out.println("Nothing found to cancel");
       }
        
    }
}
