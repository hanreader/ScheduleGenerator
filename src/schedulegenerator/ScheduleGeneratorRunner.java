package schedulegenerator;
import java.lang.*;
import java.util.*;





public class ScheduleGeneratorRunner {

    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Student stud1 = new Student();
        StudentPreference studentP = new StudentPreference();        
        
        System.out.println("Student Schedule Generator");
        System.out.println("***********************************");
        
//Input student information
        do{
        System.out.print("Input First Name: ");
        stud1.fname= cin.nextLine();
        }while(stud1.fname.length() == 0);
        
        do{
        System.out.print("Input Last Name: ");
        stud1.lname= cin.nextLine();
        }while(stud1.lname.length() == 0);
        
        do{
            System.out.print("Input Grade(9-12): ");
            stud1.grade= cin.nextInt();
        }while(stud1.grade < 9 || stud1.grade > 12);
        
        do{
            System.out.print("Input Osis: ");
            stud1.osis= cin.next();
        }while(stud1.osis.length() < 9 || stud1.osis.length() > 10);
        
        do{
            System.out.print("Input VALID Email: ");
            stud1.email= cin.next();
        }while(stud1.email.indexOf("@") == -1 || stud1.email.indexOf(".com") == -1);
        
        System.out.println("");
       
//Ask for class preference 
        String [] schedule = new String[11];
        int firstPd = studentP.start();
        studentP.print(stud1.grade);
        
        for(int i= firstPd; i<11; i++){
            System.out.println(schedule[i]);
        }  
        
        
        
        
        
        
        
    }
    
}
