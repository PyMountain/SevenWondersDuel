package br.ufsc.ine5608.view;

import br.ufsc.ine5608.controller.GeneralController;
import br.ufsc.ine5608.controller.PlayerController;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeFrame extends JFrame {
    private JButton btConect;
    private JButton btStartGame;
    private JButton btDisconect;
    private ButtonManager buttonManager;
    private static HomeFrame hfInstance;
    private MessagePanel msgPanel;
    private ConectPanel cnctPanel;
    
    public HomeFrame() {
        super("7 Wonders Duel - Conect");
        this.buttonManager = new ButtonManager();
        this.screenConfiguration();        
    }
    
    public static HomeFrame getInstance() {        
        if (hfInstance == null) {
        	hfInstance = new HomeFrame();
        }        
        return hfInstance;
    }
    
    private void screenConfiguration() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        //conection buttons configuration
        {
            btConect = new JButton();
            btConect.setText("Conectar");
            btConect.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btConect, cons);
        }
        {
            btStartGame = new JButton();
            btStartGame.setText("Iniciar partida");
            btStartGame.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btStartGame, cons);
        }
        {
            btDisconect = new JButton();
            btDisconect.setText("Desconectar");
            btDisconect.addActionListener(buttonManager);
            GridBagConstraints cons = new GridBagConstraints();
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridy = -4;
            cons.gridx = 0;
            container.add(btDisconect, cons);
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
            if(ae.getSource().equals(btConect)) {
                cnctPanel = new ConectPanel();
                cnctPanel.showFrame();
            } else if(ae.getSource().equals(btStartGame)) {
                String msg = PlayerController.getInstance().iniciarPartida();
                if(msg == "Sucesso: solicitacao de inicio enviada a Netgames Server"){
                    PlayerController.getInstance().iniciarNovaPartida();
                } else {
                    msgPanel = new MessagePanel(msg);
                    msgPanel.showFrame();
                }
            } else if(ae.getSource().equals(btDisconect)){
                msgPanel = new MessagePanel(PlayerController.getInstance().desconectar());
                msgPanel.showFrame();
            }
        }        
    }
    
}
