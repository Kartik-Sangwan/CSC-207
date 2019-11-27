package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/** A fishtank Creature. */
abstract class Creatures {
    Paint paintText = new Paint();
    /** How this creature appears on the screen. */
    String appearance;
    /** This creature's first coordinate. */
    int x;
    /** This creature's second coordinate. */
    int y;
    FishTankManager manager;
    Creatures(int first, int second, FishTankManager m) {
        x = first;
        y = second;
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        manager = m;
    }
    Creatures(String look, int first, int second, FishTankManager m) {
        appearance = look;
        x = first;
        y = second;
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        manager = m;
    }

    /**
     * Draws the given string in the given graphics context at at the given cursor location.
     *
     * @param canvas the canvas on which to draw this item.
     * @param s the string to draw.
     * @param x the x-coordinate of the string's cursor location.
     * @param y the y-coordinate of the string's cursor location.
     */
    private void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the canvas on which to draw this item.
     */
    void draw(Canvas canvas) {
        drawString(canvas, appearance, x, y);
    }

}
