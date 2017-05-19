package view;

import presenter.Presenter;

public interface OptionsView{

    void open();
    void close();
    void setPresenter(Presenter presenter);
    Presenter getPresenter();

    void setNumberOfGenerations(int numberOfGenerations);
    int getNumberOfGenerations();
    void setNumberOfCellsHorizontally(int numberOfCellsHorizontally);
    int getNumberOfCellsHorizontally();
    void setNumberOfCellsVertically(int numberOfCellsVertically);
    int getNumberOfCellsVertically();

}
