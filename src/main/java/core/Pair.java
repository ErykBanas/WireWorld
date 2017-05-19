package core;


public class Pair {

    private Coordinate coordinate;
    private Cell cell;


    public Pair(Coordinate coordinate, Cell cell){
        this.coordinate = coordinate;
        this.cell = cell;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (coordinate != null ? !coordinate.equals(pair.coordinate) : pair.coordinate != null) return false;
        return cell != null ? cell.equals(pair.cell) : pair.cell == null;
    }

    @Override
    public int hashCode() {
        int result = coordinate != null ? coordinate.hashCode() : 0;
        result = 31 * result + (cell != null ? cell.hashCode() : 0);
        return result;
    }
}
