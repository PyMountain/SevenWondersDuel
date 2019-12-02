package br.ufsc.ine5608.view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessagePanel extends JFrame{
    
    private String messsage;
    private JButton btOk;
    private JLabel lbMsg;
    private ButtonManager buttonManager;
    
    public MessagePanel(String msg){
        super("Mensagem");
        this.buttonManager = new ButtonManager();
        this.messsage = msg;
        this.screenConfiguration();
    }
    
    private void screenConfiguration() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        {
            lbMsg = new JLabel();
            lbMsg.setText(this.messsage);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 5;
            cons.gridx = 0;
            container.add(lbMsg, cons);
        }
        
        {
            btOk = new JButton();
            btOk.setText("OK");
            btOk.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btOk, cons);
        }
        
        this.setSize(600, 400);
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
                hideFrame();
            }
        }        
    }
}
