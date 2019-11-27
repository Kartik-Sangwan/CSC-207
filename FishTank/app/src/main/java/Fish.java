package uoft.csc207.fishtank;

import android.graphics.Color;

/** A fish. */
class Fish extends Creatures{

  /** Indicates whether this fish is moving right. */
  private boolean goingRight;

  /** Constructs a new fish. */
  Fish(int x, int y, FishTankManager m) {
    super("><>", x, y,m);
    paintText.setColor(Color.CYAN);
    goingRight = true;
  }

  Fish(String appearance, int x, int y, FishTankManager m) {
    super(appearance, x, y, m);
    this.appearance = appearance;
    paintText.setColor(Color.CYAN);
    goingRight = true;
  }

  /** Causes this fish to blow a bubble. */
  private void blowBubble() {
    Bubble b = new Bubble(x,y,manager);
    System.out.println(x + " " + y);
    manager.myLittleFishies.add(b);
  }

  /** Build and initialize this fish's forward and backward appearances. */
  private String reverseAppearance() {

    if (this instanceof HungryFish) {
        System.out.println("Turning around" + this.appearance);
    }
    String reverse = "";
    for (int i = appearance.length() - 1; i >= 0; i--) {
      switch (appearance.charAt(i)) {
        case ')':
          reverse = reverse.concat("(");
          break;
        case '(':
          reverse = reverse.concat(")");
          break;
        case '>':
          reverse = reverse.concat("<");
          break;
        case '<':
          reverse = reverse.concat(">");
          break;
        case '}':
          reverse = reverse.concat("{");
          break;
        case '{':
          reverse = reverse.concat("}");
          break;
        case '[':
          reverse = reverse.concat("]");
          break;
        case ']':
          reverse = reverse.concat("[");
          break;
        default:
          reverse = reverse.concat(Character.toString(appearance.charAt(i)));
          break;
      }
    }
    if (this instanceof HungryFish) {
        System.out.println("Turned around" + this.appearance);
    }
    return reverse;
  }

  /** Turns this fish around, causing it to reverse direction. */
  private void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
  }

  /** Causes this item to take its turn in the fish-tank simulation. */
  void move(int width, int height) {
      if ((this instanceof HungryFish || this instanceof Predator) && x == width - 7) {
          turnAround();
          x--;
      } else if (x == 0) {
          turnAround();
          x++;
      } else if (x == width - 1) {
          turnAround();
          x--;
      } else if (y < 2) {
        y = y + 5;
      } else if (y < -(height - 10)) {
        y = y - 5;
      }

    double d = Math.random();
    if (d < 0.1) {
      turnAround();
    }

    if (goingRight) {
      x += 1;
    } else {
      x -= 1;
    }

    d = Math.random();
    if (d < 0.1) {
      blowBubble();
    }

    d = Math.random();
    if (d < 0.1) {
      y += 1;
    } else if (d < 0.2) {
      y -= 1;
    }
  }
}
