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
            default: setBackground(Color.CYAN); //Change to WHITE
        }
    }




}
