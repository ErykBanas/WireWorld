package core;

import java.util.ArrayList;

/**
 * Reprezentuje obiekt linii przewodnika.
 */
public class WireLine extends WorldObject{

    private Cell.State state;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    /**
     * Zawiera listę komórek należących do linii przewodnika
     */
    private ArrayList<Coordinate> wireLineCellsList;

    public WireLine(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.state = Cell.State.WIRE;
        wireLineCellsList = new ArrayList<Coordinate>();
        insertCoordinatesIntoList();
    }


    public ArrayList<Coordinate> getObjectCells() {
        return wireLineCellsList;
    }

    public Cell.State getObjectState() {
        return state;
    }

    /**
     * Umieszcza na liście komórek obiektu WireLine komórki poczynając od współrzędnych początkowych (startX, startY) do końcowych (endX, endY)
     * Linia może być pionowa lub pozioma
     */
    private void insertCoordinatesIntoList(){
        if (startY == endY){
            for (int j = startX; j<= endX; j++){
                wireLineCellsList.add(new Coordinate(j,startY));
            }
        } else if (startX == endX){
            for (int j = startY; j<= endY; j++){
                wireLineCellsList.add(new Coordinate(startX,j));
            }
        }
    }
}
