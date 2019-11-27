package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;

class Seaweed extends Creatures{

  /** The number of weed segments. */
  private int l;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;

  /**
   * Constructs a new seaweed item at the specified cursor location (x,y),l segments tall.
   * @param l the number of segments this seaweed is tall.
   */
  Seaweed(int l, int first, int second, FishTankManager m) {
    super(first,second, m);
    this.l = l;
    paintText.setColor(Color.GREEN);
  }

  /**
   * Draws this fish tank item. Looks lovely waving in the current, doesn't it?
   *
   * @param canvas the graphics context in which to draw this item.
   */
  void draw(Canvas canvas) {

    boolean lR = leanRight;

    for (int i = 0; i < l; i++) {
      if (i % 2 == 0 && lR)
          // Draw the string
          drawString(canvas, "/", -i + x, (y));
      if (i % 2 == 1 && lR)
          // Draw the string
          drawString(canvas, "\\", -i + x, (y));
      if (i % 2 == 0 && !lR)
          // Draw the string
          drawString(canvas, "\\", -i + x, (y));
      if (i % 2 == 1 && !lR)
        // Draw the string
        drawString(canvas, "/", -i + x, (y));
    }
  }
  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param canvas where to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  private void drawString(Canvas canvas, String s, int x, int y) {
    canvas.drawText(s, y * FishTankView.charWidth, x * FishTankView.charHeight, paintText);
  }

  /** Causes this item to take its turn in the fish-tank simulation. */
  void wave() {
    leanRight = !leanRight;
  }
}
