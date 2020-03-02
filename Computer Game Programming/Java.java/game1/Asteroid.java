package game1;

import Utilities.Vector2D;

import static game1.Constants.DT;
import static game1.Constants.FRAME_HEIGHT;
import static game1.Constants.FRAME_WIDTH;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Asteroid extends GameObject {
	public static final int RADIUS = 20;
	public static final double MAX_SPEED = 100;
	Image img = Constants.ASTEROID1;
	
	public Asteroid(double x, double y, double vx, double vy) {
		super(new Vector2D(x,y),new Vector2D(vx, vy), RADIUS);
	}

	public static Asteroid makeRandomAsteroid() {
		double x= Math.random()*FRAME_WIDTH;
		double y = Math.random()*FRAME_HEIGHT;
		double vx= (Math.random()-0.5)*MAX_SPEED*(2);
		double vy= (Math.random()-0.5)*MAX_SPEED*(2);
		return new Asteroid(x,y,vx, vy);
	}


	@Override
	public void hit(GameObject object) {

	}

	public void update() {
	    super.update();
	}
	public void draw(Graphics2D g) {
        g.drawImage(img,(int) position.x - RADIUS, (int) position.y - RADIUS, 2 * RADIUS, 2 * RADIUS,null);
	}
}