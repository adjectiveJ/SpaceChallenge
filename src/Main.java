/**
 * Created by Donasia "Dojo" Brown
 * Project: SpaceChallenge
 * Date Created: 8/31/2022 @ 22:07
 */
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        // Create a simulation object
        Simulation sim = new Simulation();

        // Create empty lists for items for each phase
        ArrayList<Item> ph1_items = null;
        ArrayList<Item> ph2_items = null;

        // Load Phase 1 items
        try {
            ph1_items = sim.loadItems("phase-1.txt");
            System.out.println("Phase 1 Items Loaded");
        } catch (Exception e) {
            System.out.println("Error: Main class - " + e);
        }

        // Load Phase 2 items
        try {
            ph2_items = sim.loadItems("phase-2.txt");
            System.out.println("Phase 2 Items Loaded");
        } catch (Exception e) {
            System.out.println("Error: Main class - " + e);
        }

        // Load fleet of U1 rockets
        ArrayList<Rocket> u1_ph1 = sim.loadU1(ph1_items);
        ArrayList<Rocket> u1_ph2 = sim.loadU1(ph2_items);

        System.out.println("\n/---------------------------------------------------/");

        // Run simulation with U1 rockets
        System.out.println("\nMAIN: Simulating U1 - Phase 1");
        int u1_ph1_budget = sim.runSimulation(u1_ph1);
        System.out.println("\nMAIN: Simulating U1 - Phase 2");
        int u1_ph2_budget = sim.runSimulation(u1_ph2);
        int u1_totalBudget = u1_ph1_budget + u1_ph2_budget;

        System.out.println("\n/---------------------------------------------------/");

        // Load fleet of U2 rockets
        ArrayList<Rocket> u2_ph1 = sim.loadU2(ph1_items);
        ArrayList<Rocket> u2_ph2 = sim.loadU2(ph2_items);

        // Run simulation with U1 rockets
        System.out.println("\nMAIN: Simulating U2 - Phase 1");
        int u2_ph1_budget = sim.runSimulation(u2_ph1);
        System.out.println("\nMAIN: Simulating U2 - Phase 2");
        int u2_ph2_budget = sim.runSimulation(u2_ph2);
        int u2_totalBudget = u2_ph1_budget + u2_ph2_budget;

        // Display budget required for U1 rockets
        System.out.println("\nU1 ROCKET SUMMARY" +
                "\n-----------------" +
                "\nPhase 1 Budget: $" + u1_ph1_budget + " million" +
                "\nPhase 2 Budget: $" + u1_ph2_budget + " million" +
                "\nTOTAL BUDGET: $" + u1_totalBudget + " million\n");

        // Display budget required for U2 rockets
        System.out.println("U2 ROCKET SUMMARY" +
                "\n-----------------" +
                "\nPhase 1 Budget: $" + u2_ph1_budget + " million" +
                "\nPhase 2 Budget: $" + u2_ph2_budget + " million" +
                "\nTOTAL BUDGET: $" + u2_totalBudget + " million\n");

        // MIXED FLEET BUDGET RESULTS
        int u1u2_totalBudget = u1_ph1_budget + u2_ph2_budget;
        System.out.println("DUAL U1-PH1/U2-PH2 ROCKET SUMMARY" +
                "\n---------------------------------" +
                "\nU1 Phase 1 Budget: $" + u1_ph1_budget + " million" +
                "\nU2 Phase 2 Budget: $" + u2_ph1_budget + " million" +
                "\nTOTAL BUDGET: $" + u1u2_totalBudget + " million\n");

        int u2u1_totalBudget = u2_ph1_budget + u1_ph2_budget;
        System.out.println("DUAL U2-PH1/U1-PH2 ROCKET SUMMARY" +
                "\n---------------------------------" +
                "\nU2 Phase 1 Budget: $" + u1_ph1_budget + " million" +
                "\nU1 Phase 2 Budget: $" + u2_ph1_budget + " million" +
                "\nTOTAL BUDGET: $" + u2u1_totalBudget + " million\n");


    }
}
