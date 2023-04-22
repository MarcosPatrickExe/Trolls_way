package main;
import states.State;


public class Troll extends Agent{
    short hunger=0;
    short life=10;
    Locations currentLocation;  

    Troll( State initialState ){
        super( initialState );
        this.currentLocation = Locations.Cave;
    }
}
