/**
 * Created by Donasia "Dojo" Brown
 * Project: SpaceChallenge
 * Date Created: 8/31/2022 @ 22:39
 */

public class U2 extends Rocket {
    double launchFailPercentage = 0.04;
    double landFailPercentage = 0.08;

    public U2(){
        costInMillions = 120;
        weight = 18000;
        totalWeight += weight;
        maxWeight = 29000;
    }

    @Override
    public boolean launch(){
        double rand = Math.random()*10;
        double exploChance = launchFailPercentage * (weight / maxWeight)*100;
        return exploChance <= rand;
    }

    @Override
    public boolean land(){
        double rand = Math.random()*10;
        double crashChance = landFailPercentage * (weight / maxWeight)*100;
        return crashChance <= rand;
    }
}