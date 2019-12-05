package br.ufsc.ine5608.view;

import br.ufsc.ine5608.controller.CardTreeController;
import br.ufsc.ine5608.controller.GeneralController;
import br.ufsc.ine5608.controller.PlayerController;
import br.ufsc.ine5608.model.Action;
import br.ufsc.ine5608.model.WonderCard;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WonderPanel extends JFrame{
    private JLabel lbChoose;
    private JTable tbWonders;
    private JScrollPane spWonders;
    private ArrayList<WonderCard> playerWonders;
    
    public WonderPanel() {
        super("7 Wonders Duel - Selecionar maravilha");
        this.screenConfiguration();
    }
    
    public void showFrame() {
        this.setVisible(true);
    }
    
    public void hideFrame() {
        this.setVisible(false);
    }
    
    private void screenConfiguration() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        // Welcome label configuration
        {
            lbChoose = new JLabel();
            lbChoose.setText("Escolha uma maravilha: (feche para sair)");
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 5;
            cons.gridx = 0;
            container.add(lbChoose, cons);
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
            String[] players = {"Maravilhas"};
            DefaultTableModel modelPlayers = new DefaultTableModel(players, 4);
            ArrayList<WonderCard> plyWonders = PlayerController.getInstance().getPlayer().getItens().getWonders();
            for(int i = 0; i < plyWonders.size(); i++){
                modelPlayers.setValueAt(plyWonders.get(i).getName(), i, 0);
            }
            tbWonders.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    WonderCard selectedWonder = plyWonders.get(tbWonders.rowAtPoint(evt.getPoint()));
                    if(GeneralController.getInstance().verifyCanBuildWonder(selectedWonder)){
                        hideFrame();
                        GeneralController.getInstance().processMove(Action.BUILDWONDER, null, tbWonders.rowAtPoint(evt.getPoint()), selectedWonder);
                    } else {
                        MessagePanel msgPanel = new MessagePanel("Voce não tem recursos para construir essa maravilha");
                        msgPanel.showFrame();
                    }
                }
            });
            this.tbWonders.setModel(modelPlayers);
            this.repaint();
            container.add(spWonders, cons);            
        }       

        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
