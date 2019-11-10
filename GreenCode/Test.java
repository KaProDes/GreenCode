import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Test{
  public static void main(String args[]){
    UserFields.splashScreenText();
    try{Thread.sleep(1500);}catch(Exception e){}
    // UserFields.clearConsole();
    System.out.flush();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your username : ");
    String username = sc.next();
    if(LogIn.existenceOperator(username)==1){
      System.out.print("Enter your password : ");
      String auth = sc.next();
      if(UserFields.getAuthentication(username).equals(auth)){
        do{
        System.out.println("What would you like to do?  ");
        System.out.print("Default = Sign out / 1 = View your Passwords / 2  = Add a new Password :");
        int ch = sc.nextInt();
        if(ch==1){
          UserFields.getUserDetails(username);
        }
        else if(ch==2){
          System.out.println("Enter your account name (eg facebook, twitter, etc.) : ");
          String account = sc.next();
          System.out.println("Enter the associated password to be stored : ");
          String password = sc.next();
          UserFields.appendUserDetails(username,account,password);
          System.out.println("Password stored successfull to "+username);

        }
        else{
          System.out.println("Signing out and Saving this session!");
          System.exit(0);
        }
      }while(true);
      }
      else
        System.out.println("Failed to Authenticate!");
    }
    else{
      System.out.println("Account with the username of "+username+" doesn't exist");
      System.out.println("Would you like to build it? (Y/N) : ");
      Scanner sc1 = new Scanner(System.in);
      String confirm = sc1.next();
      if(confirm.equals("Y")){
        System.out.println("Enter a password for "+username+"  : ");
        String pass1 = sc1.next();
        System.out.println("Re-enter your password : ");
        String pass2 = sc1.next();
        if(pass1.equals(pass2)){
          UserFields.createNewUser(username,pass1);
        }
        else
          System.out.print("Passwords didn't match, exiting sequence!");
      }
    else if(confirm.equals("N"))
      System.out.print("Account creation Sequence has been exited!");
    }
 }
}
