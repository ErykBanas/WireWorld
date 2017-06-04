package presenter;

import core.Grid;
import model.WireWorld;
import model.World;
import utils.*;
import view.*;

import java.io.File;
import java.io.IOException;

public class WorldPresenter implements Presenter{

    private World wireWorld;
    private WireWorldView wireWorldView;
    private SimulationThread simulationThread;
    private int numberOfGenerations;
    private int numberOfCellsHorizontally;
    private int numberOfCellsVertically;
    private int preferredCellLabelSize;
    private int animationSpeed;
    private Grid grid;

    public WorldPresenter() { //Kwestia poprawy momentu przekazywania tego grid-a!

    }

    public void setWorld(World world) {
        this.wireWorld = world;
    }
    public void setWireWorldView(WireWorldView wireWorldView) {
        this.wireWorldView = wireWorldView;
    }
    public void setSimulationThread(SimulationThread simulationThread) {
        this.simulationThread = simulationThread;
    }
    public void setWWVGAWPParameters(int numberOfGenerations, int numberOfCellsHorizontally,
                                     int numberOfCellsVertically, int preferredCellLabelSize, int animationSpeed){
        this.numberOfGenerations = numberOfGenerations;
        this.numberOfCellsHorizontally = numberOfCellsHorizontally;
        this.numberOfCellsVertically = numberOfCellsVertically;
        this.preferredCellLabelSize = preferredCellLabelSize;
        this.animationSpeed = animationSpeed;
        DataReader dataReader = DataReaderJSON.getInstance();
        grid = dataReader.read(new File("exampleInputData.json"));
        World world = new WireWorld(grid);
        WireWorldView view = new WireWorldViewGUI(this.numberOfCellsVertically, this.numberOfCellsHorizontally, this.preferredCellLabelSize);
        SimulationThread simulationThread = new SimulationThread();
//Spr. w którym dokł miejscu uruchamia się ten wątek, jak działa i ewentualnie jak w nim poniższe metody uruchomic -
//choc pamietac, że to z AppTest-a wczesniej działało wywołanie NAWET, jak ten wątek juz teoretycznie ruszył!
        simulationThread.setNumberOfGenerations(this.numberOfGenerations);
        simulationThread.setAnimationSpeed(this.animationSpeed);
        simulationThread.setPresenter(this);
        view.setPresenter(this);
        setSimulationThread(simulationThread);
        setWireWorldView(view);
        setWorld(world);
        view.updateCellsColor(grid);
        view.open();
    }//I tu trzeba poprzypisywac do odpowiednich klas odpowiednie parametry

    public World getWorld() {
        return wireWorld;
    }

    public WireWorldView getWireWorldView() {
        return wireWorldView;
    }

    public SimulationThread getSimulationThread() {
        return simulationThread;
    }

    public void animationStarted() {
        simulationThread.resumeThread();
    }

    public void animationPaused() {
        try {
            simulationThread.pauseThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void animationStopped() {
        try {
            simulationThread.pauseThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wireWorld.clearGrid();
        wireWorldView.updateCellsColor(wireWorld.getGrid());
    }

    public void clickedOpenGeneration() {
        wireWorldView.close();
        DataReader dataReader = DataReaderJSON.getInstance();
        grid = dataReader.read(new File("exampleInputData2.json"));
        ConfigReader configReader = ConfigReaderJSON.getInstance();
        configReader.read(new File("config.json"));
        World world = new WireWorld(grid);
        WireWorldView view = new WireWorldViewGUI(configReader.getGridSizeX(),configReader.getGridSizeY(), 10);
        SimulationThread simulationThread = new SimulationThread();
        simulationThread.setPresenter(this);
        view.setPresenter(this);
        setSimulationThread(simulationThread);
        setWireWorldView(view);
        setWorld(world);
        view.updateCellsColor(grid);
        view.open();
    }

    public void clickedSaveGeneration() {
        try {
            DataWriter dataWriter = new DataWriterJSON();
            dataWriter.write(this.getWorld().getGrid(), new File("nowy.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickedShowOptionsWindow() {
        wireWorldView.close();
        OptionsView optionsView = new OptionsViewGUI();
        optionsView.setPresenter(this);
        optionsView.open();
    }

    public void clickedExitApplication() {
        System.exit(0);
    }

    public void clickedShowHelpWindow() {
        wireWorldView.showHelp();
    }

    public void clickedShowAboutWindow() {
        wireWorldView.showAbout();
    }
}