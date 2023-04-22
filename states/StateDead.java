package states;
import main.Agent;


public class StateDead extends State{

    public StateDead(){
        super.nameState = "morto";
    }

    @Override
    public void execute(Agent agent){
        System.out.println( "Troll is dead... \n");
    }
}
