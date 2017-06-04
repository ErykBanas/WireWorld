import core.*;
import model.WireWorld;
import model.World;
import presenter.Presenter;
import presenter.SimulationThread;
import presenter.WorldPresenter;
import utils.ConfigReader;
import utils.ConfigReaderJSON;
import utils.DataReader;
import utils.DataReaderJSON;
import view.WireWorldView;
import view.WireWorldViewGUI;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.io.File;

public class AppTest {

    public static void main(String []args){

        //Jak działa tu to SwingUtilities.invokeLater()?

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DataReader dataReader = DataReaderJSON.getInstance();
                Grid grid = dataReader.read(new File("exampleInputData.json"));
                Presenter presenter = new WorldPresenter(); //Taki interfejs, żeby było ogólniej!
                //todo Rozważyć zapisywanie aktualnie aktywnej komórki podczas wstawiania, żeby było wiadomo gdzie wstawić kolejny element

                ConfigReader configReader = ConfigReaderJSON.getInstance();
                configReader.read(new File("config.json"));

                World world = new WireWorld(grid);
                WireWorldView view = new WireWorldViewGUI(configReader.getGridSizeX(),configReader.getGridSizeY(), 10);
                SimulationThread simulationThread = new SimulationThread();
                //Tutaj juz w tym momencie uruchamiany NOWY wątek. Tam jest metoda start() uruchamiająca w
                //konstruktorze, a to dalej uruchamia nadpisane run().

                simulationThread.setPresenter(presenter); //To jest po prostu, żeby poszczególne klasy się widziały!
                view.setPresenter(presenter); // Żeby np. z view można było wywołać jakąś metodę presenter-a!
                presenter.setSimulationThread(simulationThread); //To jest do WorldPresenter
                // Na zmianę są przekazywane obiekty i dzięki temu mogą sie ze sobą komunikowac!
                // Stary wątek to obsługa przycisków, a 2-gi utworzony wątek czeka na interruption, a tak, to działa sobie po ciuchu w background


                // Zrobić zastosowanie w presenterz-e tego simulation Thread i innych, bo póki co, to NIE są poimplementowane!
                presenter.setWireWorldView(view);
                presenter.setWorld(world);

                view.updateCellsColor(grid);
                view.open();

                //presenter.getSimulationThread().setAnimationSpeed(1000);

//                simulationThread.setAnimationSpeed(200); //Metoda niezależna od presenter-a!
            }
        });
// Do głównej klasy przekazujemy obiekty w zasadzie wszystkich klas, a potem się przypisuje poszczególnym te,
        // które potrzebują - tak wygląda wzorzec proj. model-view-presenter i tak było np. w przykładowych
        // implementacjach i dokumentacjach!
    }
}