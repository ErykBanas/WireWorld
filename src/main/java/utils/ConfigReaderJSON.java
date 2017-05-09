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

public class ConfigReaderJSON implements ConfigReader{

    private Long animationSpeed;
    private Long numberOfGenerations;
    private Long gridSizeX;
    private Long gridSizeY;

    private ConfigReaderJSON(){
    }

    public static ConfigReaderJSON getInstance(){
        return ConfigReaderJSONHolder.instance;
    }

    private static class ConfigReaderJSONHolder{
        private static final ConfigReaderJSON instance = new ConfigReaderJSON();
    }

    public Long getAnimationSpeed() {
        return animationSpeed;
    }

    public Long getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public Long getGridSizeX() {
        return gridSizeX;
    }

    public Long getGridSizeY() {
        return gridSizeY;
    }


    public void read(File file) {

        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject)obj;

            this.animationSpeed = (Long)jsonObject.get("AnimationSpeed");
            this.numberOfGenerations = (Long)jsonObject.get("NumberOfGenerations");

            JSONArray gridSizes = (JSONArray) jsonObject.get("GridSize");
            Iterator i = gridSizes.iterator();
            JSONObject size = (JSONObject) i.next();
            this.gridSizeX = (Long) size.get("x");
            size = (JSONObject) i.next();
            this.gridSizeY = (Long) size.get("y");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
