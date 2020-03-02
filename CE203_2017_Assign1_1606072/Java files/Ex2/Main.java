/* Name - Md Abu Joni
 * Reg - 1606072
 * Application Programming -
 * Assignment 1, Exercise 2
 */
package Ex2;
import javax.swing.*;

public class Main {

    public static void main (String [] args){
        CE203_2017_Ex2 window = new CE203_2017_Ex2();
        window.setSize(600, 600);
        window.setVisible(true);
    //if there is not word in the list then button set to unable
    if(window.listOfWord.size()<1){
        window.butRemove.setEnabled(false);
    }

    window.butRemoveAll.setEnabled(true);
    window.setIconImage(window.createImage("src\\Ex2\\Logo.png").getImage());
    window.setLocationRelativeTo(null); //set windows to the centre of the screen
    window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //dispose the program upon closing


    }
}

