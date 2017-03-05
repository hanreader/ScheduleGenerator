/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulegenerator;

/**
 *
 * @author Hannah
 */
public class Student {
    public String fname = new String("");
    public String lname = new String("");
    public int grade;
    public String osis;
    public String email = new String("");
    
    public Student(){}
    public Student(String f, String l, int g, String o, String e){ 
        fname = f;
        lname = l;
        grade = g;
        osis = o;
        email = e;
    }
    
    public void infname(String f){
        fname=f;
    }
    public void inlname(String l){
        lname=l;
    }
    public void ingrade(int g){
        grade=g;
    }
    public void inosis(String o){
        osis=o;
    }
    public void inemail(String e){
        email=e;
    }
    
    public String getfname(){
        return fname;
    }
    public String getlname(){
        return lname;
    }
    public int getgrade(){
        return grade;
    }
    public String getosis(){
        return osis;
    }
    public String getemail(){
        return email;
    }
    
    
    
}
