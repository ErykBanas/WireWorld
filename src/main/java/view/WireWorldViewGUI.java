package view;


import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WireWorldViewGUI extends JFrame implements WireWorldView, ActionListener{

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
    JPanel gridPanel;
    JPanel buttonsPanel;

    private final int rowsNumber = 20;
    private final int columnsNumber = 30;

    Presenter presenter;



    public WireWorldViewGUI(){

        super("WireWorld");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.prepareGUI();

    }

    private void prepareGUI(){

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
        container.setLayout(null);

        //GRID PANEL
        gridPanel = new WorldGridPanel(rowsNumber,columnsNumber);
        gridPanel.setBounds(0,0,1000,600);

        container.add(gridPanel);

        //BUTTONS PANEL
        buttonsPanel = new JPanel();


        //FRAME
        setSize(1500,1000);

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
        return presenter;
    }

    public void drawGrid() {

    }

    public void actionPerformed(ActionEvent e) {

    }
}
