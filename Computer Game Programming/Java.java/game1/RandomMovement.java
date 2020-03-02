package game1;


import java.util.Random;


public class RandomMovement implements Controller {
    Random random = new Random();
    public Action  action = new Action();
    public int count=0;


    @Override
    public Action action() {
        if(count==15){
            action.turn= (random.nextDouble()>0.9)?1:(random.nextDouble()>0.8)?-1:0;
            action.thrust= (random.nextDouble()>0.3)? 1:0;
            count=0;
        }
        count++;
        action.shoot=(random.nextDouble()>0.8);
        return action;
    }

}
