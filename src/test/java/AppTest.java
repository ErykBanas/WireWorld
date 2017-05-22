import core.Grid;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.WorldPresenter;
import utils.DataReader;
import utils.DataReaderJSONDraft;
import view.WireWorldView;
import view.WireWorldViewGUI;

import java.io.File;

public class AppTest {

    public static void main(String []args){

        Grid grid;
        DataReader dr = DataReaderJSONDraft.getInstance();
        File file = new File("input\\exampleInputData.json");
        grid = dr.read(file);

        World world = new WireWorld(grid);
        Presenter presenter = new WorldPresenter();
        WireWorldView view = new WireWorldViewGUI();

        presenter.setWireWorldView(view);
        presenter.setWorld(world);
        view.setPresenter(presenter);
        view.open();


    }
}
