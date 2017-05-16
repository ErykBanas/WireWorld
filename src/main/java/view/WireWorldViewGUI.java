package view;


import core.Cell;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WireWorldViewGUI extends JFrame implements WireWorldView, ActionListener {

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
    WorldGridPanel gridPanel;
    JPanel buttonsPanel;

    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;

    private final int rowsNumber = 20;
    private final int columnsNumber = 30;
    private final int preferredCellLabelSize = 10;

    Presenter presenter;

    private boolean started;
    private boolean stopped;


    public WireWorldViewGUI() {

        super("WireWorld");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        //GRID PANEL
        gridPanel = new WorldGridPanel(rowsNumber, columnsNumber, preferredCellLabelSize);
        gridPanel.setBounds(0, 0, 1000, 600);

        container.add(gridPanel, BorderLayout.CENTER);

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
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Presenter getPresenter() {
        return this.presenter;
    }

    //Uaktualnienie koloru komórki na gridzie
    public void updateCellLabelColor(int x, int y, Cell.State state) {
        gridPanel.getCellLabel(x, y).updateCellColor(state);
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean running) {
        this.started = running;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    //Obsługa zdarzeń
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (this.startButton.equals(source) || this.startMenuItem.equals(source)) {
            this.started = true;
            presenter.startAnimation();
        } else if (this.pauseButton.equals(source) || this.pauseMenuItem.equals(source)) {
            this.started = false;
            presenter.pauseAnimation();
        } else if (this.stopButton.equals(source) || this.stopMenuItem.equals(source)) {
            this.stopped = true;
            presenter.stopAnimation();
        } else if (this.openGenerationMenuItem.equals(source)){
            presenter.openGeneration();
        } else if (this.saveGenerationMenuItem.equals(source)){
            System.out.println("Open");
            presenter.saveGeneration();
        } else if (this.optionsMenuItem.equals(source)){
            presenter.showOptionsWindow();
        } else if (this.exitMenuItem.equals(source)){
            presenter.exitApplication();
        } else if (this.helpMenuItem.equals(source)){
            presenter.showHelpWindow();
        } else if (this.aboutMenuItem.equals(source)){
            presenter.showAboutWindow();
        }

    }
}
