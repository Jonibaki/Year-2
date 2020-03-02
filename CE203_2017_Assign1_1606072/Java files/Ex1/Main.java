/* Name - Md Abu Joni
 * Reg - 1606072
 * Application Programming
 * Assignment 1, Exercise 1
 */
package Ex1;

import javax.swing.*;

public class Main extends JFrame {
    public static void main (String []args){

        CE203_2017_Ex1 window = new CE203_2017_Ex1();
        window.setSize(500, 400);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setIconImage(window.createImage("src\\Ex2\\Logo.png").getImage()); //path of the customised logo
        window.setLocationRelativeTo(null); //set the window in the middle of the screen after execution
        window.butReset.setEnabled(false); //set the button as unable beginning of the program
    }
}
