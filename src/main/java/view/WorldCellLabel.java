package view;

import core.Cell;

import javax.swing.*;
import java.awt.*;


/**
 * Obiekty tej klasy reprezentują komórki na planszy interfejsu graficznego
 */

public class WorldCellLabel extends JLabel{

    double x;
    double y;
    //Cell.State state;

    public WorldCellLabel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void updateCellColor(Cell.State state) {
        //this.state = state;

        switch (state){
            case ELECTRONHEAD:setBackground(Color.RED);
            case ELECTRONTAIL:setBackground(Color.yellow);
            case WIRE:setBackground(Color.BLACK);
            case EMPTY:setBackground(Color.white);
            default:setBackground(Color.white);
        }
    }




}
