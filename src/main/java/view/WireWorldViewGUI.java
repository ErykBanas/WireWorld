package view;

import core.Cell;
import core.Coordinate;
import core.Grid;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

public class WireWorldViewGUI extends JFrame implements WireWorldView, ActionListener {

    //Deklaracja elementów Menu
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openGenerationMenuItem;
    private JMenuItem saveGenerationMenuItem;
    private JPopupMenu.Separator separator1;
    private JMenuItem optionsMenuItem;
    private JPopupMenu.Separator separator2;
    private JMenuItem exitMenuItem;
    private JMenu visualisationMenu;
    private JMenuItem startMenuItem;
    private JMenuItem pauseMenuItem;
    private JMenuItem stopMenuItem;
    private JMenu helpMenu;
    private JMenuItem helpMenuItem;
    private JMenuItem aboutMenuItem;

    Container container;
    WorldGridPanel worldGridPanel; // To jest jedyne miejsce, w którym ta klasa będzie użyta (także można powiedzieć, że jest tu zawarta)
    JPanel buttonsPanel;

    //Deklaracja przycisków
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;

    private int rowsNumber;
    private int columnsNumber;
    private int preferredCellLabelSize;

    Presenter presenter;


    public WireWorldViewGUI() {

        super("WireWorld");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.prepareGUI();

    }

    /**
     * Konstruktor, który ustwia rozmiar planszy (gridu) wg przekazanych wartości
     * Uruchamia metodę prepareGUI, która deklaruje obiekty graficzne okna
     * @param columnsNumber Liczba kolumn (rozmiar x)
     * @param rowsNumber Liczba wierszy (rozmiar y)
     */
    public WireWorldViewGUI(int columnsNumber, int rowsNumber, int preferredCellLabelSize) {
        super("WireWorld");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.columnsNumber = columnsNumber;
        this.rowsNumber = rowsNumber;
        this.preferredCellLabelSize = preferredCellLabelSize;
        this.prepareGUI();
    }

    //Przygotowanie okna: umieszczenie wszystkich elementów takich jak menu, przyciski, grid
    private void prepareGUI() {

        //MENU
        menuBar = new JMenuBar();
        add(menuBar, BorderLayout.NORTH);

        //MENU: Plik
        fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        openGenerationMenuItem = new JMenuItem("Otwórz generację");
        openGenerationMenuItem.addActionListener(this);
        fileMenu.add(openGenerationMenuItem);

        saveGenerationMenuItem = new JMenuItem("Zapisz generację");
        saveGenerationMenuItem.addActionListener(this);
        fileMenu.add(saveGenerationMenuItem);

        separator1 = new JPopupMenu.Separator();
        fileMenu.add(separator1);

        optionsMenuItem = new JMenuItem("Opcje");
        optionsMenuItem.addActionListener(this);
        fileMenu.add(optionsMenuItem);

        separator2 = new JPopupMenu.Separator();
        fileMenu.add(separator2);

        exitMenuItem = new JMenuItem("Wyjście");
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        //MENU: Wizualizacja
        visualisationMenu = new JMenu("Wizualizacja");
        menuBar.add(visualisationMenu);

        startMenuItem = new JMenuItem("Start");
        startMenuItem.addActionListener(this);
        visualisationMenu.add(startMenuItem);

        pauseMenuItem = new JMenuItem("Pauza");
        pauseMenuItem.addActionListener(this);
        visualisationMenu.add(pauseMenuItem);

        stopMenuItem = new JMenuItem("Stop");
        stopMenuItem.addActionListener(this);
        visualisationMenu.add(stopMenuItem);

        //MENU: Pomoc
        helpMenu = new JMenu("Pomoc");
        menuBar.add(helpMenu);

        helpMenuItem = new JMenuItem("Pomoc");
        helpMenuItem.addActionListener(this);
        helpMenu.add(helpMenuItem);

        aboutMenuItem = new JMenuItem("O programie");
        aboutMenuItem.addActionListener(this);
        helpMenu.add(aboutMenuItem);

        this.setJMenuBar(menuBar);

        //CONTAINER
        container = getContentPane();
        //container.setLayout(new BorderLayout(BorderLayout.CENTER)));

        //GRID PANEL - są właśnie oddzielne Panel-e do Grid-a, jak i potem do przyciskow!
        worldGridPanel = new WorldGridPanel(rowsNumber, columnsNumber, preferredCellLabelSize);
        worldGridPanel.setBounds(0, 0, 1000, 600);

        container.add(worldGridPanel, BorderLayout.CENTER);

        //BUTTONS PANEL
        buttonsPanel = new JPanel();

        startButton = new JButton("Start");
        buttonsPanel.add(startButton);
        //startButton.setBounds(0,0,100,25);
        startButton.addActionListener(this);

        pauseButton = new JButton("Pauza");
        buttonsPanel.add(pauseButton);
        //pauseButton.setBounds(0,0,100,25);
        pauseButton.addActionListener(this);

        stopButton = new JButton("Stop");
        buttonsPanel.add(stopButton);
        //stopButton.setBounds(0,0,100,25);
        stopButton.addActionListener(this);

        container.add(buttonsPanel, BorderLayout.LINE_END);

        //FRAME
        setSize(1500, 1000);

    }

    public void open() {
        this.setVisible(true);
    }
    public void close() {
        this.dispose();
    }//Zamykanie danego okienka.
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    } //Żeby było wiadomo jaki to jest
    // presenter-a i można go potem wywołać.

    // Do tej metody nie do końca jasne są: "cellLabel[x][y]" z WorldCellLabel, konkretnie przy tym getCellLabel
    // - jak to tam działa :P

    //Uaktualnienie koloru komórki na gridzie - w sumie, to nie muszę tego do końca rozumieć, ważne, żeby to tu działało :D
    public void updateCellsColor(Grid grid){
//Grid przechowuje haszmapę z Coordinates, jak i z zawartością komórki!
        Iterator it = grid.getHashMap().entrySet().iterator();
        while(it.hasNext()) { //Dopóki metoda .next() zwróciłaby jakiś kolejny element, a nie throw wyjątek!
            Map.Entry entry = (Map.Entry) it.next();
            Coordinate coordinate = (Coordinate) entry.getKey();
            Cell cell = (Cell) entry.getValue();

            worldGridPanel.getCellLabel((int)coordinate.getY(),(int)coordinate.getX()).updateCellColor(cell.getState());

        }
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this,"WireWorld 1.0 \n\nAutorzy: \nEryk Banaś \nMateusz Bocheński");
    }

    public void showHelp(){
        JOptionPane.showMessageDialog(this,"WireWorld\n\n" +
                "Aplikacja służy do przedstawienia symulacji automatu komórkowego WireWorld.\n\n" +
                "- W celu rozpoczęcia symulacji wybierz przycisk \"Start\"\n" +
                "- Aby zatrzymać symulację wybierz \"Pauza\"\n" +
                "- Symulacja zostanie zakończona po wybraniu przycisku \"Stop\"" +
                " lub po określonej w ustawieniach liczbie generacji\n" +
                "\nAplikacja umożliwia wczytywanie oraz zapisytwanie generacji w pliku JSON\n" +
                "Użytkownik może zmienić rozmiary planszy, szybkość generacji oraz liczbę generacji" +
                " wybieracjąc z menu pozycję Plik>Opcje");
    }

//actionPerformed() jest metoda wewnętrzną, ale MUSI byc zdefiniowana by nie wywalilo przy żadnym GUI błędu!
    //Najlepiej, jak tylko się da, to analizowac w stronę - OD działającego programu, DO kodu (bo wtedy np. widac
    //jakiego tam sposobu interakcji z uzytkownikiem sobie szukac!
    //Obsługa zdarzeń
    public void actionPerformed(ActionEvent actionEvent) { //Action Listener może przechwycać obiekt zdarzenia, natomia
                                                           //natomiast ActionListener to interfejs z różnymi metodami
        Object source = actionEvent.getSource(); //Object na compareTo sprawdzająca, czy to są te same obiekty, czy
                                                 //czy start button to ten obiekt wywołujący zdarzenie, czy inne

        if (this.startButton.equals(source) || this.startMenuItem.equals(source)) {
            presenter.animationStarted(); //i to idzie do zarządcy, co się stało, przekazujemy presenter-owi, że coś się
                                            // się działo i co ma z tym zrobić.
        } else if (this.pauseButton.equals(source) || this.pauseMenuItem.equals(source)) {
            presenter.animationPaused();
        } else if (this.stopButton.equals(source) || this.stopMenuItem.equals(source)) {
            presenter.animationStopped();
        } else if (this.openGenerationMenuItem.equals(source)){
            presenter.clickedOpenGeneration();
        } else if (this.saveGenerationMenuItem.equals(source)){
            presenter.clickedSaveGeneration();
        } else if (this.optionsMenuItem.equals(source)){
            presenter.clickedShowOptionsWindow();
        } else if (this.exitMenuItem.equals(source)){
            presenter.clickedExitApplication();
        } else if (this.helpMenuItem.equals(source)){
            presenter.clickedShowHelpWindow();
        } else if (this.aboutMenuItem.equals(source)){
            presenter.clickedShowAboutWindow();
        }

    }
}
