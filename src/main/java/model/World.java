package model;

import core.Grid;

public interface World {

    void produceNewWorldState();
    Grid getGrid();
}


