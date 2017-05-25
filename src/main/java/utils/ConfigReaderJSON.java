package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Klasa singleton wczytująca z pliku dane konfiguracyjne aplikacji i przechowująca je w sobie
 */
public class ConfigReaderJSON implements ConfigReader{

    private int animationSpeed;
    private int numberOfGenerations;
    private int gridSizeX;
    private int gridSizeY;

    private ConfigReaderJSON(){
    }

    public static ConfigReaderJSON getInstance(){
        return ConfigReaderJSONHolder.instance;
    }

    private static class ConfigReaderJSONHolder{
        private static final ConfigReaderJSON instance = new ConfigReaderJSON();
    }

    public int getAnimationSpeed() {
        return animationSpeed;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public int getGridSizeX() {
        return gridSizeX;
    }

    public int getGridSizeY() {
        return gridSizeY;
    }


    public void read(File file) {

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject)obj;

            this.animationSpeed = ((Long)jsonObject.get("AnimationSpeed")).intValue();
            this.numberOfGenerations = ((Long)jsonObject.get("NumberOfGenerations")).intValue();

            JSONArray gridSizes = (JSONArray) jsonObject.get("GridSize");
            Iterator i = gridSizes.iterator();
            JSONObject size = (JSONObject) i.next();
            this.gridSizeX = ((Long) size.get("x")).intValue();
            size = (JSONObject) i.next();
            this.gridSizeY = ((Long) size.get("y")).intValue();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
