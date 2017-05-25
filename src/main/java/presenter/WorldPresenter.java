package presenter;

import model.World;
import view.OptionsView;
import view.WireWorldView;

public class WorldPresenter implements Presenter{

    private World world;
    private OptionsView optionsView;
    private WireWorldView wireWorldView;
    private SimulationThread simulationThread;


    public WorldPresenter() {

    }

    public void setWorld(World world) {
        this.world = world;
    }
    public void setOptionsView(OptionsView optionsView) {
        this.optionsView = optionsView;
    }
    public void setWireWorldView(WireWorldView wireWorldView) {
        this.wireWorldView = wireWorldView;
    }
    public void setSimulationThread(SimulationThread simulationThread) {
        this.simulationThread = simulationThread;
    }

    public World getWorld() {
        return world;
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
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }

    public void clickedOpenGeneration() {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }

    public void clickedSaveGeneration() {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }

    public void clickedShowOptionsWindow() {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
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
