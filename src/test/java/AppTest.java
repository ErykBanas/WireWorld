import core.Cell;
import presenter.Presenter;
import presenter.WorldPresenter;
import view.*;

public class AppTest {

    public static void main(String []args){

        Presenter presenter = new WorldPresenter();
        WireWorldView view = new WireWorldViewGUI();
        view.setPresenter(presenter);
        view.updateCellLabelColor(3,3, Cell.State.WIRE); //działa
        view.open();

    }
}
