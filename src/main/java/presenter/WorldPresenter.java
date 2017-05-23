package presenter;

import model.World;
import view.OptionsView;
import view.WireWorldView;

public class WorldPresenter implements Presenter{

    private World world;
    private OptionsView optionsView;
    private WireWorldView wireWorldView;
    private boolean animationStarted;

    public WorldPresenter() {
        this.animationStarted = false;
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

    public void animationStarted() {


                animationStarted = true;
                while (animationStarted) {

                    this.world.produceNewWorldState();
                    this.wireWorldView.updateCellsColor(world.getGrid());
                    //todo Uzupełnić implementację metody, aby obsługiwała wielowątkowość

                    animationStarted = false;
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
