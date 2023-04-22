package main;
import states.State;


public abstract class Agent{

    private State currentState;

    Agent(State newState){
        this.currentState = newState;
    }

    protected void changeState(State newState){
        // this.currentState.exit(this);
        this.currentState = newState;
        // this.currentState.enter(this);
    };

    protected void update(){
        this.currentState.execute(this);
    };
}