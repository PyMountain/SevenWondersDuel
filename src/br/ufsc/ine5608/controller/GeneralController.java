package br.ufsc.ine5608.controller;

import br.ufsc.ine5608.model.Action;
import br.ufsc.ine5608.model.AgeCard;
import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.Itens;
import br.ufsc.ine5608.model.Move;
import br.ufsc.ine5608.model.Player;
import br.ufsc.ine5608.model.Resource;
import br.ufsc.ine5608.model.Type;
import br.ufsc.ine5608.model.WonderCard;
import br.ufsc.ine5608.rede.AtorNetgames;
import br.ufsc.ine5608.view.FinalFrame;
import br.ufsc.ine5608.view.StartFrame;
import br.ufsc.ine5608.view.BoardFrame;
import br.ufsc.ine5608.view.HomeFrame;
import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class GeneralController {
    private static GeneralController singleGeneralCtrl;
    private Itens gameCards;
    protected AtorNetgames ngServer;
          
    public GeneralController() {
        this.gameCards = new Itens();
        ngServer = AtorNetgames.getInstance();
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
    
    public void updateTable(Action action, AgeCard selectedCard, boolean received, int cardPosition, WonderCard selectedWonder){
        PlayerController.getInstance().getPlayer().setPlayerTurn(received);
        switch (action) {
            case BUILD:
                buildCard(selectedCard, cardPosition, received);
                verifyEndOfAge();
                BoardFrame.getInstance().tableRefresh();
                break;
            case DISCARD:
                discard(cardPosition, received);
                verifyEndOfAge();
                BoardFrame.getInstance().tableRefresh();
                break;
            case BUILDWONDER:
                buildWonder(selectedCard, cardPosition, received, selectedWonder);
                break;
            default:
                break;
        }
    }
    
    public void verifyEndOfAge(){
        if(CardTreeController.getInstance().getUsedCards() == 10){
            switch(CardTreeController.getInstance().getAge()) {
                case 1: CardTreeController.getInstance().setAgeCards(gameCards.getAge2Cards());
                    break;
                case 2: CardTreeController.getInstance().setAgeCards(gameCards.getAge3Cards());
                    break;
                case 3: this.endMatch();
                    break;
            }
        }
    }
    
    public void buildCard(AgeCard selectedCard, int cardPosition, boolean received){
        CardTreeController.getInstance().removeCard(cardPosition);
        if(received){
            for(Resource res: selectedCard.getResources()){
                PlayerController.getInstance().getOponent().getResources().add(res);
            }
            PlayerController.getInstance().getOponent().addAgeCard(selectedCard);
            PlayerController.getInstance().getOponent().removeCoins(selectedCard.getCost());
        } else {
            for(Resource res: selectedCard.getResources()){
                PlayerController.getInstance().getPlayer().getResources().add(res);
            }
            PlayerController.getInstance().getPlayer().addAgeCard(selectedCard);
            PlayerController.getInstance().getPlayer().removeCoins(selectedCard.getCost());
        }
    }
    
    public void discard(int cardPosition, boolean received){
        CardTreeController.getInstance().removeCard(cardPosition);
        if(received){
            PlayerController.getInstance().getOponent().addCoins(5 + PlayerController.getInstance().getOponent().getYellowCardsNumber());
        }else {
            PlayerController.getInstance().getPlayer().addCoins(5 + PlayerController.getInstance().getPlayer().getYellowCardsNumber());
        }
    }
    
    public void buildWonder(AgeCard selectedCard, int cardPosition, boolean received, WonderCard wonder){
        CardTreeController.getInstance().removeCard(cardPosition);
        if(received){
            for(Resource res: wonder.getResources()){
                PlayerController.getInstance().getOponent().getResources().add(res);
            }
            PlayerController.getInstance().getOponent().getItens().getWonderCards().remove(wonder);
            PlayerController.getInstance().getOponent().removeCoins(selectedCard.getCost());
        } else {
            for(Resource res: wonder.getResources()){
                PlayerController.getInstance().getPlayer().getResources().add(res);
            }
            PlayerController.getInstance().getPlayer().addAgeCard(selectedCard);
            PlayerController.getInstance().getPlayer().removeCoins(selectedCard.getCost());
        }
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
    
    public void processMove(Action action, AgeCard selectedCard, int cardPosition, WonderCard selectedWonder){
        this.ngServer.enviaJogada(new Move(action, selectedCard, selectedWonder, cardPosition));
        updateTable(action, selectedCard, false, cardPosition, selectedWonder);
    }
    
    public boolean verifyCard(int cardPosition){
        return CardTreeController.getInstance().verifyCard(cardPosition);
    }
    
    public boolean verifyCanBuild(AgeCard selectedCard){
        ArrayList<Resource> auxCost = selectedCard.getResourcesCost();
        ArrayList<Resource> auxPlayer = PlayerController.getInstance().getPlayer().getResources();
        for(Resource res : auxCost){
            if(auxPlayer.contains(res)){
                auxCost.remove(res);
            }
        }
        return auxCost.isEmpty() && selectedCard.getCost() < PlayerController.getInstance().getPlayer().getCoins();
    }
    
    public boolean verifyCanBuildWonder(WonderCard selectedCard){
        ArrayList<Resource> auxCost = selectedCard.getResourcesCost();
        ArrayList<Resource> auxPlayer = PlayerController.getInstance().getPlayer().getResources();
        for(Resource res : auxCost){
            if(auxPlayer.contains(res)){
                auxCost.remove(res);
            }
        }
        return auxCost.isEmpty() && selectedCard.getCost() < PlayerController.getInstance().getPlayer().getCoins();
    }
    
    public void endMatch(){
        int playerPoints = PlayerController.getInstance().getPlayer().getCoins();
        for(AgeCard card : PlayerController.getInstance().getPlayer().getAgeCards()){
            playerPoints += card.getVictoryPoints();
        }
        
        int oponentPoints = PlayerController.getInstance().getOponent().getCoins();
        for(AgeCard card : PlayerController.getInstance().getOponent().getAgeCards()){
            oponentPoints += card.getVictoryPoints();
        }
        String winnerName = "";
        String loserName = "";
        if(playerPoints >= oponentPoints){
            winnerName = PlayerController.getInstance().getPlayer().getName();
            loserName = PlayerController.getInstance().getOponent().getName();
        } else {
            winnerName = PlayerController.getInstance().getOponent().getName();
            loserName = PlayerController.getInstance().getPlayer().getName();
        }
        
        BoardFrame.getInstance().hideFrame();
        FinalFrame.getInstance().showFrame(winnerName, loserName);
        
        
    }
    
}