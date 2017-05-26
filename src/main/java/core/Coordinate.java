package core;

/**
 * Klasa reprezentuje współrzędne x i y komórki
 */
public class Coordinate {

    /**
     * Współrzędna x
     */
    private int x;
    /**
     * Współrzędna y
     */
    private int y;


    /**
     * Konstruktor ustawiający współrzędne
     * @param x Współrzędna x
     * @param y Współrzędna y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Pobiera wartość współrzędnej x
     * @return Wartość współrzędnej x
     */
    public int getX() {
        return x;
    }
    /**
     * Pobiera wartość współrzędnej y
     * @return Wartość współrzędnej y
     */
    public int getY() {
        return y;
    }
    /**
     * Ustawia wartość współrzędnej x
     * @param x Wartość współrzędnej x
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Ustawia wartość współrzędnej y
     * @param y wartość Współrzędnej y
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
