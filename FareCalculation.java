public class FareCalculation extends LocationInfo {
    double fare_per_km =2.20;
    double fare;
    int location;
    String locationA;
    String locationB;
    public void Location() {
        System.out.println("Scan for your Starting 1st Location!!");
        locationA =  getLocation();

        System.out.println("Scan for your Destination 2nd Location!!");
        locationB =  getLocation();

    }
    public double setFare()
    {
        location = Math.abs(getNumberB() - getNumberA());
        fare = fare_per_km* location;
        System.out.println("Your fare is: "+fare);
        return fare;
    }
    public int getNumberA() {
        switch (locationA) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            case "E":
                return 5;
            case "F":
                return 6;
            case "G":
                return 7;
            case "H":
                return 8;
            case "I":
                return 9;
            case "J":
                return 10;
            case "K":
                return 11;
            case "L":
                return 12;
            case "M":
                return 13;
            case "N":
                return 14;
            case "O":
                return 15;
            case "P":
                return 16;
            default:
                return 0;
        }
    }
    public int getNumberB() {
        switch (locationB) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            case "E":
                return 5;
            case "F":
                return 6;
            case "G":
                return 7;
            case "H":
                return 8;
            case "I":
                return 9;
            case "J":
                return 10;
            case "K":
                return 11;
            case "L":
                return 12;
            case "M":
                return 13;
            case "N":
                return 14;
            case "O":
                return 15;
            case "P":
                return 16;
            default:
                return 0;
        }
    }

}