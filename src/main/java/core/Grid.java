package core;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa reprezentuje grid (planszę) z komórkami
 */
public class Grid {

    /**
     * Obiekt typu HashMap. Wiąże współrzędną komórki {@link Coordinate} ze stanem komórki {@link Cell}. Zawiera komórki wczytane do aplikacji
     * Wczytane na razie poprzez "insertNewCell()" W ogólności wiąże wartość z kluczem, a my tutaj takie wybraliśmy
     */
    private HashMap <Coordinate,Cell> hashMap;


    /**
     * Konstruktor tworzący nową HashMapę
     */
    public Grid(){
        this.hashMap = new HashMap<Coordinate, Cell>();
    }
    /**
     * Konstruktor ustawiający hashmapę jako podaną
     * @param hashMap Przekazana HashMapa
     */
    public Grid(HashMap<Coordinate, Cell> hashMap) {
        this.hashMap = hashMap;
    }


    /**
     * Zwraca obiekt HashMapy
     * @return HashMapa
     */
    public HashMap<Coordinate, Cell> getHashMap() {
        return hashMap;
    }

    /**
     * Ustawia HashMapę w gridzie
     * @param hashMap HashMapa
     */
    public void setHashMap(HashMap<Coordinate, Cell> hashMap) {
        this.hashMap = hashMap;
    }

    /**
     * Wstawia nową komórkę do HashMapy w gridzie
     * @param x Współrzędna x komórki
     * @param y Współrzędna y komórki
     * @param state Stan komórki typu {@link core.Cell.State}
     */
    public void insertNewCell(int x, int y, Cell.State state){
        this.hashMap.put(new Coordinate(x,y), new Cell(state));
    }

    /**
     * Wstawia komórkę do gridu na podstawie istniejących już obiektów Coordinate i Cell
     * @param coordinate Obiekt klasy Coordinate - współrzędne x i y
     * @param cell Obiekt klasy cell - komórka
     * Metoda napisana specjalnie dla klasy WireWorld.java do łatwej obsługi HashMap-y!
     */
    public void insertCell(Coordinate coordinate, Cell cell){
        this.hashMap.put(coordinate, cell);
    }
    /**
     * Ustawia stan komórki z HashMapy. Jeśli komórka nie istnieje jeszcze w gridzie, zostaje dodana do HashMapy
     * @param x Współrzędna x komórki
     * @param y Współrzędna y komórki
     * @param state Stan komórki typu {@link core.Cell.State} do ustawienia
     */
    public void setCellState(int x, int y, Cell.State state) {
        Coordinate coord = new Coordinate(x,y);
        if (this.hashMap.containsKey(coord)){
            hashMap.get(coord).setState(state);
        }
        else {
            this.insertNewCell(x,y,state);
        }
    }

    public void insertNewObject(WorldObject worldObject){
        for(Coordinate c:worldObject.getObjectCells()){
            this.hashMap.put(c,new Cell(worldObject.getObjectState()));
        }
    }


    /**
     * Pobiera stan komórki z HashMapy
     * @param x Współrzędna x komórki
     * @param y Współrzędna y komórki
     * @return Stan komórki typu {@link core.Cell.State}. Jeśli komórka nie jest znaleziona zwraca stan EMPTY
     */
    public Cell.State getCellState(int x, int y){
        Coordinate coord = new Coordinate(x,y);
        if (this.hashMap.containsKey(coord)){
            return hashMap.get(coord).getState();
        }
        else return Cell.State.EMPTY;
    }

    /**
     * Zlicza sąsiadów danej komórki
     */
    public void countNeighbours(){
        for (Map.Entry<Coordinate,Cell> entry: hashMap.entrySet()){
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
                hashMap.put(coord,cell);
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid1 = (Grid) o;

        return hashMap != null ? hashMap.equals(grid1.hashMap) : grid1.hashMap == null;
    }

    @Override
    public int hashCode() {
        return hashMap != null ? hashMap.hashCode() : 0;
    }
}
