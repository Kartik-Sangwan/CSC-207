package uoft.csc207.fishtank;

import android.graphics.Color;

/** A Predator. */
class Predator extends Fish{

    Predator(int x, int y, FishTankManager m) {
        super("><PREDATOR>", x, y, m);
        paintText.setColor(Color.RED);
    }

    void eat() {
        for (int a = 0; a != manager.myLittleFishies.size(); a++) {
            Object creature = manager.myLittleFishies.get(a);
            if (!(creature instanceof Predator) && !(creature instanceof HungryFish) &&
                    creature instanceof Fish) {
                float distance = (((Fish) creature).x-x)*(((Fish) creature).x-x) +
                        (((Fish) creature).y-y)*(((Fish) creature).y-y);
                if (distance < 10) {
                    manager.myLittleFishies.remove(creature);
                    System.out.println("FISH EATEN YUM YUM");
                }
            }
        }
    }
}
