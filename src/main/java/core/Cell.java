package core;

public class Cell {
    public enum State {
        EMPTY,
        WIRE,
        ELECTRONHEAD,
        ELECTRONTAIL
    }

    private State state;
    private int neighboursNumber;


    public Cell() {
        this.state = State.EMPTY;
        setNeighboursCount(0);
    }

    public Cell(State state) {
        this.state = state;
        setNeighboursCount(0);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getNeighboursCount() {
        return neighboursNumber;
    }

    public void setNeighboursCount(int neighboursCount) {
        this.neighboursNumber = neighboursCount;
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
