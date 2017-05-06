package utils;

import java.io.File;


public interface ConfigReader {

    Long getAnimationSpeed();
    Long getNumberOfGenerations();
    Long getGridSizeX();
    Long getGridSizeY();
    void read(File file);


}
