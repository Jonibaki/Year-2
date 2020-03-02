//Created by Md Abu Joni
//Reg. No. 1606072
//Assignment 2
//Submission Date: 11/12/2017
//CE203 Application Programming
import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {
    public Component comp;
    public ShapesFrame(Component comp, String title){
        super(title);
        this.comp = comp;
        getContentPane().add(BorderLayout.CENTER, comp);
        getContentPane().setBackground(Color.white);
        pack();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);

    }
}
