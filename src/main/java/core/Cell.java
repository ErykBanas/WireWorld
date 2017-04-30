package core;

public class Cell {
    private enum State {
        DEAD,
        WIRE,
        ELECTRONHEAD,
        ELECTRONTAIL
    }

    private State state;
    private int neighboursCount;


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
        return neighboursCount;
    }

    public void setNeighboursCount(int neighboursCount) {
        this.neighboursCount = neighboursCount;
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
        result = 31 * result + neighboursCount;
        return result;
    }
}
