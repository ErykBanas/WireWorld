package utils;

import core.Grid;

import java.io.File;
import java.io.IOException;

/**
 * Interfejs do zapisywania danych generacji do pliku
 */
public interface DataWriter {

    /**
     * Zapisuje dane pobrane z obieku gridu (jego HashMapy) i zapisuje do pliku
     * @param grid Obiekt gridu zawiarający HashMapę z komórkami
     * @param file Plik wyjściowy
     * @throws IOException Wyjątek rzucany, gdy nie uda się zapisać danych do pliku
     */
    void write (Grid grid, File file) throws IOException;

}
