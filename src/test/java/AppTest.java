import core.Cell;
import core.Grid;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.SimulationThread;
import presenter.WorldPresenter;
import view.WireWorldView;
import view.WireWorldViewGUI;

import javax.swing.*;

public class AppTest {

    public static void main(String []args){


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Ręczne utworzenie gridu na cele testowe. Docelowo będzie tworzony i zwracany przez wywołanie metody DataReaderJSON.read()
                Grid grid = new Grid();
                grid.insertNewCell(1,3, Cell.State.WIRE);
                grid.insertNewCell(2,3, Cell.State.WIRE);
                grid.insertNewCell(3,3, Cell.State.WIRE);
                grid.insertNewCell(0,3, Cell.State.WIRE);
                grid.insertNewCell(4,3, Cell.State.WIRE);
                grid.insertNewCell(5,3, Cell.State.WIRE);
                grid.insertNewCell(6,3, Cell.State.WIRE);
                grid.insertNewCell(7,2, Cell.State.WIRE);
                grid.insertNewCell(7,4, Cell.State.WIRE);
                grid.insertNewCell(8,2, Cell.State.WIRE);
                grid.insertNewCell(8,4, Cell.State.WIRE);
                grid.insertNewCell(2,3, Cell.State.ELECTRONHEAD);
                grid.insertNewCell(1,3, Cell.State.ELECTRONTAIL);
                grid.insertNewCell(9,3, Cell.State.WIRE);

                World world = new WireWorld(grid);
                Presenter presenter = new WorldPresenter();
                WireWorldView view = new WireWorldViewGUI();
                SimulationThread simulationThread = new SimulationThread();

                simulationThread.setPresenter(presenter);

                presenter.setSimulationThread(simulationThread);
                presenter.setWireWorldView(view);
                presenter.setWorld(world);

                view.setPresenter(presenter);
                view.open();
            }
        });



    }
}
