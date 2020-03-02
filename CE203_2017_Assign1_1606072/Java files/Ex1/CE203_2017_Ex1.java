/* Name - Md Abu Joni
 * Reg - 1606072
 * Application Programming -
 * Assignment 1, Exercise 1
 */
package Ex1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CE203_2017_Ex1 extends JFrame {
    JTextField[] field; //an array that holds all the fields
    int [] valueRGB; //an array that holds all the integer variables

    JTextField txtField1,txtField2, txtField3;
    JButton butDisplay, butReset;
    JTextArea txtArea;
    int valueR,valueG,valueB;

    public Color color = new Color(valueR,valueG,valueB);
    public CE203_2017_Ex1() {
        super("Window");
        txtArea = new JTextArea("CE203 Assignment 1, submitted by: ");
        txtArea.setForeground(Color.BLUE);
        txtArea.setFont(new Font("Serif", Font.BOLD, 16));
        txtArea.setEditable(false);


        JLabel label1 = new JLabel("RED");
        label1.setForeground(Color.RED);

        JLabel label2 = new JLabel("GREEN");
        label2.setForeground(Color.GREEN);

        JLabel label3 = new JLabel("BLUE");
        label3.setForeground(Color.BLUE);

        txtField1 = new JTextField(10);
        txtField2 = new JTextField(10);
        txtField3 = new JTextField(10);

        //an array of integer which store RGB value in their specific position
        valueRGB = new int[3];
        valueRGB[0] = valueR;
        valueRGB[1] = valueG;
        valueRGB[2] = valueB;

        //an array of Text fields
        field = new JTextField[3];
        field[0] = txtField1;
        field[1] = txtField2;
        field[2] = txtField3;

        //creation of buttons
        butDisplay = new JButton("Display");
        butReset = new JButton("Reset");

        //create new panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GRAY);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setBackground(Color.WHITE);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GRAY);

        GridBagLayout g = new GridBagLayout();
        panel3.setLayout(g);

        GridBagConstraints grid = new GridBagConstraints();


        //add button to the panel
        panel1.add(butReset);

        //add text fields and the text area to the panel
        panel2.add(txtArea);

        //panel 3
        //set up the position of the JTextFields and JLabels,
        //so that they can be sit on top of each other
        grid.gridx = 1;
        grid.gridy = 0;
        g.setConstraints(label1, grid);
        panel3.add(label1);

        grid.gridx = 1;
        grid.gridy = 1;
        g.setConstraints(txtField1, grid);
        panel3.add(txtField1);

        grid.gridx = 10;
        grid.gridy = 0;
        g.setConstraints(label2, grid);
        panel3.add(label2);

        grid.gridx = 10;
        grid.gridy = 1;
        g.setConstraints(txtField2, grid);
        panel3.add(txtField2);

        grid.gridx = 20;
        grid.gridy = 0;
        g.setConstraints(label3, grid);
        panel3.add(label3);

        grid.gridx = 20;
        grid.gridy = 1;
        g.setConstraints(txtField3, grid);
        panel3.add(txtField3);

        grid.gridx = 10;
        grid.gridy = 2;
        g.setConstraints(butDisplay, grid);
        panel3.add(butDisplay);

        //adding panels to the different location in the main frame
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);

        butDisplay.addActionListener(new ButtonHandler(this, 1));
        butReset.addActionListener(new ButtonHandler(this, 2));
    }

    //change the default Java Logo to customised Logo
    public ImageIcon createImage(String path){
        return new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage(path));
    }
}
//Handle different action for the buttons to perform
class ButtonHandler implements ActionListener {
    CE203_2017_Ex1 app;
    int act;
    //constructor that has main class and an integer as its argument
    ButtonHandler(CE203_2017_Ex1 theApp, int action) {
        app = theApp;
        act = action;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (act == 1) {
            boolean exception = false; //which updates if there is any catch
            app.butReset.setEnabled(true);
            //the Loop ables to step through each field
            //if the there is any invalid input then program throws exception which catches by
            //catch NumberFormatException and display it in the text area
            for (int i=0; i<app.field.length;i++){
                try{
                    app.valueRGB[i]= Integer.parseInt(app.field[i].getText());
                    if (app.valueRGB[i]>255){
                        app.valueRGB[i]=255;
                        app.field[i].setText("255");
                    }else if(app.valueRGB[i]<0){
                        app.valueRGB[i]=200;
                        app.field[i].setText("200");
                    }
                } catch(NumberFormatException e1){
                    app.txtArea.setForeground(Color.RED);
                    app.txtArea.setText("Invalid Input" );
                    app.field[i].setText("");
                    exception = true;
                }

            }
            //if there is no catch then it displays the final message
            if(!exception == true ) {
                // change the colors value accordingly and display the message
                app.color = new Color(app.valueRGB[0],app.valueRGB[1],app.valueRGB[2]);
                app.txtArea.setForeground(app.color);
                app.txtArea.setText("CE203 Assignment 1, submitted by: Md Abu Joni, Reg No : 1606072");
                app.butReset.setEnabled(true);
            }

        }

        if (act==2){
            //change the text colour to blue and unable the reset button
            app.txtArea.setForeground(Color.BLUE);
            app.txtArea.setText("CE203 Assignment 1, submitted by: ");
            app.butReset.setEnabled(false);
        }

    }




}




