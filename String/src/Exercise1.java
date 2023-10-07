import java.util.Scanner;

public class Exercise1 {

  static void stringConcat(String a, String b){
    System.out.println("Output string is : " + a.concat(b));
  }
  
  public static void main(String[] args) {
    String s1, s2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter string : ");
    System.out.println("String 1 : ");
    s1 = sc.nextLine();
        System.out.println("String 1 : ");
    s2 = sc.nextLine();
    stringConcat(s1, s2);
  }
}
