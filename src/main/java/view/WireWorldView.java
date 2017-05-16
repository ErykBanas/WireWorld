package view;

import core.Cell;
import presenter.Presenter;


public interface WireWorldView {

    void open(); //Pokazanie zawartości widoku
    void close(); //Usunięcie zawartości widoku
    void setPresenter(Presenter presenter);
    Presenter getPresenter();

    void updateCellLabelColor(int x, int y, Cell.State state); //Uaktualnienie koloru komórki na gridzie

}
