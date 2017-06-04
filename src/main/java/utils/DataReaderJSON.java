package utils;

import core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class DataReaderJSON implements DataReader {

    private Grid grid = new Grid();
    int roboczyX;
    int roboczyY;
    int roboczyStartX;
    int roboczyStartY;
    int roboczyEndX;
    int roboczyEndY;

    private DataReaderJSON(){
    }

    public static DataReaderJSON getInstance(){
        return DataReaderJSONHolder.instance;
    }

    private static class DataReaderJSONHolder{
        private static final DataReaderJSON instance = new DataReaderJSON();
    }

    public Grid read(File file) {

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject)obj;

            //Wczytywanie pojedynczych komórek:
            JSONArray wireCell = (JSONArray) jsonObject.get("WireCell");
            Iterator i = wireCell.iterator();
    //      Uwaga - MY tu iterujemy po elementach tablicy tym iteratorem, elementami tablicy mogą być pary, a nawet
    //      jeszcze większe ilosci poprzypisywanych zmiennych, ale WEWNĄTRZ danej zmiennej, po której w danym momencie
    //      iterujemy (której przypisalismy rezultat iteracji) mozemy odwoływać się do różnych innych zmiennych!
    //      While tu wczytuje, az się wszystkie wczytaja!
            while(i.hasNext()) {
                JSONObject cell = (JSONObject) i.next();
                roboczyX = ((Long) cell.get("x")).intValue();
                roboczyY = ((Long) cell.get("y")).intValue();
                grid.insertNewCell(roboczyX, roboczyY, Cell.State.WIRE);
                i.remove();
            }

            //Wczytywanie odcinków prostych:
            JSONArray wireLine = (JSONArray) jsonObject.get("WireLine");
            i = wireLine.iterator();
            while(i.hasNext()) {
                JSONObject line = (JSONObject) i.next();
                roboczyStartX = ((Long) line.get("startX")).intValue();
                roboczyStartY = ((Long) line.get("startY")).intValue();
                roboczyEndX = ((Long) line.get("endX")).intValue();
                roboczyEndY = ((Long) line.get("endY")).intValue();
                grid.insertNewObject(new WireLine(roboczyStartX, roboczyStartY, roboczyEndX, roboczyEndY));
                i.remove();
            }

            //Wczytywanie bramki logicznej:
            JSONArray xorvsorGate = (JSONArray) jsonObject.get("OrGate");
            i = xorvsorGate.iterator();
            JSONObject gate = (JSONObject) i.next();
            roboczyStartX = ((Long) gate.get("startX")).intValue();
            roboczyStartY = ((Long) gate.get("startY")).intValue();
            grid.insertNewObject(new OrGate(roboczyStartX, roboczyStartY));
            i.remove();

            //Wczytywanie ElectronHead:
            JSONArray electronHead = (JSONArray) jsonObject.get("ElectronHead");
            i = electronHead.iterator();
            while(i.hasNext()) {
                JSONObject head = (JSONObject) i.next(); //Albo może zrobic while-a z TAKIM wczytaniem, az się wreszcie skonczy
                roboczyX = ((Long) head.get("x")).intValue();
                roboczyY = ((Long) head.get("y")).intValue();
                grid.insertNewCell(roboczyX, roboczyY, Cell.State.ELECTRONHEAD);
                i.remove();
            }

            //Wczytywanie ElectronTail:
            JSONArray electronTail = (JSONArray) jsonObject.get("ElectronTail");
            i = electronTail.iterator();
            while(i.hasNext()) {
                JSONObject tail = (JSONObject) i.next(); //Albo może zrobic while-a z TAKIM wczytaniem, az się wreszcie skonczy
                roboczyX = ((Long) tail.get("x")).intValue();
                roboczyY = ((Long) tail.get("y")).intValue();
                grid.insertNewCell(roboczyX, roboczyY, Cell.State.ELECTRONTAIL);
                i.remove();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return grid;
    }
}