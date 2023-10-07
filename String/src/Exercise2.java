import java.util.Scanner;

public class Exercise2 {
  
  static void stringLength(String s){
    System.out.println("Length of the string : " + s.length());
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str ;
    System.out.println("Enter the string : ");
    str = sc.nextLine();
    stringLength(str);
    sc.close();
  }
}
