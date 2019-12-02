package br.ufsc.ine5608.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FinalFrame extends JFrame {
	private static FinalFrame ffInstance;
	private JLabel lbplayerOne;
	private JLabel lbplayerTwo;
	private JLabel lbwinnerPlayer;
	private JLabel lbloserPlayer;
		
	public FinalFrame() {
        super("7 Wonders Duel - Final");
        this.screenConfiguration();
    }
    
    public static FinalFrame getInstance() {        
        if (ffInstance == null) {
        	ffInstance = new FinalFrame();
        }        
        return ffInstance;
    }
    
    public void showFrame() {
        this.setVisible(true);
    }
    
    public void hideFrame() {
        this.setVisible(false);
    }
    
    private void screenConfiguration() {
    	Container container = getContentPane();
        container.setSize(400, 400);
        container.setLayout(new GridBagLayout());
        
     // Player one label configuration
        {
            lbplayerOne = new JLabel();
            lbplayerOne.setText("Jogador 1");
            GridBagConstraints cons = new GridBagConstraints();
            cons.ipadx = 200;
            cons.anchor = GridBagConstraints.FIRST_LINE_START;             
            cons.gridy = 0;
            cons.gridx = 0;
            container.add(lbplayerOne, cons);
        }
               
     // Player two label configuration
        {
            lbplayerTwo = new JLabel();
            lbplayerTwo.setText("Jogador 2");
            GridBagConstraints cons = new GridBagConstraints();
            cons.anchor = GridBagConstraints.FIRST_LINE_END;          
            cons.gridy = 0;
            cons.gridx = 1;
            container.add(lbplayerTwo, cons);
        }
                      
     // Winner label configuration
        {
            lbwinnerPlayer = new JLabel();
            lbwinnerPlayer.setText("Vitorioso");
            lbwinnerPlayer.setForeground(Color.GREEN);
            GridBagConstraints cons = new GridBagConstraints();
            cons.ipadx = 200;
            cons.anchor = GridBagConstraints.LINE_START;             
            cons.gridy = -1;
            cons.gridx = 0;
            container.add(lbwinnerPlayer, cons);
        }
        
     // Loser label configuration
        {
            lbloserPlayer = new JLabel();
            lbloserPlayer.setText("Perdedor");
            lbloserPlayer.setForeground(Color.RED);
            GridBagConstraints cons = new GridBagConstraints();
            cons.anchor = GridBagConstraints.LINE_END;          
            cons.gridy = -1;
            cons.gridx = 1;
            container.add(lbloserPlayer, cons);
        }
        
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
	
}