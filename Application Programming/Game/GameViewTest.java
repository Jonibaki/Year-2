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
import java.util.Random;
public class GameViewTest
{
    public static void main(String[] args)
    {
        // test the view component
        Random r = new Random();
        int w = 20;
        int h = 20;
        int[][] a = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                a[i][j] = r.nextInt(GameView.colors.length);
            }
        }

        GameView tv = new GameView(a);
        tv.setOpaque(false);

        //background image for the game
        JLabel label = new JLabel(new ImageIcon("src\\background.jpg"));
        label.setLayout(new BorderLayout());
        label.add(tv);

        new JEasyFrame(label, "Md Abu Joni, Reg. No- 1606072");
    }
}