package utils;

import java.io.File;

/**
 * Interfejs do obiektu pobierającego konfigurację aplikacji z pliku
 */
public interface ConfigReader {

    /**
     * Zwraca prędkość animacji
     * @return Prędkość animacji
     */
    int getAnimationSpeed();

    /**
     * Zwraca liczbę generacji
     * @return Liczba generacji
     */
    int getNumberOfGenerations();

    /**
     * Zwraca rozmiar poziomy planszy (gridu)
     * @return Rozmiar poziomy planszy (gridu)
     */
    int getGridSizeX();

    /**
     * Zwraca rozmiar pionowy planszy (gridu)
     * @return Rozmiar pionowy planszy (gridu)
     */
    int getGridSizeY();

    /**
     * Wczytuje dane konfiguracyjne z pliku i zapisuje w atrybutach klasy
     * @param file Plik wejściowy z danymi konfiguracyjnymi
     */
    void read(File file);


}
