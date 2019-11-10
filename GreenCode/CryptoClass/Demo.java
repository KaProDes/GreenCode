import java.util.Scanner;
class Demo{
  public static void main(String args[]){
    String key = System.getenv("KEY");
    System.out.println(key);
    Scanner sc = new Scanner(System.in);
    String plain = sc.next();
    String encry = AES.encrypt(plain,key);
    String decry = AES.decrypt(encry,key);
    System.out.println(plain+" "+encry+" "+decry);
  }
}
