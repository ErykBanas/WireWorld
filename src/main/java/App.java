import core.Grid;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.WorldPresenter;
import view.WireWorldView;
import view.WireWorldViewGUI;

public class App {

    public static void main (String [] args){

        Grid grid;
        World wireWorld = new WireWorld();
        Presenter presenter = new WorldPresenter();
        WireWorldView view = new WireWorldViewGUI();

        presenter.setWireWorldView(view);
        presenter.setWorld(wireWorld);
        view.setPresenter(presenter);

        view.open();

    }

}
