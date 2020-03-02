package Assignment2;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Assignment2 extends  Thread {

    public static void main(String[] args) {
            //MyRobot me = new MyRobot();
            MySensors rm = new MySensors();
            ForwardBehavior b1= new ForwardBehavior(rm);
            b1.r.ml.setPower(30);
            b1.r.mr.setPower(30);
            b1.start();
            while (b1.r.us.getDistance()>10){
                try{
                    Thread.sleep(50);
                }catch (Exception e){

                }
            }
        }
}






