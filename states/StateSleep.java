package states;
import main.Agent;
import main.Troll;
import main.Locations;



public class StateSleep extends State{


    @Override
    public void execute(Agent agent){
        Troll tr = (Troll) agent; // Downcasting

        if(tr.life <10)
            ++tr.life;

        if(tr.hunger > 4){
            tr.currentLocation = Locations.Forest;
            tr.changeState( new StateEating() );
        }

        System.out.println( "\n======> Troll is sleeping in the cave... \n");
    }
    
/* 
    @Override
    public void enter(Agent agent){ }

    @Override
    public void exit(Agent agent){ }
*/
}
