package br.ufsc.ine5608.view;

import br.ufsc.ine5608.controller.PlayerController;
import br.ufsc.ine5608.model.AgeCard;
import br.ufsc.ine5608.model.Resource;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActionPanel extends JFrame {
    
    private JButton btBuild;
    private JButton btDiscard;
    private JButton btBuildWonder;
    private JLabel lbName;
    private JLabel lbCost;
    private JLabel lbResources;
    private JLabel lbResourcesCost;
    private ButtonManager buttonManager;
    private static HomeFrame actionPanelInstance;
    private MessagePanel msgPanel;
    private ConectPanel cnctPanel;
    private AgeCard selectedCard;
    
    public ActionPanel(AgeCard selectedCard) {
        super("Selecionar ação");
        this.buttonManager = new ButtonManager();
        this.selectedCard = selectedCard;
         this.screenConfiguration(); 
    }
    
    private void screenConfiguration() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        //conection buttons configuration
        {
            lbName = new JLabel();
            lbName.setText("Nome da carta: " + this.selectedCard.getName());
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 0;
            cons.gridx = 0;
            container.add(lbName, cons);
        }
        {
            lbCost = new JLabel();
            lbCost.setText("Custo da carta em moedas: " + this.selectedCard.getCost());
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 1;
            cons.gridx = 0;
            container.add(lbCost, cons);
        }
        {
            lbResources = new JLabel();
            String resourcesString = "custo da carta em recursos: ";
            for(Resource res: this.selectedCard.getResourcesCost()){
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
            lbResources.setText(resourcesString);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 2;
            cons.gridx = 0;
            container.add(lbResources, cons);
        }
        {
            lbResourcesCost = new JLabel();
            String resourcesString = "esta carta lhe concede: ";
            for(Resource res: this.selectedCard.getResources()){
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
            lbResourcesCost.setText(resourcesString);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 3;
            cons.gridx = 0;
            container.add(lbResourcesCost, cons);
        }
        {
            btBuild = new JButton();
            btBuild.setText("Construir carta");
            btBuild.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btBuild, cons);
        }
        {
            btDiscard = new JButton();
            btDiscard.setText("Descartar carta");
            btDiscard.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btDiscard, cons);
        }
        {
            btBuildWonder = new JButton();
            btBuildWonder.setText("Utilizar esta carta para construir maravilha");
            btBuildWonder.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btBuildWonder, cons);
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
            if(ae.getSource().equals(btBuild)) {
                
            } else if(ae.getSource().equals(btDiscard)) {
                
            } else if(ae.getSource().equals(btBuildWonder)){
                
            }
        }        
    }
    
}
