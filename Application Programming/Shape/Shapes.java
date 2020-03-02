//Created by Md Abu Joni
//Reg. No. 1606072
//Assignment 2
//Submission Date: 11/12/2017
//CE203 Application Programming
import java.awt.*;

abstract class Shapes {
    //variables to hold each shapes coordinates and sizes
    protected int xPoint, yPoint,shapeWidth, shapeHeight,size, rotation;
    //abstract paint method that further implemented by individual shapes
    public abstract void draw(Graphics2D g2d);
    }
//All the shapes extends abstract Shape class and implemented its abstract method
//uses the same protected variables to initiate its coordinates and sizes
class Square extends Shapes {
    public  Square (int xPoint, int yPoint, int size,int rotation){

            this.xPoint=xPoint;
            this.yPoint=yPoint;
            this.size=size;
            this.rotation=rotation;
        }
    public  void draw(Graphics2D g2d){
           // g2d.rotate(Math.toRadians(rotation));
            g2d.setColor(Color.orange);
            g2d.fillRect(xPoint,yPoint,size,size);
        }
}
class Rectangle extends Shapes  {
    public  Rectangle (int xPoint, int yPoint, int shapeWidth, int shapeHeight){

        this.xPoint=xPoint;
        this.yPoint=yPoint;
        this.shapeWidth= shapeWidth;
        this.shapeHeight= shapeHeight;
    }
    public  void draw(Graphics2D g2d){
        g2d.setColor(Color.GREEN);
        g2d.fillRect(xPoint,yPoint,shapeWidth,shapeHeight);

    }
}
class Circle extends Shapes{
    public  Circle (int xPoint, int yPoint, int size) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.size = size;
    }
    public  void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillOval(xPoint,yPoint,size,size);

    }
}
class PieShape extends Shapes{
    private int x, y;
    public PieShape(int xPoint, int yPoint, int shapeWidth, int shapeHeight,int x,int y){
        this.xPoint=xPoint;
        this.yPoint=yPoint;
        this.shapeWidth= shapeWidth;
        this.shapeHeight= shapeHeight;
        this.x=x;
        this.y=y;
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.pink);
        g2d.fillArc(xPoint,yPoint,shapeWidth,shapeHeight,x,y);

    }
}
class Triangle extends Shapes{
    //arrays for polygons 1st and 2nd argument to create a triangle
    private int[] xCoordinate, yCoordinate;
    private int noAngle;
    public Triangle(int[] xCoordinate, int[]yCoordinate, int noAngle){
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
        this.noAngle=noAngle;
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.pink);
        g2d.fillPolygon(xCoordinate,yCoordinate,noAngle);
    }
}
