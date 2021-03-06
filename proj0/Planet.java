public class Planet {
  public double xxPos, yyPos, xxVel, yyVel, mass;
  public String imgFileName;
  public static final double grav = 6.67e-11;

  public Planet(double xP, double yP, double xV, double yV, double m, String img) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p2) {
    double dX = this.xxPos - p2.xxPos;
    double dY = this.yyPos - p2.yyPos;
    double r = Math.sqrt(dX * dX + dY * dY);
    return r;
  }

  public double calcForceExertedBy(Planet p2) {
    double f;
    f = (grav * this.mass * p2.mass) / (Math.pow(this.calcDistance(p2), 2));
    return f;
  }

  public double calcForceExertedByX(Planet p2) {
    double f = this.calcForceExertedBy(p2);
    double r = this.calcDistance(p2);
    double fX = (f * (p2.xxPos - this.xxPos))/r;
    return fX;
  }

  public double calcForceExertedByY(Planet p2) {
    double f = this.calcForceExertedBy(p2);
    double r = this.calcDistance(p2);
    double fY = (f * (p2.yyPos - this.yyPos))/r;
    return fY;
  }

  public double calcNetForceExertedByX(Planet[] planets) {
    double netForceX = 0;
    for(Planet planet : planets) {
      if(this.equals(planet)) {
        continue;
      }
      netForceX += this.calcForceExertedByX(planet);
    }
    return netForceX;
  }

    public double calcNetForceExertedByY(Planet[] planets) {
    double netForceY = 0;
    for(Planet planet : planets) {
      if(this.equals(planet)) {
        continue;
      }
      netForceY += this.calcForceExertedByY(planet);
    }
    return netForceY;
  }

  public void update(double dt, double fX, double fY) {
    double aX = fX/this.mass;
    double aY = fY/this.mass;
    this.xxVel = this.xxVel + dt * aX;
    this.yyVel = this.yyVel + dt * aY;
    this.xxPos = this.xxPos + dt * this.xxVel;
    this.yyPos = this.yyPos + dt * this.yyVel;
  }

  public void draw() {
    StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
  }
}
