package states;
import main.Agent;
import main.Troll;



public class StateDead extends State{


    @Override
    public void execute(Agent agent){
        Troll tro = (Troll) agent; // Downcasting

        String frase = (tro.life == 0) ? "\n ====> The troll is dead! GAME OVER =( \n" : "\n ====> The troll starved to death! GAME OVER =( \n";
        System.out.println(frase);
    }

/* 
    @Override
    public void enter(Agent agent){ }

    @Override
    public void exit(Agent agent){ }
*/

}
