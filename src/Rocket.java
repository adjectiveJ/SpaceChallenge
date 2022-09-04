/**
 * Created by Donasia "Dojo" Brown
 * Project: SpaceChallenge
 * Date Created: 8/31/2022 @ 21:15
 */

public class Rocket implements SpaceShip {
    int weight;
    double totalWeight;
    double maxWeight;
    int costInMillions;

    public boolean launch(){
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item){
        return totalWeight + item.weight < maxWeight;
    }

    public void carry(Item item){
        totalWeight += item.weight;
    }
}
