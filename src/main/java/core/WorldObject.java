package core;

import java.util.ArrayList;

/**
 * Klasa abstrakcyjna dla obiektów takich jak bramki - Jak ona tu będzie zaimplementowana?
 */
public abstract class WorldObject {

    public abstract ArrayList<Coordinate> getObjectCells();
    public abstract Cell.State getObjectState();

}
