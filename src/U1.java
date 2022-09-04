/**
 * Created by Donasia "Dojo" Brown
 * Project: SpaceChallenge
 * Date Created: 8/31/2022 @ 21:24
 */

public class U1 extends Rocket {
    double launchFailPercentage = 0.05;
    double landFailPercentage = 0.01;

    public U1(){
        costInMillions = 100;
        weight = 10000;
        totalWeight += weight;
        maxWeight = 18000;
    }

    @Override
    public boolean launch(){
        double rand = Math.random()*10;
        double exploChance = 0.05 * ((totalWeight / maxWeight)*100);
        return exploChance <= rand;
    }

    @Override
    public boolean land(){
        double rand = Math.random()*10;
        double crashChance = landFailPercentage * (totalWeight / maxWeight)*100;
        return crashChance <= rand;
    }
}