package core;


import java.util.ArrayList;

/**
 * Przechowuje dane komórek należących do bramki typu OR
 */
public class OrGate extends WorldObject{

    /**
     * Współrzędna początkowa X bramki OR
     */
    private int startXcoordinate;

    /**
     * Współrzędna początkowa Y bramki OR
     */
    private int startYcoordinate;

    /**
     * Liczba komórek w bramce
     */
    private final int gateCellsNumber = 5;

    /**
     * Stan komórek w bramce
     */
    private Cell.State gateState;

    /**
     * Lista komórek w bramce
     */
    private ArrayList<Coordinate> gateCellsList;

    /**
     * Tworzy bramkę z listą komórek do niej należących
     * @param startXcoordinate Współrzędna początkowa X bramki OR
     * @param startYcoordinate Współrzędna początkowa Y bramki OR
     */
    public OrGate (int startXcoordinate, int startYcoordinate){
        gateCellsList= new ArrayList<Coordinate>();
        this.startXcoordinate = startXcoordinate;
        this.startYcoordinate = startYcoordinate;
        insertCoordinatesIntoList();
        gateState = Cell.State.WIRE;
    }

    /**
     * Wstawia do listy komórek w bramce komórki ze współrzędnymi obliczonymi względem współrzędnych startowych
     */
    private void insertCoordinatesIntoList(){
        gateCellsList.add(new Coordinate(startXcoordinate,startYcoordinate+1));
        gateCellsList.add(new Coordinate(startXcoordinate,startYcoordinate+2));
        gateCellsList.add(new Coordinate(startXcoordinate,startYcoordinate+3));
        gateCellsList.add(new Coordinate(startXcoordinate-1,startYcoordinate+2));
        gateCellsList.add(new Coordinate(startXcoordinate+1,startYcoordinate+2));
    }


    public int getGateCellsNumber() {
        return gateCellsNumber;
    }

    /**
     * Zwraca listę komórek bramki
     * @return Lista komórek (Coordinate) bramki
     */
    public ArrayList<Coordinate> getObjectCells() {
        return gateCellsList;
    }

    public Cell.State getObjectState() {
        return this.gateState;
    }
}
