package presenter;

import model.World;
import view.OptionsView;
import view.WireWorldView;

/**
 * Interfejs prezentera zarządzającego komunikacją pomiędzy obiektami widoku oraz modelu
 */
public interface Presenter{

    /**
     * Ustawia widok głównego okna aplikacji
     * @param wireWorldView Widok okna aplikacji
     */
    void setWireWorldView(WireWorldView wireWorldView);

    /**
     * Ustawia widok okna opcji
     * @param optionsView Widok okna opcji
     */
//    void setOptionsView(OptionsView optionsView);

    /**
     * Ustawia obiekt modelu
     * @param world Obiekt modelu
     */
    void setWorld(World world);

    World getWorld();

    WireWorldView getWireWorldView();

    SimulationThread getSimulationThread();

    /**
     * Reakcja na wciśnięcie przycisku Start
     */
    void animationStarted();

    /**
     * Reakcja na wciśnięcie przycisku Pauza
     */
    void animationPaused();

    /**
     * Reakcja na wciśnięcie przycisku Stop
     */
    void animationStopped();

    /**
     * Reakcja na wybranie z menu pozycji Otwórz generację
     */
    void clickedOpenGeneration();

    /**
     * Reakcja na wybranie z menu pozycji Zapisz generację
     */
    void clickedSaveGeneration();

    /**
     * Reakcja na wybranie z menu pozycji Opcje
     */
    void clickedShowOptionsWindow();

    /**
     * Reakcja na wybranie z menu pozycji Wyjście
     */
    void clickedExitApplication();

    /**
     * Reakcja na wybranie z menu pozycji Otwórz Pomoc
     */
    void clickedShowHelpWindow();

    /**
     * Reakcja na wybranie z menu pozycji O programie
     */
    void clickedShowAboutWindow();

    void setSimulationThread(SimulationThread simulationThread);

    void setWWVGAWPParameters(int numberOfGenerations, int numberOfCellsHorizontally,
                              int numberOfCellsVertically, int preferredCellLabelSize, int animationSpeed);
}
