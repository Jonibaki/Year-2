package game1;

import Utilities.ImageManager;
import Utilities.JEasyFrameFull;

import java.awt.*;
import java.io.IOException;

public class Constants {
    public static final int FRAME_HEIGHT = JEasyFrameFull.HEIGHT;
    public static final int FRAME_WIDTH = JEasyFrameFull.WIDTH;
    public static final Dimension FRAME_SIZE = new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
    public static final int DELAY = 10;  // in milliseconds
    public static final double DT = DELAY / 1000.0;  // in seconds
    public static Image ASTEROID1, MILKYWAY1, SPACESHIP1, SPACESHIP2;
    static {
        try {
            ASTEROID1 = ImageManager.loadImage("asteroid1");
            MILKYWAY1 = ImageManager.loadImage("milkyway2");
            SPACESHIP1 = ImageManager.loadImage("spacecraft");
            SPACESHIP2 = ImageManager.loadImage("spaceship2");
        } catch (IOException e) { e.printStackTrace(); }
    }
}
