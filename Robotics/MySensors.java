package Assignment2;

import lejos.nxt.*;

/**
 * Created by mj16123 on 15/03/2018.
 */

public class MySensors  {
    public UltrasonicSensor us;
    public ColorSensor cs;
    public NXTMotor ml, mr;
    public MySensors()  {
        us = new UltrasonicSensor(SensorPort.S4);
        cs = new ColorSensor(SensorPort.S3 ) ;
        ml = new NXTMotor(MotorPort.C);
        mr = new NXTMotor(MotorPort.A);
    }
}

