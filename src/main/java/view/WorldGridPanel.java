package view;


import javax.swing.*;
import java.awt.*;

public class WorldGridPanel extends JPanel {

    private WorldCellLabel cellLabels [][]; //To Też jest jedyne miejsce, w którym ta klasa jest wykorzystywana - ogólnie jest Frame, w tym jest
    // sobie Panel, a w tych panelach Label-e. Do przechowywania danych służą klasy związane z model-em i grid-em, natomiast my tu chcemy przechowywać
    //KOLORY (czyli tylko reprezentację graficzną) i do TEGO właśnie jest wykorzystywana klasa WorldCellLabel!

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


}
