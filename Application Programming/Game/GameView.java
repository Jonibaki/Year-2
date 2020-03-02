package Assignment2;
// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// further updated and created by
//Student Name: Md Abu Joni
//Reg. No. 1606072
//Assignment 2
//Submission Date: 11/12/2017
//CE203 Application Programming

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import static java.awt.Color.*;

// import all the Colors

public class GameView extends JComponent implements KeyListener,ActionListener {
    HashMap<Integer,GameShapes> brickMap = new HashMap<>(); //hold blocks value
    static Color[] colors ={darkGray, green, blue, red, yellow, magenta, pink, cyan}; // an array of set of colours
    int[][] a;
    int w, h;
    static int size = 20;
    GameShapes[] gs  = new  GameShapes[3];

    boolean gamePlay= false;
    private  Timer time;
    //sliderBar X position in the frame
    private int sliderBar = 200;
    //ball position and direction
    private int ballPosX= 210;
    private int ballPosY=370;
    private int ballXdir= -1;
    private int ballYdir=-2;

    //different state of the game variable
    private int gameLive=3;
    private int gamePoints=0;
    private int remainBlocks=1;


    public GameView(int[][] a) {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.a = a;
        w = a.length;
        h = a[0].length;

        //sets the speed of the game
        time = new Timer(8,this);
        time.start();
    }
    public void paintComponent(Graphics g){



        gs[1] = new Circle(ballPosX,ballPosY,size); //For Ball
        gs[2] = new ShapeRectangle(sliderBar,390,50,10); //For Slider Bar

        //side bars of the frame
        g.setColor(Color.yellow);
        g.fill3DRect(0,0,3,400,true);//Left bar of the frame
        g.fill3DRect(0,0,400,3,true); //top bar of the frame
        g.fill3DRect(397,0,3,400,true); //Right bar of the frame

        // brick block draws and add to the hash map
            for (int i = 2; i < w - 2; i++) {
                for (int j = 2; j < h / 2; j++) {
                    g.setColor(colors[a[i][j]]);
                    gs[0] = new Square(i * size, j * size, size);
                   gs[0].draw(g);
                }
            }

        gs[1].draw(g); //ball
        gs[2].draw(g); //slider bar

        //Game points
        g.setColor(Color.white);
        g.drawString("Game Point(s): "+gamePoints,300,20);

        //Game credits
        g.setColor(Color.white);
        g.drawString("Live : "+gameLive,10,400);

        //when ball drop down it sets the actions in false
        // and shows message in screen to continue
        if(ballPosY>400){
            gamePlay=false;
            g.setColor(Color.RED);
            g.drawString("Press ENTER to continue",140,250);
        }

        g.dispose();

    }

    //performing all the action that done by the player while pressing down
    // left,right and enter key in the keyboard
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!gamePlay){
                gameDefault();
            }
        }
        //pressing down right arrow key to move the bar
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(sliderBar>350){
                sliderBar=350;
            }else{
                //move the slider to the right direction
                gamePlay=true;
                sliderBar+=20;
            }
        }
        // while pressing the left arrow key to move the slider bar
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(sliderBar<30){
                sliderBar=30;
            }else{
                //move the slider bar to the left direction
                gamePlay=true;
                sliderBar-=30;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //decrement X & Y position for ball and check against side bars' and slider bar's intersection
        //with the ball as it moves around the frame while the game play
        if(gamePlay) {

            Rectangle ball  = new Rectangle(ballPosX,ballPosY,20,20); //sets new rectangle around the ball
            Rectangle brick;

            //looping through each set of the map and creating new rectangle around them
            //further checking for interaction between those block and the
//            for (Map.Entry<Integer, GameShapes> entry : brickMap.entrySet()) {
//                brick = new Rectangle( entry.getValue().xPoint,entry.getValue().yPoint,entry.getValue().size,entry.getValue().size);
//                if(ball.intersects(brick) ){
//                    ballYdir=-ballYdir;
//                }
//            }


           ballPosX+=ballXdir;
           ballPosY+=ballYdir;

             if(ballPosX<3){
               ballXdir=-ballXdir;

           }
            if(ballPosY<3){
                ballYdir=-ballYdir;
            }
            if(ballPosX>380){
                ballXdir=-ballXdir;
            }

            //detect the intersect between ball and the slider bar and changes the ball direction
            if(ball.intersects(new Rectangle(sliderBar,390,40,8))){
                ballYdir=-ballYdir;
            }
            repaint();
        }
    }



    //default state of the game play
    public void gameDefault(){
        gamePlay=true;
        sliderBar=200;
        ballPosX= 210;
        ballPosY=370;
        ballXdir= -1;
        ballYdir=-2;
        gameLive=3;

    }

    //set dimension of the frame by 20X20
    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }


    //unused implemented methods of keyListener class
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {


    }
}
