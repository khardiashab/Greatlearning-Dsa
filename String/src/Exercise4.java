public class Exercise4 {
  public static void main(String[] args) {
    String str  = "This is my string for this exercise";
    String searchString = "m2";

    if(str.contains(searchString)){
      System.out.println("The starting indexof this search string : " + str.indexOf(searchString));
    } else {
      System.out.println(str.contains(searchString));
      System.out.println(str.indexOf(searchString));
      System.out.println("This substirng is not available in this string.");
    }
  }
}
