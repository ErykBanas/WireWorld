package model;

import core.Grid;

public interface World {

    void produceNewWorldState();
    Grid getGrid();
    void setGrid(Grid grid);

    void clearGrid();
}


