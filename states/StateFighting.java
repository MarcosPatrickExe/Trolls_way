package states;
import main.Agent;


public class StateFighting extends State{

    public StateFighting(){
        super.nameState = "lutando";
    }

    @Override
    public void execute(Agent agent){
        System.out.println( "Troll is fighting... \n");
    }
}
