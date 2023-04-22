package states;
import main.Agent;


public abstract class State {
      public String nameState;
   
      public abstract void execute(Agent agent);
     // public abstract void enter(Agent agent);
     // public abstract void exit(Agent agent);
}
