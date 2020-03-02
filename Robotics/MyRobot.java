package Assignment2;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mj16123 on 15/03/2018.
 */
public class MyRobot {
    File f = new File("data.csv");
    FileOutputStream out = null;
    DataOutputStream data;
    DifferentialPilot pilot = new DifferentialPilot(3.2f, 18f, Motor.C, Motor.A, false);
    OdometryPoseProvider odo = new OdometryPoseProvider(pilot);
    NXTRegulatedMotor ml= Motor.C;
    NXTRegulatedMotor mr = Motor.A;
    UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);

    public void run ( ) throws IOException {
        pilot.addMoveListener(odo);
        Navigator navigator = new Navigator(pilot, odo);
        try {
            f . createNewFile ( ) ;
            out = new FileOutputStream (f ) ;
            data = new DataOutputStream ( out ) ;
        }
        catch ( IOException e ) {}
        while (pilot.isMoving()) {
            pilot.travel(100);
            data.writeChars(String.valueOf(odo.getPose().getX()));
            data.writeChars(",") ;
            data.writeChars (String.valueOf(odo.getPose().getY()));
            data.writeChars ("\r\n") ;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
