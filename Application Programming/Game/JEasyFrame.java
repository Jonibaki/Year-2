// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// further updated and created by
//Student Name: Md Abu Joni
//Reg. No. 1606072
//Assignment 2
//Submission Date: 11/12/2017
//CE203 Application Programming
package Assignment2;


import javax.swing.*;
import java.awt.*;

public class JEasyFrame extends JFrame {
    public Component comp;
    public JEasyFrame(Component comp, String title) {
        super(title);
        this.comp = comp;
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        repaint();
    }
}
