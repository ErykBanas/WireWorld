package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionsViewGUI extends JFrame implements OptionsView, ActionListener {

    Container container;
    JPanel buttonsPanel;
    JPanel textPanel;
    private JButton startButton;
    Presenter presenter;
    JTextField numberOfGenerationsField;
    JTextField numberOfCellsHorizontallyField;
    JTextField numberOfCellsVerticallyField;
    JTextField preferredCellLabelSizeField;
    JTextField animationSpeedField;
    int numberOfGenerations;
    int numberOfCellsHorizontally;
    int numberOfCellsVertically;
    int preferredCellLabelSize;
    int animationSpeed;

    public OptionsViewGUI() { //Ewentualnie potem zmodyf. o ekstra argumenty!
        super("Options");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.prepareGUI();
    }

    private void prepareGUI() {
        setSize(1500, 1000);
        //Konfiguracja buttonsPanel:
        buttonsPanel = new JPanel();
        startButton = new JButton("Start");
        buttonsPanel.add(startButton);
        startButton.addActionListener(this);
        //Konfiguracja textPanel:
        textPanel = new JPanel();
        textPanel.setBounds(0, 0, 1000, 600);
        numberOfGenerationsField = new JTextField("Podaj ilosc generacji",25);
        numberOfGenerationsField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                numberOfGenerationsField.setText("");
            }
        });
        numberOfCellsHorizontallyField = new JTextField("Podaj ilosc komórek w poziomie >=15",25);
        numberOfCellsHorizontallyField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                numberOfCellsHorizontallyField.setText("");
            }
        });
        numberOfCellsHorizontallyField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                numberOfCellsHorizontallyField.setText("");
            }
            public void focusLost(FocusEvent e) {
            }
        });
        numberOfCellsVerticallyField = new JTextField("Podaj ilosc komórek w pionie >=20",25);
        numberOfCellsVerticallyField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                numberOfCellsVerticallyField.setText("");
            }
        });
        numberOfCellsVerticallyField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                numberOfCellsVerticallyField.setText("");
            }
            public void focusLost(FocusEvent e) {
            }
        });
        preferredCellLabelSizeField = new JTextField("Podaj preferowany rozmiar komorki <5,15>",25);
        preferredCellLabelSizeField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                preferredCellLabelSizeField.setText("");
            }
        });
        preferredCellLabelSizeField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                preferredCellLabelSizeField.setText("");
            }
            public void focusLost(FocusEvent e) {
            }
        });
        animationSpeedField = new JTextField("Podaj opoznienie miedzy generacjami w ms",25);
        animationSpeedField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                animationSpeedField.setText("");
            }
        });
        animationSpeedField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                animationSpeedField.setText("");
            }
            public void focusLost(FocusEvent e) {
            }
        });
        textPanel.add(numberOfGenerationsField);
        textPanel.add(numberOfCellsHorizontallyField);
        textPanel.add(numberOfCellsVerticallyField);
        textPanel.add(preferredCellLabelSizeField);
        textPanel.add(animationSpeedField);
        //CONTAINER:
        container = getContentPane();
        container.add(textPanel, BorderLayout.CENTER);
        container.add(buttonsPanel, BorderLayout.LINE_END);
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

//    public Presenter getPresenter(); //Spr., MOŻE potem będzie potrzebny, ale TO się okaże :P

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (this.startButton.equals(source)) {
            numberOfGenerations = Integer.parseInt(numberOfGenerationsField.getText());
            numberOfCellsHorizontally = Integer.parseInt(numberOfCellsHorizontallyField.getText());
            numberOfCellsVertically = Integer.parseInt(numberOfCellsVerticallyField.getText());
            preferredCellLabelSize = Integer.parseInt(preferredCellLabelSizeField.getText());
            animationSpeed = Integer.parseInt(animationSpeedField.getText());
            close();
            presenter.setWWVGAWPParameters(numberOfGenerations, numberOfCellsHorizontally, numberOfCellsVertically, preferredCellLabelSize, animationSpeed);
        }
    }
}