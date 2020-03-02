package Assignment2;
// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// further updated and created by
//Student Name: Md Abu Joni
//Reg. No. 1606072
//Assignment 2
//Submission Date: 11/12/2017
//CE203 Application Programming
import java.awt.*;

public abstract class GameShapes  {
    protected  int xPoint, yPoint, size, width,height;
    public abstract void draw(Graphics g);
}

//Encapsulated different shape class extend abstract class and its variables
class Square extends GameShapes{

    public  Square (int x, int y, int size){
        this.xPoint= x;
        this.yPoint = y;
        this.size = size;
    }
    public  void draw(Graphics g){
        g.fill3DRect(xPoint,yPoint,size,size,true);

    }
}
class ShapeRectangle extends GameShapes{

    public ShapeRectangle(int x, int y, int width, int height){
        this.width= width;
        this.height= height;
        this.xPoint= x;
        this.yPoint=y;

    }
    public  void draw(Graphics g) {
        g.setColor(new Color(197, 179, 88));
        g.fillRect(xPoint,yPoint,width,height);
    }

}
class Circle extends GameShapes{
    public Circle(int x, int y,int size){
        this.size=size;
        this.xPoint= x;
        this.yPoint=y;
    }
    public  void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xPoint,yPoint,size,size);

    }

}
