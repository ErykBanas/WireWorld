package utils;

import core.Cell;
import core.Coordinate;

import java.io.File;
import java.util.HashMap;

/**
 * Wczytuje dane generacji z pliku typu JSON do Hashmapy
 */
public class DataReaderJSON implements DataReader {
    public HashMap<Coordinate, Cell> read(File file) {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }
}
