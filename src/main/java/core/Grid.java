package core;


import java.util.HashMap;

public class Grid {

    private HashMap <Coordinate,Cell> grid;

    public Grid(){
        this.grid = new HashMap<Coordinate, Cell>();
    }
    public Grid(HashMap<Coordinate, Cell> grid) {
        this.grid = grid;

    }
/* todo Dopisać gettery i settery oraz metody zmieniające stan komórki, pobierające stan,
  zmieniające i pobierające liczbę sąsiadów*/

}
