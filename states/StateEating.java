package states;
import main.Agent;
import main.Troll;
import main.Locations;


public class StateEating extends State{
    

    @Override
    public void execute(Agent agent){
        Troll t = (Troll) agent; // Downcasting

        t.hunger -=3;
        --t.life;

        if(t.hunger <= 4){
            t.currentLocation = Locations.Cave;
            t.changeState( new StateSleep() );
        }


        System.out.println( "\n======> Troll is eating in the forest... \n");
    }

    
/* 
    @Override
    public void enter(Agent agent){ }

    @Override
    public void exit(Agent agent){ }
*/
}
