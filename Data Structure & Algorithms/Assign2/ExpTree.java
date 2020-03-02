/*
* Programmed by Md Abu Joni
* Reg NO-1606072
* Assignment 2
* Submission date- 20/03/2018
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExpTree {
    protected int kind;
    protected Object value;
    protected ExpTree lChild, rChild;
    private boolean approval=false;
    private Map<Character, Integer> idMap= new HashMap<>();
    private String post_order_print="";
    private String in_order_print="";
    protected static final  int numNode=0, idNode=1, opNode=2, letNode=3, andNode=4, eqNode=5;
    /**
     *Three are different constructors where each one of them hold different sets of arguments;
     * 1st constructor is for operator node
     * 2nd constructor is for 'let' and 'and' node
     * 3rd constructor is for 'def' node
     */

    public ExpTree(int knd,Object val, ExpTree l, ExpTree r){
        this.kind=knd;
        this.value=val;
        this.lChild=l;
        this.rChild=r;
    }
    public ExpTree(int knd, ExpTree l, ExpTree r){
        this.kind=knd;
        this.lChild=l;
        this.rChild=r;
    }
    public ExpTree(int knd,Object val, ExpTree t){
        this.kind=knd;
        this.value=val;
        this.rChild=t;
    }

    /*method returns a string by calling it left and right child recursively then add the value
     * to the string variable. In addition, the method calculate and add variables to a map when root is let
     * and node kind is equal. To avoid adding 'null' to the string, it substitute with an empty string;
     */
    public String post_order(ExpTree expTree) {
        char c = 0;
        int result= 0;
        if(expTree!=null){
            //adding elements to the map when it is a let tree
            if (expTree.kind==eqNode){
                    approval=true;
                    c = (char) expTree.value;
                    result=evaluate_express(expTree.rChild);
                idMap.put(c,result);
            }//end

            post_order(expTree.lChild);
            post_order(expTree.rChild);

            //determine 'let' and 'and' node and replace with empty string;
            if(expTree.kind==andNode||expTree.kind==letNode){
                post_order_print+="";
            }else{
                post_order_print+=expTree.value+" ";
            }
        }
        return post_order_print;
    }

    /* returns an integer value from let tree and normal expression.
     * method checks for each kind of node i.e. equal node, the tree calls left and right child recursively and use the appropriate operator
     * Furthermore, in the case of Identifier node or Alphabets, it checks if it is a let tree or normal expression and get value respectively
     */
    public int evaluate_express(ExpTree expTree){
            if (expTree.kind == opNode) {
                if (expTree.value == "+") {
                    return evaluate_express(expTree.lChild) + evaluate_express(expTree.rChild);
                }
                if (expTree.value == "-") {
                    return evaluate_express(expTree.lChild) - evaluate_express(expTree.rChild);
                }
                if (expTree.value == "*") {
                    return evaluate_express(expTree.lChild) * evaluate_express(expTree.rChild);
                }
                if (expTree.value == "/") {
                    int r = evaluate_express(expTree.rChild);
                    if (r == 0) {
                        throw new ArithmeticException("ERROR: Number cannot divide by " + r);
                    }
                    return evaluate_express(expTree.lChild) / evaluate_express(expTree.rChild);
                }
                if (expTree.value == "%") {
                    return evaluate_express(expTree.lChild) % evaluate_express(expTree.rChild);
                }
                if (expTree.value == "^") {
                    int r = evaluate_express(expTree.rChild);
                    if (r < 0) {
                        throw new ArithmeticException("ERROR: Power of a base cannot be a negative integer");
                    }
                    return (int) Math.pow(evaluate_express(expTree.lChild), r);
                }
            }
            // tree node is equal to number
            if (expTree.kind == numNode) {
                return (int) expTree.value;
            }

            //tree node is equal to ID
            if ((expTree.kind == idNode) && (approval == true)) {
                if (idMap.containsKey(expTree.value)) {
                    return idMap.get(expTree.value);
                } else {
                    System.out.println("WARNING: " + expTree.value + " hasn't been initialised OR null. Assumed to be 0");
                    return 0;
                }

                //char array holds the index of each char and retrieve the index position+1 when it matches with tree value
            }else if(expTree.kind == idNode && !approval){
                char [] alpha= {'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C','B','A'};
                for(int a=0;a<alpha.length;a++) {
                    if(expTree.value.equals(alpha[a])){
                        return a+1;
                    }
            }
        }
            return 0;
    }
  /*
   * method returns a string in-order traversal. Besides depends on the operator higher precedence it surround operand
   * with left and right parentheses. Inside the method condition checks with child operator and parent operator level.
   */
    public String toString(ExpTree expTree) {
            if (expTree.kind == opNode) {
                if (getParentheses(expTree.lChild) <= getParentheses(expTree)) {
                    in_order_print+=('(');
                }
            }
            if(expTree.lChild!=null) {
                toString(expTree.lChild);
            }
        //determine 'let' and 'and' node and replace with a string;
            if(expTree.kind==andNode){
                in_order_print+=" and ";
            }else if(expTree.kind==letNode){
                in_order_print+=" in ";
            }else{
                in_order_print+=expTree.value;
            }

            if(expTree.rChild!=null) {
                toString(expTree.rChild);
            }
            //if node and right child are operators
            if (expTree.kind == opNode) {
                if (getParentheses(expTree.rChild) <= getParentheses(expTree)) {
                    in_order_print+=(')');
                }
            }

            if(approval){
                return "let "+in_order_print;
            }
            return in_order_print;
        }
    /**
     * method returns integer value for operators level of precedence
     */

    private int getParentheses(ExpTree t) {
        String operator = "";
        if (t.kind == opNode) {
            operator = (String) t.value;
        }
        else {
            return 0;
        }
        if (Objects.equals(operator, "^")) {
            return 3;
        }
        else if (Objects.equals(operator, "*") || Objects.equals(operator, "%") || Objects.equals(operator, "/")) {
            return 2;
        }
        else if (Objects.equals(operator, "+") || Objects.equals(operator, "-")) {
            return 1;
        }
        return 0;
    }

}
