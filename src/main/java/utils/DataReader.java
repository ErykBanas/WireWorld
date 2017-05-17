package utils;

import core.Cell;
import core.Coordinate;

import java.io.File;
import java.util.HashMap;

/**
 * Interfejs reprezentuje obiekt wczytujący dane generacji do aplikacji
 */

public interface DataReader {

    /**
     * Wczytuje z pliku dane generacji do hashMapy
     * @param file Plik, który został wskazany przez użytkownika do wczytania
     * @return HashMapa z wczytanymi współrzędnymi komórek
     */
    HashMap<Coordinate,Cell> read(File file);

}
