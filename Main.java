import java.util.*;
import java.util.Scanner;  // Import the Scanner class

class Main {

  public static int count = 1;
  public static void main(String[] args) {

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("How many discs do you want to play with?");

    int numDiscs = myObj.nextInt();  // Read user input
    
    
    solve(numDiscs);
  }
  
  public static boolean move(String start, String end, int step){
    if(step == 1){
      return true;
    }
    
    String other = "A";
    if(!(start == "B" || end == "B")){
      other = "B";
    }
    else if(!(start == "C" || end == "C")){
      other = "C";
    }

    move(start, other, step - 1);
    if(step > 2){
      System.out.println(count + ": " + start + " to " + end);
      count++;
    }
    move(other, end, step - 1);

    if(step == 2){
    System.out.println(count + ": " + start + " to " + other);
      count++;
    System.out.println(count + ": " +start + " to " + end);
      count++;
    System.out.println(count + ": " +other + " to " + end);
      count++;
    }
    return false;
  }

  public static void solve(int num){
  System.out.println("It will take " + (int)(Math.pow(2, num)- 1) + " moves for " + num + " discs.");
   move("A", "C", num);
  }
}