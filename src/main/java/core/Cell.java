package core;

/**
 * Klasa reprezentuje pojedynczą komórkę w modelu z jej stanem
 */
public class Cell {

    /**
     * Typ wyliczeniowy: dostępne stany komórki
     */
    public enum State {
        EMPTY,
        WIRE,
        ELECTRONHEAD,
        ELECTRONTAIL
    }

    /**
     * Aktualny stan komórki
     */
    private State state;
    /**
     * Liczba sąsiadów komórki
     */
    private int neighboursNumber;


    /**
     * Bezargumentowy konstruktor. Ustawia stan komórki na EMPTY i liczbę sąsiadów na 0.
     */
    public Cell() {
        this.state = State.EMPTY;
        setNeighboursNumber(0);
    }
    /**
     * Konstruktor ustawiający stan komórki
     * @param state Stan komórki typu wyliczeniowego {@link State}
     */
    public Cell(State state) {
        this.state = state;
        setNeighboursNumber(0);
    }


    /**
     * Pobranie stanu komórki
     * @return Stan komórki typu {@link State}
     */
    public State getState() {
        return state;
    }
    /**
     * Ustawienie stanu komórki
     * @param state Stan komórki typu {@link State}
     */
    public void setState(State state) {
        this.state = state;
    }
    /**
     * Pobiera liczbę sąsiadów komórki
     * @return Liczba sąsiadów komórki
     */
    public int getNeighboursNumber() {
        return neighboursNumber;
    }
    /**
     * Ustawia liczbę sąsiadów komórki
     * @param neighboursNumber Liczba sąsiadów komórki
     */
    public void setNeighboursNumber(int neighboursNumber) {
        this.neighboursNumber = neighboursNumber ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return state == ((Cell) o).state;
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + neighboursNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "state=" + state +
                ", neighboursCount=" + neighboursNumber +
                '}';
    }
}
