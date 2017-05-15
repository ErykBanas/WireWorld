package view;

import core.Cell;
import presenter.Presenter;

public interface WireWorldView {

    void open();
    void close();
    void setPresenter(Presenter presenter);
    Presenter getPresenter();
    void drawGrid();
    //void showMessage();
    void updateCellLabelColor(int x, int y, Cell.State state);

}
