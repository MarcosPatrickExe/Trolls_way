package main;
import states.State;


public class Troll extends Agent{
    public short hunger=0;
    public short life=10;
    public Locations currentLocation;  

    Troll( State initialState ){
        super( initialState );
        this.currentLocation = Locations.Cave;
    }
}
