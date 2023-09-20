package design3;

public class PointCP{
    private double X;
    private double Y;

    public PointCP(char type, double xOrRho, double yOrTheta) {
        if(type == 'C') {
            X = xOrRho;
            Y = yOrTheta;
        } else if (type != 'P') {
            X = (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
            Y = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getRho() {
        return (Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)));
    }

    public double getTheta() {
        return Math.toDegrees(Math.atan2(Y, X));
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
      return "Stored as Cartesian  (" + getX() + "," + getY() + ")";
    }
}