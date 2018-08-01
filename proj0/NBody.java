import java.util.Arrays;

public class NBody {
  // public static double readRadius(String filePath) {
  //   In file = new In(filePath);
  //   double radius = Double.parseDouble(file.readAllLines()[1]);
  //   return radius;
  // }

  // public static String[] readPlanets(String filePath) {
  //   In file = new In(filePath);
  // }

  //Is the right approach here a try/catch block with the Planet constructor in the try block?

  public static void main(String[] args) {
    String filePath = "./data/planets.txt";
    In file = new In(filePath);
    System.out.println(Arrays.toString(file.readAllLines()));
  }
}
