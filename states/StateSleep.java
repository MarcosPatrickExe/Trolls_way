package states;
import main.Agent;


public class StateSleep extends State{

    public StateSleep(){
        super.nameState = "dormindo";
    }

    @Override
    public void execute(Agent agent){
        System.out.println( "Troll is sleeping in the cave... \n");
    }
}
