package view;


import core.Cell;
import core.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class WorldGridPanel extends JPanel {

    private WorldCellLabel cellLabels [][];

    public WorldGridPanel(int rows, int columns, int preferredLabelSize){

        cellLabels = new WorldCellLabel[rows][columns];
        setLayout(new GridLayout(rows,columns));

        Dimension cellLabelSize = new Dimension(preferredLabelSize, preferredLabelSize);

        for(int i = 0; i<rows; i++ ){
            for(int j=0; j<columns; j++){
                cellLabels[i][j] = new WorldCellLabel(i,j);
                cellLabels[i][j].setOpaque(true);
                cellLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
                cellLabels[i][j].setPreferredSize(cellLabelSize);
                add(cellLabels[i][j]);
            }
        }

    }


    public WorldCellLabel getCellLabel(int x, int y){
        return this.cellLabels[x][y];
    }

    public void upadateCellsColorList(LinkedList<Pair> linkedList){
        for(Pair pair:linkedList){
            int x = (int)pair.getCoordinate().getX();
            int y = (int)pair.getCoordinate().getY();
            Cell.State state = pair.getCell().getState();

            this.cellLabels[x][y].updateCellColor(state);
        }
    }


}
