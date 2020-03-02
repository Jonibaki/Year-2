package game1;

import Utilities.SoundManager;
import Utilities.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;


public class EnemyShip extends GameObject{
    public boolean thrusting ;
    public Bullet bullet = null;
    public  int BUL_SPEED = 50;
    public static final int RADIUS = 8;
    public boolean dead = false;

    // rotation velocity in radians per second
    public static final double STEER_RATE = 2* Math.PI;
    // acceleration when thrust is applied
    public static final double MAG_ACC = 100;
    // constant speed loss factor
    public static final double DRAG = 0.01;
    public static final Color COLOR = Color.cyan;
    //Co-ordinate for drawing ships
    private static final double DRAWING_SCALE = 0.1;
    // direction in which the nose of the ship is pointing
    // this will be the direction in which thrust is applied
    // it is a unit vector representing the angle by which the ship has rotated
    public Vector2D direction;
    // controller which provides an Action object in each frame
    private Controller ctrl;
    Image img = Constants.SPACESHIP2;

    public EnemyShip(Controller ctrl) {
        super(new Vector2D(Math.random()*Constants.FRAME_WIDTH,Math.random()*Constants.FRAME_WIDTH),new Vector2D(0,0),RADIUS);
        this.ctrl = ctrl;
        direction = new Vector2D(1,0);
    }


    @Override
    public void hit(GameObject object) {
        if(object instanceof Bullet){
            dead=false;
        }

    }

    public void update() {
        super.update();
        Action ac = ctrl.action();
        if(ac.thrust!=0){
            this.velocity.addScaled(direction,MAG_ACC*Constants.DT*ac.thrust);
        }
        if(ac.turn!=0){
            direction.rotate(STEER_RATE*Constants.DT*ac.turn);
        }
        this.velocity.mult(1-DRAG);
        if (ac.shoot){
            mkBullet();
            if(bullet.position.x<Constants.FRAME_WIDTH){
                dead=true;
            }
            ac.shoot=false;
        }
    }
    public void mkBullet(){
        Vector2D bulLocation = new Vector2D(1,0);
        bulLocation.mult(this.radius+8);
        bulLocation.rotate(direction.angle());
        bulLocation.add(position);
        bullet = new Bullet (bulLocation, new Vector2D(velocity));
        bullet.velocity = new Vector2D(velocity).addScaled(direction,BUL_SPEED);
        SoundManager.fire();
    }

    public void draw(Graphics2D g){
        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        double rot = direction.angle() + Math.PI / 2;
        g.rotate(rot);
        g.scale(DRAWING_SCALE, DRAWING_SCALE);
        g.setColor(COLOR);
        g.drawImage(img,img.getWidth(null)/(-2), img.getHeight(null)/(-2), img.getWidth(null), img.getHeight(null),null);
        if (thrusting) {
            g.drawImage(img,img.getWidth(null)/(-2), img.getHeight(null)/(-2), img.getWidth(null), img.getHeight(null),null);
        }

        g.setTransform(at);
    }

}