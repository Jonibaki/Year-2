/* Name - Md Abu Joni
 * Reg - 1606072
 * Application Programming -
 * Assignment 1, Exercise 2
 */
package Ex2;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Date;

public class CE203_2017_Ex2  extends JFrame{
    LinkedList <String> listOfWord;

    JPanel panel1,panel2,panel3;
    JButton butAdd, butDisplayAll, butRemove, butRemoveAll, butClear, butSearch;
    JTextField txtField;
    JTextArea txtArea;

    CE203_2017_Ex2(){
        super("Word");
        panel1 = new JPanel();
        panel1.setBackground(Color.GRAY);
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setBackground(Color.WHITE);
        panel2.setBorder ( new TitledBorder( new EtchedBorder(), "Display Area" ) );
        panel3 = new JPanel();
        panel3.setBackground(Color.GRAY);

        //creation of buttons
        butAdd = new JButton("Add");
        butAdd.setToolTipText("Click to Add word in the list");

        butDisplayAll = new JButton("Display List");
        butDisplayAll.setToolTipText("Click to show the specific words");

        butRemove = new JButton("Remove");
        butRemove.setToolTipText("Click to remove the last occurrence of word");

        butRemoveAll = new JButton("Remove All");
        butRemoveAll.setToolTipText("Click to remove all the occurrence of the same word");

        butClear = new JButton("Clear");
        butClear.setToolTipText("Click to clear the entire list");

        butSearch =new JButton("Search");
        butSearch.setToolTipText("Click to search for words in the list");

        //creation of text area
        txtArea = new JTextArea(10, 10);
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Serif", Font.PLAIN, 14)); //set font and font size


        //creation of panel that sets in the middle of the frame
        JScrollPane scroll = new JScrollPane(txtArea);
        setPreferredSize(new Dimension(600 , 400));
        scroll.getViewport ().setView (txtArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



        //A string type linked list that has two default elements start with
        //it catches any empty exception if the list is eventually empty some point in the execution.
        try{
                listOfWord = new LinkedList<String>();
                listOfWord.add("Joni");
                listOfWord.add("Abu");
        }catch (NullPointerException e1){
            txtArea.append("There are no word in the list \n");
        }

        JLabel lbl2 = new JLabel("Add or Search for word(s)");

        txtField = new JTextField(10);
        txtField.setToolTipText("Enter a string to add, search or remove for a word in the list");




        //add components to the panel 1
        panel1.add(butAdd);
        panel1.add(butDisplayAll);
        panel1.add(butRemove);
        panel1.add(butRemoveAll);
        panel1.add(butClear);
        panel1.add(butSearch);

        //add components to the panel 2
        //panel2.add(scroll);

        //add components to the panel3
        panel3.add(lbl2);
        panel3.add(txtField);

        //add panels in top, centre and bottom of the window
        add(panel1, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);


        ButtonHandler bh = new ButtonHandler(this);
        butAdd.addActionListener(bh);
        butDisplayAll.addActionListener(bh);
        butRemove.addActionListener(bh);
        butRemoveAll.addActionListener(bh);
        butClear.addActionListener(bh);
        butSearch.addActionListener(bh);

    }
    //Get the current date and time from the system
    DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss > ");
    Date date = new Date();

    //change the default Java Logo to customised Logo
    public ImageIcon createImage(String path){
        return new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage(path));
    }
}
//Handle different actions for the buttons to perform
class ButtonHandler implements ActionListener {
    CE203_2017_Ex2 app;
    int act;

    ButtonHandler(CE203_2017_Ex2 theApp) {
        app = theApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Add button in action
        if (e.getSource() == app.butAdd) {

            //if null field, show message
            if (app.txtField.getText().isEmpty()) {
                app.txtArea.append(app.dateFormat.format(app.date)+ "Please enter a word to be added to the list! \n");
            }
            //matches for integer value in the text field
            else if(app.txtField.getText().matches("[0-9]+")){
                app.txtArea.append(app.dateFormat.format(app.date)+ "The string \'"+app.txtField.getText()+
                        "\' was not added to the list as it is not a valid word.\n");
                }
             // check first char of the string against any numbers or symbols
            else if(app.txtField.getText().matches("^[0-9].*|^[-].*")){
                app.txtArea.append(app.dateFormat.format(app.date)+ "The word must begin with a letter \n");
            }
            //only add word that contain letter number and hyphen
            else if (app.txtField.getText().matches("[a-zA-Z0-9-]*")) {

                //add to the list and show message in the text area
                app.listOfWord.add(app.txtField.getText());
                app.txtArea.append(app.dateFormat.format(app.date)+ "Word \'" + app.txtField.getText() + "\' has been added to the list \n");
                //enable all the buttons
                app.butDisplayAll.setEnabled(true);
                app.butRemove.setEnabled(true);
                app.butClear.setEnabled(true);
                app.butSearch.setEnabled(true);
            } else{
                app.txtArea.append(app.dateFormat.format(app.date)+ "The word \'"+app.txtField.getText()+"\' is not valid to be added in the list \n");
            }

            app.butRemoveAll.setEnabled(true);

            //Clear the text field after each entry in the text field
            app.txtField.setText(null);

        }

        //Display All button
        if (e.getSource() == app.butDisplayAll) {
            if (!app.txtField.getText().isEmpty()){
                for (int i = 0; i < app.listOfWord.size(); i++) {
                //get and display element by the matching ending
                    if (app.listOfWord.get(i).endsWith(app.txtField.getText().toLowerCase())) {
                    app.txtArea.append(app.dateFormat.format(app.date)  + app.listOfWord.get(i) + "\n");
                    }
                }
                // display message if there is no string in the text field
            }else if(app.txtField.getText().isEmpty()) {
                    app.txtArea.append(app.dateFormat.format(app.date) + "Please enter a string into the text field \n");
                }

        }
            //Remove button in action
        if (e.getSource() == app.butRemove) {
                //set button unable to use when there is no elements in the list
                if (app.listOfWord.size()<1) {
                    app.butRemove.setEnabled(false);
                }
                //remove the last element from the list
                else {
                    app.txtArea.append(app.dateFormat.format(app.date)+ "The last \'" + app.listOfWord.getLast() + "\' has been DELETED \n");
                    app.listOfWord.remove(app.listOfWord.getLast());

                }
            }
            //Remove All button in action
        if (e.getSource() == app.butRemoveAll) {
            boolean bool = false;

            if (!app.txtArea.getText().isEmpty()) {
                for (int i =0; i<app.listOfWord.size();i++ ){
                    if (app.txtField.getText().equalsIgnoreCase(app.listOfWord.get(i))) {
                        app.listOfWord.remove(i);
                        bool =true;
                    }
                }
            }
            if (bool==true){
                app.txtArea.append("The word(s) \'"+app.txtField.getText()+"\' removed from the list. \n");
            }

            else if (bool ==false) {
                app.txtArea.append("Please check the word again! \n");
            }
        }

            //Clear button in action
        if (e.getSource() == app.butClear) {
                //clear the entire list and set buttons to unable mode
                app.listOfWord.clear();
                app.txtArea.append(app.dateFormat.format(app.date)+ " The list is all CLEARED. Add word(s) to the list. \n");
                //set all the buttons to unable
                app.butSearch.setEnabled(false);
                app.butClear.setEnabled(false);
                app.butRemove.setEnabled(false);
                app.butDisplayAll.setEnabled(false);
            }

             //Search button in action
        if (e.getSource() == app.butSearch) {

                //get all the size of the element when text field is empty
                if (app.txtField.getText().isEmpty()) {
                    app.txtArea.append(app.dateFormat.format(app.date) +" Total number of words in the list is  "+ app.listOfWord.size() + "\n");

                    //additional code that display all the words from the list with their current position in the list
                    for (String temp : app.listOfWord) {
                        app.txtArea.append(">> "+ temp + " :  position at "+ app.listOfWord.indexOf(temp)+ "th\n");
                    }
                }
                //matches with the string that is stored in the list
                //Ignored case-sensitivity
                else if (app.txtField.getText() != null) {
                    int total=0; //keep the record of the match words in the list
                    //Display how many times it appears and the position of the words
                    for (int temp=0; temp<app.listOfWord.size();temp++) {
                        if (app.txtField.getText().equalsIgnoreCase(app.listOfWord.get(temp))) {
                            app.txtArea.append(app.dateFormat.format(app.date) + app.listOfWord.get(temp) + " : " + " position is "+temp+"th \n");
                            total += 1;
                        }
                    }
                    app.txtArea.append(">> "+app.txtField.getText() + " appears "+ total+" time(s) in the list.\n" );

                }


        }

    }
}
