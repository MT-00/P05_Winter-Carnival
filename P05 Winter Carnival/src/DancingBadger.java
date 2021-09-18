//////////////// FILE HEADER //////////////////////////
//
// Title: P05 Winter Carnival
// Files: WinterCarnival, StarshipRobot, FrozenStatue, DancingBadger
// Course: CS300,Spring, 2020
//
// Author: Meng Tian
// Email: mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
import java.io.File;

/**
 * create a class DancingBadger with its constructors and methods
 */
public class DancingBadger extends StarshipRobot {
  protected DanceStep[] danceSteps;// series of dancing steps 
  protected int stepIndex;// the index of the dancing steps

  /**
   * Creates a new frozen statue object with input a float array of its begin position and a array
   * of dancing steps
   * 
   * @param array one-dimensional array with the begin and end position of the object
   * @param dance one-dimensional array with a series of dancing steps enumerations
   */
  public DancingBadger(float[] array, DanceStep[] dance) {
    super(new float[][] {array, dance[0].getPositionAfter(array)});// call the base class' constructor
    beginAndEnd[0] = array;// set the start and end positions
    danceSteps = dance;// set the dancing steps
    imageName = "images" + File.separator + "dancingBadger.png";// set the name of the image
    speed = 2;// set the speed
    isFacingRight = true;// set the facing of the badger to right
    destination = danceSteps[0].getPositionAfter(array);// set the destination of the badger by the
                                                        // accessor defined in dance step class
    stepIndex = 1;
    x = array[0];
    y = array[1];// set the index to 1 because its current position is on step 0 already
  }

  /**
   * update the dancing badger by drawing it on simulation engine override the update(simulation
   * engine) method in starship robot
   */
  @Override
  public void updateDestination() {
    float[] start = new float[] {x, y};
    if (stepIndex < danceSteps.length) {
      destination = (danceSteps[stepIndex].getPositionAfter(start));// change the destination after
                                                                    // each dance step
      stepIndex++;// the index adds one each time
    } else {// if the badger has performed all steps
      // restart at the beginning
      stepIndex = 0;
      destination = (danceSteps[stepIndex].getPositionAfter(start));
      stepIndex++;
    }


  }
}
