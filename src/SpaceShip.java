/**
 * Created by Donasia "Dojo" Brown
 * Project: SpaceChallenge
 * Date Created: 8/31/2022 @ 21:12
 */

public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}
