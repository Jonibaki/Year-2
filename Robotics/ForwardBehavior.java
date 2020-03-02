package Assignment2;

import lejos.robotics.subsumption.Behavior;


/**
 * Created by mj16123 on 15/03/2018.
 */
public class ForwardBehavior extends Thread {
    public MySensors r;
    public ForwardBehavior(MySensors rl){
        this.setDaemon(true);
        r=rl;
    }

    @Override
    public void run() {

    }
}
