package uoft.csc207.fishtank;

import android.graphics.Color;

/** A bubble. */
class Bubble extends Creatures{

  /** Use for random movement left and right. */
  private double d;

  /** Constructs a new bubble at the specified cursor location (x, y). */
  Bubble(int x, int y, FishTankManager m) {
    super(".",x,y,m);
    paintText.setColor(Color.LTGRAY);
  }

  void setD(double d) {
    this.d = d;
  }

  /** Causes this item to take its turn in the fish-tank simulation, moving straight up. */
  void Float() {

    if (d < 0.33) {
      y--;
    } else if (d < 0.66) {
      y--;
      x += 1;
    } else {
      y--;
      x -= 1;
    }
    if (d < 0.05) {
      if (appearance.equals(".")) appearance = "o";
      else if (appearance.equals("o")) appearance = "O";
    }
  }
}
