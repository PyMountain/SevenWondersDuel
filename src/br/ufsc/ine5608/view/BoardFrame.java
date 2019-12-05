package br.ufsc.ine5608.view;

import br.ufsc.ine5608.controller.CardTreeController;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5608.controller.GeneralController;
import br.ufsc.ine5608.controller.PlayerController;
import br.ufsc.ine5608.model.AgeCard;
import br.ufsc.ine5608.model.Resource;
import java.util.ArrayList;

public class BoardFrame extends JFrame {
     private static BoardFrame tfInstance; 
     private JLabel lbCardBoard;
     private JLabel lbPlayersItens;
     private JTable tbCardBoard;
     private JTable tbPlayersItens;
     private JScrollPane spCardBoard;
     private JScrollPane spPlayersItens;
     private JButton btEndTurn;     
     
    public BoardFrame() {
        super("7 Wonders Duel");
        this.screenConfiguration();
    }
    
    public static BoardFrame getInstance() {        
        if (tfInstance == null) {
        	tfInstance = new BoardFrame();
        }        
        return tfInstance;
    }
    
    public void showFrame() {
        this.setVisible(true);
    }
    
    public void hideFrame() {
        this.setVisible(false);
    }

    public void tableRefresh() {
        this.screenConfiguration();
    }
    
    private void screenConfiguration() {
        Container container = getContentPane();
        container.setSize(1280, 720);
        container.setLayout(new GridBagLayout());
        
        // Cardboard label configuration
        {
            lbCardBoard = new JLabel();
            lbCardBoard.setText("Cartas da mesa:");
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.ipadx = 1280; 
            cons.gridheight = 1;
            cons.gridwidth = 1;
            cons.gridy = 0;
            cons.gridx = 0;
            container.add(lbCardBoard, cons);
        }
        
        // Cardboard table configuration
        {
            tbCardBoard = new JTable();
            tbCardBoard.setPreferredScrollableViewportSize(new Dimension(400, 200));
            tbCardBoard.setFillsViewportHeight(true);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.ipady = 500;
            cons.gridheight = 1;
            cons.gridwidth = 1;
            cons.gridx = 0;
            cons.gridy = 1;
            spCardBoard = new JScrollPane(tbCardBoard);
            String[] age = {"Age "+CardTreeController.getInstance().getAge()};
            DefaultTableModel modelItens = new DefaultTableModel(age, 10);
            ArrayList<AgeCard> cardTreeCards = CardTreeController.getInstance().getCards();
            for(int i = 0; i < cardTreeCards.size(); i++){
                String label = "";
                if(CardTreeController.getInstance().verifyCard(i)){
                    label = cardTreeCards.get(i).getName();
                } else {
                    label = cardTreeCards.get(i).getName() + "-BLOQUEADA";
                }
                modelItens.setValueAt(label, i, 0);
            }
            //setup click event for cardTree table
            tbCardBoard.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(!PlayerController.getInstance().getPlayer().getPlayerTurn()){
                        MessagePanel msgPanel = new MessagePanel("Não é sua vez!");
                        msgPanel.showFrame();
                    } else {
                        int row = tbCardBoard.rowAtPoint(evt.getPoint());
                        if(!CardTreeController.getInstance().verifyCard(row)){
                            MessagePanel msgPanel = new MessagePanel("A carta não pode ser selecionada pois está bloqueada!");
                            msgPanel.showFrame();
                        } else {
                            ActionPanel actionPanel = new ActionPanel(CardTreeController.getInstance().getCards().get(row), row);
                            actionPanel.showFrame();
                        }
                    }
                }
            });
            this.tbCardBoard.setModel(modelItens);
            this.repaint();
            container.add(spCardBoard, cons);            
        }
        
        // Players itens label configuration
        {
            lbPlayersItens = new JLabel();
            lbPlayersItens.setText("Seus itens:");
            GridBagConstraints cons = new GridBagConstraints();
            cons.ipadx = 1280; 
            cons.gridheight = 1;
            cons.gridwidth = 1;
            cons.gridy = 2;
            cons.gridx = 0;
            container.add(lbPlayersItens, cons);
        }
        
     // Players itens table configuration
        {
            tbPlayersItens = new JTable();
            tbPlayersItens.setPreferredScrollableViewportSize(new Dimension(400, 200));
            tbPlayersItens.setFillsViewportHeight(true);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.ipady = 300;
            cons.gridheight = 1;
            cons.gridwidth = 1;
            cons.gridx = 0;
            cons.gridy = 7;
            spPlayersItens = new JScrollPane(tbPlayersItens);
            String[] players = {PlayerController.getInstance().getPlayer().getName() + "- MOEDAS: " + PlayerController.getInstance().getPlayer().getCoins(), PlayerController.getInstance().getOponent().getName()+ "- MOEDAS: " + PlayerController.getInstance().getOponent().getCoins()};
            DefaultTableModel modelPlayers = new DefaultTableModel(players, 15);
            ArrayList<AgeCard> playerCards = PlayerController.getInstance().getPlayer().getAgeCards();
            ArrayList<AgeCard> oponentCards = PlayerController.getInstance().getOponent().getAgeCards();
            for(int i = 0; i < playerCards.size(); i++){
                String resourcesString = "";
                for(Resource res: playerCards.get(i).getResources()){
                    switch (res) {
                        case CLAY:
                            resourcesString = resourcesString + "argila, ";
                            break;
                        case STONE:
                            resourcesString = resourcesString + "pedra, ";
                            break;
                        case WOOD:
                            resourcesString = resourcesString + "madeira, ";
                            break;
                        case PAPER:
                            resourcesString = resourcesString + "papel, ";
                            break;
                        default:
                            break;
                    }
                }
                String label = playerCards.get(i).getName() + "-" + resourcesString;
                modelPlayers.setValueAt(label, i, 0);
            }
            for(int i = 0; i < oponentCards.size(); i++){
                String resourcesString = "";
                for(Resource res: oponentCards.get(i).getResources()){
                    switch (res) {
                        case CLAY:
                            resourcesString = resourcesString + "argila, ";
                            break;
                        case STONE:
                            resourcesString = resourcesString + "pedra, ";
                            break;
                        case WOOD:
                            resourcesString = resourcesString + "madeira, ";
                            break;
                        case PAPER:
                            resourcesString = resourcesString + "papel, ";
                            break;
                        default:
                            break;
                    }
                }
                String label = oponentCards.get(i).getName() + "-" + resourcesString + "-PONTOS DE VITÓRIA: " + oponentCards.get(i).getVictoryPoints();
                modelPlayers.setValueAt(label, i, 1);
            }
            
            this.tbPlayersItens.setModel(modelPlayers);
            this.repaint();
            container.add(spPlayersItens, cons);            
        }
        
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
