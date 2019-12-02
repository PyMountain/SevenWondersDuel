package br.ufsc.ine5608.view;

import br.ufsc.ine5608.controller.GeneralController;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StartFrame extends JFrame {
    private JLabel lbWelcome;
    private JLabel lbJourney;
    private JButton btContinue;
    private JTable tbWonders;
    private JScrollPane spWonders;
    private TableManager tableManager;
    private ButtonManager buttonManager;
    private int wonderCode;
    private static StartFrame sfInstance;    

    public StartFrame() {
        super("7 Wonders Duel - Start");
        this.buttonManager = new ButtonManager();
        this.screenConfiguration();        
    }
    
    public static StartFrame getInstance() {        
        if (sfInstance == null) {
        	sfInstance = new StartFrame();
        }        
        return sfInstance;
    }

    private void screenConfiguration() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        // Welcome label configuration
        {
            lbWelcome = new JLabel();
            lbWelcome.setText("BEM VINDO AO JOGO! ESSAS SÃO AS SUAS MARAVILHAS:");
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 5;
            cons.gridx = 0;
            container.add(lbWelcome, cons);
        }

        // Wonders table configuration
        {
            tbWonders = new JTable();
            tbWonders.setPreferredScrollableViewportSize(new Dimension(200, 200));
            tbWonders.setFillsViewportHeight(true);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridheight = 0;
            cons.gridwidth = 0;
            cons.gridx = 0;
            cons.gridy = -2;
            spWonders = new JScrollPane(tbWonders);
            tbWonders.addMouseListener(tableManager);            
            String[] players = {"Jogador 1", "Jogador 2"};
            DefaultTableModel modelPlayers = new DefaultTableModel(players, 1);
            modelPlayers.setValueAt("As Pirâmides", 0, 0);
            modelPlayers.setValueAt("A Grande Biblioteca", 0, 1);
            this.tbWonders.setModel(modelPlayers);
            this.repaint();
            container.add(spWonders, cons);            
        }       

        // Journey label configuration
        {
            lbJourney = new JLabel();
            lbJourney.setText("Você terá uma longa jornada pela frente, prepare-se!");
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = -2;
            cons.gridx = 0;
            container.add(lbJourney, cons);
        }

        // Start button configuration
        {
            btContinue = new JButton();
            btContinue.setText("Continuar");
            btContinue.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btContinue, cons);
        }

        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showFrame() {
        this.setVisible(true);
    }

    public void hideFrame() {
        this.setVisible(false);
    }
        
    private class ButtonManager implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource().equals(btContinue)) {
                GeneralController.getInstance().startGame();
            }
        }        
    }

    private class TableManager implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            wonderCode = Integer.valueOf(tbWonders.getValueAt(tbWonders.getSelectedRow(), 3).toString());
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {

        }

        @Override
        public void mousePressed(MouseEvent arg0) {

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {

        }

    }
}