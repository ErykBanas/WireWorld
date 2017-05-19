package presenter;

import model.WireWorld;
import view.OptionsView;
import view.WireWorldView;

public class WorldPresenter implements Presenter{

    private WireWorld wireWorld;
    private OptionsView optionsView;
    private WireWorldView wireWorldView;
    private boolean animationStarted;

    public WorldPresenter() {
        this.animationStarted = false;
    }

    public void setWireWorld(WireWorld wireWorld) {
        this.wireWorld = wireWorld;
    }
    public void setOptionsView(OptionsView optionsView) {
        this.optionsView = optionsView;
    }
    public void setWireWorldView(WireWorldView wireWorldView) {
        this.wireWorldView = wireWorldView;
    }

    public void animationStarted() {

        animationStarted = true;
        while(animationStarted) {
            this.wireWorld.getGrid().countNeighbours();
            this.wireWorld.produceNewGridState();
            wireWorldView.updateCellsColor(wireWorld.getGrid());

//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //todo Poprawić, żeby poprawnie reagowało na ewentualne przerwania
            animationStarted =false;
        }
    }

    public void animationPaused() {
        this.animationStarted = false;
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
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }

    public void clickedShowHelpWindow() {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }

    public void clickedShowAboutWindow() {
        throw new UnsupportedOperationException("Jeszcze nie zaimplementowane");
    }


}
