package model;

import core.Cell;
import core.Coordinate;
import core.Grid;

import java.util.Iterator;
import java.util.Map;

/**
 * Klasa reprezentuje model danych aplikacji. Zawiera obiekt gridu i wylicza jego nowe stany
 */
public class WireWorld implements World{

    /**
     * Aktualny grid w modelu aplikacji
     */
    private Grid grid;

    /**
     * Nowy grid po zmianie stanów komórek wg zasad
     */
    private Grid newGrid;

    /**
     * Konstruktor bezargumentowy tworzący nowy obiekt gridu
     */
    public WireWorld() {
        this.grid = new Grid();
    }

    /**
     * Konstruktor przypisujący podany grid do obiektu modelu danych
     * @param grid Istniejący grid podany podczas tworzenia obiektu klasy WireWorld
     */
    public WireWorld(Grid grid) {
        this.grid = grid;
    }

    /**
     * Generuje nowy stan gridu na podstawie reguł
     */
    public void produceNewWorldState() {

        boolean cellStateChanged;
        Cell.State oldState;
        Cell.State newState;

        newGrid = new Grid();

        Iterator it = grid.getHashMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Coordinate coordinate = (Coordinate) entry.getKey();
            Cell cell = (Cell) entry.getValue();

            cellStateChanged = false;
            oldState = cell.getState();
            newState = cell.getState();

            if (oldState == Cell.State.ELECTRONHEAD) {
                newState = Cell.State.ELECTRONTAIL;
                cellStateChanged = true;
            } else if (oldState == Cell.State.ELECTRONTAIL) {
                newState = Cell.State.WIRE;
                cellStateChanged = true;
            } else if (oldState == Cell.State.WIRE) {
                if (cell.getNeighboursNumber() == 1 || cell.getNeighboursNumber() == 2) {
                    newState = Cell.State.ELECTRONHEAD;
                    cellStateChanged = true;
                }
            }

            if (cellStateChanged) {
                cell.setState(newState);
            }

            newGrid.insertCell(coordinate, cell);
            it.remove();
        }
        this.grid = newGrid;

    }

    public Grid getGrid() {
        return this.grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }


}