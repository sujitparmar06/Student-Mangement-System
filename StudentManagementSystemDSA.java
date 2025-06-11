import java.util.*;


class Student{
    int id;
    String name;
    int age;

    Student(int id,String name,int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }

    void display()
    {
        System.out.println("Id:"+id+"Name:"+name+"Age:"+age);
    }
}

public class StudentManagementSystemDSA{
    static ArrayList<Student> students=new ArrayList<>();
    static HashMap<Integer,Student> studentsMap=new HashMap<>();
    static Stack<Student> deletedStack=new Stack<>();
    static Queue<Student> recent=new LinkedList<>();

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args)
    {
    
        int choice;

        do{
            System.out.println("\n Student Management System");
            System.out.println("\n 1. ADD Student");
            System.out.println("\n 2. VIEW Student");
            System.out.println("\n 3. UPDATE Student");
            System.out.println("\n 4. DELETE Student");
            System.out.println("\n 5.Stack");
            System.out.println("\n 6.Queue");
            System.out.println("\n 7.deletedStack view");
            System.out.println("\n 8. EXIT Student");
            System.out.println("\n Enter your choice:");

            choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:addStudent();
                break;
                case 2: viewStudent();
                break;
                case 3: updateStudent();
                break;
                case 4: deleteStudent();
                break;
                case 5:undoDelete();
                break;
                case 6: recentView();
                break;
                case 7: viewDeleted();
                break;
                case 8:System.out.println("Exited");
                break;
                default:System.out.println("Invalid choice");
            }
        }while(choice!=7);
    }

    public static void addStudent(){
        System.out.println("Enter id:");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter name:");
        String name=sc.nextLine();

        System.out.println(":Enter age:");
        int age=sc.nextInt();
        sc.nextLine();

        Student s=new Student(id,name,age);
        students.add(s);
        studentsMap.put(id,s);
    }

    public static void viewStudent(){
       System.out.println("Enter id to view:");
       int id=sc.nextInt();
       sc.nextLine();

       Student s=studentsMap.get(id);
       if(s!=null)
       {
          s.display();
          recent.offer(s);
       }
       else
       {
        System.out.println("Id not found");
       }
    }

    public static void updateStudent(){
       System.out.println("Enter id to update");
       int id=sc.nextInt();
       sc.nextLine();

       Student s=studentsMap.get(id);
       if(s!=null)
       {
          System.out.println("Enter new name");
          s.name=sc.nextLine();
          System.out.println("Enter new age");
          s.age=sc.nextInt();
          sc.nextLine();
          System.out.println("Student updated");
       }
       else
       {
         System.out.println("Student not found");
       }
    }

    public static void deleteStudent(){
        System.out.println("Enter id to delete:");
        int id=sc.nextInt();
        sc.nextLine();

       Student s=studentsMap.get(id);
       if(s!=null)
       {
          students.remove(s);
          studentsMap.remove(id);
          deletedStack.push(s);
          System.out.println("Student gets deleted");
       }
       else
       {
         System.out.println("Student not found");
       }
    }

    public static void undoDelete(){
        if(!deletedStack.isEmpty())
        {
           Student s=deletedStack.pop();
           students.add(s);
           studentsMap.put(s.id,s);
           System.out.println("Undo successfull");
        }
        else
        {
            System.out.println("no Undo done");
        }
    }

    public static void recentView()
    {
        System.out.println("Recently viewed students");
        for(Student s:recent)
        {
          s.display();
        }
    }

    public static void viewDeleted()
    {
        if(!deletedStack.isEmpty())
        {
            for(Student s:deletedStack)
            {
                s.display();
            }
        }
        else
        {
            System.out.println("No deleted Students found");
        }
    }
}
