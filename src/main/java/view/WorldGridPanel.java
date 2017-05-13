package view;


import javax.swing.*;

public class WorldGridPanel extends JPanel {

    private WorldCellLabel cellLabels [][];

    public WorldGridPanel(int rows, int columns){

        cellLabels = new WorldCellLabel[rows][columns];

        //todo Ustawić obiekty klasy WorldCellLabel na panelu

    }


}
