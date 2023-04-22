package main;
import states.State;


public abstract class Agent{

    private State currentState;

    Agent(State newState){
        this.currentState = newState;
    }

    public void changeState(State newState){
        // this.currentState.exit(this);
        this.currentState = newState;
        // this.currentState.enter(this);
    };

    public void update(){
        this.currentState.execute(this);
    };
    
}
