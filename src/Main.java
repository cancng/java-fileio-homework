import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) {


    ArrayList<Integer> numbers = new ArrayList<>();

    try {
      File file = new File("Scores.txt");
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextInt()) {
        int number = scanner.nextInt();
        numbers.add(number);
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("error: " + e.getMessage());
    }


    int total = getTotal(numbers);
    double average = getAverage(numbers);

    try {
      PrintWriter writer = new PrintWriter("Summary.txt");

      writer.print("Numbers: [");
      for (int i = 0; i < numbers.size(); i++) {
        writer.print(numbers.get(i));
        if (i != numbers.size() - 1) {
          writer.print(", ");
        }
      }
      writer.println("]");

      writer.println("Total: " + total);
      writer.println("Average: " + average);

      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + e.getMessage());
    }
  }

  public static int getTotal(ArrayList<Integer> numbers) {
    int total = 0;

    for (int i = 0; i < numbers.size(); i++) {
      total += numbers.get(i);
    }

    return total;
  }

  public static double getAverage(ArrayList<Integer> numbers) {
    int total = getTotal(numbers);
    return (double) total / numbers.size();
  }

}
