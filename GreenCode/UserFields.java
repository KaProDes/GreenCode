import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class UserFields{
  static void getUserDetails(String username){
    try{
      FileInputStream fin=new FileInputStream("Users\\"+username+".txt");
      String db = "";
      int i;
      while ((i=fin.read()) !=-1){
        db = db + (char)i ;
      }
      String arraydb[] = db.split(",");
      System.out.println("-----------------------------------------");
      System.out.println("Here are your stored passwords : ");
      System.out.println("You are currently seeing the details of -- "+arraydb[0]);
      for(i=2;i<arraydb.length;i++){
        if(i%2!=0){
          System.out.print(Crypt.decrypt(arraydb[i])+" ");
          System.out.println();
        }else{
          System.out.print(arraydb[i]+" : ");
        }
      }
      System.out.println("-----------------------------------------");
      }catch(Exception e){System.out.println(e);}
  }

  static String getAuthentication(String username){
    String auth="";
    try{
      FileInputStream fin=new FileInputStream("Users\\"+username+".txt");
      String db = "";
      int i;
      while ((i=fin.read()) !=-1){
        db = db + (char)i ;
      }
      String arraydb[] = db.split(",");
      auth = arraydb[1];
      }catch(Exception e){System.out.println(e);}
      return Crypt.decrypt(auth);
  }

  static void appendUserDetails(String username,String account,String password){
    try{
      FileInputStream fin=new FileInputStream("Users\\"+username+".txt");
      String db = "";
      int i;
      while ((i=fin.read()) !=-1){
        db = db + (char)i ;
      }
      db+=","+account+","+Crypt.encrypt(password);
      FileOutputStream fout=new FileOutputStream("Users\\"+username+".txt");
      fout.write(db.getBytes());
      }
      catch(Exception e){System.out.println(e);}
  }

  static void createNewUser(String username,String password){
    try{
      String db = "";
      db+=username+","+Crypt.encrypt(password);
      FileOutputStream fout=new FileOutputStream("Users\\"+username+".txt");
        fout.write(db.getBytes());
      }
      catch(Exception e){System.out.println(e);}
  }

  static void splashScreenText(){
    try{
      FileInputStream fin=new FileInputStream("welcomeText.txt");
      String str = "";
      int i;
        while ((i=fin.read()) !=-1){
          str = str + (char)i ;
        }
      System.out.println(str);
      }
      catch(Exception e){System.out.println(e);}
    }

  public final static void clearConsole(){
    try {
    if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
  }

}
