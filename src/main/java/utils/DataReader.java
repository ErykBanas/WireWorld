package utils;

import core.Grid;

import java.io.File;

/**
 * Interfejs reprezentuje obiekt wczytujący dane generacji do aplikacji
 */

public interface DataReader {

    /**
     * Wczytuje z pliku dane generacji do gridu
     * @param file Plik, który został wskazany przez użytkownika do wczytania
     * @return Grid z wczytanymi do hashMapy współrzędnymi komórek
     */
    Grid read(File file);

}
