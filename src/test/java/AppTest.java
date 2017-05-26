import core.Cell;
import core.Grid;
import core.OrGate;
import core.WireLine;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.SimulationThread;
import presenter.WorldPresenter;
import utils.ConfigReader;
import utils.ConfigReaderJSON;
import view.WireWorldView;
import view.WireWorldViewGUI;

import javax.swing.*;
import java.io.File;

public class AppTest {

    public static void main(String []args){


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Ręczne utworzenie gridu na cele testowe. Docelowo będzie tworzony i zwracany przez wywołanie metody DataReaderJSON.read()
                Grid grid = new Grid();

                grid.insertNewObject(new WireLine(0,3,6,3));
                grid.insertNewCell(7,2, Cell.State.WIRE);
                grid.insertNewCell(7,4, Cell.State.WIRE);
                grid.insertNewCell(8,2, Cell.State.WIRE);
                grid.insertNewCell(8,4, Cell.State.WIRE);
                grid.insertNewCell(9,3, Cell.State.WIRE);
                grid.insertNewCell(10,3, Cell.State.WIRE);

                grid.insertNewObject(new OrGate(11,3));
                grid.insertNewObject(new WireLine(0,7,10,7));
                grid.insertNewObject(new WireLine(13,5,17,5));

                grid.insertNewCell(2,3, Cell.State.ELECTRONHEAD);
                grid.insertNewCell(1,3, Cell.State.ELECTRONTAIL);
                grid.insertNewCell(2,7, Cell.State.ELECTRONHEAD);
                grid.insertNewCell(1,7, Cell.State.ELECTRONTAIL);
                grid.insertNewCell(7,7, Cell.State.ELECTRONHEAD);
                grid.insertNewCell(6,7, Cell.State.ELECTRONTAIL);

                //Koniec ręcznego tworzenia gridu

                //todo Rozważyć zapisywanie aktualnie aktywnej komórki podczas wstawiania, żeby było wiadomo gdzie wstawić kolejny element

                ConfigReader configReader = ConfigReaderJSON.getInstance();
                configReader.read(new File("config.json"));

                World world = new WireWorld(grid);
                Presenter presenter = new WorldPresenter();
                WireWorldView view = new WireWorldViewGUI(configReader.getGridSizeX(),configReader.getGridSizeY());
                SimulationThread simulationThread = new SimulationThread();

                simulationThread.setPresenter(presenter);
                view.setPresenter(presenter);
                presenter.setSimulationThread(simulationThread);
                presenter.setWireWorldView(view);
                presenter.setWorld(world);

                view.updateCellsColor(grid);
                view.open();

                //presenter.getSimulationThread().setAnimationSpeed(1000);
            }
        });



    }
}
