package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;

class FishTankManager {

  /** All the locations where a fish can be. */
  ArrayList<Object> myLittleFishies;
  /** The width of myLittleFishes. */
  private int gridWidth;
  /** The height of myLittleFishes. */
  private int gridHeight;

  /**
   * Return the width of a row of locations.
   *
   * @return the width of a column of locations.
   */
  private int getGridWidth() {
    return gridWidth;
  }

  /**
   * Return the height of a column of locations.
   *
   * @return the height of a column of locations.
   */
  private int getGridHeight() {
    return gridHeight;
  }

  /** The fish tank manager on a screen with height rows and width columns. */
  FishTankManager(int height, int width) {
    gridHeight = height;
    gridWidth = width;
    myLittleFishies = new ArrayList<>();
  }

  void draw(Canvas canvas) {
    for (int a = 0; a != myLittleFishies.size(); a++) {
          if (myLittleFishies.get(a) instanceof HungryFish) {
            ((HungryFish) myLittleFishies.get(a)).draw(canvas);
          } else if (myLittleFishies.get(a) instanceof Seaweed) {
            ((Seaweed) myLittleFishies.get(a)).draw(canvas);
          } else if (myLittleFishies.get(a) instanceof Bubble) {
            ((Bubble) myLittleFishies.get(a)).draw(canvas);
          } else {
              ((Fish) myLittleFishies.get(a)).draw(canvas);
          }
      }
    }

  void update() {
    ArrayList <Object> temp = new ArrayList<>();
    for (int a = 0; a != myLittleFishies.size(); a++) {
          if (myLittleFishies.get(a) instanceof HungryFish) {
            ((HungryFish) myLittleFishies.get(a)).move(getGridWidth(),getGridHeight());
          } else if (myLittleFishies.get(a) instanceof Seaweed) {
            ((Seaweed) myLittleFishies.get(a)).wave();
          } else if (myLittleFishies.get(a) instanceof Fish) {
            ((Fish) myLittleFishies.get(a)).move(getGridWidth(),getGridHeight());
          }
        if (myLittleFishies.get(a) instanceof Bubble) {
          // Figure out whether to float left or right, if at all.
          Bubble heybub = (Bubble) myLittleFishies.get(a);
          heybub.setD(Math.random());
          heybub.Float();
          if (heybub.y < 0) {
            temp.add(heybub);
          }
        }
        if (myLittleFishies.get(a) instanceof Predator) ((Predator)myLittleFishies.get(a)).eat();
      }
    myLittleFishies.removeAll(temp);
    }

  void createTankItems() {
    myLittleFishies.add(0,new Fish(28,18, this));
    myLittleFishies.add(1,new Fish(10,27, this));
    myLittleFishies.add(2,new Fish(17,14, this));
    myLittleFishies.add(3,new Fish(15,28, this));
    myLittleFishies.add(4,new Fish(30,33, this));
    myLittleFishies.add(5,new Fish(16,5, this));
    myLittleFishies.add(6,new Fish(16,12, this));
    myLittleFishies.add(7,new Fish(16,18, this));
    myLittleFishies.add(8,new Fish(23,18, this));
    myLittleFishies.add(9,new Fish(6,12, this));
    myLittleFishies.add(10,new Fish(16,12, this));
    myLittleFishies.add(11,new Fish(26,22, this));
    myLittleFishies.add(12,new Fish(36,42, this));
    myLittleFishies.add(13,new Fish(39,12, this));
    myLittleFishies.add(14,new Fish(37,22, this));
    myLittleFishies.add(15, new HungryFish(10,12, this));
    myLittleFishies.add(16, new Seaweed(9, 33, 4, this));
    myLittleFishies.add(17, new Seaweed(6,24,13, this));
    myLittleFishies.add(18, new Seaweed(14,42,15, this));
    myLittleFishies.add(19, new Seaweed(5,13,20, this));
    myLittleFishies.add(20, new Predator(12,20,this));
  }
}
