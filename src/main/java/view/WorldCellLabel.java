package view;

import core.Cell;

import javax.swing.*;
import java.awt.*;


/**
 * Obiekty tej klasy reprezentują komórki na planszy interfejsu graficznego
 */

public class WorldCellLabel extends JLabel{

    /**Wspólrzędna x
     *
     */
    double x;
    /**Współrzędna y
     *
     */
    double y;

    /**
     * Konstruktor: ustawia współrzędne x i y
     * @param x Wspórzędna x
     * @param y Współrzędna y
     */
    public WorldCellLabel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Uaktualnia kolor komórki na planszy w zależnośći od przekazanego stanu
     * @param state Przekazany stan komórki
     */
    public void updateCellColor(Cell.State state) {

        switch (state){
            case ELECTRONHEAD:{
                setBackground(Color.RED);
                break;
            }
            case ELECTRONTAIL:{
                setBackground(Color.yellow);
                break;
            }
            case WIRE: {
                setBackground(Color.BLACK);
                break;
            }
            case EMPTY:{
                setBackground(Color.white);
                break;
            }
            default: setBackground(Color.white);
        }
    }




}
