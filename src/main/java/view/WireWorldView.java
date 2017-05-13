package view;

import presenter.Presenter;

public interface WireWorldView {

    void open();
    void close();
    void setPresenter(Presenter presenter);
    Presenter getPresenter();
    void drawGrid();
    //void showMessage();

}
