import java.util.*;

public class windowClass {

    private double baseRatePerWindow;
    private double hardToReachWindowExtraCharge;
    private double complexWindowExtraCharge;
    private double heavilySoiledWindowExtraCharge;
    private double overheadCosts;
    private double profitMarginPercentage;

    public windowClass(double baseRatePerWindow,
                                       double hardToReachWindowExtraCharge,
                                       double complexWindowExtraCharge,
                                       double heavilySoiledWindowExtraCharge,
                                       double overheadCosts,
                                       double profitMarginPercentage) {
        this.baseRatePerWindow = baseRatePerWindow;
        this.hardToReachWindowExtraCharge = hardToReachWindowExtraCharge;
        this.complexWindowExtraCharge = complexWindowExtraCharge;
        this.heavilySoiledWindowExtraCharge = heavilySoiledWindowExtraCharge;
        this.overheadCosts = overheadCosts;
        this.profitMarginPercentage = profitMarginPercentage;
    }

    public double calculateTotalCost(int numberOfWindows,
                                     int numberOfHardToReachWindows,
                                     int numberOfComplexWindows,
                                     int numberOfHeavilySoiledWindows) {

        double totalCost = numberOfWindows * baseRatePerWindow;
        totalCost += numberOfHardToReachWindows * hardToReachWindowExtraCharge;
        totalCost += numberOfComplexWindows * complexWindowExtraCharge;
        totalCost += numberOfHeavilySoiledWindows * heavilySoiledWindowExtraCharge;

        totalCost += overheadCosts; // Add fixed overhead costs
        totalCost += (totalCost * profitMarginPercentage / 100); // Add profit margin

        return totalCost;
    }

    public static void main(String[] args) {

        System.out.println("Would you like to input your own rates into the calculator? (y/n)");
        Scanner userInput = new Scanner(System.in);
        String userChoice = userInput.next();

        if (userChoice.equals("y"))
        {
            System.out.println("Please enter your base rate per window: ");
            double baseRate = userInput.nextDouble();
            System.out.println("Please enter your extra charge for hard-to-reach windows: ");
            double hardToReachExtra = userInput.nextDouble();
            System.out.println("Please enter your extra charge for complex windows: ");
            double complexExtra = userInput.nextDouble();
            System.out.println("Please enter your extra charge for heavily soiled windows: ");
            double soiledExtra = userInput.nextDouble();
            System.out.println("Please enter your overhead costs: ");
            double overhead = userInput.nextDouble();
            System.out.println("Please enter your profit margin percentage: ");
            double profitMargin = userInput.nextDouble();

            windowClass selfEstimator = new windowClass(
                    baseRate, // Base rate per window in New Jersey
                    hardToReachExtra, // Extra charge for hard-to-reach windows
                    complexExtra, // Extra charge for complex windows
                    soiledExtra, // Extra charge for heavily soiled windows
                    overhead, // Overhead costs in New Jersey
                    profitMargin); // Profit margin percentage

            System.out.println("Please enter the number of windows you would like to clean: ");
            int numWindows = userInput.nextInt();
            System.out.println("Please enter the number of hard-to-reach windows you would like to clean: ");
            int numHardToReach = userInput.nextInt();
            System.out.println("Please enter the number of complex windows you would like to clean: ");
            int numComplex = userInput.nextInt();
            System.out.println("Please enter the number of heavily soiled windows you would like to clean: ");
            int numSoiled = userInput.nextInt();

            double totalCost = selfEstimator.calculateTotalCost(
                    numWindows, // Total number of windows
                    numHardToReach,  // Number of hard-to-reach windows
                    numComplex,  // Number of complex windows
                    numSoiled); // Number of heavily soiled windows

            System.out.println("Total cost for cleaning " + numWindows + " windows: $" + totalCost);



        }

        else if (userChoice.equals("n")){

            windowClass estimator = new windowClass(
                    7.0, // Base rate per window in New Jersey
                    3.0, // Extra charge for hard-to-reach windows
                    2.5, // Extra charge for complex windows
                    4.0, // Extra charge for heavily soiled windows
                    600.0, // Overhead costs in New Jersey
                    15.0); // Profit margin percentage


            double totalCost = estimator.calculateTotalCost(
                    1000, // Total number of windows
                    100,  // Number of hard-to-reach windows
                    150,  // Number of complex windows
                    200); // Number of heavily soiled windows

            System.out.println("Total cost for cleaning 1000 windows: $" + totalCost);
       }
        else {
            System.out.println("Please enter a valid input.");
        }

    }
}
