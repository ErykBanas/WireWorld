package core;


import java.util.ArrayList;

/**
 * Przechowuje dane komórek należących do bramki typu OR
 */
public class OrGate {

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

    public ArrayList<Coordinate> getGateCellsList() {
        return gateCellsList;
    }

    public int getGateCellsNumber() {
        return gateCellsNumber;
    }
}
