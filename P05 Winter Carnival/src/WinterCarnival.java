//////////////// FILE HEADER //////////////////////////
//
// Title: P05 Winter Carnival
// Files: WinterCarnival, StarshipRobot, FrozenStatue, DancingBadger
// Course: CS300,Spring, 2020
//
// Author: Meng Tian
// Email: mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
import java.util.ArrayList;

/**
 * create a class WinterCarnival with its constructors and methods
 */
public class WinterCarnival extends SimulationEngine {
  private ArrayList<FrozenStatue> objects;

  /**
   * Creates a new winter carnival object
   */
  public WinterCarnival() {
    objects = new ArrayList<>();// initialize the arraylist of object frozen statue
    // add in two frozen statues
    objects.add(new FrozenStatue(new float[] {600, 100}));
    objects.add(new FrozenStatue(new float[] {200, 500}));
    // add in two starship robots
    objects.add(new StarshipRobot(new float[][] {{0, 0}, {600, 100}}));
    objects.add(new StarshipRobot(new float[][] {{800, 300}, {200, 500}}));
    // add in four dancing badgers
    objects.add(new DancingBadger(new float[] {304, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up}));
    objects.add(new DancingBadger(new float[] {368, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up}));
    objects.add(new DancingBadger(new float[] {432, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up}));
    objects.add(new DancingBadger(new float[] {496, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up}));
  }

  /**
   * update the winter carnival by presenting frozen statue objects on it override the update method
   * in simulation engine
   */
  @Override
  public void update() {
    for (int i = 0; i < objects.size(); i++)
      objects.get(i).update(this);
  }

  public static void main(String[] args) {

    WinterCarnival blueBackground = new WinterCarnival();
  }

}
