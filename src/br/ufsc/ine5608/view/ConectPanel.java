package br.ufsc.ine5608.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import br.ufsc.ine5608.controller.GeneralController;
import br.ufsc.ine5608.controller.PlayerController;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ConectPanel extends JFrame{
    private JLabel lbName;
    private JLabel lbHost;
    private JButton btOk;
    private JButton btCancel;
    private JTextField tfName;
    private JTextField tfHost;
    private ButtonManager buttonManager;
    private MessagePanel msgPanel;
    
    public ConectPanel(){
        super("Conectar");
        this.buttonManager = new ButtonManager();
        this.screenConfiguration();
    }
    
    private void screenConfiguration() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        {
            lbName = new JLabel();
            lbName.setText("Nome do jogador");
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 0;
            cons.gridx = 0;
            container.add(lbName, cons);
        }
        
        {
            tfName = new JTextField();
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = 1;
            cons.gridx = 0;
            container.add(tfName, cons);
        }
        
        {
            lbHost = new JLabel();
            lbHost.setText("Host");
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 2;
            cons.gridx = 0;
            container.add(lbHost, cons);
        }
        
        {
            tfHost = new JTextField();
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = 3;
            cons.gridx = 0;
            container.add(tfHost, cons);
        }
        
        {
            btOk = new JButton();
            btOk.setText("CONECTAR");
            btOk.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 4;
            cons.gridx = 0;
            container.add(btOk, cons);
        }
        
        {
            btCancel = new JButton();
            btCancel.setText("CANCELAR");
            btCancel.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 5;
            cons.gridx = 0;
            container.add(btCancel, cons);
        }
        
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
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
            if(ae.getSource().equals(btOk)) {
                msgPanel = new MessagePanel(PlayerController.getInstance().conectar(tfHost.getText(), tfName.getText()));
                msgPanel.showFrame();
                hideFrame();
            } else {
                hideFrame();
            }
        }        
    }
    
}
