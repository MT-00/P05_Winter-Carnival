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
 * create a class StarshipRobot with its constructors and methods
 */
public class StarshipRobot extends FrozenStatue {
  protected float[][] beginAndEnd;// array of the starting position and end position
  protected float[] destination;// the position that the robot moves toward
  protected float speed;// the robot move during each update

  /**
   * Creates a new starship robot object with input a 2D float array of its begin and end position
   * 
   * @param array two-dimensional float array with the begin and end position of the object
   */
  public StarshipRobot(float[][] array) {
    super(array[0]);
    beginAndEnd = array;// set the begin and end position
    destination = array[1];// set the destination
    speed = 6;// set the speed to 6
    isFacingRight = true;// set the facing of the object to right first
    imageName = "images" + File.separator + "starshipRobot.png";// set the name of the image
  }

  /**
   * change the position of the starship each time to move toward destination
   * 
   * @return true/false depends on the distance between the current position of the object and its
   *         destination
   */
  protected boolean moveTowardDestination() {
    // update position according to the given formula
    float oldX = x;
    float oldY = y;
    float dis =
        (float) Math.sqrt(Math.pow(oldX - destination[0], 2) + Math.pow(oldY - destination[1], 2));
    float newX = oldX + (speed * (destination[0] - oldX)) / (dis);
    float newY = oldY + (speed * (destination[1] - oldY)) / (dis);
    if (newX > oldX)// change the facing of the robot based on its x position
      isFacingRight = true;
    else
      isFacingRight = false;
    x = newX;
    y = newY;
    // determine the return value
    if (dis < 2 * speed)// check if the starship robot is close enough to the destination
      return true;
    return false;
  }

  /**
   * update the destination once the robot arrives
   */
  protected void updateDestination() {
    float[] intermidiate;
    // check if the robot gets close to the destination
    // if it is, exchange the end position and the starting position
    // reset the destination according to different starting position
    if (!destination.equals(beginAndEnd[0])) {
      destination = beginAndEnd[0];
      intermidiate = beginAndEnd[0];
      beginAndEnd[0] = beginAndEnd[1];
      beginAndEnd[1] = intermidiate;
    } else {
      destination = beginAndEnd[1];
      intermidiate = beginAndEnd[1];
      beginAndEnd[1] = beginAndEnd[0];
      beginAndEnd[0] = intermidiate;
    }

  }

  /**
   * update the starship robot by drawing it on simulation engine override the update(simulation
   * engine) method in frozen statue
   * 
   * @param e SimulationEngine type that draw the position of starship robot
   */
  @Override
  public void update(SimulationEngine e) {
    if (moveTowardDestination() == false) { // if object hasn't moved to its destination,
      // move to the destination
      super.update(e);
    } else { // if object reaches its destination, change starting point and destination
      updateDestination();
      super.update(e);
    }
  }
}
