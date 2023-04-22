package states;
import main.Agent;


public class StateEating extends State{
    
    public StateEating(){
        super.nameState = "comendo";
    }

    @Override
    public void execute(Agent agent){
        System.out.println( "Troll is eating in the forest... \n");
    }
}
