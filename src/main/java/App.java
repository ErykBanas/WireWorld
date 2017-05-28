import core.Grid;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.SimulationThread;
import presenter.WorldPresenter;
import utils.ConfigReader;
import utils.ConfigReaderJSON;
import view.WireWorldView;
import view.WireWorldViewGUI;

import java.io.File;

public class App {

    public static void main (String [] args){

        ConfigReader configReader = ConfigReaderJSON.getInstance();
        configReader.read(new File("config.json"));

        Grid grid = new Grid();
        World world = new WireWorld(grid);
        Presenter presenter = new WorldPresenter();
        WireWorldView view = new WireWorldViewGUI(configReader.getGridSizeX(),configReader.getGridSizeY());
        SimulationThread simulationThread = new SimulationThread();

        simulationThread.setPresenter(presenter);

        presenter.setSimulationThread(simulationThread);
        presenter.setWireWorldView(view);
        presenter.setWorld(world);

        view.setPresenter(presenter);
        view.open();

    }

}
