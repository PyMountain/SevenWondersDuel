package br.ufsc.ine5608.controller;

import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.Player;
import br.ufsc.ine5608.model.WonderCard;
import br.ufsc.ine5608.rede.AtorNetgames;
import br.ufsc.inf.leobr.cliente.Proxy;
import java.util.ArrayList;

public class PlayerController {
    private Player player;
    private Player oponent;
    private static PlayerController plyCtrl;
    protected AtorNetgames ngServer;
    
    private PlayerController(){
        this.player = new Player();
        this.oponent = new Player();
        ngServer = new AtorNetgames();
    }
    
    public static PlayerController getInstance(){
        if(plyCtrl == null) 
            plyCtrl = new PlayerController();
        return plyCtrl;
    }
    
    //netgames connection
    
    public String conectar(String host, String nome) {
        player.setName(nome);
        String mensagem = ngServer.conectar(host, nome);
        return mensagem;
    }

    public String desconectar() {
        String mensagem = ngServer.desconectar();
        return mensagem;
    }

    public String iniciarPartida() {
        String mensagem = ngServer.iniciarPartida(player.getName()); 
        return mensagem;
    }

    public void iniciarNovaPartida() {
        Proxy.getInstance().iniciarNovaPartida(1);
    }
    
    //Player Controller methods
    void initPlayers() {
        this.oponent.setName(ngServer.getNomeOponente(player.getName()));
        this.player.setCoins(5);
        this.oponent.setCoins(5);
        
        ArrayList<Card> initialWonders = new ArrayList<Card>();
        initialWonders.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        initialWonders.add(new WonderCard(new ArrayList(), "torre de babel", new ArrayList(), 4));
        initialWonders.add(new WonderCard(new ArrayList(), "piramide do egito", new ArrayList(), 4));
        initialWonders.add(new WonderCard(new ArrayList(), "meu tio carlos", new ArrayList(), 4));
        
        this.player.getItens().setWonders(initialWonders);
        this.oponent.getItens().setWonders(initialWonders);
    }
    
    public Player getPlayer(){
        return this.player;
    }
    
    public Player addAgeCard(int ageCard){
        return this.player;
    }
    
    public void discard(){
        
    }
    
    public void setWonders(){
        
    }
    
    public boolean verifyResources(String resources){
        return false;
    }
    
    public String countResources(){
        return "";
    }
    
    public void charge(int cost) {
        
    }
    
    public void updateResources(int coins){
        
    }

}
