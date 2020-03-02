//Created by Md Abu Joni
//Reg. No. 1606072
//Assignment 2
//Submission Date: 11/12/2017
//CE203 Application Programming
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Random;


public class ShapeView extends JComponent implements MouseListener,MouseMotionListener {
    int w=20, h=20;
    static int size = 20;

    //Array of shape that holds all the shapes from abstract class
    Shapes[] arrayShapes = new Shapes[5];
    Random rand = new Random();
    //each of these array holds random number of individual shape's coordinates, width and height
    int[] squareParams = {rand.nextInt(400), rand.nextInt(400), (rand.nextInt(400)),rand.nextInt(45)};
    int[] rectParams = {rand.nextInt(400), rand.nextInt(400), rand.nextInt(300),rand.nextInt(300)};
    int[] circleParams = {rand.nextInt(400), rand.nextInt(400), rand.nextInt(300)};
    int[] pieParams = {rand.nextInt(400), rand.nextInt(400), rand.nextInt(300),rand.nextInt(300),rand.nextInt(90),rand.nextInt(90)};

    // Arrays of random xCoordinate and yCoordinate of Polygon
    int [] xCoordinate = {(int)(Math.random()*400),(int)(Math.random()*400),(int)(Math.random()*400)};
    int [] yCoordinate = {(int)(Math.random()*400),(int)(Math.random()*400),(int)(Math.random()*400)};
    int[][] triParams = {xCoordinate, yCoordinate};

    // state of mouse movement
    boolean isRunning = false;

    //change this variable upon each shape clicked
    private  int scenario = 0 ;

    //constructor holds the mouse listener
    public ShapeView() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;

        //draws 20X20 square grids in the frame
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h ; j++) {
                g.drawRect(i * size, j * size, size, size);
            }
        }

        //sets each position of the shapes and add to the shape array
        arrayShapes[0] = new Square(squareParams[0] , squareParams[1], squareParams[2] ,squareParams[3]); //for square
        arrayShapes[1] = new Rectangle(rectParams[0] , rectParams[1], rectParams[2],rectParams[3]); //for rectangle
        arrayShapes[2] = new Circle(circleParams[0],circleParams[1],circleParams[2]); //for circle
        arrayShapes[3] = new PieShape(pieParams[0],pieParams[1],pieParams[2],pieParams[3],pieParams[4],pieParams[5]); //for PieShape
        arrayShapes[4] = new Triangle(xCoordinate,yCoordinate,3); //for Triangle

        //draw all the shapes
        for(int i=0; i<arrayShapes.length;i++){
            arrayShapes[i].draw(g2d);
        }

        g2d.dispose();
    }
    //method sets the dimension of the frame
    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //current location of mouse points
        int currentX= e.getX();
        int currentY= e.getY();

        // each condition search for shapes x and y coordinate
        // against the current location of the mouse
        // and assigned different number to the shape tracker

        //square
        if ((currentX > squareParams[0] && currentX < squareParams[0]+squareParams[2] )&& (currentY > squareParams[1] && currentY < squareParams[1]+squareParams[2])) {
            System.out.println("Square clicked");
            scenario=1;
            isRunning=true;
        }
        //rectangle
        if ((currentX > rectParams[0] && currentX < rectParams[0]+rectParams[2] )&& (currentY > rectParams[1] && currentY < rectParams[1]+rectParams[3])) {
            System.out.println("Rectangle Clicked");
            scenario = 2;
            isRunning = true;
        }
        //circle
        if ((currentX > circleParams[0] && currentX < circleParams[0]+circleParams[2] )&& (currentY > circleParams[1] && currentY < circleParams[1]+circleParams[2])) {
            System.out.println("Circle Clicked");
            scenario = 3;
            isRunning = true;
        }
        //Pie Shape
        if ((currentX > pieParams[0] && currentX < pieParams[0]+pieParams[2] )&& (currentY > pieParams[1] && currentY < pieParams[1]+pieParams[3])) {
            System.out.println("Pie Clicked");
            scenario = 4;
            isRunning = true;
        }
        //Triangle
        if ((currentX > triParams[0][0] && currentX < triParams[0][0]+triParams[0][1] )&& (currentY > triParams[1][0] && currentY < triParams[1][0]+triParams[1][1])) {
            System.out.println("Triangle Clicked");
            scenario = 5;
            isRunning = true;
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        isRunning=false;

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int currentX = e.getX();
        int currentY = e.getY();
        //repaint square as mouse dragged around
        if (scenario == 1 && isRunning) {
            squareParams[0] = currentX;
            squareParams[1] = currentY;
            repaint();
        }
        //repaint rectangle as mouse dragged around
        if (scenario == 2 && isRunning) {
            rectParams[0] = currentX;
            rectParams[1] = currentY;
            repaint();
        }
        //repaint circle as mouse dragged around
        if (scenario == 3 && isRunning) {
            circleParams[0] = currentX;
            circleParams[1] = currentY;
            repaint();
        }
        //repaint pie as mouse dragged around
        if (scenario == 4 && isRunning) {
            pieParams[0] = currentX;
            pieParams[1] = currentY;
            repaint();
        }
        //repaint triangle as mouse dragged around
        if (scenario == 5 && isRunning) {
            triParams[0][0] = currentX;
            triParams[0][1] = currentY;
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //Print out current x and y coordinate of the mouse
        System.out.println("The new Location is X:" + e.getX() + " Y:" + e.getY());

    }
    //unused implemented methods from mouseListener class
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
