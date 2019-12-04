package br.ufsc.ine5608.view;

import br.ufsc.ine5608.controller.GeneralController;
import br.ufsc.ine5608.controller.PlayerController;
import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.WonderCard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
            String[] players = {PlayerController.getInstance().getPlayer().getName(), PlayerController.getInstance().getOponent().getName()};
            DefaultTableModel modelPlayers = new DefaultTableModel(players, 4);
            ArrayList<WonderCard> plyWonders = PlayerController.getInstance().getPlayer().getItens().getWonders();
            ArrayList<WonderCard> oponentWonders = PlayerController.getInstance().getOponent().getItens().getWonders();
            for(int i = 0; i < plyWonders.size(); i++){
                modelPlayers.setValueAt(plyWonders.get(i).getName(), i, 0);
            }
            for(int i = 0; i < oponentWonders.size(); i++){
                modelPlayers.setValueAt(plyWonders.get(i).getName(), i, 1);
            }
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
}