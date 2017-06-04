package utils;

import core.Cell;
import core.Coordinate;
import core.Grid;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriterJSON implements DataWriter{

    public DataWriterJSON(){

    }

    /**
     * Zapisuje dane pobrane z obieku gridu (jego HashMapy) i zapisuje do pliku
     * @param grid Obiekt gridu zawiarający HashMapę z komórkami
     * @param file Plik wyjściowy
     * @throws IOException Wyjątek rzucany, gdy nie uda się zapisać danych do pliku
     */

    //Wszystko będzie zapisywane do postaci WireCell (uniwersalnej), ELECTRONHEAD albo ELECTRONTAIL!

    @SuppressWarnings("unchecked")
    public void write (Grid grid, File file){
        Writer fileWriter = null;

        try{
            JSONObject state = new JSONObject();
            JSONArray stateWire = new JSONArray();
            JSONArray stateHead = new JSONArray();
            JSONArray stateTail = new JSONArray();
            JSONObject stateCoordinates = new JSONObject();
            Iterator it = grid.getHashMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Coordinate coordinate = (Coordinate) entry.getKey();
                Cell cell = (Cell) entry.getValue();
                if (cell.getState() == Cell.State.WIRE) {
                    stateCoordinates.put("x", coordinate.getX());
                    stateCoordinates.put("y", coordinate.getY());
                    stateWire.add(stateCoordinates);
                    //stateCoordinates = null;
                    //To, JAK tu zapisać dwukropek, ale co WAŻNIEJSZE 2-gą wartość?
                    //Dwukropek SAM się dodaje, kwestia, czy "put" nie powinien być po dodaniu WSZYSTKICH elementów do listy
                }
                else if (cell.getState() == Cell.State.ELECTRONHEAD) {
                    stateCoordinates.put("x", coordinate.getX());
                    stateCoordinates.put("y", coordinate.getY());
                    stateHead.add(stateCoordinates);
                    //stateCoordinates = null;
                }
                else if (cell.getState() == Cell.State.ELECTRONTAIL) {
                    stateCoordinates.put("x", coordinate.getX());
                    stateCoordinates.put("y", coordinate.getY());
                    stateTail.add(stateCoordinates);
                    //stateCoordinates = null;
                }
            }
            state.put("WireCell", stateWire);
            state.put("ElectronHead", stateHead);
            state.put("ElectronTail", stateTail);
            //it.remove();

            fileWriter = new BufferedWriter(new FileWriter("/Users/hvx/IdeaProjects/jimp2-proj2/nowy.json"));
            fileWriter.write(state.toString());
            //System.out.println("\nJSON Object: " + state);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) try { fileWriter.close(); } catch (IOException ignore) {}
        }
    }
}