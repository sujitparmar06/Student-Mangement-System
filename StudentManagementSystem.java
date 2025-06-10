import java.util.ArrayList;
import java.util.Scanner;

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

public class StudentManagementSystem{
    static ArrayList<Student> students=new ArrayList<>();
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
            System.out.println("\n 5. EXIT Student");
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
                case 5:System.out.println("Exited");
                break;
                default:System.out.println("Invalid choice");
            }
        }while(choice!=5);
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
    }

    public static void viewStudent(){
        if(students.isEmpty())
        {
            System.out.println("No student found");
        }
        else
        {
            for(Student st:students)
            {
                st.display();
            }
        }
    }

    public static void updateStudent(){
       System.out.println("Enter id to update:");
       int id=sc.nextInt();
       sc.nextLine();

       boolean found=false;
       for(Student st:students)
       {
        if(st.id==id)
        {
            System.out.println("Enter updated name:");
            st.name=sc.nextLine();
            System.out.println("Enter updated age:");
            st.age=sc.nextInt();
            sc.nextLine();
            found=true;
            break;
        }

        if(!found)
        {
            System.out.println("Id to update not found");
        }
       }
    }

    public static void deleteStudent(){
        System.out.println("Enter id to delete:");
        int id=sc.nextInt();
        sc.nextLine();

        boolean removed=false;
        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).id==id)
            {
                students.remove(i);
                removed=true;
                break;
            }
        }
        
        if(!removed)
        {
            System.out.println("Id to delete not found");
        }
    }
}