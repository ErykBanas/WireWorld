package model;

import core.Cell;
import core.Coordinate;
import core.Grid;
import core.Pair;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class WireWorld {

    private Grid grid;
    private Grid newGrid;
    private boolean animationStarted;
    private LinkedList<Pair> changedCellsList;



    public WireWorld(){
        this.grid = new Grid();
        this.animationStarted = false;
        this.changedCellsList = new LinkedList<Pair>();
    }

    public WireWorld(Grid grid){
        this.grid = grid;
        this.animationStarted = false;
        this.changedCellsList = new LinkedList<Pair>();
    }
    /**
     * Uruchamia animację
     */
    public void produceNewGridState(){

        boolean cellStateChanged;
        Cell.State oldState;
        Cell.State newState;
        Pair pair;

        while(animationStarted){

            newGrid = new Grid();

            Iterator it = grid.getHashMap().entrySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry)it.next();
                Coordinate coordinate = (Coordinate)entry.getKey();
                Cell cell = (Cell)entry.getValue();

                cellStateChanged = false;
                oldState = cell.getState();
                newState = cell.getState();

                if(oldState == Cell.State.ELECTRONHEAD){
                    newState = Cell.State.ELECTRONTAIL;
                    cellStateChanged = true;
                }else if(oldState == Cell.State.ELECTRONTAIL) {
                    newState = Cell.State.WIRE;
                    cellStateChanged = true;
                }else if(oldState == Cell.State.WIRE){
                    if(cell.getNeighboursNumber() == 1 || cell.getNeighboursNumber() == 2){
                        newState = Cell.State.ELECTRONHEAD;
                        cellStateChanged = true;
                    }
                }

                if (cellStateChanged) {
                    cell.setState(newState);
                    pair = new Pair(coordinate,cell);
                    this.changedCellsList.add(pair);
                }

                newGrid.insertCell(coordinate,cell);

                it.remove();

            }


        }

    }

    public Grid getGrid(){
        return this.grid;
    }

    public void setGrid(Grid grid){
        this.grid = grid;
    }

    public LinkedList<Pair> getChangedCellsList() {
        return this.changedCellsList;
    }
}