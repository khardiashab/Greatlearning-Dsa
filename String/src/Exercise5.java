import java.util.Scanner;

public class Exercise5 {
  static void chooseAction() {
    System.out.println("-----------------------------------");
    System.out.println("Choose a action on the string. ");
    System.out.println(" 1) Convert the string to uppercase");
    System.out.println("2) Convert the string to lowercase.");
    System.out.println("3) Replace all occurrences of a specified character with another character.");
    System.out.println("4) Count the number of occurrences of a specific substring in the string.");
    System.out.println("5) Remove all whitespace characters from the string.");
    System.out.println("6) Exit the program.");

    System.out.println("-----------------------------------");

  }

  public static void main(String[] args) {
    String str = "This is my string for this exercise 5.";
    Scanner sc = new Scanner(System.in);
    int option;
    // Convert the string to uppercase.
    // Convert the string to lowercase.
    // Replace all occurrences of a specified character with another character.
    // Count the number of occurrences of a specific substring in the string.
    // Remove all whitespace characters from the string.

    do {
      chooseAction();
      option = sc.nextInt();

      // int count;
      switch (option) {
        case 1:
          System.out.println(str.toUpperCase());

          break;
        case 2:
          System.out.println(str.toLowerCase());
          break;
        case 3:
          System.out.println(str.replaceAll("i", "E"));
          break;
        case 4:
          int index = 0, count = 0;
          System.out.println("   ------------------------        ");
          System.out.println((index = str.indexOf(" ", index)));
          System.out.println("   ------------------------        ");

          while ((index = str.indexOf(" ", index)) != -1) {
            index++;
            count++;
          }
          System.out.println("Occurence of whitespace in this string  : " + count);
          break;
        case 5:
          System.out.println(str.replaceAll(" ", ""));
          break;
        case 6:
          System.out.println("Exit successfully.");
          break;

        default:
          break;
      }

    } while (option != 6);

    sc.close();

  }
}
