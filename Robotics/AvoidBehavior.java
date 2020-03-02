package Assignment2;

import lejos.robotics.subsumption.Behavior;

/**
 * Created by mj16123 on 15/03/2018.
 */
public class AvoidBehavior {
    public static boolean suppressed;
    private static MyRobot r;

    public AvoidBehavior(MyRobot r1){
        this.r=r1;
    }
    public boolean takeControl() {
        return (r.us.getRange()<10);
    }


    public void stop() {
        suppressed = false;
        r.ml.backward();
        r.mr.backward();
        try {Thread.sleep(2000);}
        catch (Exception e ){;}
        r.ml.stop();
        r.mr.stop();

    }

    public void suppress() {
        suppressed=true;
    }
}
