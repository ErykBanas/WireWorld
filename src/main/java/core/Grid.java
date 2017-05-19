package core;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa reprezentuje grid (planszę) z komórkami
 */
public class Grid {

    /**
     * Obiekt typu HashMap. Wiąże współrzędną komórki {@link Coordinate} ze stanem komórki {@link Cell}. Zawiera komórki wczytane do aplikacji
     */
    private HashMap <Coordinate,Cell> hm;


    /**
     * Konstruktor tworzący nową HashMapę
     */
    public Grid(){
        this.hm = new HashMap<Coordinate, Cell>();
    }
    /**
     * Konstruktor ustawiający hashmapę jako podaną
     * @param hashMap Przekazana HashMapa
     */
    public Grid(HashMap<Coordinate, Cell> hashMap) {
        this.hm = hashMap;
    }


    /**
     * Zwraca obiekt HashMapy
     * @return HashMapa
     */
    public HashMap<Coordinate, Cell> getHashMap() {
        return hm;
    }

    /**
     * Ustawia HashMapę w gridzie
     * @param hashMap HashMapa
     */
    public void setHashMap(HashMap<Coordinate, Cell> hashMap) {
        this.hm = hashMap;
    }

    /**
     * Wstawia nową komórkę do HashMapy w gridzie
     * @param x Współrzędna x komórki
     * @param y Współrzędna y komórki
     * @param state Stan komórki typu {@link core.Cell.State}
     */
    public void insertNewCell(int x, int y, Cell.State state){
        this.hm.put(new Coordinate(x,y), new Cell(state));
    }

    /**
     * Ustawia stan komórki z HashMapy. Jeśli komórka nie istnieje jeszcze w gridzie, zostaje dodana do HashMapy
     * @param x Współrzędna x komórki
     * @param y Współrzędna y komórki
     * @param state Stan komórki typu {@link core.Cell.State} do ustawienia
     */
    public void setCellState(int x, int y, Cell.State state) {
        Coordinate coord = new Coordinate(x,y);
        if (this.hm.containsKey(coord)){
            hm.get(coord).setState(state);
        }
        else {
            this.insertNewCell(x,y,state);
        }
    }

    /**
     * Pobiera stan komórki z HashMapy
     * @param x Współrzędna x komórki
     * @param y Współrzędna y komórki
     * @return Stan komórki typu {@link core.Cell.State}. Jeśli komórka nie jest znaleziona zwraca stan EMPTY
     */
    public Cell.State getCellState(long x, long y){
        Coordinate coord = new Coordinate(x,y);
        if (this.hm.containsKey(coord)){
            return hm.get(coord).getState();
        }
        else return Cell.State.EMPTY;
    }

    /**
     * Zlicza sąsiadów danej komórki
     */
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
