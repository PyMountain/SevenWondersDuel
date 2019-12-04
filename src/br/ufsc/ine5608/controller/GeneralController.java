package br.ufsc.ine5608.controller;

import br.ufsc.ine5608.model.AgeCard;
import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.Itens;
import br.ufsc.ine5608.model.Player;
import br.ufsc.ine5608.model.Resource;
import br.ufsc.ine5608.model.Type;
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
        this.gameCards = new Itens();
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
        PlayerController.getInstance().initPlayers();      
        HomeFrame.getInstance().hideFrame();
        StartFrame.getInstance().showFrame();
    }
    
    public void startGame() {
        this.setGameCards();
        CardTreeController.getInstance().setAgeCards(this.gameCards.getAge1Cards());
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
        CardTreeController.getInstance().removeCard(cardPosition);
    }
    
    public void buildWonder(int cardPosition, WonderCard wonder){
        
    }
    
    public void definePlayersWonders(){
        
    }
    
    public void defineStartCards(){
        
    }
    
    public void setGameCards(){
        ArrayList<Resource> cost;
        ArrayList<Resource> effect;
        //setup cards
        ArrayList<AgeCard> age1Cards = new ArrayList<AgeCard>();
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.WOOD);
        age1Cards.add(new AgeCard(cost, "jardim do lenhador", effect,Type.CIVILIAN, 0, 0));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.WOOD);
        age1Cards.add(new AgeCard(cost, "campo de lenha", effect,Type.CIVILIAN, 0, 1));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.CLAY);
        age1Cards.add(new AgeCard(cost, "piscina de argila", effect,Type.CIVILIAN, 0, 0));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.CLAY);
        age1Cards.add(new AgeCard(cost, "poço de argila", effect,Type.CIVILIAN, 0, 1));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.STONE);
        age1Cards.add(new AgeCard(cost, "pedreira", effect,Type.CIVILIAN, 0, 0));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.STONE);
        age1Cards.add(new AgeCard(cost, "centro de escavação", effect,Type.CIVILIAN, 0, 1));
        cost = new ArrayList();
        effect = new ArrayList();
        age1Cards.add(new AgeCard(cost, "torre de guarda", effect,Type.MILITARY, 2, 0));
        cost = new ArrayList();
        effect = new ArrayList();
        age1Cards.add(new AgeCard(cost, "oficina", effect,Type.SCIENTIFIC, 2, 0));
        cost = new ArrayList();
        effect = new ArrayList();
        age1Cards.add(new AgeCard(cost, "escola elementar", effect,Type.SCIENTIFIC, 2, 0));
        cost = new ArrayList();
        effect = new ArrayList();
        age1Cards.add(new AgeCard(cost, "banco", effect,Type.COMMERCIAL, 2, 0));
        this.gameCards.setAge1Cards(age1Cards);
        
        
        ArrayList<AgeCard> age2Cards = new ArrayList<AgeCard>();
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.WOOD);
        effect.add(Resource.WOOD);
        age2Cards.add(new AgeCard(cost, "serralheria", effect,Type.CIVILIAN, 0, 2));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.CLAY);
        effect.add(Resource.CLAY);
        age2Cards.add(new AgeCard(cost, "jardin de tijolos", effect,Type.CIVILIAN, 0, 2));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.STONE);
        effect.add(Resource.STONE);
        age2Cards.add(new AgeCard(cost, "escavação", effect,Type.CIVILIAN, 0, 2));
        cost = new ArrayList();
        effect = new ArrayList();
        effect.add(Resource.PAPER);
        effect.add(Resource.PAPER);
        age2Cards.add(new AgeCard(cost, "papelaria central", effect,Type.MANUFACTURED, 0, 0));
        cost = new ArrayList();
        cost.add(Resource.STONE);
        cost.add(Resource.STONE);
        effect = new ArrayList();
        age2Cards.add(new AgeCard(cost, "muralhas", effect,Type.MILITARY, 4, 0));
        cost = new ArrayList();
        cost.add(Resource.CLAY);
        effect = new ArrayList();
        effect.add(Resource.PAPER);
        age2Cards.add(new AgeCard(cost, "fórum", effect,Type.COMMERCIAL, 2, 3));
        cost = new ArrayList();
        cost.add(Resource.WOOD);
        cost.add(Resource.WOOD);
        effect = new ArrayList();
        age2Cards.add(new AgeCard(cost, "tribunal", effect,Type.COMMERCIAL, 5, 3));
        cost = new ArrayList();
        cost.add(Resource.WOOD);
        cost.add(Resource.STONE);
        effect = new ArrayList();
        age2Cards.add(new AgeCard(cost, "faculdade", effect,Type.SCIENTIFIC, 5, 3));
        cost = new ArrayList();
        cost.add(Resource.WOOD);
        cost.add(Resource.WOOD);
        cost.add(Resource.CLAY);
        effect = new ArrayList();
        age2Cards.add(new AgeCard(cost, "arquearia", effect,Type.MILITARY, 5, 0));
        cost = new ArrayList();
        cost.add(Resource.STONE);
        cost.add(Resource.STONE);
        effect = new ArrayList();
        age2Cards.add(new AgeCard(cost, "foritificações", effect,Type.MILITARY, 5, 0));
        this.gameCards.setAge2Cards(age2Cards);
        

        ArrayList<AgeCard> age3Cards = new ArrayList<AgeCard>();
        cost = new ArrayList();
        cost.add(Resource.CLAY);
        cost.add(Resource.WOOD);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "arsenal", effect,Type.MILITARY, 5, 0));
        cost = new ArrayList();
        cost.add(Resource.CLAY);
        cost.add(Resource.WOOD);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "corte", effect,Type.MILITARY, 8, 8));
        cost = new ArrayList();
        cost.add(Resource.CLAY);
        cost.add(Resource.WOOD);
        cost.add(Resource.PAPER);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "academia de ciencia", effect,Type.SCIENTIFIC, 10, 0));
        cost = new ArrayList();
        cost.add(Resource.STONE);
        cost.add(Resource.PAPER);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "câmara do comercio", effect,Type.COMMERCIAL, 6, 0));
        cost = new ArrayList();
        cost.add(Resource.STONE);
        cost.add(Resource.WOOD);
        cost.add(Resource.PAPER);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "prefeitura", effect,Type.CIVILIAN, 7, 0));
        cost = new ArrayList();
        cost.add(Resource.STONE);
        cost.add(Resource.STONE);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "obelisco", effect,Type.CIVILIAN, 5, 0));
        cost = new ArrayList();
        cost.add(Resource.CLAY);
        cost.add(Resource.WOOD);
        cost.add(Resource.PAPER);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "biblioteca", effect,Type.SCIENTIFIC, 10, 0));
        cost = new ArrayList();
        cost.add(Resource.WOOD);
        cost.add(Resource.PAPER);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "praça de comércio", effect,Type.COMMERCIAL, 6, 0));
        cost = new ArrayList();
        cost.add(Resource.WOOD);
        cost.add(Resource.WOOD);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "porto", effect,Type.COMMERCIAL, 5, 0));
        cost = new ArrayList();
        cost.add(Resource.WOOD);
        cost.add(Resource.CLAY);
        effect = new ArrayList();
        age3Cards.add(new AgeCard(cost, "tribunal", effect,Type.COMMERCIAL, 8, 0));
        this.gameCards.setAge3Cards(age3Cards);
        //end of setup cards
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