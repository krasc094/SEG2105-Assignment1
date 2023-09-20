package design2;

public class PointCP {
    private double Rho;
    private double Theta;

    public PointCP(char type, double xOrRho, double yOrTheta) {
        if(type == 'C') {
            Rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
            Theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
        } else if (type != 'P') {
            Rho = xOrRho;
            Theta = yOrTheta;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getX() {
        return (Math.cos(Math.toRadians(Theta)) * Rho);
    }

    public double getY() {
        return (Math.sin(Math.toRadians(Theta)) * Rho);
    }

    public double getRho() {
        return Rho;
    }

    public double getTheta() {
        return Theta;
    }

    public double getDistance(PointCP pointB)
    {
      // Obtain differences in X and Y, sign is not important as these values
      // will be squared later.
      double deltaX = getX() - pointB.getX();
      double deltaY = getY() - pointB.getY();
      
      return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointCP rotatePoint(double rotation)
    {
      double radRotation = Math.toRadians(rotation);
      double X = getX();
      double Y = getY();
          
      return new PointCP('C',
        (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
        (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString()
    {
      return "Stored as Polar [" + getRho() + "," + getTheta() + "]" + "\n";
    }
}