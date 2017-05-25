package view;

import core.Grid;
import presenter.Presenter;


public interface WireWorldView {

    void open(); //Pokazanie zawartości widoku
    void close(); //Usunięcie zawartości widoku
    void setPresenter(Presenter presenter);

    /**
     * Pokolorowanie komórek wg stanów gridu
     * @param grid Grid wejściowy, wg któego są kolorowane komórki
     */
    void updateCellsColor(Grid grid);

    void showAbout();
    void showHelp();

}
