package game1;

import Utilities.Vector2D;
import java.awt.*;

public class Bullet extends GameObject {
    public static final int RADIUS = 3  ;
    int i=1;
    public final int TIMER = 500; //duration time for bullet
    public Bullet(Vector2D position, Vector2D velocity) {
        super(position, velocity, RADIUS);
    }

    @Override
    public void update(){
        super.update();
        i++;
        if(i==TIMER) {
            dead = true;
        }
    }
    @Override
    public void hit(){
        dead= true;
    }

    @Override
    public void hit(GameObject object) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int)(position.x-radius),(int)(position.y-radius),(int)(2*radius),(int)(2*radius));
    }
}
