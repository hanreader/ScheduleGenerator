package schedulegenerator;
import java.util.*;

public class StudentPreference extends Student{
    public StudentPreference(){}
    Scanner cin = new Scanner(System.in);
    Student stud = new Student();
    public ArrayList<Integer> scheduleArr = new ArrayList<Integer>();
    
    String[] nineR= {"English9", "Algebra", "Biology", "Language", 
           "PE", "Global"};
    String[] tenR= {"English10", "Geometry", "Chemistry", "Language2", 
        "PE", "Global2"};
    String[] elevenR= {"English11", "Trigonometry", "Physics", "Language3", 
        "PE", "US History"};
    String[] tweleveR= {"English12", "PreCalculus", 
        "PE", "Government&Economics"};
    String[] extra= {"Lunch", "Chorus", "Drama", "Art", "Computer"};
    
    int [] English9={0,15,15,15,15,15,15,15,15,15,15};
    int [] English10={0,15,15,15,15,15,15,15,15,15,15};
    int [] English11={0,15,15,15,15,15,15,15,15,15,15};
    int [] English12={0,15,15,15,15,15,15,15,15,15,15};
    int [] Language1={0,15,15,15,15,15,15,15,15,15,15};
    int [] Language2={0,15,15,15,15,15,15,15,15,15,15};
    int [] Language3={0,15,15,15,15,15,15,15,15,15,15};
    int [] Algebra={0,15,15,15,15,15,15,15,15,15,15};
    int [] Geometry={0,15,15,15,15,15,15,15,15,15,15};
    int [] Trigonometry={0,15,15,15,15,15,15,15,15,15,15};
    int [] PreCalculus={0,15,15,15,15,15,15,15,15,15,15};
    int [] Biology={0,15,15,15,15,15,15,15,15,15,15};
    int [] Chemistry={0,15,15,15,15,15,15,15,15,15,15};
    int [] Physics={0,15,15,15,15,15,15,15,15,15,15};
    int [] GlobalStudies1={0,15,15,15,15,15,15,15,15,15,15};
    int [] GlobalStudies2={0,15,15,15,15,15,15,15,15,15,15};
    int [] USHistory={0,15,15,15,15,15,15,15,15,15,15};
    int [] GovernmentEconomics={0,15,15,15,15,15,15,15,15,15,15};
    int [] Lunch={0,15,15,15,15,15,15,15,15,15,15};
    int [] PE={0,15,15,15,15,15,15,15,15,15,15};
    
    
    
    public int begin = 1;//change later
    
    public int start(){
        do{
        System.out.println("What period would you like to start school(Period 1-4)");
        begin = cin.nextInt();
        }while(begin < 1 || begin > 4); 
        return begin;
    }
    
    public void print(int g){
        System.out.println("-1. Study Hall (Free Period)");
        if(g == 9) {
            System.out.println("Required Classes for Ninth Graders");
            for (int i=0; i<6; i++){
                System.out.println(i + ". " + nineR[i]);
            }
            System.out.println("Electives");
            for (int i=0; i<5; i++){
                System.out.println(i+6 + ". " + extra[i]);
            }
        }
        if(g == 10) {
            System.out.println("Required Classes for Tenth Graders");
            for (int i=0; i<6; i++){
                System.out.println(i + ". " + tenR[i]);
            }
            System.out.println("Electives");
            for (int i=0; i<5; i++){
                System.out.println(i+6 + ". " + extra[i]);
            }
        }
        if(g == 11) {
            System.out.println("Required Classes for Eleven Graders");
            for (int i=0; i<6; i++){
                System.out.println(i + ". " + elevenR[i]);
            }
            System.out.println("Electives");
            for (int i=0; i<5; i++){
                System.out.println(i+6 + ". " + extra[i]);
            }
        }
        if(g == 12) {
            System.out.println("Required Classes for Tweleve Graders");
            for (int i=0; i<4; i++){
                System.out.println(i + ". " + tweleveR[i]);
            }
            System.out.println("Electives");
            for (int i=0; i<5; i++){
                System.out.println(i+4 + ". " + extra[i]);
            }
        }
    }
    
//    public ArrayList<Integer> schedule(){
//        System.out.println("Pick the number of the class for each period");
//        
//        while(begin <= 10){
//            int num = 1;
//            System.out.print("Period "+ num + ": ");
//            scheduleArr.add(begin, cin.nextInt());
//            num++;
//            begin++;
//        }
//        return scheduleArr;
//    }
    public String[] createSchedule(int g){
        String [] legitSchedule = new String[11];
        int [] schedule=new int [11];
        for (int i=0;i<begin;i++){
            schedule[i]=-1;}
        
        System.out.println("Input the number of the cooresponding class for each period");
        int index=begin;
        while(index <= 10){
            boolean valid=false;
            
            while (valid==false){
                System.out.print("Period "+ index + ": ");
                int check = cin.nextInt();
                //System.out.println(check);
                schedule[index]=check;
                if (this.isCapacity(index, schedule[index],g)==true){
                    System.out.println(" ");
                    valid=true;
                }
                else 
                    System.out.println("This class at Period"+index+"is full! Pick again.");
            }
                index++;    
        }
        for(int i = 0; i<11; i++){
            legitSchedule[i] = matchClassNum(schedule[i], g);
        }
        return legitSchedule;
  
    }
    
    String matchClassNum(int classnum, int grade){
        String classname = "";
        if(classnum == -1){
            classname = "Study Hall";
        }
        else {
            if(grade == 9){
                if(classnum<6){
                    classname = nineR[classnum];
                }
                else{
                    classname = extra[classnum-6];
                }
            }
            if(grade == 10){
                if(classnum<6){
                    classname = tenR[classnum];
                }
                else{
                    classname = extra[classnum-6];
                }
            }
            if(grade == 11){
                if(classnum<6){
                    classname = elevenR[classnum];
                }
                else{
                    classname = extra[classnum-6];
                }
            }
            if(grade == 12){
                if(classnum<4){
                    classname = tweleveR[classnum];
                }
                else{
                    classname = extra[classnum-4];
                }
            }
        }
        return classname;
    }
    
     boolean isCapacity(int period, int classnum, int g) {
        
        String classname=matchClassNum(classnum, g);//figure out this with classnum
        boolean check=true;
        
        if(classname == "English9"){
            int num = English9[period]--;
             
            if (num == -1)
                check = false;
            else
                English9[period]--;
            }
         if(classname == "English10"){
            int num = English10[period]--;
             
            if (num == -1)
                check = false;
            else
                English10[period]--;
            }
         if(classname == "English11"){
            int num = English11[period]--;
             
            if (num == -1)
                check = false;
            else
                English11[period]--;
            }
         if(classname == "English12"){
            int num = English12[period]--;
             
            if (num == -1)
                check = false;
            else
                English12[period]--;
            }
         if(classname == "Language1"){
            int num = Language1[period]--;
             
            if (num == -1)
                check = false;
            else
                Language1[period]--;
            }
         if(classname == "Language2"){
            int num = Language2[period]--;
             
            if (num == -1)
                check = false;
            else
                Language2[period]--;
            }
         if(classname == "Language3"){
            int num = Language3[period]--;
             
            if (num == -1)
                check = false;
            else
                Language3[period]--;
            }
         if(classname == "Algebra"){
            int num = Algebra[period]--;
             
            if (num == -1)
                check = false;
            else
                Algebra[period]--;
            }
         if(classname == "Geometry"){
            int num = Geometry[period]--;
             
            if (num == -1)
                check = false;
            else
                Geometry[period]--;
            }
         if(classname == "Trigonometry"){
            int num = Trigonometry[period]--;
             
            if (num == -1)
                check = false;
            else
                Trigonometry[period]--;
            }
         if(classname == "PreCalculus"){
            int num = PreCalculus[period]--;
             
            if (num == -1)
                check = false;
            else
                PreCalculus[period]--;
            }
        if(classname == "GlobalStudies1"){
            int num = GlobalStudies1[period]--;
             
            if (num == -1)
                check = false;
            else
                GlobalStudies1 [period]--;
            }
        if(classname == "GlobalStudies2"){
            int num = GlobalStudies2[period]--;
             
            if (num == -1)
                check = false;
            else
                GlobalStudies2[period]--;
            }
        if(classname == "USHistory"){
            int num = USHistory[period]--;
             
            if (num == -1)
                check = false;
            else
                USHistory[period]--;
            }
        if(classname == "GovernmentEconomics"){
            int num = GovernmentEconomics[period]--;
             
            if (num == -1)
                check = false;
            else
                GovernmentEconomics[period]--;
            }
        if(classname == "Lunch"){
            int num = Lunch[period]--;
             
            if (num == -1)
                check = false;
            else
                Lunch[period]--;
            }
        if(classname == "Biology"){
            int num = Biology[period]--;
             
            if (num == -1)
                check = false;
            else
                Biology[period]--;
            }
        if(classname == "Chemistry"){
            int num = Chemistry[period]--;
             
            if (num == -1)
                check = false;
            else
                Chemistry[period]--;
            }
        if(classname == "Physics"){
            int num = Physics[period]--;
             
            if (num == -1)
                check = false;
            else
                Physics[period]--;
            }
        
        return check;}
    
    
    
}
