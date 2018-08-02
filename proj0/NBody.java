import java.util.Arrays;

public class NBody {
  public static double readRadius(String filePath) {
    In file = new In(filePath);
    double radius = Double.parseDouble(file.readAllLines()[1]);
    return radius;
  }

  public static Planet[] addPlanet(Planet[] oldPlanets, Planet newPlanet) {
    Planet[] newPlanets = Arrays.copyOf(oldPlanets, oldPlanets.length + 1);
    newPlanets[newPlanets.length - 1] = newPlanet;
    return newPlanets;
  }

  public static Planet[] readPlanets(String filePath) {
    In file = new In(filePath);
    int i = 0;
    Planet[] planets = new Planet[0];
    double size = file.readDouble();
    System.out.println(size);
    file.readDouble();
    while(!file.isEmpty()) {
      try {
        double xxPos = file.readDouble();
        double yyPos = file.readDouble();
        double xxVel = file.readDouble();
        System.out.println(xxVel);
        double yyVel = file.readDouble();
        double mass = file.readDouble();
        String imgFileName = file.readString();
        Planet newPlanet = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        i ++;
        planets = addPlanet(planets, newPlanet);
      } catch (Exception err) {
        file.readAllLines();
      }
    }
    return planets;
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
  }
}
