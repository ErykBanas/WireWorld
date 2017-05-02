package core;


import java.util.HashMap;
import java.util.Map;

public class Grid {

    private HashMap <Coordinate,Cell> grid;

    public Grid(){
        this.grid = new HashMap<Coordinate, Cell>();
    }
    public Grid(HashMap<Coordinate, Cell> grid) {
        this.grid = grid;

    }

    public HashMap<Coordinate, Cell> getGrid() {
        return grid;
    }

    public void setGrid(HashMap<Coordinate, Cell> grid) {
        this.grid = grid;
    }


    public void insertNewCell(int x, int y, Cell.State state){
        this.grid.put(new Coordinate(x,y), new Cell(state));
    }

    public void setCellState(int x, int y, Cell.State state) throws Exception {
        Coordinate coord = new Coordinate(x,y);
        if (this.grid.containsKey(coord)){
            grid.get(coord).setState(state);
        }
        else throw new Exception();
    }

    public Cell.State getCellState(int x, int y){
        Coordinate coord = new Coordinate(x,y);
        if (this.grid.containsKey(coord)){
            return grid.get(coord).getState();
        }
        else return Cell.State.EMPTY;

    }

    public void countNeighbours(){
        for (Map.Entry<Coordinate,Cell> entry: grid.entrySet()){
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
                cell.setNeighboursCount(counter);
                grid.put(coord,cell);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid1 = (Grid) o;

        return grid != null ? grid.equals(grid1.grid) : grid1.grid == null;
    }

    @Override
    public int hashCode() {
        return grid != null ? grid.hashCode() : 0;
    }
}
