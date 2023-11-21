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
}
