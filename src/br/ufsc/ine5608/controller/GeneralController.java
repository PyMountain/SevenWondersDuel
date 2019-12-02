package br.ufsc.ine5608.controller;

import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.Itens;
import br.ufsc.ine5608.model.Player;
import br.ufsc.ine5608.model.WonderCard;
import br.ufsc.ine5608.view.FinalFrame;
import br.ufsc.ine5608.view.StartFrame;
import br.ufsc.ine5608.view.BoardFrame;
import br.ufsc.ine5608.view.HomeFrame;
import java.util.ArrayList;

public class GeneralController {
    private static GeneralController singleGeneralCtrl;
    private Itens gameCards;
          
    public GeneralController() {
    }
    
    public static GeneralController getInstance() {
        if(singleGeneralCtrl == null) 
            singleGeneralCtrl = new GeneralController();
        return singleGeneralCtrl;
    }
    
    public void homeFrame(){
        HomeFrame.getInstance().showFrame();
    }
    
    public void startFrame() {      
        HomeFrame.getInstance().hideFrame();
        StartFrame.getInstance().showFrame();
    }
    
    public void startGame() {
        PlayerController.getInstance().initPlayers();
        //setup cards
        ArrayList<Card> age1Cards = new ArrayList<Card>();
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        age1Cards.add(new WonderCard(new ArrayList(), "grande muralha", new ArrayList(), 4));
        
        CardTreeController.getInstance().initCardTree();
        StartFrame.getInstance().hideFrame();
        BoardFrame.getInstance().showFrame();
    }
    
    public void finalFrame() {
    	BoardFrame.getInstance().hideFrame();
    	FinalFrame.getInstance().showFrame();
    }
    
    public void updateTable(){
        
    }
    
    public void discard(int cardPosition){
        
    }
    
    public void buildWonder(int cardPosition, WonderCard wonder){
        
    }
    
    public void definePlayersWonders(){
        
    }
    
    public void defineStartCards(){
        
    }
    
    public void setGameCards(){
        
    }
    
    public void processMove(){
        
    }
    
    public boolean verifyCard(int cardPosition){
        return CardTreeController.getInstance().verifyCard(cardPosition);
    }
    
    public boolean jogadaBuilded(){
        return false;
    }
    
}