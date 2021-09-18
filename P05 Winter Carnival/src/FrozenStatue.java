//////////////// FILE HEADER //////////////////////////
//
// Title: P05 Winter Carnival
// Files: WinterCarnival, StarshipRobot, FrozenStatue, DancingBadger
// Course: CS300,Spring,2020
//
// Author: Meng Tian
// Email: mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
import java.io.File;

/**
 * create a class FrozenStatue with its constructors and methods
 */
public class FrozenStatue {
  protected float x;// horizontal position of the object
  protected float y;// vertical position of the object 
  protected boolean isFacingRight;// used to mirror image
  protected String imageName;// set the name of the object

  /**
   * Creates a new frozen statue object with input a float array of its begin position
   * 
   * @param array two-dimensional array with the begin and end position of the object
   */
  public FrozenStatue(float[] array) {
    // the current position of the statue is at the starting point as input
    this.x = array[0];
    this.y = array[1];
    this.isFacingRight = true;// set the facing of the statue to right
    this.imageName = "images" + File.separator + "frozenStatue.png";// set the name of the image
  }

  /**
   * update the frozen statue by drawing on the simulation engine
   * 
   * @param engine SimulationEnigne type that draw the frozen statue
   */
  public void update(SimulationEngine engine) {
    engine.draw(this.imageName, this.x, this.y, !isFacingRight);
  }

}
