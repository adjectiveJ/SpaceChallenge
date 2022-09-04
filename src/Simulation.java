/**
 * Created by Donasia "Dojo" Brown
 * Project: SpaceChallenge
 * Date Created: 8/31/2022 @ 21:44
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Simulation {
    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> itemsToLoad = new ArrayList<>();

        try {
            System.out.println("Loading items from " + filename);
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splitLine = line.split("=");
                Item item = new Item();
                item.name = splitLine[0];
                item.weight = Integer.parseInt(splitLine[1]);
                itemsToLoad.add(item);
            }
        } catch (FileNotFoundException e){
            System.out.println("Simulation Error: File \""+filename+"\" not found.");
        }
        return itemsToLoad;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsToLoad) {
        ArrayList<Rocket> u1rockets = new ArrayList<>();

        //Create first rocket
        U1 rocket = new U1();
        // Add this rocket to the rockets list
        u1rockets.add(rocket);

        for (Item item : itemsToLoad){
            //For each item, see if current rocket can carry the item
            if(rocket.canCarry(item)){
                // If yes, add the item to the rocket
                rocket.carry(item);
            } else {
                // If not, create a new rocket
                rocket = new U1();

                // Add new rocket to the rockets list
                u1rockets.add(rocket);

                // Give item to the new rocket
                rocket.carry(item);
            }
        }
        return u1rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsToLoad) {
        ArrayList<Rocket> u2rockets = new ArrayList<>();

        //Create first rocket
        U2 rocket = new U2();
        // Add this rocket to the rockets list
        u2rockets.add(rocket);

        for (Item item : itemsToLoad){
            //For each item, see if current rocket can carry the item
            if(rocket.canCarry(item)){
                // If yes, add the item to the rocket
                rocket.carry(item);
            } else {
                // If not, create a new rocket
                rocket = new U2();

                // Add new rocket to the rockets list
                u2rockets.add(rocket);

                // Give item to the new rocket
                rocket.carry(item);
            }
        }
        return u2rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int totalCost = 0; //million $
        int rocketCount = 0;

        for (Rocket rocket : rockets){
            rocketCount ++;
            // int attemptCount = 0;
            boolean launchAgain = true;

            while (launchAgain) {
                // attemptCount ++;
                totalCost += rocket.costInMillions;
                // System.out.println("\nSIM: Sending rocket #"+ rocketCount + " | Take: " + attemptCount);

                if (rocket.launch()) {
                    if (rocket.land()) {
                        // System.out.println("Rocket #" + rocketCount + " successful!");
                        launchAgain = false;
                    } else {
                        System.out.println("Rocket #" + rocketCount + " crashed!");
                    }
                } else {
                    System.out.println("Rocket #" + rocketCount + " exploded!");
                }
            }
        }
        return totalCost; //million $
    }
}
