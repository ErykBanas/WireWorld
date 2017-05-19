package presenter;


import model.WireWorld;
import view.WireWorldView;

public interface Presenter{

    void setWireWorldView(WireWorldView wireWorldView);
    void setWireWorld(WireWorld wireWorld);

    void animationStarted();
    void animationPaused();
    void animationStopped();
    void clickedOpenGeneration();
    void clickedSaveGeneration();
    void clickedShowOptionsWindow();
    void clickedExitApplication();
    void clickedShowHelpWindow();
    void clickedShowAboutWindow();



}
