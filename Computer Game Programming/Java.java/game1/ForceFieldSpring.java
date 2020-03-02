package game1;
import Utilities.Vector2D;
import static game1.Constants.FRAME_HEIGHT;
import static game1.Constants.FRAME_WIDTH;
import game1.GameObject;

final public  class  ForceFieldSpring implements ForceField{

    final static Vector2D center=new Vector2D(FRAME_WIDTH/2.0,FRAME_HEIGHT/2.0);
    final static double elasticFactor=0.5;

    public void update(GameObject obj, double DT){
        Vector2D dist=new Vector2D(center).subtract(obj.position);
        if(obj.velocity.mag()<elasticFactor) {
            obj.velocity.addScaled(dist, elasticFactor * DT);
        }
    }

}