package view;

import core.Cell;
import core.Grid;
import core.Pair;
import presenter.Presenter;

import java.util.LinkedList;


public interface WireWorldView {

    void open(); //Pokazanie zawartości widoku
    void close(); //Usunięcie zawartości widoku
    void setPresenter(Presenter presenter);
    Presenter getPresenter();

    void updateCellLabelsColorList(LinkedList<Pair> linkedList);
    void updateCellsColor(Grid grid);

}
