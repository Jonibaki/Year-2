package game1;

import Utilities.Vector2D;
import java.awt.*;

public abstract class GameObject  {
    public Vector2D position;
    public Vector2D velocity;
    public boolean dead =false;
    public double radius;
    public GameObject(Vector2D position, Vector2D velocity, double radius) {
        this.position = position;
        this.velocity = velocity;
        this.radius = radius;
    }
    public void hit(){
        dead=true;
    }

    public abstract void hit(GameObject object);

    public void update() {
        position.addScaled(velocity,Constants.DT);
        position.wrap(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
    }
    public abstract void draw (Graphics2D g);
    public boolean overlap(GameObject other){
        double distance = position.dist(other.position);
        if(distance<this.radius+other.radius){
            return true;
        }else{
          return false;
        }
    }
    public void collisionHandling(GameObject other) {
        if (this.getClass()!= other.getClass() && this.overlap(other)) {
            this.hit();
            other.hit();
        }
    }
}
