import core.Grid;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.SimulationThread;
import presenter.WorldPresenter;
import view.WireWorldView;
import view.WireWorldViewGUI;

public class App {

    public static void main (String [] args){

        Grid grid;
        World wireWorld = new WireWorld();
        Presenter presenter = new WorldPresenter();
        WireWorldView view = new WireWorldViewGUI();
        SimulationThread simulationThread = new SimulationThread();

        simulationThread.setPresenter(presenter);

        presenter.setSimulationThread(simulationThread);
        presenter.setWireWorldView(view);
        presenter.setWorld(wireWorld);

        view.setPresenter(presenter);
        view.open();

    }

}
