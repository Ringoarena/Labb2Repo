package UI;

public class StatisticsMenu {
    private static boolean previous;

    public static void runSubMenu() {
        previous = false;
        printHeader();

        while (!previous) {
            printMenu();
            performAction(Utilities.getInput(0, 6));
        }
    }

    private static void printHeader() {
        System.out.println("\n+-----------------+");
        System.out.println("|Statistics Header|");
        System.out.println("+-----------------+");
    }

    private static void printMenu() {
        System.out.println("\nStatistics menu");
        System.out.println("1. Average wage");
        System.out.println("2. Maximum wage");
        System.out.println("3. Minimum wage");
        System.out.println("4. Total bonus");
        System.out.println("5. Percentage women");
        System.out.println("6. Percentage men per role");
        System.out.println("0. Return to previous menu");
    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nReturning to previous menu...");
                previous = true;
                break;
            case 1:
                System.out.println("\nCalling sub-option 1...");
                break;
            case 2:
                System.out.println("\nCalling sub-option 2...");
                break;
            case 3:
                System.out.println("\nCalling sub-option 3...");
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
