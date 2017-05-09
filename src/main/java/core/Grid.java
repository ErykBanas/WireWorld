package core;


import java.util.HashMap;
import java.util.Map;

public class Grid {

    private HashMap <Coordinate,Cell> hm;


    public Grid(){
        this.hm = new HashMap<Coordinate, Cell>();
    }
    
    public Grid(HashMap<Coordinate, Cell> grid) {
        this.hm = grid;
    }

    public HashMap<Coordinate, Cell> getHashMap() {
        return hm;
    }

    public void setHashMap(HashMap<Coordinate, Cell> grid) {
        this.hm = grid;
    }

    public void insertNewCell(int x, int y, Cell.State state){
        this.hm.put(new Coordinate(x,y), new Cell(state));
    }

    public void setCellState(int x, int y, Cell.State state) throws Exception {
        Coordinate coord = new Coordinate(x,y);
        if (this.hm.containsKey(coord)){
            hm.get(coord).setState(state);
        }
        else throw new Exception();
    }

    public Cell.State getCellState(long x, long y){
        Coordinate coord = new Coordinate(x,y);
        if (this.hm.containsKey(coord)){
            return hm.get(coord).getState();
        }
        else return Cell.State.EMPTY;
    }

    public void countNeighbours(){
        for (Map.Entry<Coordinate,Cell> entry: hm.entrySet()){
            int counter = 0;
            Coordinate coord;
            coord = entry.getKey();
            Cell  cell;
            cell = entry.getValue();
            if(cell.getState()== Cell.State.WIRE) {
                if (getCellState(coord.getX() - 1, coord.getY()) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX() - 1, coord.getY() - 1) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX(), coord.getY() - 1) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX() + 1, coord.getY() - 1) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX() + 1, coord.getY()) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX() + 1, coord.getY() + 1) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX(), coord.getY() + 1) == Cell.State.ELECTRONHEAD) counter++;
                if (getCellState(coord.getX() - 1, coord.getY() + 1) == Cell.State.ELECTRONHEAD) counter++;
                cell.setNeighboursNumber(counter);
                hm.put(coord,cell);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid1 = (Grid) o;

        return hm != null ? hm.equals(grid1.hm) : grid1.hm == null;
    }

    @Override
    public int hashCode() {
        return hm != null ? hm.hashCode() : 0;
    }
}
