import java.util.Scanner;

public class Exercise3 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str, subString;
    int start, end;
    System.out.println("Enter the string : ");
    str = sc.nextLine();
    System.out.println("Enter the starting index : ");
    start = sc.nextInt();
    System.out.println("Enter the end index : ");
    end = sc.nextInt();
    sc.close();

    subString = str.substring(start, end);
    System.out.println("The substring is : " + subString);
    
  }
}
