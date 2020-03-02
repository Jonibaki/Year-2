/*
* Programmed by Md Abu Joni
* Reg NO-1606072
* Assignment 2
* Submission date- 20/03/2018
*/

public class Ass2 {
    public static void main (String []args){
        ExpTree myTree=null;
        System.out.println("Md Abu Joni 1606072");
        System.out.println("Welcome to Joni's expression evaluation program. Please type an expression");
        String userInput = "";
        Parser p = new Parser();
        do {
            try {
                myTree = p.parseLine();
                //check for the let tree first
                if (myTree.value == null){
                    myTree.post_order(myTree.lChild);
                    System.out.println("Post-order: "+ myTree.post_order(myTree.rChild));
                    System.out.println("In-order: "+myTree.toString(myTree));
                    System.out.println("Result of the expression: "+myTree.evaluate_express(myTree.rChild));
                }else{
                    System.out.println("Post-order: "+ myTree.post_order(myTree));
                    System.out.println("In-order: "+myTree.toString(myTree));
                    try {
                        System.out.println("Result of the expression: "+myTree.evaluate_express(myTree));
                    }catch (ArithmeticException e){
                        System.out.println(e.getMessage());
                    }
                }
            }catch(ParseException e){
                System.out.println(e.getMessage());
            }
            System.out.println();
            System.out.println("Another expression (y/n)? OR any output to terminate!!");
            userInput=p.getLine();

            if(userInput.equalsIgnoreCase("y")){
                System.out.println("Please type an expression");
            }else if (userInput.equalsIgnoreCase("n")) {
                break;
            }else{
                System.out.println("Program Terminating... ");
            }

        }while (userInput.equalsIgnoreCase("y"));

        System.out.println("___END OF PROGRAM___ ");
    }
}
