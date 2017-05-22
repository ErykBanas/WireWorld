package presenter;

import model.World;
import view.OptionsView;
import view.WireWorldView;

public interface Presenter{

    void setWireWorldView(WireWorldView wireWorldView);
    void setOptionsView(OptionsView optionsView);
    void setWorld(World world);

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
