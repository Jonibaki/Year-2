package game1;

import Utilities.JEasyFrameFull;
import Utilities.SoundManager;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static game1.Constants.DELAY;

public class Game {
    public List<GameObject>objects;
    public static final int N_INITIAL_ASTEROIDS = 10; //number of Asteriods
    public List<Asteroid> asteroids;
    public Controller ctrl;
    public int score;
    public  int live = 3;
    public int level = 1;
    public Ship ship;
    public EnemyShip eShip;
    ForceFieldGravity gravity;
    RandomMovement randomMovement;

    public Game() {
        randomMovement = new RandomMovement();
        gravity = new ForceFieldGravity();
        objects = new ArrayList<GameObject>();
        asteroids = new ArrayList<Asteroid>();

        //creates random asteroids in the start of the game
        for (int i = 0; i < N_INITIAL_ASTEROIDS; i++) {
            objects.add(Asteroid.makeRandomAsteroid());
        }
        //add player and enemy ship into object
        ctrl = new Keys();
        eShip= new EnemyShip(randomMovement);
        ship = new Ship(ctrl);
        objects.add(ship);
        objects.add(eShip);
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        View view = new View(game);
        new JEasyFrameFull(view).addKeyListener((KeyListener) game.ctrl);
        while (true) {
            game.update();
            view.repaint();
            Thread.sleep(DELAY);
        }
    }
    public void update() {
        if (level>5){
            JOptionPane.showMessageDialog(null, "Mission Completed \n"+"Score: "+getScore());
            System.exit(0);
        }
        for(int i =0; i<objects.size();i++){
            GameObject ii =objects.get(i);
            for(int j=i;j<objects.size();j++){
                GameObject kk = objects.get(j);
                if(ii.getClass()!=kk.getClass()){
                    objects.get(i).collisionHandling(objects.get(j));
                }
            }
        }
        List<GameObject> alive = new ArrayList<GameObject>();

        for(GameObject o: objects){
            o.update();
            gravity.update(o,Constants.DT); //gravity effect of the game;
        }
        for(GameObject a: objects){
            if(!a.dead){
                a.update();
                alive.add(a);
            } else{
                if(a instanceof Ship){

                    shipLive(a);
                    if(getLive()<0){
                        JOptionPane.showMessageDialog(null, "Game Over \n"+"Score: "+getScore());
                        System.exit(0);
                    }
                }
                if(a instanceof Asteroid ){
                    SoundManager.play(SoundManager.bangMedium);
                    incScore(a);
                }
            }
        }

        if(ship.bullet!=null){
            alive.add(ship.bullet);
            ship.bullet=null;
        }
        if(eShip.bullet!=null){
            alive.add(eShip.bullet);
            eShip.bullet=null;
        }

        synchronized (Game.class){
            objects.clear();
            objects.addAll(alive);
        }
        //make new ship if its not in the game
        if(!objects.contains(ship)){
            SoundManager.play(SoundManager.extraShip);
            ship= new Ship(ctrl);
            objects.add(ship);
        }
        //make new enemy
        if(!objects.contains(eShip)){
            eShip= new EnemyShip(randomMovement);
            objects.add(eShip);
        }

        //increment level as it hits different scores
        if(getScore()==100){
            level =2;
            this.objects.add(Asteroid.makeRandomAsteroid());
        }
        if(getScore()==200){
            level =3;
            this.objects.add(Asteroid.makeRandomAsteroid());
        }
        if(getScore()==300){
            level =4;
            this.objects.add(Asteroid.makeRandomAsteroid());
        }
        if(getScore()==400){
            level =5;
            live=3;
            this.objects.add(Asteroid.makeRandomAsteroid());
            }
        if(getScore()==1000){
            level=6;
        }
    }

    //method to increment score
    public void incScore(GameObject object){
        if(object instanceof Asteroid){
            score+=10;
        }
    }
    //method decrement player ship's lives
    public void shipLive (GameObject object){
        if(object instanceof Ship) {
            live--;
        }
    }
    //method return the score
    public int getScore(){
        return score;
    }
    public int getLive(){
        return live;
    }
//    public void loselost(){
//        live--;
//        if(live<=0){
//            ship.dead=true;
//        }
//    }

}